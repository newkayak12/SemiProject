<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List, com.notice.model.vo.Notice" %>
<%
	List<Notice> list = (List<Notice>)request.getAttribute("list");
%>
   
<%@ include file="/views/common/header.jsp"%> 


<%@include file="/views/common/footer.jsp"%>