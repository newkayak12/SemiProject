<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/views/common/header.jsp" %>


<%
	Cookie[] lg = request.getCookies();
	String check = null;
	if(lg!=null){
		for(Cookie l : lg){
			if(l.getName().equals("userid")){
				
				check = l.getValue();
				
			}
		}
		
	}
%>



<main id="signinMain">

	<div id="signin-container">
		
			<form action=" <%=request.getContextPath() %>/sign/signin/end" method="post">
				<div id="input_section">
					<p>ID</p>
					<input type="text" name="userId" placeholder="ID :)" value="<%=check!=null? check:""%>">
					<br>
					<p>PASSWORD</p>
					<input type="password" name="password" placeholder="PASSWORD"><br>
				</div>
				

				<div id="submit_section">
						아이디저장<input type="checkbox" name="idsave" style="width:20px; margin-left: 10px !important; margin-right: 15px !important;" <%= check!=null? "checked":"" %>>
						<input type="submit" value="로그인" onsubmit="" style="width:150px; margin-left: 15px !important; margin-right: 10px !important; margin-bottom:10px !important" >
				</div>
			</form>
		
		

		<div id="check_signin">
		<!-- 로그인 검사 -->
		<p><!-- 로그인 실패 아이디 혹은 비밀번호를 확인하세요 --></p>
		</div>
		
		
		
		<div id="lostorsignup-container">
			<span><a href = "<%=request.getContextPath()%>/sign/signup/start">회원 가입</a></span>
			<span><a href = "">아이디/비밀번호 찾기</a></span>

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
<%@ include file ="/views/common/footer.jsp" %>
