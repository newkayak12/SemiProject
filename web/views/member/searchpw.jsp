<%@page import="com.users.model.vo.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Users users = (Users)request.getAttribute("userpwtemp");

%>
<link rel="stylesheet" href="web/css/style.css">
<%@ include file ="/views/common/header.jsp" %>

<main id="searchpwMain">
		<div class="container_wrap" id="searchpw-container">
		
			<span>비밀번호 찾기</span>
			
			<form action="<%=request.getContextPath()%>/search/searchpw/end"
				method="post">
				<div id="searchpw_input_section">
					<p class="input_txt" style="text-align : start;">아이디</p>
					<input class="input_style" type="text" name="userid"  id="pwuserid"placeholder="아이디"><br>
					<p class="input_txt"  style="text-align : start;">이메일</p>
					<input class="input_style" type="email" name="useremail"  id= "pwemail" placeholder="이메일주소"><br>
					<p class="input_txt" style="text-align : start;">전화번호</p>
					<input class="input_style" type="text" name="userPhone" id="pwuserPhone" placeholder="핸드폰번호"><br>
				</div>
				
				<div id="searchpw_submit_section">
					<input class="bigBtn_syle serchid_submit_btn" type="button" id="findpw" value="비밀번호찾기">
					<input class="bigBtn_syle serchid_reset_btn" type="reset" onclick="history.back(-1);" value="취소">
				</div>
				
				
				<%-- <div>
					<div class="serachid_txt">
					<% if(users!=null) {%>
						<p>찾으시는 비밀번호는 </p><p><%=users.getUserPwd()%></p> <p>입니다.</p><br>
						<%} else { %>
							<p>해당하는 비밀번호는 없습니다.</p><br>
						<%} %>
					</div>
		 --%>			
					<div class="bigBtn_syle serchid_login_btn" id = "pw-to-login">
						<a href="<%= request.getContextPath() %>/sign/signin/start">로그인하기</a>
						<button id="findpw"> 로그인하기 </button>
					</div>
			</div>
			
		</form>			
	</div>

</main>




	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/emailjs-com@2/dist/email.min.js"></script>
<script type="text/javascript">

$(function() {
emailjs.init("user_2vqdXq9qcr9TqpRIhPVG6");


});
$("#findpw").click(()=>{

	let id = $("#pwuserid").val()
	let phone = $("#pwuserPhone").val()
	 console.log(id+":"+phone)
	
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
	
	window.open('<%=request.getContextPath()%>/users/search/middle?info='+id+'&phone='+phone+'&flag=pw', 'find' , 'width =500 height=500')

	
	/* template_rqzflyg */
	
	
	
})



</script>
	


<%@ include file ="/views/common/footer.jsp" %>