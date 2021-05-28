<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = " com.admin.model.vo.product.ProductAjax" %>
 <%@ page import = "java.util.List" %>
 
 
<!DOCTYPE html>
<html>
<script src ="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<head>
<meta charset="UTF-8">
<title>product poster</title>
<%

	
	List<ProductAjax> list =  (List<ProductAjax>)request.getAttribute("category");
	
%>
</head>
<body>
<p>상품 추가</p>
<div>
	<!-- 상품 이름,  카테고리,  (설명1, 설명2), 가격,  메인사진, -->
	<table>
			<tr>
			<th>상품명</th>
			<td><input type="text"id="productname" required="required"></td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td>
				<select name="category" id="category" required="required">
				<%for (ProductAjax p : list) {%>
						<option value="<%=p.getcId()%>"><%=p.getCategoryName() %></option>
				<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="number" required="required"></td>
		</tr>
		<tr>
			<th>메인 설명</th>
			<td><textarea cols="50" rows="2"></textarea></td>
		</tr>
		<tr>
			<th>상세페이지 설명</th>
			<td><textarea cols="50" rows="20"></textarea></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><input type="file"  ></td>
		</tr>
	</table>
	
		<div style="display: flex; justify-content: center; margin-top:50px;">
			<input type="button" value="등록">
			<input type="button" value="취소" onclick="window.close()">
		</div>

</div>

</body>
</html>