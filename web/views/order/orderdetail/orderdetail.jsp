<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="com.order.model.vo.*" %>
<%@ page import ="com.users.model.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_sh.css">
<meta charset="UTF-8">
<%
List<Order> orderlist = (List<Order>) request.getAttribute("list");
	Users userInfo = (Users) request.getAttribute("user");
	Order orderInfo =  orderlist.get(0);
%>

<title>order details</title>
</head>
<body>

 <div id="orderdetail_info-container">
    <h3>주문 상세</h3>
    <span>
        <h4><%=orderInfo.getOrderDate()%> 주문</h4>
    </span>
    <span>주문번호<%=orderInfo.getOrderNumber()%></span>
 </div>   
    <table id="orderdetail-table">
	<tr>
		<th>제품사진</th>
	
		<th>제품명</th>
	
		<th>사이즈</th>
	
		<th>색상</th>
	
		<th>수량</th>
	
		<th>단일 가격 / 합산 가격</th>
	
		<th>상태</th>
	
		<th>환불</th>
	</tr>
	
<%
for( Order order : orderlist) {
%>
       
        <tr>
        	<td>
        	<!-- 사진 -->
        		<img alt="제품사진" src="<%=request.getContextPath()%>/upload/product/<%=order.getProductFile()%>" width="150px">
        	</td>
        	<td>
        	<!--제품 이름 -->
        		<%=order.getProductName()%>
        	</td>
        	<td>
        	<!-- 사이즈 -->
        		<%=order.getProductSize() %>
        	</td>
            <td >
            <!--  색상  -->
				<%=order.getProductColor() %>	                
            </td>
            <td>
            	<%=order.getOrderdetailcount() %>
        	</td>
             <td>
             	<%=order.getProductprice() %>원/<%=Integer.parseInt(order.getProductprice())*order.getOrderdetailcount() %>원
        	</td>
            <td >
            <!-- 상태 -->
               <%=order.getOrderstat()%>
            </td>
            <td>
            	<button onclick = " fn_status("+<%=order.getCategoryId() %>+","+<%=order.getProductId() %>+","+<%=order.getProductSize()%>+","+ <%=order.getProductColor() %>+","+<%=order.getOrderNumber() %> +")">환불 신청</button>
            </td>
            
            
        </tr>
        
 <%} %>       
        
    </table>
    
     <div id="orderdetail_userInfo-container">
        <hr>
        <table id="orderdetail_userInfo-table">
            <tr>
                <th>받는 사람</th>
                <td><%=orderlist.get(0).getReceivername()%></td>
            </tr>
            <tr>
                <th>연락처</th>
                <td><%=userInfo.getUserPhone() %></td>
            </tr>
            <tr>
                <th>주소</th>
                <td><%=orderlist.get(0).getAddress()%></td>
            </tr>
            
        </table>
    </div> 
    
    <!-- users테이블, 주소 테이블 추가 join 필요해보임 -->
    
<script type="text/javascript">
	const fn_status = (cid, pid, size, color ,onumber)=>{
		
		
	}

</script>
<style>

 #orderdetail-table{
 	text-align:center !important;
 }
</style>

</body>
</html>