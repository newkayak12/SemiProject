<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<%@ page import = "com.cart.model.vo.Cart" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.users.model.vo.Users" %>

<% 
	
// detail - 0
// cart - 1


	/* Users user = null; */
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
	/* Object j = request.getSession().getAttribute("user");
	if(j!= null){
		user = (Users) j;
	} */
	
	 
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
				<h1 class="Menu-name">주문결제</h1>
				<hr>
			</div>
			<div id="product_info-container">
				
				
				<table id="orderplace-table">
					<tr>
						<th >사진</th>
						<th >제품명</th>
						<th >사이즈</th>
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
						<td colspan="6" style="padding-top: 20px;">
						
						총 가격 : <span class="grey-font">( 배송비 )</span> 2500원 +
				
				
								
	<!-- // detail - 0
	// cart - 1		
	 -->				
							
							<% 
							
							if(flag2.equals("page")||flag==1){
								result = 0;
								 result = cart.getCartPrice(); 
							%>
							
								<span class="grey-font">( 상품 가격 )</span> <%=cart.getCartPrice() %>원  = <span class="blue-font bolder"><%=result +2500 %> 원</span>  
								
							<%}  else {
								for(Cart l : list){
									result = 0;
									result += l.getCartPrice()*l.getCartStock();
								}
							%>
								
								<span class="grey-font">(상품 가격)</span> <%=result %>원  = <span class="blue-font bolder"><%=result + 2500 %>원</span>
							
							
							<%} %>
						</td>
					</tr>
				</table> 
				
				
				
			</div>
			
			<div id = "user_info-container" class ="order-tables">
				<p class="bolder">&nbsp&nbsp&nbsp&nbsp주문 정보</p>
				<div>	
					<table id = "user-info-tbl">
						<tr>
							<th>주문하시는 분</th>
							<td ><span id ="user_name"><%=user.getUserName() %></span></td>
						</tr>
						<%	String[] addrs = null;
							if(user.getUserAddr().contains("@")){
								addrs =user.getUserAddr().split("@"); 
							}
						%>
						<tr>
							<th rowspan="3">주소</th>
							<td ><span style="font-weight: bold;">주소</span> <span id = "user_addr"><%= user.getUserAddr().contains("@")? addrs[0]:user.getUserAddr()%></span></td>
						</tr>
						<tr>
							<td ><span style="font-weight: bold; ">상세주소</span><span id = "user_addrdetail">  <%= user.getUserAddr().contains("@")? addrs[1]:""%></span> </td>
						</tr>
						<tr>
							<td > <span style="font-weight: bold;" >우편번호</span><span id= "user_zip"><%=user.getUserZip() %></span></td>
						</tr>		
						<tr>
							<th>휴대전화</th>
							<td > <span id ="user_phone"><%=user.getUserPhone() %></span> </td>
						</tr>		
						<tr>
							<th>이메일</th>
							<td > <span id = "user_email"><%=user.getUserEmail() %></span></td>
							
						</tr>								
					</table>
					<table>
						
					
					</table>
				</div>
				<div>
				<p class="bolder">&nbsp&nbsp&nbsp배송 정보</p>
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
								<th rowspan="3">주소</th>
								<td id = "user_addr">
								<span style="font-weight: bold;">주소</span> 
								<input type = "text" id = "receive_addr">
								<button type="button" class="notice-btn blue" id="addrfind">주소 찾기</button>
								</td>
								
							</tr>
							<tr>
								<td ><span style="font-weight: bold; ">상세주소</span> <input type = "text" id = "receive_addrdetail"></td>
							</tr>
							<tr>
								<td> <span style="font-weight: bold;">우편번호</span><input type="text" id= "receive_zip"></td>
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
			<p class="bolder">&nbsp&nbsp&nbsp결제 방식</p>
				<div id="payment_selector-contianer">
					<input type = "radio" name = "payraido" id="pay"  checked> 무통장 입금
					<input type = "radio" name = "payraido"	id="kakao" >  카카오페이 <img id="kakaopay" src="<%=request.getContextPath() %>/images/payment_icon_yellow_large.png" alt="카카오페이" width="50px" style="margin:0px; padding:0px; display: none;">
				
				</div>
				
				
					<table id="pay-table">
						<tr>
							<th>예금주</th>
							<td>&nbsp&nbspdie Kleidung</td>
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

					<%-- <div id="kakaopay" style="display: none;">

							<img src="<%=request.getContextPath() %>/images/payment_icon_yellow_large.png" alt="카카오페이" width="200px">
					</div> --%>
				
				
			</div>
			
			<div id = "pay-choice">
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
					<input type="hidden" name="payflag" id ="formpaymethod" value="bank">
					
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
					<input type="button" class ="btn-width blue" value ="결제" id="bankpaybtn" onclick="fn_pay()">
					<input type="button" class ="btn-width white" value ="취소" onclick="fn_cancel()">
				</form>
				
			</div>
			
			
		</div>
