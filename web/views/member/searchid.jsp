<%@page import="com.users.model.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Users users = (Users)request.getAttribute("useridtemp");

%>
<link rel="stylesheet" href="web/css/style.css">
<%@ include file ="/views/common/header.jsp" %>

<main id="searchidMain">

		<div id="searchid-container">
		
			<span>아이디 찾기</span>
			
			
			<form action="<%=request.getContextPath()%>/search/searchid/end"
			method="post">
				<div id="searchid_input_section">
					<p class="input_txt" style="text-align : start;">이름</p>
					<input class="input_style" type="text" name="username" id="idusername" placeholder="이름"><br>
					<p class="input_txt"  style="text-align : start;">이메일</p>
					<input class="input_style" type="email" name="useremail" id="pwemail" placeholder="이메일주소"><br>
					<p class="input_txt"  style="text-align : start;">전화번호</p>
					<input class="input_style" type="text" name="userPhone" id="iduserPhone" placeholder="핸드폰번호"><br>
					
				</div>
				
				
				<div id="searchid_submit_section">
					<input class="bigBtn_syle serchid_submit_btn" type="button" id="findid" value="아이디찾기">
					<input class="bigBtn_syle serchid_reset_btn" type="reset" onclick="history.back(-1);" value="취소">
				</div>
	
				
				<div id ="searchid_to_login" class="bigBtn_syle serchid_login_btn">
					<a href="<%= request.getContextPath() %>/sign/signin/start">로그인하기</a>
				</div>
		
			</form>			
	</div>

</main>


	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/emailjs-com@2/dist/email.min.js"></script>
<script type="text/javascript">

$(function init() {
emailjs.init("user_2vqdXq9qcr9TqpRIhPVG6");


})

$("#findid").click(()=>{

	let name = $("#idusername").val()
	let phone = $("#iduserPhone").val()
	
	
	
	var templateParams = {
			email: $("#pwemail").val(),
			
			<%
				String number = String.valueOf(((int) (Math.random()*1000)+1));
				if(number.length()<4){
					number+="0";
				}
				
				HttpSession sessions  = request.getSession();
				sessions.setAttribute("number", number);
				sessions.setMaxInactiveInterval(60*5);
				
				
				
			%>
			message :  '<%= number%>'
			
	}
	
	emailjs.send('service_fj5byad','template_rqzflyg', templateParams )
		 .then(function(response) {
         	       console.log('SUCCESS!', response.status, response.text);
         	    }, function(error) {
         	       console.log('FAILED...', error);
         	    });
	
	window.open('<%=request.getContextPath()%>/users/search/middle?info='+name+'&phone='+phone+'&flag=id', 'find' , 'width =500 height=500')

	
	/* template_rqzflyg */
	
	
	
})



</script>

<%@ include file ="/views/common/footer.jsp" %>