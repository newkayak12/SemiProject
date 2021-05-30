<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.order.model.vo.Order" %>    
<%@ include file = "/views/common/header.jsp"%>
<%
	List<Order> order = null;
	Object o = request.getAttribute("orderlist");
	List<Order> refund = null;
	Object j = request.getAttribute("refundlist");
	
	if(o!=null){
		order = (List<Order>) o;
	}
	
	if(j!=null){
		refund = (List<Order>)j;
	}
%>
<main style="display:flex; justify-content: center; align-content: space-around; flex-direction: column; font-size:14px">
	
	<div>
		<p>전체 회원 주문 내역</p>
		<table style="text-align:center">
			<tr>
				<th>
					주문번호
				</th>
				<th>
					사용자 계정명
				</th>
				<th>
					주문 제품명
				</th>
				<th>
					제품 사이즈
				</th>
				<th>
					색상
				</th>
				<th>
					주문한 사람 이름
				</th>
				<th>
					받을 사람 이름
				</th>
				<th>
					전화번호
				</th>
				<th>
					우편번호
				</th>
				<th>
					주문 주소
				</th>
				<th>
					상태
				</th>
				
			</tr>
	<%if(order.size()>1) {%>		
	<%for(int i =0; i<order.size(); i++) {%>	
			<tr>
				<td>
				<!-- 주문번호 -->
				<%= order.get(i).getOrderNumber() %>
				</td>
				<td>
				<!-- id -->
				<%= order.get(i).getUserid() %>
				</td>
				<td>
				<!-- pname -->
				<%= order.get(i).getProductName() %>
				</td>
				<td>
				<!-- size -->
				<%= order.get(i).getProductSize() %>
				</td>
				<td>
				<!-- color -->
				<%= order.get(i).getProductColor() %>
				</td>
				<td>
				<!-- oname -->
				<%= order.get(i).getOrderusername() %>
				</td>
				<td>
				<!-- rname -->
				<%= order.get(i).getReceivername() %>
				</td>
				<td>
				<!--phone  -->
				<%= order.get(i).getPhone() %>
				</td>
				<td>
				<!-- zip -->
				<%= order.get(i).getZipcode() %>
				</td>
				<td>
				<!-- addr -->
				<%= order.get(i).getAddress() %>
				</td>
				<td>
				<!-- status -->
					<select name="order<%=i%>" id="order<%=i%>" onchange="fn_order('order<%=i%>','<%=order.get(i).getO_d_no()%>')">
						<option value="결제전" <%=order.get(i).getOrderstat().equals("결제전")?"selected":"" %> >
							결제전
						</option>
						<option value="결제완료" <%=order.get(i).getOrderstat().equals("결제완료")?"selected":"" %>>
							결제완료
						</option>
						<option value="배송중" <%=order.get(i).getOrderstat().equals("배송중")?"selected":"" %>>
							배송중
						</option>
						<option value="배송완료" <%=order.get(i).getOrderstat().equals("배송완료")?"selected":"" %>>
							배송완료
						</option>
						
						
					
					</select>
				</td>
			</tr>
			
		<%} %>	
		<%} else { %>
			<tr>
				<td colspan="11">
					내용이 없습니다.
				</td>
			</tr>
		<%} %>
		</table>
	</div>
	
	<div>
		<p>전체 회원 반품 내역</p>
		<table style="text-align:center">
		
			<tr>
				<th>
					주문번호
				</th>
				<th>
					사용자 계정명
				</th>
				<th>
					주문 제품명
				</th>
				<th>
					제품 사이즈
				</th>
				<th>
					색상
				</th>
				<th>
					주문한 사람 이름
				</th>
				<th>
					받을 사람 이름
				</th>
				<th>
					전화번호
				</th>
				<th>
					우편번호
				</th>
				<th>
					주문 주소
				</th>
				<th>
					상태
				</th>
				
			</tr>
			
		<%if(refund.size()>0){%>	
			<%for(int i=0; i<refund.size(); i++){ %>
			
			<tr>
				<td>
				<!-- 주문번호 -->
				<%= refund.get(i).getOrderNumber() %>
				</td>
				<td>
				<!-- id -->
				<%= refund.get(i).getUserid() %>
				</td>
				<td>
				<!-- pname -->
				<%= refund.get(i).getProductName() %>
				</td>
				<td>
				<!-- size -->
				<%= refund.get(i).getProductSize() %>
				</td>
				<td>
				<!-- color -->
				<%= refund.get(i).getProductColor() %>
				</td>
				<td>
				<!-- oname -->
				<%= refund.get(i).getOrderusername() %>
				</td>
				<td>
				<!-- rname -->
				<%= refund.get(i).getReceivername() %>
				</td>
				<td>
				<!--phone  -->
				<%= refund.get(i).getPhone() %>
				</td>
				<td>
				<!-- zip -->
				<%= refund.get(i).getZipcode() %>
				</td>
				<td>
				<!-- addr -->
				<%= refund.get(i).getAddress() %>
				</td>
				<td>
				<!-- status -->
					<select name="refund<%=i%>" id="refund<%=i%>" onchange="fn_refund('refund<%=i%>','<%=refund.get(i).getO_d_no()%>')">
					
						<option value="환불처리중" <%=refund.get(i).getOrderstat().equals("환불처리중")?"selected":"" %>>
							환불처리중
						</option>
						<option value="환불완료" <%=refund.get(i).getOrderstat().equals("환불완료")?"selected":"" %>>
							환불완료
						</option>
						
					
					</select>
				</td>
			</tr>
			<%} %>	
		<%} else { %>
			<tr>
				<td colspan="11">
					내용이 없습니다.
				</td>
			</tr>
		<%} %>
		</table>
	</div>
	
</main>	
<script>
	const fn_order=(o,noo)=>{
		console.log(o+';'+noo)
		
		console.log($("#"+o).val())
		 $.ajax({
			url:"<%=request.getContextPath()%>/admin/order/ajax",
			data:{"value":$("#"+o).val(),"no":noo},
			success:data=>{
				/* alert(data) */
				location.reload()
				
			}
		}) 
	}
	
	const fn_refund=(f, nof)=>{
		console.log(f+';'+nof)
		console.log($("#"+f).val())
		
		$.ajax({
			url:"<%=request.getContextPath()%>/admin/order/ajax",
			data:{"value":$("#"+f).val(),"no":nof},
			success:data=>{
				/* alert(data) */
				 location.reload() 
			}
		}) 
	}

</script>
	
<%@ include file = "/views/common/footer.jsp"%>