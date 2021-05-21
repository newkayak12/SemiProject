<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List, com.notice.model.vo.Notice" %>
<%
	List<Notice> list = (List<Notice>)request.getAttribute("list");
%>
   
<%@ include file="/views/common/header.jsp"%> 
	<section id = notice-container>
		<h2>Notice</h2>
	
	</section>




<%@include file="/views/common/footer.jsp"%>