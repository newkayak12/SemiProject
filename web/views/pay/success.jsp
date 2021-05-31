<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp" %>
<main style="display: flex; justify-content: center; align-content: center">
	<div style="height:500px; display: flex; flex-direction:column;  justify-content: center; align-items: center;">
	 	<p> 결제가 완료되었습니다.</p>
	 	
	 	<p> <span id ="timer" > 5</span><span>초 후 메인으로 돌아갑니다.</span></p>
	 	
	</div>
</main>
<%@ include file = "/views/common/footer.jsp" %>

<script>
	$(function(){
		setInterval(() => {
			let timer = $("#timer").html() -1
			$("#timer").html(timer);
			
			if($("#timer").html()==0){
				location.assign('<%=request.getContextPath()%>/');
			}
			
		}, 1000);
	})
</script>