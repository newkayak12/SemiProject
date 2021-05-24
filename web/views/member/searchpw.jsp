<%@page import="com.users.model.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Users users = (Users)request.getAttribute("userpwtemp");

%>
<link rel="stylesheet" href="web/css/style.css">
<%@ include file ="/views/common/header.jsp" %>

<main id="searchpwMain">
	<div class="wrap">
		<div class="container_wrap" id="searchpw-container">
		
		<h1>비밀번호 찾기</h1>
		
		<form action="<%=request.getContextPath()%>/search/searchpw/end"
		method="post">
			<div id="searchpw_input_section">
				<p class="input_text">아이디</p>
				<input class="input_style" type="text" name="userid" placeholder="아이디"><br>
				<p class="input_txt">전화번호</p>
				<input class="input_style" type="text" name="userPhone" placeholder="핸드폰번호"><br>
			</div>
			
			<div id="searchid_submit_section">
				<input class="bigBtn_syle serchid_submit_btn" type="submit" value="비밀번호찾기">
				<input class="bigBtn_syle serchid_reset_btn" type="reset" onclick="history.back(-1);" value="취소">
			</div>
			
			
			<div>
				<div class="serachid_txt">
				<% if(users!=null) {%>
					<p>찾으시는 비밀번호는 </p><p><%=users.getUserPwd()%></p> <p>입니다.</p><br>
					<%} else { %>
						<p>해당하는 비밀번호는 없습니다.</p><br>
					<%} %>
				</div>
				
				<div class="bigBtn_syle serchid_login_btn">
					<a href="<%= request.getContextPath() %>/sign/signin/start">로그인하기</a>
				</div>
			</div>
			
		</form>			
	</div>
	</div>
</main>


<%@ include file ="/views/common/footer.jsp" %>