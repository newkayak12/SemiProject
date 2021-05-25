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
	
	Cookie cookie = new Cookie("cartlist", cookieContent);
	cookie.setMaxAge(60*60*24*365*100);
%> 
	



<main id="cart-main">
	<div id="cart-container">
		<div id="cart_title">
			<p>장바구니</p>
		</div>
		
		<div>
			<table id="cart-table" >
				<tr>
					<th>
						<input type="checkbox" name="cart_check_all" id="cart_check_all" onclick="fn_checked()" >
					</th>
					<th>전체선택</th>
					<th>상품정보</th>
					<th>상세</th>
					<th>상품금액</th>
					<th>배송비</th>
				</tr>
				<%
				
				if(cartlist!=null&&cartlist.size()>0){
					for( int i = 0; i<cartlist.size(); i++) {
						
						
					%>
					<tr> 
						<td >
							<input type="checkbox" class = "cartchecker" name="cart_list" id="cart_list" value="#<%=cartlist.get(i).getProductId()%>@<%=cartlist.get(i).getCartOptionSize()%>@<%=cartlist.get(i).getCartOptionColor()%>@<%=cartlist.get(i).getCartPrice()%>@<%=cartlist.get(i).getCartStock()%>@<%=cartlist.get(i).getCategoryId()%>">
							<%-- <!-- pid+'@'+size+'@'+color+'@'+price+'@'+stock+'@'+category -->
							<input type="hidden" value="#<%=cartlist.get(i).getProductId()%>@<%=cartlist.get(i).getCartOptionSize()%>@<%=cartlist.get(i).getCartOptionColor()%>@<%=cartlist.get(i).getCartPrice()%>@<%=cartlist.get(i).getCartStock()%>@<%=cartlist.get(i).getCartStock()%>"> --%>
						</td>
						<td>
							
							<img alt="사진" src="<%=request.getContextPath()%>/upload/product/<%=cartlist.get(i).getProductFile()%>" width="100px">
							
							
									<!--사진이름은? 제품번호+카테고리  -->
						</td>
						<td>
							<div>
								<%=cartlist.get(i).getCartName() %>
							</div>
							<div>
								<span><%=cartlist.get(i).getCartOptionColor() %></span>
								<span><%=cartlist.get(i).getCartOptionSize() %></span>
							</div>
						</td>
						<td>
							<%=cartlist.get(i).getCartStock() %>
						</td>
						<td id="productPrice">
							<%= cartlist.get(i).getCartPrice() %>
						</td>
						<td>2500원</td>
					</tr>
					
					<%}%>
					
				
				<tr>
					<td colspan="6" id="result">
						<%
							int result = 0;
							int shippay = 2500;
						for( int i = 0; i<cartlist.size(); i++){
							
								result+=cartlist.get(i).getCartPrice() * cartlist.get(i).getCartStock();
						}
						%>
						
						<p>상품 가격&nbsp;:&nbsp;<%= result %>&nbsp;&nbsp;배송&nbsp;:&nbsp;<%= shippay %>&nbsp;=&nbsp;주문 금액:&nbsp;<%=result+shippay %></p>
				
					</td>
				</tr>
				<%} else {%>
				<tr>
					<td colspan="6" rowspan="2" id="result_none"> 장바구니가 비었습니다. </td>
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
				<button type="button" onclick = "fn_cart()"  >선택항목 삭제</button>
			</span>
		</div>
		
		<%}%>
	</div>
	
	<form action="<%=request.getContextPath()%>/cart/update" id = "cartfrom" >
		<input type="hidden" id = "cartCookie" name="cartCookie">
	</form>
	
	<%-- <input type="hidden" id="cartlistset" value = "<%=cookieContent%>"> --%>
</main>
<!-- 스크립트! -->
	<script>
			const fn_cart=()=>{
				alert('선택 항목을 삭제합니다.')
				$("#cartfrom").submit()
				
			}


			const fn_checked=()=>{
				
				if($("#cart_check_all").prop("checked")==false){
					$(".cartchecker").prop("checked", false);

					$("#cartCookie").val('');

					
				} else {
					$(".cartchecker").prop("checked", true);
					let temp = "";
				
					$(".cartchecker").each((i,v)=>{
						temp += $(v).val();
					})

					$("#cartCookie").val(temp);
					
					
					
				}
			

					
				
			}
			
			
			$(".cartchecker").click((e)=>{
				let cartcookiejar = $("#cartCookie").val();

				if(cartcookiejar.includes($(e.target).val())){
					cartcookiejar = cartcookiejar.replace($(e.target).val(),"");
					
					if($("#cart_check_all").prop("checked")==true){
						$("#cart_check_all").prop("checked", false)	
						
						

					}
									
				} else {
					
					$("#cartCookie").val(cartcookiejar+'!'+$(e.target).val());

					
				}

				

			})
			
			const fn_buy = () =>{
				/* 플래그 넘기기 */
				
				location.assign("<%=request.getContextPath()%>/order/place/cart/start?cartshow=<%=cookieContent%>");
				
			}
			
			/* 카트 삭제?? */
			
			


	</script>

<%@ include file = "/views/common/footer.jsp"%>