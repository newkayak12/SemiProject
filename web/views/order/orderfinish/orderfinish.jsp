<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<% 
	String pay = (String) request.getAttribute("pay");
	String msg = (String) request.getAttribute("msg");
%>
<main>
	
	<div>
	
			<h1><%=msg %></h1>
			
			<p>아래의 은행으로 입금하시면 결제가 완료됩니다.</p>
			<p> <%=pay %> </p>
	
	
	</div>



</main>

<%@ include file = "/views/common/footer.jsp"%>