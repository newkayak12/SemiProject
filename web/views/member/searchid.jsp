<%@page import="com.users.model.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Users users = (Users)request.getAttribute("useridtemp");

%>
<link rel="stylesheet" href="web/css/style.css">
<%@ include file ="/views/common/header.jsp" %>

<main id="searchidMain">

	<div class="wrap" style="justify-content: center; margin:0px!important">
		<div class="container_wrap" id="searchid-container" >
		
		<h1>아이디 찾기</h1>
		
		<form action="<%=request.getContextPath()%>/search/searchid/end"
		method="post">
			<div id="searchid_input_section">
				<p class="input_txt">이름</p>
				<input class="input_style" type="text" name="username" placeholder="이름"><br>
				<p class="input_txt">전화번호</p>
				<input class="input_style" type="text" name="userPhone" placeholder="핸드폰번호"><br>
			</div>
			
			
			<div id="searchid_submit_section">
				<input class="bigBtn_syle serchid_submit_btn" type="submit" value="아이디찾기">
				<input class="bigBtn_syle serchid_reset_btn" type="reset" onclick="history.back(-1);" value="취소">
			</div>

			
			<div>
			
			
				<%-- <div class="serachid_txt">
				<% if(users!=null) {%>
					<p>찾으시는 아이디는 </p><p><%=users.getUserId()%></p> <p>입니다.</p><br>
					<%} else { %>
						<p>해당하는 아이디는 없습니다.</p><br>
					<%} %>
				</div> --%>
				
				<div class="bigBtn_syle serchid_login_btn">
					<a href="<%= request.getContextPath() %>/sign/signin/start">로그인하기</a>
				</div>
			</div>
			
		</form>			
	</div>
	</div>
</main>

<%@ include file ="/views/common/footer.jsp" %>