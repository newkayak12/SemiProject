<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/views/common/header.jsp" %>


<main id="joinMain">
	<div id="join-container">
		
		<form action="<%=request.getContextPath() %>/sign/signup/end"
		method="post">
			<div id="join_input_section">
				<p>ID</p>
				<input type="text" name="userId" placeholder="id"><button>아이디 중복확인</button><br>
				<p>PassWord</p>
				<input type="password" name="password" placeholder="pw"><br>
				<p>PassWord check</p>
				<input type="password" name="password-check" placeholder="pw-ck"><br>
				<p>Name</p>
				<input type="text" name="username" placeholder="이름"><br>
				<P>Email</P>
				<input type="text" name="useremail" placeholder="@까지입력"><br>
				<p>Phone<p>
				<input type="text" name="userPhone" placeholder="핸드폰번호"><br>
				<p>주소</p>
				<input type="text" name="userzip" placeholder="우편번호"><button>우편번호 검색</button><br>
				<input type="text" name="useraddr" placeholder="도로명주소"><br> 
				<input type="text" name="useraddrdetail" placeholder="상세주소"><br>
			</div>
			
			
			<div id="join_submit_section">
				<input type="submit" value="회원가입하기">
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
</main>
<%@ include file ="/views/common/footer.jsp" %>