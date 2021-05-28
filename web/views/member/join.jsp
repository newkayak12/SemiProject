<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/views/common/header.jsp" %>

<link rel="stylesheet" href="web/css/style.css">


<main id="joinMain">
	<div class="wrap"style="margin-bottom:40px; margin-left: 0px; ">
		<div class="container_wrap" id="join-container" style="margin-bottom:10px; ">
		
		<h1>회원가입</h1>
		<h4 style="text-align: right; color: red;">* 모든 사항이 필수 입력입니다.</h4>
		<form action="<%=request.getContextPath() %>/sign/signup/end"
		method="post">
			<div id="join_input_section">
			
				<p class="input_txt">ID</p>
				<input class="input_style" type="text"  id= "userId"name="userId" placeholder="ID" onblur="fn_ajaxcheck()" required>
				<div id="id_check"></div>
					
				<p class="input_txt">PassWord</p>
				<input class="input_style" type="password" name="password" id="password" placeholder="PASSWORD"><br>
				
				<p class="input_txt">PassWord check</p>
				<input class="input_style" type="password" name="password-check" id="password-check" placeholder="PASSWORD"><br>
				<div id="checkpw"></div>
					
				
				<p class="input_txt">Name</p>
				<input class="input_style" type="text" name="username" placeholder="이름"><br>
				<P class="input_txt">Email</P>
				<input class="input_style" type="text" name="useremail" placeholder="@까지입력"><br>
				<p class="input_txt">Phone<p>
				<input class="input_style" type="text" name="userPhone" placeholder="핸드폰번호"><br>
				<p class="input_txt">주소</p>
				<input class="input_style" type="text" name="userzip"  id = "userzip"placeholder="우편번호" style="width:70%;"><button class="smallBtn_syle" id="findaddr">우편번호 검색</button><br>
				<input class="input_style" type="text" name="useraddr" id = "useraddr"placeholder="도로명주소"><br> 
				<input class="input_style" type="text" name="useraddrdetail"  id = "useraddrdetail" placeholder="상세주소" required><br>
			</div>
			
			
			<div id="join_submit_section">
				<input class="bigBtn_syle" type="submit" value="회원가입하기">
				<input class="bigBtn_syle" type="reset" onclick="history.back(-1);" value="취소">
				
			</div>
		</form>
	</div>
	</div>
</main>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<script>
$("#findaddr").click(()=>{

new daum.Postcode({
    oncomplete: function(data) {
        console.log(data["zonecode"])
        $("#userzip").val(data["zonecode"])
        console.log(data["address"])
        $("#useraddr").val(data["address"])
        
       console.log(data)
    }
}).open();
	
})












/*  2차 비번에 onkeyup 걸고
 1차 비번값 2차비번값 다가져와서 같은면 checkpw에 일치합니다 
 아니면 일치하지 않습니다 */
 
 $("#password-check").keyup((e)=>{
	 let pw1 = $("#password").val()
	 let pw2 = $(e.target).val()
	 
	 	if(pw1 ==  pw2 ){
	 		$("#checkpw").text('비밀번호가 일치합니다.')
	 		$("#checkpw").css("color","green")
	 	
	 	} else {
	 		$("#checkpw").text('비밀번호가 일치하지 않습니다.')
	 		$("#checkpw").css("color","red")
	 	}
 })
 
 /* $("#userid").click(function(){ */
 const fn_ajaxcheck=()=>{
	 var userid=$('#userId').val();
	 console.log(userid);
	 $.ajax({
		 url : "<%=request.getContextPath()%>/check/checkid/ajax",
		 data :{"userId":$("#userId").val()},
		 success : data=>{
			 
			 let idval =$("#id_check");
			 
			 var idReg = /^[A-Za-z0-9]{5,12}$/g;
			 if(data=="no"){
				 idval.text("사용중인아이디");
				 idval.css("color","red");
			 }
			 else{
				 if(idReg.test(userid)){
					 idval.text("사용가능한 아이디");
					 idval.css("color","green");
				 }
				 else if(userid==""){
											 
					 idval.text("아이디를 입력해주세요");
					 idval.css("color","red");
				 
					 }
				 else {
					idval.text("아이디는 영어,숫자 5자리이상 12자리이하입니다.");
					idval.css("color","blue");	 
				 
				 }
			 }
			 
		 }
	 });
 };
 
</script>
<%@ include file ="/views/common/footer.jsp" %>
