<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.admin.model.vo.product.ProductAjax, java.util.List, com.product.model.vo.Product" %>

<%
	// 모든 컬러 옵션
 	List<ProductAjax> colors = (List<ProductAjax>)request.getAttribute("colors");

	// 모든 사이즈 옵션
 	List<ProductAjax> sizes = (List<ProductAjax>)request.getAttribute("sizes");
 	
	// 카테고리 번호에 해당하는 카테고리 이름
 	ProductAjax category = (ProductAjax)request.getAttribute("category");
 	
 	String pId = (String)request.getAttribute("pId");

 	// 해당하는 상품의 모든 디테일
 	List<Product> productDetails = (List<Product>)request.getAttribute("productDetails");
 	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세정보 등록</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_yj.css"> --%>
<style>
	.padding_20{
		padding : 20px;
	}
	
	.padding_50{
		padding : 50px;
	}
	
	.margin_10{
		margin : 10px;
	}
	
	.margin_center{
		margin-left: auto; 
		margin-right: auto; 
	}
	
	.section_title{
		text-align : center;
		margin : 50px auto 0px auto;
		color : orange;
		font-weight : bolder;
		font-size : 25px;
	}
	
	.blueText{
		color : rgb(9, 74, 169);
		font-weight : bolder;
		font-size : 20px;
	}
	
	.text_align_center{
		text-align : center;
	}
	.width_500{
		width : 500px;
	}
	.thead-color{
		background-color : rgb(0, 70, 172);
		color : white;
	}
	
	.white_button{
		width : 70px;
		height : 35px;
		margin-left : 3px;
		margin-right : 3px;
		border-radius : 0;
		background-color : white;
	}
	
	.blue_button{
		width : 70px;
		height : 35px;
		margin-left : 3px;
		margin-right : 3px;
		border-radius : 0;
		background-color : rgb(9, 74, 169);
		color : white;
	}
	
</style>
</head>

<body>

<main>

	<p class="section_title padding_20">상품 상세정보 등록</p>
	
	<% if( colors != null && sizes != null &&  productDetails != null) { %>
	
	<div>
	
		<p class="text_align_center blueText">상품 정보</p>
	
		<table class="margin_center padding_20 width_500">
		
			<thead class="thead-color">
				<th>상품번호</th>
				<th>상품명</th>
				<th>카테고리</th>
			</thead>
			
			<tr>
				<td id="a_p_pId"><%= pId%></td>
				<td><%= productDetails.get(0).getProductName()%></td>
				<td>
					<span id="a_p_cId"><%=category.getcId()%></span>
					<span><%=category.getCategoryName() %></span>
				</td>
			</tr>
			
		</table>
		
		
		
		<p class="text_align_center blueText">옵션 별 재고 현황</p>
		
		<table class="margin_center padding_20 width_500">
			
			<thead class="thead-color">
				<th>현재 보유 색상</th>
				<th>현재 보유 사이즈</th>
				<th>현재 재고 수량</th>
			</thead>
			
			<% for( Product p : productDetails ) { %>
				<tr>
					<td><%=p.getProductOptionColor() %></td>
					<td><%=p.getProductOptionSize() %></td>
					<td><%=p.getProductStock() %></td>
				</tr>
			<% } %>
		
		</table>
		
		
		<p class="text_align_center blueText">옵션 별 재고 등록 및 추가</p>
	
		<table class="margin_center padding_20 width_500">
			
			<thead class="thead-color">
				<th>색상</th>
				<th>사이즈</th>
				<th>수량</th>
			</thead>
			
			<tr>
				<td>
					
					<select id="a_p_pColor">
						<% for(ProductAjax co : colors) { %>
							<option><%=co.getColor() %></option>
						<% } %>
					</select>
				</td>
				<td>
					<select id="a_p_pSize">
						<% for(ProductAjax s : sizes) { %>
							<option><%= s.getSize() %></option>
						<% } %>
					</select>
				</td>
				<td><input type="text" id="a_p_pStock" required="required"></td>
			</tr>
			
			
			<%-- <tr>
				<th>색상</th>
				<td>
					
					<select id="a_p_pColor">
						<% for(ProductAjax co : colors) { %>
							<option><%=co.getColor() %></option>
						<% } %>
					</select>
				</td>
			</tr>
			
			<tr>
				<th>사이즈</th>
				<td>
					<select id="a_p_pSize">
						<% for(ProductAjax s : sizes) { %>
							<option><%= s.getSize() %></option>
						<% } %>
					</select>
				</td>
			</tr>
			
			<tr>
				<th>재고</th>
				<td><input type="number" min="1" id="a_p_pStock"></td>
			</tr> --%>
			
		</table>
		
		<div class="text_align_center padding_50">
			<button class="blue_button" onclick = "fn_postProcudtDetailAjax()">등록</button>
			<button class="white_button" onclick="window.close();">취소</button>
		</div>
		
	</div>
	
	<% } %>
	
</main>	
	
</body>


<script>

	const fn_postProcudtDetailAjax = () => {
		
		console.log( $("#a_p_pId").text() );
		console.log( $("#a_p_cId").text() );
		console.log( $("#a_p_pColor").val() );
		console.log( $("#a_p_pSize").val() );
		console.log( $("#a_p_pStock").val() );
		
		if($("#a_p_pStock").val().length == 0) {
			alert("수량은 필수 입력 항목입니다");
			$("#a_p_pStock").focus();
		}
		
		$.ajax({
			
			url : "<%=request.getContextPath()%>/admin/product/detailend",
			
			data : {
				"pId" : $("#a_p_pId").text(),
				"cId" : $("#a_p_cId").text(),
				"pColor" : $("#a_p_pColor").val(),
				"pSize" : $("#a_p_pSize").val(),
				"pStock" : $("#a_p_pStock").val()
			},
			
			success : data => {
				
				alert(data);
				window.close();
			}
			
		})
	}
	
</script>

</html>