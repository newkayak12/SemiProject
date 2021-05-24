<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/views/common/header.jsp" %>

<link rel="stylesheet" href="web/css/style.css">

<main id="myPage">
	<div class="wrap">
		<div class="container_wrap" id="search-container">
			<h1>마이페이지</h1>
			
			<span><a class="serch_btn" href="<%= request.getContextPath()%>/order/list">주문내역</a></span>
			<span><a class="serch_btn" href="<%= request.getContextPath()%>/cart/list">장바구니</a></span>
			<span><a class="serch_btn" href="<%= request.getContextPath()%>/review/list">나의게시글</a></span>
			<span><a class="serch_btn" href="<%= request.getContextPath()%>/sign/modify/start?userId=<%=userid%>">회원정보수정</a></span>
		
		</div>
		
		<div id="join_submit_section">
				<input class="bigBtn_syle" type="reset" onclick="history.back(-1);" value="취소">
	</div>
	</div>

</main>
<%@ include file ="/views/common/footer.jsp" %>
