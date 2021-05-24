<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.users.model.vo.Users" %>>
<%@ include file ="/views/common/header.jsp" %>
<%
	Users user=(Users)request.getAttribute("users");
%>
<main id="mypageMain">
	<div id="mypage-container">
		<form action="" method="post">
			<tr>
				<th>아이디</th>
				<td input type="text' name="userid" value="<%= Users.getUserId()%>"></td>
			</tr>
		</form>
		
	</div>
</main>
<%@ include file ="/views/common/footer.jsp" %>