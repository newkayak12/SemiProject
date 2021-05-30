<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/views/common/header.jsp" %>



<main id="myPage">
		<div class="container_wrap" id="myPage-container">
			<span>마이페이지</span>
			
			<div id = "order-cart">
				<span><a class="serch_btn" href="<%= request.getContextPath()%>/order/list">주문내역</a></span>
				<span><a class="serch_btn" href="<%= request.getContextPath()%>/cart/list">장바구니</a></span>
			</div>
			<div id = "board-modi">
				<span><a class="serch_btn" href="<%= request.getContextPath()%>//MyQna/list">나의게시글</a></span>
				<span><a class="serch_btn" href="<%= request.getContextPath()%>/sign/modify/start?userId=<%=userid%>">회원정보수정</a></span>
			</div>
			<div id="drop-out">	
				<span><a class="serch_btn" href="<%= request.getContextPath()%>/sign/signoff/start?userId=<%=userid%>">회원탈퇴</a></span>
			</div>
		</div>
		
		<div id="join_submit_section">
				<input class="bigBtn_syle" type="reset" onclick="history.back(-1);" value="취소">
	</div>


</main>
<%@ include file ="/views/common/footer.jsp" %>