</main>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>




	$("#addrfind").click(()=>{
		new daum.Postcode({
		    oncomplete: function(data) {
		        console.log(data["zonecode"])
		       $("#receive_zip").val(data["zonecode"])
		        console.log(data["address"])
		       $("#receive_addr").val(data["address"])
		        
		       console.log(data)
		    }
		}).open();
		
		
		
	})







	const fn_pay = () =>{
		let flag = $("#formpaymethod").val();
		
		
		if(flag == 'bank'){
			
		
		let bank = $("#bank-select").val();
		let receive_name = $("#receive_name").val()
		let receive_addr = $("#receive_addr").val()
		let receive_addrdetail = $("#receive_addrdetail").val()
		let receive_phone = $("#receive_phone").val()
		let receive_zip = $("#receive_zip").val()
		
		let receive_email = $("#receive_email").val()
		
		$("#formbank").val(bank);
		$("#formnamer").val(receive_name)
		$("#formaddr").val(receive_addr+"@"+receive_addrdetail)
		$("#formphone").val(receive_phone)
		$("#formzip").val(receive_zip)
		/* $("#formemail").val() */
		
		<!--bank namr addr phone  zip/ -->
		
		
		
		//은행명  id nameo/ namr addr phone email/ 쿠키로 조지자  zip size color count pid cid
		<%-- location.assign("<%=request.getContextPath()%>/order/pay") --%>
		$("#formhidden").submit();
		
		//은행>>
		} else {
			/*  195f3373454374ffb5d7e3d8285bf924  */
			
			/* restapikey b7afc7c263972b218c4242f48aac9659 */
			/* admin 7be18bb35d4598742bb7e4f4c82ab6d0 */
			
			
			/* POST /v1/payment/ready HTTP/1.1
			Host: kapi.kakao.com
			Authorization: KakaoAK {"7be18bb35d4598742bb7e4f4c82ab6d0"}
			Content-type: application/x-www-form-urlencoded;charset=utf-8
			 */
			  let kname = $("#receive_name").val()
			  let kemail = $("#receive_email").val()
			  let kamount = '<%=result%>';
			  let kaddr = $("#receive_addr").val() + $("#receive_addrdetail").val();
			  let kzip = $("#receive_zip").val();
			  let kpname = '<%=cart.getCartName()%>'+" 등";
			  let kphone = $("#recevice_phone").val()
			  
			  
			  
			  
			 <%-- location.assign('<%=request.getContextPath()%>/pay/kakao'); --%>
			 var IMP = window.IMP; 
			 IMP.init('imp29380166');
			 
			 IMP.request_pay({
				    pg : 'kakao', // version 1.1.0부터 지원.
				    pay_method : 'card',
				    merchant_uid : 'merchant_' + new Date().getTime(),
				    name : kpname,
				    amount : kamount ,
				    buyer_email : kemail,
				    buyer_name : kname,
				    buyer_tel : kphone,
				    buyer_addr : kaddr,
				    buyer_postcode : kzip,
				    m_redirect_url : 'https://www.yourdomain.com/payments/complete'
				}, function(rsp) {
				    if ( rsp.success ) {
				        var msg = '결제가 완료되었습니다.';
				        msg += '고유ID : ' + rsp.imp_uid;
				        msg += '상점 거래ID : ' + rsp.merchant_uid;
				        msg += '결제 금액 : ' + kamount;
				        msg += '카드 승인번호 : ' + rsp.apply_num;
				    } else {
				        var msg = '결제에 실패하였습니다.';
				        msg += '에러내용 : ' + rsp.error_msg;
				    }
				    alert(msg);
				});
			 
			
		}
		
	}

	const fn_cancel = () =>{
		if(confirm('장바구니로 돌아가시겠습니까?')==true){
			location.assign("<%=request.getContextPath()%>/cart/list")
		}

	
	}
/* 
 * 카카오주소 막
 
 	$(function(){
	console.log($("#user_addr").val())
	let flg = $("#user_zip").html();
	
	if( flg.include('카카오로그인 사용자는 직접 입력해주십시오')){
		alert('ss')
		$("#samepeople").css("display","none")
		
	}
	 */

	$("#pay").click((e)=>{
		

	$("#kakaopay").css("display","none");
	$("#pay-table").css("display","table")
	$("#formpaymethod").val("bank")
	
	
		
	})

	$("#kakao").click(()=>{
	$("#kakaopay").css("display","inline-block");
	$("#pay-table").css("display","none")
	$("#formpaymethod").val("kakao")
	
	
	})

	$("#bank-select").change((e)=>{
		console.log($(e.target).val())
	})

$("#samepeople").change( ()=>{
	let flag = $("#sameiam");
	let receive_name = $("#receive_name")
	let receive_addr = $("#receive_addr")
	let receive_addredetail = $("#receive_addrdetail")
	
	
	let receive_phone = $("#receive_phone")
	let receive_email = $("#receive_email")
	let receive_zip = $("#receive_zip")
	
	let user_name = $("#user_name")
	let user_zip = $("#user_zip")
	let user_addr = $("#user_addr")
	let user_addrdetail = $("#user_addrdetail")
	
	console.log(user_addrdetail.html())
	let user_phone = $("#user_phone")
	let user_email = $("#user_email")
	console.log(user_zip.html());
	

			if(flag.val() == 0){
					receive_name.val(user_name.html())
					receive_addr.val(user_addr.html())
					receive_phone.val(user_phone.html())
					receive_email.val(user_email.html())
					receive_zip.val(user_zip.html())
					$("#receive_addrdetail").val(user_addrdetail.html())
					
					
					flag.val("1");
			} else {
				receive_name.val("")
				receive_addr.val("")
				receive_phone.val("")
				receive_email.val("")
				receive_zip.val("")
				$("#receive_addrdetail").val("")
				flag.val("0")

			}

})


</script>

<%@ include file = "/views/common/footer.jsp"%>