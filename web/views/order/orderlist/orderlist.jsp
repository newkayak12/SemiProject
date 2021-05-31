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




<!-- order 시작 -->
<main id="orderOrrefundMain">

    <div id="orderOrrefund">
    
    	<div id="orderOrrefund_selector-container">
	        <span id="order_selector" onclick="ajax_order()">주문 내역 조회(<%=request.getAttribute("orderCount")%>)</span>
    	</div>		
    	
	    <div id="oderOrrefund-container">
	    
	        <p id="orderOrrefundFlag">주문 상품 정보</p>
	
	        <table id="orderOrrefund-table" >
	        
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
	               		주문한 사람
	               	</th>
	               	<th>
	               		받는 사람
	               	</th>
	                
	                
	                
	            </tr>
	            
	            
			<%
	          for(Order o : result){
	        	  
	          
	          %>
			
                <tr>
                    <td>
                    	<span onclick="window.open('<%=request.getContextPath()%>/order/detail?userid=<%=userid%>&onumber=<%=o.getOrderNumber() %>','_blank','width=900px, height=800px')">
	                      <!-- 날짜/주문 번호  -->
	                        <p><%=o.getOrderDate() %></p>
	                        <p><%=o.getOrderNumber() %></p>
                        </span>
                    </td>
                    <td>
                    	<img alt="상품사진" src="<%=request.getContextPath()%>/upload/product/<%=o.getProductFile() %>" width="100px">
                    </td>
                    <td>
                        <h4> <%=o.getProductName() %>&nbsp;등 <%=o.getHowmany() %> 건  </h4>
                    </td>
                    <td>
                    	<%=o.getOrderusername() %>
                    </td>
                    <td>
                    	<%=o.getReceivername() %>
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
<style>

 #orderOrrefund-table{
 	text-align:center !important;
 }
</style>
<!-- order 끝 -->


<%@ include file = "/views/common/footer.jsp"%>