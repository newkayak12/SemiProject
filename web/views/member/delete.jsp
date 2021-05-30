<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<main id="signinMain1">


	
		<div id="delete-member-container">
			<span>회원탈퇴</span>
			
				<form action=" <%=request.getContextPath()%>/sign/signoff/end"
				method="post">
				
					<div id="delete-input-id">
						<p class="input_txt">아이디</p>
						<input class="input_style" type="text" name="userId" placeholder="ID :)"> <br>
					</div>
					<div id="delete-input-pw">
						<p class="input_txt">PASSWORD</p>
						<input class="input_style" type="password" name="password" placeholder="PASSWORD"><br>
					</div>
				
				
					<div id="lostorsignup-container" class="bigBtn_style bigBtn_style">
						<input class="bigBtn_syle blue" type="submit" value="회원탈퇴하기">
					 	<input class="bigBtn_syle" style="color : black;" type="reset" onclick="history.back(-1);" value="취소">
	
					</div>
				
				</form>
	
		</div>
</main>
<%@ include file="/views/common/footer.jsp"%>