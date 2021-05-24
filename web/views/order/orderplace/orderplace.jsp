<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<%@ page import = "com.cart.model.vo.Cart" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.users.model.vo.Users" %>

<% 
	Users user = (Users) session.getAttribute("user");
	int flag  = (Integer) request.getAttribute("flag");
	Cart cart = null;
	List<Cart> list = null;
	int result = 0;
	if(flag ==0){
	/* 바로 구매 */
	
		 cart = (Cart) request.getAttribute("list");
		request.setAttribute("list",cart);
	}else {
		/*  장바구니 */
		
		list = (List<Cart>) request.getAttribute("list");
		request.setAttribute("list", list);
	}
%>
<main id = "orderplace-main">

		<div id="orderplace-container">	
			<div id = "orderplace_title-container">
				<h1>주문결제</h1>
				<hr>
			</div>
			<div id="product_info-container">
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
					<%-- 	<%=cart.getProductName() %> --%>
					</td>
					<td>
						<%-- <%=cart.getProductOptionSize() %> --%>
					</td>
					<td>
						<%-- <%=cart.getProductOptionColor() %> --%>
					</td>
					<td>
						<%-- <%=cart.getProductPrice() %> --%>
					</td>
					<td>
						<%-- <%=cart.getProductCount() %> --%>
					</td>
				
				<%
				
					}  else {
						for(Cart temp : list){
				%>
					
					<td>
						<%-- <%= temp.getProductName() %> --%>
					</td>
					<td>
						<%-- <%= temp.getProductOptionSize() %> --%>
					</td>
					<td>
						<%-- <%= temp.getProductOptionColor() %> --%>
					</td>
					<td>
						<%-- <%= temp.getProductPrice() %> --%>
					</td>
					<td>
						<%-- <%= temp.getProductCount() %> --%>
					</td>
				
				
				<%
					}				
						} %>
				<tr>
					<td rowspan="5">
					
					총 가격 : 배송비 2500원 +
					
						
						<% 
						
						if(flag ==0){
						
							/* result = cart.getProductPrice(); */
						%>
						
							<%-- 상품 가격 <%=cart.getProductPrice() %> = <%=result +2500 %>원 --%>
							
						<%}  else {
							for(Cart c : list){
							/* 	result += c.getProductPrice(); */
							}
						%>
							
							상품 가격 <%=result %> = <%=result + 2500 %>원
						
						
						<%} %>
					</td>
				</tr>
				</table>
			</div>
			
			<div id = "user_info-container">
				<p>주문 정보</p>
				
				<table>
					<tr>
						<th>주문하시는 분</th>
						<td><%=user.getUserName() %></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><%=user.getUserAddr() %></td>
					</tr>		
					<tr>
						<th>휴대전화</th>
						<td><%=user.getUserPhone() %></td>
					</tr>		
					<tr>
						<th>이메일</th>
						<td><%=user.getUserEmail() %></td>
					</tr>								
				</table>
			</div>
			
			<div id = "payment-container">
				<div id="payment_selector-contianer">
					<input type = "radio" name = "payraido" id="pay" value="무통장입금" checked>
					<input type = "radio" name = "payraido"	id="kakao" value = "카카오페이">
				</div>
				
				<table id="pay-table">
					
				</table>
				
			</div>
			
			<div>
				<input type="button" value ="결제">
				<input type="button" value ="취소">
			</div>
			
			
		</div>
</main>

<script>
$(function(){
	

	$("#pay").on("checked",(e)=>{
		$("#pay-table").append($("<tr>").append($("<th>".html("입금자명"))).append($("<td>").html("<%=user.getUserName()%>")));
		const opt1 = $("<option>").attr({"value":"하나은행 661-910265-*****",
			"name":"pay_sel"
			
			
		})
		const opt2 = $("<option>").attr({
			"value":"신한은행 910-910265-*****",
			"name":"pay_sel"
			
		})
		$("#pay-table").append($("<tr>").append($("<th>".html("입금자은행"))) .append($("<td>").append( $("<select>")).append(opt1 ).append(opt2)  ) );
		
		
	})

})
</script>

<%@ include file = "/views/common/footer.jsp"%>