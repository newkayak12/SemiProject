<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<%@ page import = "com.cart.model.vo.Cart" %>
<%@ page import = "java.util.List" %>

<% 
	int flag  = (Integer) request.getAttribute("flag");
	Cart cart = null;
	List<Cart> list = null;

	if(flag ==0){
	/* 바로 구매 */
	
		 cart = (Cart) request.getAttribute("list");
	}else {
		/*  장바구니 */
		
		list = (List<Cart>) request.getAttribute("list");
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
				<tr>
					<th>사진</th>
					<th>제품명</th>
					<th>사이즈</th>
					<th>색상</th>
					<th>가격</th>
					<th>개수</th>
					
				</tr>
				
				<%if(flag ==0) {%>
					<td>
						<img alt="" src="">
					</td>
					<td>
						<%=cart.getProductName() %>
					</td>
					<td>
						<%=cart.getProductOptionSize() %>
					</td>
					<td>
						<%=cart.getProductOptionColor() %>
					</td>
					<td>
						<%=cart.getProductPrice() %>
					</td>
					<td>
						<%=cart.getProductCount() %>
					</td>
				
				<%
				
					}  else {
						for(Cart temp : list){
				
				
				%>
					
					
					
					
				
				
				<%
						}				
						} %>
				
				
				</table>
			</div>
			
			<div id>
			
			</div>
			
			
		</div>
</main>

<%@ include file = "/views/common/footer.jsp"%>