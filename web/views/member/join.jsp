<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/views/common/header.jsp" %>

<link rel="stylesheet" href="web/css/style.css">


<main id="joinMain">
	<div class="wrap">
		<div class="container_wrap" id="join-container">
		
		<h1>회원가입</h1>
		
		<form action="<%=request.getContextPath() %>/sign/signup/end"
		method="post">
			<div id="join_input_section">
				<p class="input_txt">ID</p>
				<input class="input_style join_input_id" type="text" name="userId" placeholder="id"><button class="smallBtn_syle">아이디 중복확인</button><br>
				<p class="input_txt">PassWord</p>
				<input class="input_style" type="password" name="password" placeholder="pw"><br>
				<p class="input_txt">PassWord check</p>
				<input class="input_style" type="password" name="password-check" placeholder="pw-ck"><br>
				<p class="input_txt">Name</p>
				<input class="input_style" type="text" name="username" placeholder="이름"><br>
				<P class="input_txt">Email</P>
				<input class="input_style" type="text" name="useremail" placeholder="@까지입력"><br>
				<p class="input_txt">Phone<p>
				<input class="input_style" type="text" name="userPhone" placeholder="핸드폰번호"><br>
				<p class="input_txt">주소</p>
				<input class="input_style" type="text" name="userzip" placeholder="우편번호"><button class="smallBtn_syle">우편번호 검색</button><br>
				<input class="input_style" type="text" name="useraddr" placeholder="도로명주소"><br> 
				<input class="input_style" type="text" name="useraddrdetail" placeholder="상세주소"><br>
			</div>
			
			
			<div id="join_submit_section">
				<input class="bigBtn_syle" type="submit" value="회원가입하기">
				<input class="bigBtn_syle" type="reset" onclick="history.back(-1);" value="취소">
				
			</div>
		</form>
	</div>
	</div>
</main>
<%@ include file ="/views/common/footer.jsp" %>