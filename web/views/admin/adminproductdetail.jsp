<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.admin.model.vo.product.ProductAjax, java.util.List" %>

<%
	
 	List<ProductAjax> colors = (List<ProductAjax>)request.getAttribute("color");
 	List<ProductAjax> sizes = (List<ProductAjax>)request.getAttribute("size");
 	
 	ProductAjax category = (ProductAjax)request.getAttribute("category");
 	
 	String pId = (String)request.getAttribute("pId");
 	String pName = (String)request.getAttribute("pName");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세정보 등록</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>

	<p class="section_title padding_50">상품 상세정보 등록</p>
	
	<% if( colors != null && sizes != null ) { %>
	
	<div>
	
		<table>
		
			<tr>
				<th>상품번호</th>
				<td id="a_p_pId"><%= pId%></td>
			</tr>
			
			<tr>
				<th>상품명</th>
				<td><%=pName %></td>
			</tr>
			
			<tr>
				<th>카테고리</th>
				<td>
					<span id="a_p_cId"><%=category.getcId()%></span>
					<span><%=category.getCategoryName() %></span>
				</td>
			</tr>
			
			<tr>
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
			</tr>
			
		</table>
		
		<button onclick = "fn_postProcudtDetailAjax()">등록</button>
		
	</div>
	
	<% } %>

</body>

<script>

	const fn_postProcudtDetailAjax = () => {
		
		console.log( $("#a_p_pId").text() );
		console.log( $("#a_p_cId").text() );
		console.log( $("#a_p_pColor").val() );
		console.log( $("#a_p_pSize").val() );
		console.log( $("#a_p_pStock").val() );
		
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