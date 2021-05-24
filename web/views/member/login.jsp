<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

 <link rel="stylesheet" href="web/css/style.css">
<%
Cookie[] lg = request.getCookies();
String check = null;
if (lg != null) {
	for (Cookie l : lg) {
		if (l.getName().equals("userid")) {

	check = l.getValue();

		}
	}

}
%>



<main id="signinMain1">


	<div class="wrap">
		<div class="container_wrap" id="signin-container">
			<h1>LOGIN</h1>
			<form action=" <%=request.getContextPath()%>/sign/signin/end"
				method="post">
				<div id="input_section">
					<div class="input_section_id">
						<p class="input_txt">아이디</p>
						<input class="input_style" type="text" name="userId" placeholder="ID :)"
							value="<%=check != null ? check : ""%>"> <br>
					</div>
					<div class="input_section_pw">
						<p class="input_txt">PASSWORD</p>
						<input class="input_style" type="password" name="password" placeholder="PASSWORD"><br>
					</div>
				</div>

				<div id="submit_section">

					<input class= "bigBtn_syle login_loginBtn" type="submit" value="로그인" onsubmit="">
					<div class="submit_section_idSave">
						<input type="checkbox" name="idsave">
						<p>아이디 저장</p>
					</div>
				

				</div>
			</form>



			<div id="check_signin">
				<!-- 로그인 검사 -->
				<p>
					<!-- 로그인 실패 아이디 혹은 비밀번호를 확인하세요 -->
				</p>
			</div>
			
			
			<div id="logstorsignup-search">
				<span><a
					href="<%=request.getContextPath()%>/search/search/start">아이디/비밀번호
						찾기</a></span>
			
			</div>



			<div id="lostorsignup-container" class="bigBtn_style bigBtn_style">
				<span><a
					href="<%= request.getContextPath()%>/sign/signup/start">회원 가입</a></span>
				 

			</div>
			


		</div>
	</div>

</main>

<%-- <script>
	const signin_ajax = () =>{
		console.log('1');
		$.ajax({
			url:"<%=request.getContextPath()%>/sign/signin/end",
			type:"post",
			data: {"id":$("#userId").val(),"password":$("#password").val()},
			success:data=>{
				
				console.log('2');
				console.log(data);
			}



		})
	}


</script> --%>
<%@ include file="/views/common/footer.jsp"%>
