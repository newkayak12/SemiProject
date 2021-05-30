<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>change password</title>

<%
	String id = (String) request.getAttribute("id");
%>
</head>
<body>

	<div style="display: flex; justify-content: center; align-items: center; flex-direction: column">
		<div>
			비밀번호 : <input type="password" name = "password" id="password" placeholder="비밀번호" required="required">
		</div>
		<div>
			비밀번호 확인 : <input type="password" id="passwordcheck" placeholder="비밀번호 확인" required="required" onkeyup="fn_check()">
		</div>
		<p id ="checker"></p>
		
		<button onclick = "fn_replace()">비밀번호 변경</button>
	</div>

</body>
<script src ="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
	
	const fn_check=()=>{
		let pw1 = $("#passwordcheck").val()
		let pw2 = $("#password").val()
		
		if(pw1!=pw2){
			
			$("#checker").html("비밀번호가 일치하지 않습니다.").css("color","red")
			
		} else {
			
			
			$("#checker").html("훌륭한 비밀번호 입니다.").css("color","green")
		}
		
		
		
	}
	
	
	const fn_replace = () =>{
		let pw1 = $("#passwordcheck").val()
		let pw2 = $("#password").val()
		
		if(pw1==pw2){
			$.ajax({
				url:"<%=request.getContextPath()%>/user/search/replace",
				data:{"password":pw2,"id":'<%=id%>'},
				success:data=>{
					
					alert('비밀번호 변경이 완료되었습니다.')
					window.close()
					opener.location.assign('<%=request.getContextPath()%>/')
				}
			})
		} else {
			
			alert('비밀번호가 일치하지 않습니다.')
		}
		
	}
	

</script>
</html>