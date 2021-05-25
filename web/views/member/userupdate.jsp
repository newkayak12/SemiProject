<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.users.model.vo.Users" %>>
<%@ include file ="/views/common/header.jsp" %>
<%
	Users user=(Users)request.getAttribute("usersinfo");
%>


<link rel="stylesheet" href="web/css/style.css">
<main id="mypageMain">
	<div id="mypage-container">
		<form action="<%=request.getContextPath() %>/sign/modify/end" method="post">
			
				<p class="input_text">ID</p>
				<input class="input_style join_input_id" type="text" name="userid" placeholder="id" value="<%=userid%>"><br>
			
				<p class="input_text">PassWord</p>
				<input class="input_style" type="password" name="password" placeholder="pw" value="<%=user.getUserPwd() %>"><br>
			
				<p class="input_text">PassWord check</p>
				<input class="input_style" type="password" name="userpw-check" placeholder="pw-ck" value="<%=user.getUserPwd() %>"><br>
			
				<p class="input_text">Name</p>
				<input class="input_style" type="text" name="username" placeholder="이름" value="<%=user.getUserName() %>"><br>
			
				<P class="input_txt">Email</P>
				<input class="input_style" type="text" name="useremail" placeholder="@까지입력" value="<%=user.getUserEmail() %>"><br>			
			
				<p class="input_txt">Phone<p>
				<input class="input_style" type="text" name="userphone" placeholder="핸드폰번호" value="<%=user.getUserPhone() %>"f><br>
			
				<p class="input_txt">주소</p>
				<input class="input_style" type="text" name="userzip" placeholder="우편번호"value="<%=user.getUserZip() %>"><button class="smallBtn_syle">우편번호 검색</button><br>
				<input class="input_style" type="text" name="useraddr" placeholder="도로명주소" value="<%=user.getUserAddr() %>"><br> 
				<input class="input_style" type="text" name="useraddrdetail" placeholder="상세주소" value="<%=user.getUserAddr() %>"><br>
			
			
			<div id="join_submit_section">
				<input class="bigBtn_syle" type="submit" value="회원수정하기">
				<input class="bigBtn_syle" type="reset" onclick="history.back(-1);" value="취소">
				
			</div>
			
		</form>
		
	</div>
</main>
<%@ include file ="/views/common/footer.jsp" %>