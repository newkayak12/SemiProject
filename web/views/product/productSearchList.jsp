<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.product.model.vo.Product, java.util.List" %>    
    
<%@include file="/views/common/header.jsp" %>

<%
	List<Product> searchResult = (List<Product>)request.getAttribute("searchResult");
%>

<nav class="category-bar">
	<ul id="category-bar">
		<li><a href= "<%=request.getContextPath()%>/product/list?category=all">ALL</a></li>
		<li><a href= "<%=request.getContextPath()%>/product/list?category=c01">OUTTER</a></li>
		<li><a href= "<%=request.getContextPath()%>/product/list?category=c02">TOP</a></li>			<li><a href= "<%=request.getContextPath()%>/product/list?category=c03">BOTTOM</a></li>
		<li><a href= "<%=request.getContextPath()%>/product/list?category=c04">ETC</a></li>
	</ul> 
</nav>
	
<main id ="category-container">

	<div id="search-product-container">
		<ul>
			<li>
				<input type="text">
				<button id="search-product">검색</button>
			</li>
		</ul>
	</div>
	
	
	<% if(searchResult != null && searchResult.size() != 0) { %>
	
		<% for( Product p : searchResult ) { %>
		
			<a href="<%=request.getContextPath()%>/product/detail?pid=<%=p.getProductId()%>&category=<%=p.getCategoryId()%>">
				<img width="200px" height="250px" alt="" src="<%=request.getContextPath()%>/upload/product/<%=p.getProductFile()%>">
			</a>
			<span><%= p.getProductName()%></span>
			<span><%=p.getProductPrice() %></span>
		
		<% } %>
	
	<% } %>
	
	
</main>

<%@include file="/views/common/footer.jsp" %>