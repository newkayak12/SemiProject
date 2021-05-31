<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import = " com.admin.model.vo.product.ProductAjax, java.util.List" %>
 
 
<!DOCTYPE html>
<html>
<script src ="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<head>
<meta charset="UTF-8">
<title>product poster</title>

<%
	List<ProductAjax> cList =  (List<ProductAjax>)request.getAttribute("category");	
%>

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
	.width_550{
		width : 550px;
	}
	.th-color{
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

	<p class="section_title padding_50">상품 등록</p>
	
	<div>
		<!-- 상품 이름,  카테고리,  (설명1, 설명2), 가격,  메인사진, 상세사진1 상세사진2 -->
		<table class="margin_center padding_20 width_520">
		
			<form action="<%=request.getContextPath() %>/product/postend/admin" method="post" enctype="multipart/form-data">
			
				<tr>
					<th class="th-color">상품명</th>
					<td><input type="text" id="productname" name="productname" required="required" size="60"></td>
				</tr>
				
				<tr>
					<th class="th-color">카테고리</th>
					<td>
						<p>c01&nbsp;아우터&nbsp;&nbsp;|
							&nbsp;&nbsp;c02&nbsp;상의&nbsp;&nbsp;|
							&nbsp;&nbsp;c03&nbsp;하의&nbsp;&nbsp;|
							&nbsp;&nbsp;c04&nbsp;악세서리</p>
						
						<select name="category" id="category" name="category" required="required">
						
							<% if( cList != null && cList.size() != 0 ) { %>
								<%for (ProductAjax p : cList) {%>
									<option value="<%=p.getcId()%>"><%=p.getcId()%></option>
								<% } %>
							<% } %>
						</select>
						
					</td>
				</tr>
				
				<tr>
					<th class="th-color">가격</th>
					<td><input type="text" id="productprice" name="productprice" required="required" size="60"></td>
				</tr>
				
				<tr>
					<th class="th-color">메인 설명</th>
					<td><textarea cols="50" id="mainexplain" name="mainexplain" rows="5" required="required"></textarea></td>
				</tr>
				
				<tr>
					<th class="th-color">상세 설명</th>
					<td><textarea cols="50" id="detailexplain" name="detailexplain" rows="10" required="required"></textarea></td>
				</tr>
				
				<tr>
					<th class="th-color">메인사진</th>
					<td><input type="file" id="mainimage" name="mainimage" required="required"></td>
				</tr>
				
				<tr>
					<th class="th-color">상세사진1</th>
					<td><input type="file" id="detailimage1" name="detailimage1" required="required"></td>
				</tr>
				<tr>
					<th class="th-color">상세사진2</th>
					<td><input type="file" id="detailimage2" name="detailimage2" required="required"></td>
				</tr>
				<tr class="text_align_center">
					<td colspan="2">
						<input class="blue_button" type="submit" value="등록">
						<input class="white_button" type="button" value="취소" onclick="window.close()">
					</td>
				</tr>
				
			</form>
			
		</table>
		
	</div>

</body>

<script>
<%-- 	
	const fn_productpost = () => {
		
			$.ajax({
				
				url : "<%=request.getContextPath()%>/product/postend/admin",
				
				data : {
					"productname" : $("#productname").val(),
					"category" : $("#category").val(),
					"productprice" : $("#productprice").val(),
					"mainexplain" : $("#mainexplain").val(),
					"detailexplain" : $("#detailexplain").val(),
					"mainimage" : $("#mainimage").val(),
					"detailimage1" : $("#detailimage1").val(),
					"detailimage2" : $("#detailimage2").val()
					
				},
				
				type : "post",
				
				success : data => {
					
					alert("업로드 성공");
				}
	
			})
	}
	
	 --%>
	
</script>

</html>