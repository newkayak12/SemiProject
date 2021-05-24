<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ include file = "/views/common/header.jsp"%>
<%@ page import ="java.util.*" %>
<%@ page import = "com.cart.model.vo.Cart" %>



<%
	List<Cart> cartlist = new ArrayList();
	Object o =  request.getAttribute("cartlist");
	if(o!=null){
		cartlist = (List<Cart>) o;
	}
	
	
	Cookie[] c = request.getCookies();
	String cookieContent = "";
	
	if(c!=null){
		for(Cookie cookie : c){
			if(cookie.getName().equals("cartlist")){
				cookieContent = cookie.getValue();
				break;
			}
		}
	}
%> 
	



<main id="cart-main">
	<div id="cart-container">
		<div id="cart_title">
			<p>장바구니</p>
		</div>
		
		<div>
			<table id="cart-table" class="cartchecker">
				<tr>
					<th>
						<input type="checkbox" name="cart_check_all" id="cart_check_all" onchange="fn_checked()" >
					</th>
					<th>전체선택</th>
					<th>상품정보</th>
					<th>상품금액</th>
					<th>배송비</th>
				</tr>
				<%
				
				if(cartlist!=null){
					for( int i = 0; i<cartlist.size(); i++) {
						
						
					%>
					<tr> 
						<td >
							<input type="checkbox" class = "cartchecker" name="cart_list" id="cart_list">
							<!-- pid+'@'+size+'@'+color+'@'+price+'@'+stock+'@'+category -->
							<input type="hidden" value="<%=cartlist.get(i).getProductId()%>@<%=cartlist.get(i).getCartOptionSize()%>@<%=cartlist.get(i).getCartOptionColor()%>@<%=cartlist.get(i).getCartPrice()%>">
						</td>
						<td>
							
							<img alt="사진" src="<%=request.getContextPath()%>/upload/product/<%=cartlist.get(i).getProductFile()%>" width="100px">
							
							
									<!--사진이름은? 제품번호+카테고리  -->
						</td>
						<td><%=cartlist.get(i).getCartName() %></td>
						<td id="productPrice">
							<%= cartlist.get(i).getCartPrice() %>
						</td>
						<td>2500원</td>
					</tr>
					
					<%}%>
					
				
				<tr>
					<td colspan="5" id="result">
						<%
							int result = 0;
							int shippay = 2500;
						for( int i = 0; i<cartlist.size(); i++){
							
								result+=cartlist.get(i).getCartPrice();
						}
						%>
						
						<p>상품 가격&nbsp;:&nbsp;<%= result %>&nbsp;&nbsp;배송&nbsp;:&nbsp;<%= shippay %>&nbsp;=&nbsp;주문 금액:&nbsp;<%=result+shippay %></p>
				
					</td>
				</tr>
				<%} else {%>
				<tr>
					<td colspan="5" rowspan="2" id="result_none"> 장바구니가 비었습니다. </td>
				</tr>
				<tr>
				
				</tr>
				
				<%} %>
			</table>
			
			
		</div>
		
		<%if(cartlist!=null){
				
					%>
		<div>
			<span>
				<button type="button" onclick ="location.assign('<%=request.getContextPath()%>/')">돌아가기</button>
			</span>
			<span>
				<button type="button" onclick ="fn_buy()">구매하기</button>
			</span>
			<span>
				<button type="button" ></button>
			</span>
		</div>
		
		<%}%>
	</div>
	<input type="hidden" id = "cartCookie">
</main>
<!-- 스크립트! -->
	<script>
			const fn_checked=()=>{
					

					if($(".cartchecker").attr("checked")=="checked"){
						$(".cartchecker").attr("checked", false);
					} else {
						$(".cartchecker").attr("checked", true);
					}
				
			}
			
			const fn_buy = () =>{
				/* 플래그 넘기기 */
			}
			
			
			
			


	</script>

<%@ include file = "/views/common/footer.jsp"%>