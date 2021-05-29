<%@page import="com.users.model.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Users users = (Users)request.getAttribute("useridtemp");

%>
<link rel="stylesheet" href="web/css/style.css">
<%@ include file ="/views/common/header.jsp" %>

<main id="searchidMain">

		<div id="searchid-container">
		
			<span>아이디 찾기</span>
			
			
			<form action="<%=request.getContextPath()%>/search/searchid/end"
			method="post">
				<div id="searchid_input_section">
					<p class="input_txt" style="text-align : start;">이름</p>
					<input class="input_style" type="text" name="username" placeholder="이름"><br>
					<p class="input_txt"  style="text-align : start;">전화번호</p>
					<input class="input_style" type="text" name="userPhone" placeholder="핸드폰번호"><br>
				</div>
				
				
				<div id="searchid_submit_section">
					<input class="bigBtn_syle serchid_submit_btn" type="submit" value="아이디찾기">
					<input class="bigBtn_syle serchid_reset_btn" type="reset" onclick="history.back(-1);" value="취소">
				</div>
	
				
				<div id ="searchid_to_login" class="bigBtn_syle serchid_login_btn">
					<a href="<%= request.getContextPath() %>/sign/signin/start">로그인하기</a>
				</div>
		
			</form>			
	</div>

</main>

<%@ include file ="/views/common/footer.jsp" %>