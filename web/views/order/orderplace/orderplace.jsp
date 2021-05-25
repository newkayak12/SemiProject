<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<%@ page import = "com.cart.model.vo.Cart" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.users.model.vo.Users" %>

<% 
	



	Users user = null;
	int flag  = 0;
	String flag2 = null;
	Object c = request.getAttribute("flag2");
	
	
	if(c!=null){
		flag2=(String) c;
	}
	Object j = request.getSession().getAttribute("user");
	if(j!= null){
		user = (Users) j;
	}
	
	 
	List<Cart> list = null;
	Cart cart = null;
	int result = 0;
	if(flag ==0 && flag2.equals("cart")){
	/* 바로 구매 */
	
		 cart = (Cart) request.getAttribute("list");
		/* request.setAttribute("list",cart); */
		
		
	}else {
		/*  장바구니 */
		
		list = (List<Cart>) request.getAttribute("list");
		/* request.setAttribute("list", list); */
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
				
				
				
				<%if(flag ==0 && flag2.equals("cart")) {%>
				<tr>
					<td>
						<img alt="사진" src="<%=request.getContextPath()%>/upload/product/<%= cart.getProductFile()%>">
					</td>
					<td>
					 	<%= cart.getCartName() %> 
					</td>
					<td>
						 <%=cart.getCartOptionSize() %> 
					</td>
					<td>
						<%=cart.getCartOptionColor() %>
					</td>
					<td>
						 <%=cart.getCartPrice()%>
					</td>
					<td>
						 <%=cart.getCartStock() %> 
					</td>
				</tr>
				
				<%
				
					}  else {
						for(Cart temp : list){
				%>
					
				<tr>
					<td>
							<img alt="사진" src="<%=request.getContextPath()%>/upload/product/<%= temp.getProductFile()%>">
					</td>
					<td>
					 	<%= temp.getCartName() %> 
					</td>
					<td>
						 <%=temp.getCartOptionSize() %> 
					</td>
					<td>
						<%=temp.getCartOptionColor() %>
					</td>
					<td>
						 <%=temp.getCartPrice()%>
					</td>
					<td>
						 <%=temp.getCartStock() %> 
					</td>
				
				</tr>
				
				<%
					}				
						} %>
						
				
				
				<tr>
					<td rowspan="5">
					
					총 가격 : ( 배송비 ) 2500원 +
					
						
						<% 
						
						if(flag ==0 && flag2.equals("cart")){
							result = 0;
							 result = cart.getCartPrice(); 
						%>
						
							( 상품 가격 ) <%=cart.getCartPrice() %>원  = <%=result +2500 %> 원  
							
						<%}  else {
							for(Cart l : list){
								result = 0;
								result += l.getCartPrice()*l.getCartStock();
							}
						%>
							
							( 상품 가격 ) <%=result %>원  = <%=result + 2500 %>원
						
						
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
						<td> <%=user.getUserAddr() %></td>
					</tr>		
					<tr>
						<th>휴대전화</th>
						<td> <%=user.getUserPhone() %> </td>
					</tr>		
					<tr>
						<th>이메일</th>
						<td> <%=user.getUserEmail() %></td>
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