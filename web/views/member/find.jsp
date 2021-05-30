<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>window</title>
<%
	String info = (String)request.getAttribute("info");
	String phone = (String)request.getAttribute("phone");
	String flag = (String)request.getAttribute("flag");

%>

<script src ="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
</head>
<body>

<div style="display: flex; flex-direction:column; justify-content: center;">
<p id= "timer">5:00</p>

<div style="display: flex; justify-content: space-between;">
	<input type="text" id = "token" placeholder = "인증번호를 입력하세요">
	<button id="finishing">인증번호 입력완료</button>
</div>
</div>

<input type= "hidden" value="<%=info %>" id= "infos">
<input type= "hidden" value="<%=phone %>" id= "phones">

</body>
</html>

<script>

$(function(){
	
	let alltime = 5*60-1;
	
	let countdown = setInterval(function(){
	
		let minutes = parseInt(alltime/60)
		let second = parseInt (alltime%60)
		
		$("#timer").html(minutes +" : " + second);
		alltime = alltime -1
		
		if( alltime < 0 ){
			clearInterval(countdown)
			
			
			
		}
		
		
	}, 1000)
	
	
	
	
});

$("#finishing").click(()=>{
	
	let token = $("#token").val();
	let session = <%= request.getSession().getAttribute("number")%>;
	
	if(token==session){
		
		let phones = $("#phones").val()
		let infos = $('#infos').val()
		
		if(<%=flag.equals("pw")%>){
			<%System.out.println("비밀번호"); %>
			location.assign('<%=request.getContextPath()%>/search/searchpw/end?userid='+infos+'&userPhone='+phones);
			
		} else {
			location.assign('<%=request.getContextPath()%>/search/searchid/end?username='+infos+'&userPhone='+phones);
			
		}
		
		
		
		
	} else {
		
		alert('인증번호가 유효하지 않습니다.')
		
	}
	
	
	
	
})



</script>