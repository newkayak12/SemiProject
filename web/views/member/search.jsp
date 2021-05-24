<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/views/common/header.jsp" %>

<link rel="stylesheet" href="web/css/style_ws.css">

<main id="searchMain">
	<div class="wrap">
		<div class="container_wrap" id="search-container">
		
			<h1>아이디/비밀번호 찾기</h1>

			<span><a class="serch_btn" href="<%= request.getContextPath()%>/search/searchid/start">아이디찾기</a></span>
			<span><a class="serch_btn" href="<%= request.getContextPath()%>/search/searchpw/start">비밀번호찾기</a></span>	
		
	</div>
	</div>
</main>

<%@ include file ="/views/common/footer.jsp" %>