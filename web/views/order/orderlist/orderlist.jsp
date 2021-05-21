<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_sh.css">

<%@ page import = "java.util.*" %>
<%@ page import = "com.order.model.vo.Order" %>
<!-- import -->


<!-- java -->
<% 
	String pageBar = (String)request.getAttribute("pageBar");
	List<Order> result = (List<Order>) request.getAttribute("result");
	
%>

<%-- 
<script>
$(function(){
	const ajax_order = () =>{
	
	$.ajax({
		url:'<%=request.getContextPath()%>/order/list',
		data:{"userId":'<%=session.getAttribute("userid")%>'},
		success: data =>{


			
		}
	
	
	})


});
</script> --%>


<!-- order 시작 -->
<main id="orderOrrefundMain">

    <div id="orderOrrefund">
    	<div id="orderOrrefund_selector-container">
	        <span id="order_selector" onclick="ajax_order()">주문 내역 조회(<%=request.getAttribute("orderCount") %>)</span>
	        <span id="refund_selector"onclick="">취소/반품/교환 내역()</span>
    	</div>		
	    <div id="oderOrrefund-container">
	        <p id="orderOrrefundFlag">주문 상품 정보</p>
	
	        <table id="orderOrrefund-table" align="center">
	            <tr>
	                <th>
	                    <p>주문일자</p>
	                    <p>(주문번호)</p>
	                </th>
	                <th>
	                    이미지
	                </th>
	                <th>
	                    상품정보
	                </th>
	                <th>
	                    수량
	                </th>
	                <th>
	                    상품 구매 금액
	                </th>
	                <th>
	                    주문처리상태
	                </th>
	                <!-- <th>
	                    취소/교환/반품
	                </th> -->
	            </tr>
			<%for(Order o : result){
				
			%>
			
                <tr>
                    <td>
                    	<span onclick="window.open('<%=request.getContextPath()%>/order/detail?orderNumber=<%=o.getOrderNumber()%>','_blank','width=500px, height=600px')">
	                        <p><%=o.getOrderDate() %></p>
	                        <p><%=o.getOrderNumber() %></p>
                        </span>
                    </td>
                    <td>
                        <img src="<%=request.getContextPath() %>/images/product/<%=o.getProductFile() %>" alt="상품 이미지" onclick = "location.assign('<%=request.getContextPath() %>/---- ?productNumber=<%=o.getProductId() %>')">
                    </td>
                    <td>
                    
                    	<span onclick = "location.assign('<%=request.getContextPath() %>/---- ?productNumber=<%=o.getProductId() %>')" >
	                        <h4> <%=o.getProductName() %></h4>
	                        <p><%=o.getProductSize() %> / <%=o.getProductColor() %> </p>
	                    </span>    
                    </td>
                    <td>
                        <%=o.getProductStock()%>
                        
                    </td>
                    <td>
                        <%=o.getProductPrice() %>
                    </td>
                    <td>
                        <%=o.getOrderStatus() %>
                        <!-- 결제전/ 결제완료/ 배송중/ 배송완료/ 구매확정(리뷰쓰기)  -->
                    </td>
                    <!-- <td>
                       <button type="button" id="status-button"> 취소/교환/환불 상태</button>
                    </td> -->
                </tr>
			<%	}	%>
	        </table>
	
	
	    </div>
	</div>
	<div id="pageBar"><%=pageBar %></div>
	
</main>
<!-- order 끝 -->
<%@ include file = "/views/common/footer.jsp"%>