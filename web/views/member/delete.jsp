<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
main id="signinMain1">


	<div class="wrap">
		<div class="container_wrap" id="signin-container">
			<h1>회원탈퇴</h1>
			<form action=" <%=request.getContextPath()%>/sign/signoff/end"
				method="post">
				<div id="input_section">
					<div class="input_section_id">
						<p class="input_txt">아이디</p>
						<input class="input_style" type="text" name="userId" placeholder="ID :)"> <br>
					</div>
					<div class="input_section_pw">
						<p class="input_txt">PASSWORD</p>
						<input class="input_style" type="password" name="password" placeholder="PASSWORD"><br>
					</div>
				</div>
				
				<div id="lostorsignup-container" class="bigBtn_style bigBtn_style">
					<input class="bigBtn_syle" type="submit" value="회원탈퇴하기">
				 	<input class="bigBtn_syle" type="reset" onclick="history.back(-1);" value="취소">

				</div>
				
			</form>
		</div>
	</div>

</main>
<%@ include file="/views/common/footer.jsp"%>