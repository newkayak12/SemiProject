<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/views/common/header.jsp" %>

<main id="searchidMain">
	<div id="searchid-container">
		
		<form action="<%=request.getContextPath()%>/search/searchid/end"
		method="post">
			<div id="searchid_input_section">
				<p>이름</p>
				<input type="text" name="username" placeholder="이름"><br>
				<p>전화번호</p>
				<input type="text" name="userPhone" placeholder="핸드폰번호"><br>
			</div>
			
			<div id="searchid_submit_section">
				<input type="submit" value="아이디찾기">
				<input type="reset" value="취소">
			</div>
			
		</form>			
	</div>
</main>

<%@ include file ="/views/common/footer.jsp" %>