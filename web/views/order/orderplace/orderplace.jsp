<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<%@ page import = "com.cart.model.vo.Cart" %>
<%@ page import = "java.util.List" %>

<% 
	int flag  = (Integer) request.getAttribute("flag");

	if(flag ==0){
	/* 바로 구매 */
	
		Cart list = (Cart) request.getAttribute("list");
	}else {
		/*  장바구니 */
		
		List<Cart> list = (List<Cart>) request.getAttribute("list");
	}
%>
<main id = "orderplace-main">

		<div id="orderplace-container">	
			<div id = "orderplace_title-container">
				<h1>주문결제</h1>
				<hr>
			</div>
			<div id="user_info-container">
				<table id="orderplace-table">
				
				
				</table>
			</div>
			
			
		</div>
</main>

<%@ include file = "/views/common/footer.jsp"%>