<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<% String pay = (String) request.getAttribute("pay"); %>
<main>
	
	<div>
	
			<h1>아래의 은행으로 입금하시면 결제가 완료됩니다.</h1>
			
			<p><%=pay %> </p>
	
	
	</div>



</main>

<%@ include file = "/views/common/footer.jsp"%>