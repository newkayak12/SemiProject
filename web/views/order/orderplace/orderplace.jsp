<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<%@ page import = "com.cart.model.vo.Cart" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.users.model.vo.Users" %>

<% 
	
// detail - 0
// cart - 1


	Users user = null;
	Object v = request.getAttribute("flag"); 
	int flag =0;
	if(v!=null){
		flag = (Integer) v;
	 } 
	  
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
	
	// detail - 0
	// cart - 1
	/* && flag2.equals("detail") */
	if(flag2.equals("page") ){
	/* 바로 구매 */
	
		 cart = (Cart) request.getAttribute("list");
		/* request.setAttribute("list",cart); */
		
		
	}else {
		/*  장바구니 */
		if(flag==2){
		list = (List<Cart>) request.getAttribute("list");
			
		} else {
			cart = (Cart) request.getAttribute("list");
		}
		/* request.setAttribute("list", list); */
	}
	
	String size = "";
	String color = "";
	String count ="";
	int price = 0;
	String cid ="";
	String pid ="";
	
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
				
<!-- // detail - 0
// cart - 1		
 -->				
				<%if( flag2.equals("page")||flag==1) {%>
				
				
				 <!-- 페이지 -->
				<tr>
					<td>
						<img alt="사진" src="<%=request.getContextPath()%>/upload/product/<%= cart.getProductFile()%>" class="order-img">
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
							<img alt="사진" src="<%=request.getContextPath()%>/upload/product/<%= temp.getProductFile()%>" class="order-img">
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
			
			
							
<!-- // detail - 0
// cart - 1		
 -->				
						
						<% 
						
						if(flag2.equals("page")||flag==1){
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
			
			<div id = "user_info-container" class ="order-tables">
				<p>주문 정보</p>
				<div>	
					<table>
						<tr>
							<th>주문하시는 분</th>
							<td id ="user_name"><%=user.getUserName() %></td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td id= "user_zip"> <%=user.getUserZip() %></td>
						</tr>
						<tr>
							<th>주소</th>
							<td id = "user_addr"> <%=user.getUserAddr() %></td>
						</tr>		
						<tr>
							<th>휴대전화</th>
							<td id ="user_phone"> <%=user.getUserPhone() %> </td>
						</tr>		
						<tr>
							<th>이메일</th>
							<td id = "user_email"> <%=user.getUserEmail() %></td>
							
						</tr>								
					</table>
				</div>
				<div>
					<p>주문하는 분과 받는 분이 같습니다. <input type="checkbox" id = "samepeople"></p>
					<table class ="order-tables">
					<input type="hidden" id="sameiam" value= "0">
						<tr>
							<th>받는 분</th>
							<td>
								<input type ="text" name="receive_name" id="receive_name" required>
							</td>
						</tr>
						<tr>
							<th>우편번호</th>
							<td><input type="text" id= "receive_zip" name = "receive_zip" required> </td>
						</tr>
						<tr>
							<th>주소</th>
							<td> <input type ="text" name="receive_addr" id="receive_addr" required>
							<button type="button">주소 찾기</button>
							</td>
						</tr>		
						<tr>
							<th>휴대전화</th>
							<td> <input type ="text" name="receive_phone" id="receive_phone" required></td>
						</tr>		
						<tr>
							<th>이메일</th>
							<td><input type ="text" name="receive_email" id="receive_email" required></td>
							
						</tr>	
					
					</table>
				</div>
				
			</div>
			
			<div id = "payment-container">
				<div id="payment_selector-contianer">
					<input type = "radio" name = "payraido" id="pay"  checked> 무통장 입금
					<input type = "radio" name = "payraido"	id="kakao" > 카카오페이
					
				</div>
				
				
					<table id="pay-table">
						<tr>
							<th>예금주</th>
							<td>die Kleidung</td>
						</tr>
						<tr>
							<th>입금 은행</th>
							<td>
									<select name="pay_sel" id="bank-select">
											<option value="하나은행 661-910265-*****">하나은행 661-910265-*****</option>
											<option value="신한은행 910-910265-*****">신한은행 910-910265-*****</option>

									</select>

							</td>
						</tr>
					</table>

					<div id="kakaopay" style="display: none;">

							<button>카카오페이</button>
					</div>
				
				
			</div>
			
			<div>
				<form action="<%=request.getContextPath()%>/order/pay " id="formhidden">
					<input type ="hidden" id="formnameo" name = "formnameo" value = "<%=user.getUserName() %>" >
					<input type ="hidden" id="formid" name ="formid" value ="<%=user.getUserId() %>">
					<input type ="hidden" id="formbank" name = "formbank"value="">
					
					<input type ="hidden" id="formnamer" name = "formnamer" value="">
					<input type ="hidden" id="formaddr" name = "formaddr" value="">
					<input type ="hidden" id="formphone"  name = "formphone"value="">
					<input type ="hidden" id="formzip" name = "formzip" value="">
					<input type="hidden" name ="totalprice" value="<%=result%>">
					<input type = "hidden" name ="flag2" value= "<%=flag2%>" >
					
					<% System.out.println(flag2+" "+flag); %>
					<input type="hidden" name ="cartflag" value ='<%=flag%>'> 
					
					
					
					<%if(flag2.equals("page")){ %>
						
						<!-- String pid = request.getParameter("pid");
						String size = request.getParameter("size");
						String color = request.getParameter("color");
						String price = request.getParameter("price");
						String stock = request.getParameter("stock");
						String category = request.getParameter("category"); -->
					<input type="hidden" name = "pid" value="<%=cart.getProductId()%>">
					<input type="hidden" name = "size" value="<%=cart.getCartOptionSize()%>">
					<input type="hidden" name = "color" value="<%=cart.getCartOptionColor()%>">
					
					<input type="hidden" name = "price" value="<%=cart.getCartPrice()%>">
					<input type="hidden" name = "stock" value="<%=cart.getCartStock()%>">
					<input type="hidden" name = "category" value="<%=cart.getCategoryId()%>">	
						
						
					<%} %>	
					<input type="button" value ="결제" onclick="fn_pay()">
					<input type="button" value ="취소" onclick="fn_cancel()">
				</form>
				
			</div>
			
			
		</div>
</main>

<script>
	const fn_pay = () =>{
		
		let bank = $("#bank-select").val();
		let receive_name = $("#receive_name").val()
		let receive_addr = $("#receive_addr").val()
		let receive_phone = $("#receive_phone").val()
		let receive_zip = $("#receive_zip").val()
		
		let receive_email = $("#receive_email").val()
		
		$("#formbank").val(bank);
		$("#formnamer").val(receive_name)
		$("#formaddr").val(receive_addr)
		$("#formphone").val(receive_phone)
		$("#formzip").val(receive_zip)
		/* $("#formemail").val() */
		
		<!--bank namr addr phone  zip/ -->
		
		
		
		//은행명  id nameo/ namr addr phone email/ 쿠키로 조지자  zip size color count pid cid
		<%-- location.assign("<%=request.getContextPath()%>/order/pay") --%>
		$("#formhidden").submit();
		
		
	}

	const fn_cancel = () =>{
		if(confirm('장바구니로 돌아가시겠습니까?')==true){
			location.assign("<%=request.getContextPath()%>/cart/list")
		}
	}
$(function(){
	
	

	$("#pay").click((e)=>{
		// $("pay-table").html("");
		// $("#pay-table").append($("<tr>").append($("<th>").html("입금자명")).append($("<td>").html("<%=user.getUserName()%>")));
		

		// $("#pay-table").append(   $("<tr>").append($("<th>").html("입금자은행")).append($("<td>").append( $("<select>").attr({
		// 	"id":"bank-select"
		// 	,"name":"pay_sel"
			
		// }).append( $("<option>").attr({"value":"하나은행 661-910265-*****",
		// 	"name":"pay_sel"
			
			
		// }).html("하나은행 661-910265-*****")).append($("<option>").attr({
		// 	"value":"신한은행 910-910265-*****",
		// 	"name":"pay_sel"
			
		// }).html("신한은행 910-910265-*****"))  ) ));

	$("#kakaopay").css("display","none");
	$("#pay-table").css("display","table")
		
	})

	$("#kakao").click(()=>{
		$("#kakaopay").css("display","block");
	$("#pay-table").css("display","none")
	})

	$("#bank-select").change((e)=>{
		console.log($(e.target).val())
	})
})

$("#samepeople").change( ()=>{
	let flag = $("#sameiam");
	let receive_name = $("#receive_name")
	let receive_addr = $("#receive_addr")
	let receive_phone = $("#receive_phone")
	let receive_email = $("#receive_email")
	let receive_zip = $("#receive_zip")
	
	let user_name = $("#user_name")
	let user_zip = $("#user_zip")
	let user_addr = $("#user_addr")
	let user_phone = $("#user_phone")
	let user_email = $("#user_email")
	console.log(user_zip.html());
	

			if(flag.val() == 0){
					receive_name.val(user_name.html())
					receive_addr.val(user_addr.html())
					receive_phone.val(user_phone.html())
					receive_email.val(user_email.html())
					receive_zip.val(user_zip.html())
					flag.val("1");
			} else {
				receive_name.val("")
				receive_addr.val("")
				receive_phone.val("")
				receive_email.val("")
				receive_zip.val("")
				flag.val("0")

			}

})


</script>

<%@ include file = "/views/common/footer.jsp"%>