<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="com.order.model.vo.*" %>
<%@ page import ="com.users.model.vo.*" %>
<!DOCTYPE html>
<html>
<head>
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

<% for( Order order : orderlist) {%>
        <tr>
            <td>
                <%=order.getOrderStatus()%>
            </td>
            <td rowspan="2">
                <span>
                    <button type="button"></button>
                    <button type="button"></button>
                    <button type="button"></button>
                    <button type="button"></button>
                </span>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <span><img src="" alt="상품이미지"></span>
                    <span><%=order.getProductName()%></span>
                    <span>
                        <p><%=order.getProductPrice()%></p>
                        <p><%= order.getProductStock()%></p>
                    
                    </span>
                </div>
            </td>
            
        </tr>
        
 <%} %>       
        
    </table>
    
     <div id="orderdetail_userInfo-container">
        <hr>
        <table id="orderdetail_userInfo-table">
            <tr>
                <th>받는 사람</th>
                <td><%=userInfo.getUserName()%></td>
            </tr>
            <tr>
                <th>연락처</th>
                <td><%=userInfo.getUserPhone() %></td>
            </tr>
            <tr>
                <th>주소</th>
                <td><%=userInfo.getUserAddr() %></td>
            </tr>
        </table>
    </div> 
    
    <!-- users테이블, 주소 테이블 추가 join 필요해보임 -->
    


</body>
</html>