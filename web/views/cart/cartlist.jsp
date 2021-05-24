<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ include file = "/views/common/header.jsp"%>
<%@ page import ="java.util.*" %>
<%@ page import = "com.cart.model.vo.Cart" %>

<% List<Cart> cartlist = (List<Cart>) request.getAttribute("cartlist"); %> 
	



<main id="cart-main">
	<div id="cart-container">
		<div id="cart_title">
			<p>장바구니</p>
		</div>
		
		<div>
			<table id="cart-table" class="cartchecker">
				<tr>
					<th>
						<input type="checkbox" name="cart_check_all" id="cart_check_all"  >
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
						<td class = "cartchecker">
							<input type="checkbox" name="cart_list"+<%=i %> id="cart_list"+<%=i%>>
						</td>
						<td>
							
							<img alt="" src="<%=request.getContextPath()%>/upload/goods/"<%=cartlist.get(i).getProductId()+"_"+cartlist.get(i).getCategoryId() %>>
									<!--사진이름은? 제품번호+카테고리  -->
						</td>
						<td><%=cartlist.get(i).getProductName() %></td>
						<td id="productPrice"+<%=i %>><%=cartlist.get(i).getProductPrice() %></td>
						<td>2500원</td>
					</tr>
					
					<%}%>
					
				
				<tr>
					<td rowspan="5" id="result">
						<%
							int result = 0;
							int shippay = 2500;
						for( int i = 0; i<cartlist.size(); i++){
							
								result+=cartlist.get(i).getProductPrice();
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
				<button type="button" onclick ="location.assing('<%=request.getContextPath()%>/')">돌아가기</button>
			</span>
			<span>
				<button type="button" onclick ="fn_buy()">구매하기</button>
			</span>
		</div>
		
		<%}%>
	</div>

<!-- 스크립트! -->
	<script>
			$("#cart_check_all").change((e)=>{
				$(".cartchecker").children().each((i,v)=>{
					$(v).attr("check", true);
				})
			})
			
			const fn_buy = () =>{
				/* 플래그 넘기기 */
			}


	</script>

</main>
<%@ include file = "/views/common/footer.jsp"%>