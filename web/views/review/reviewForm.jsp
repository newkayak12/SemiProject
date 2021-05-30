<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.Review"%>    
<%@ page import= "com.users.model.vo.Users" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_yj.css">
<script src ="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<%
	Users user = null;
	Object o = request.getSession().getAttribute("user");
	String userid = "";
	if(o!= null){
		user = (Users) o;
		userid = user.getUserId();
	}
	
	Review  selectedProduct = null;
	Object temp = request.getAttribute("selectedProduct");
	if(temp != null){
		selectedProduct = (Review) temp;
	}
%>

<!-- 주석주석 -->
<main id="reviewForm_main" style="width: 100% !important;">

	<div id="reviewForm-container" >
	
		<h1>REVIEW</h1>
	
		<form action="<%=request.getContextPath()%>/review/post/end" method="post" enctype="multipart/form-data">
		
			<input type="hidden" id="cId" name="cId" value="<%=selectedProduct.getCategoryId()%>">
			<input type="hidden" id="orderNo" name="orderNo" value="<%=selectedProduct.getOrderNumber()%>">
			<input type="hidden" id="pFile" name="pFile" value="<%=selectedProduct.getProductFile()%>">
			<input type="hidden" id="pId" name="pId" value="<%=selectedProduct.getProductId()%>">
			<input type="hidden" id="pName" name="pName" value="<%=selectedProduct.getProductName()%>">
			<input type="hidden" id="pColor" name="pColor" value="<%=selectedProduct.getProductOptionColor()%>">
			<input type="hidden" id="pSize" name="pSize" value="<%=selectedProduct.getProductOptionSize()%>">
			<input type="hidden" id="userId" name="userId" value="<%=userid%>">
		
			<table id = "reviewForm-table">
			
				<tr>
					<th>상품</th>
					<td>
						<% if(selectedProduct != null) { %>
							<img src="<%=request.getContextPath() %>/upload/product/<%=selectedProduct.getProductFile()%>" name="" id="" width="100px" height="100px">
							<span><%=selectedProduct.getProductName() %></span>
							<span><%=selectedProduct.getProductOptionColor() %></span>
							<span><%=selectedProduct.getProductOptionSize()%></span>
						<% } else { %>
							<span>선택된 상품이 없습니다</span>
						<% } %>
					</td>
				</tr>
			
				<tr>
					<th>제&nbsp;&nbsp;&nbsp;목</th>
					<td><input type="text" name="reviewTitle" id="reviewTitle" size="95" required></td>
				</tr>
				
				<tr>
					<th>작성자</th>
					<%-- value에 <%=loginMember.getMemberId()%> --%>
					<td><input type="text" name="reviewWriter" id="reviewWriter" value="<%=userid %>" readonly required size="95"></td>
				</tr>
				
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="up_file"></td>
				</tr>
				
				<tr>
					<th>내&nbsp;&nbsp;&nbsp;용</th>
					<td><textarea rows="25" cols="80" name="reviewContent" required></textarea></td>
				</tr>
				
				<tr>
					<th colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</th>
				</tr>
				
			</table>
			
		</form>
		
	</div>
	
</main>

</body>
</html>
