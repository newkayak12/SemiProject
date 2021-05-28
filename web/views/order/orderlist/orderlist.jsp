<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_sh.css">

<%@ page import = "java.util.*" %>
<%@ page import = "com.order.model.vo.Order" %>
<!-- import -->


<!-- java -->
<%
String pageBar = null;
	List<Order> result = null;
	
	
	
	Object temp1 = request.getAttribute("pageBar");
	Object temp2 = request.getAttribute("result");
	if(temp1 != null){
		pageBar = (String) temp1;
	}
	if(temp2 != null){
		result = (List<Order>) temp2;
	}
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
	        <span id="order_selector" onclick="ajax_order()">주문 내역 조회(<%=request.getAttribute("orderCount")%>)</span>
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
	                    상품 구매 금액
	                </th>
	                
	                <!-- <th>
	                    취소/교환/반품
	                </th> -->
	            </tr>
	            
	            
			<%
	            	            			for(Order o : result){
	            	            			%>
			
                <tr>
                    <td>
                    	<span onclick="window.open('<%=request.getContextPath()%>/order/detail?userid=<%=userid%>&onumber=<%=o.getOrderNumber() %>','_blank','width=500px, height=600px')">
	                      
	                      <!-- 날짜/주문 번호  -->
	                      
	                        <p><%=o.getOrderDate() %></p>
	                        <p><%=o.getOrderNumber() %></p>
                        </span>
                    </td>
                    
             
                    <td>
                    
                    	<span onclick = "location.assign('<%=request.getContextPath() %>/---- ?productNumber=<%=o.getProductId() %>')" >
	                        
	                        <!--  -->
	                        <h4> <%=o.getProductName() %></h4>
	                        <p><%=o.getProductSize() %> / <%=o.getProductColor() %> </p>
	                    </span>    
                    </td>
                    <td>
                    	<img alt="" src="<%=request.getContextPath()%>/upload/product/">
                    </td>
                    <td>
                    <%--     <%=o.getProductStock()%>
                        
                    </td>
                    
                    <td>
                        <%=o.getProductPrice() %>
                    </td>
                    
                    <td id="td_orderStatus">
                    	<!-- 결제전/ 결제완료/ 배송중/ 배송완료  -->
                    	
                        <%=o.getOrderStatus() %>
                        
                        <% if( o.getOrderStatus().equals("배송완료") ) { %> --%>
                        	<br>
                        	<button onclick="location.assign('<%=request.getContextPath()%>/review/post/start?pid=<%=o.getProductId()%>&pname=<%=o.getProductName()%>&color=<%=o.getProductColor()%>&size=<%=o.getProductSize()%>&category=<%=o.getCategoryId()%>&file=<%=o.getProductFile()%>&onumber=<%=o.getOrderNumber()%>')">리뷰쓰기</button>
                        <% } %>
                    </td>
                    <!-- <td>
                       <button type="button" id="status-button"> 취소/교환/환불 상태</button>
                    </td> -->
                </tr>
                
			<%-- <%	}	%> --%>
			
	        </table>
	
	    </div>
	</div>
	
	
	<div id="pageBar"><%=pageBar %></div>
	
</main>

<!-- order 끝 -->


<%@ include file = "/views/common/footer.jsp"%>