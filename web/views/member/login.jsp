<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

 
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

<!-- 안녕 -->

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
							value="<%=check != null ? check : ""%>" style="margin-left:0px;"> <br>
					</div>
					<div class="input_section_pw">
						<p class="input_txt">PASSWORD</p>
						<input class="input_style" type="password" name="password" placeholder="PASSWORD" style="margin-left:0px;">
					</div>
				</div>

				<div id="submit_section" style="display: flex; flex-direction: column;">

					<input class= "bigBtn_syle login_loginBtn" type="submit" value="로그인" onsubmit="">
					<div style ="display: flex; justify-content: space-between; flex-direction: row;">
						<div class="submit_section_idSave" style="display:flex; align-items: center;">
							<input type="checkbox" name="idsave">
							<p>아이디 저장</p>
						</div>
						
						<div id="logstorsignup-search" style="display:flex; align-content: center">
							<a href="<%=request.getContextPath()%>/search/search/start" style="width:150px; margin-left:0px !important;  text-align: right;">
								아이디/비밀번호 찾기
							</a>
						</div>
					</div>							

				</div>
			</form>



			<div id="check_signin">
				<!-- 로그인 검사 -->
				<p>
					<!-- 로그인 실패 아이디 혹은 비밀번호를 확인하세요 -->
				</p>
			</div>
			
			<%-- 
			<div id="logstorsignup-search">
				<span><a
					href="<%=request.getContextPath()%>/search/search/start">아이디/비밀번호
						찾기</a></span>
			
			</div>
 --%>


			<div id="lostorsignup-container" class="bigBtn_style bigBtn_style">
				<a href="<%= request.getContextPath()%>/sign/signup/start" style="width:450px;">회원 가입</a>
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
