<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.users.model.vo.Users" %>
<% List<Users> list = (List<Users>)request.getAttribute("userlist"); %>
<%@ include file="/views/common/header.jsp"%>
<main>
	<div>
		<div>
			<h1>회원관리</h1>
			
				<table id="tbl-notice">
            		<thead class="thead-color">
                		<th>회원 아이디</th>
		                <th>회원 이름</th>
		                <th>회원 탈퇴여부</th>
		                <th>탈퇴 관리</th>
            	</thead>
            	
            	<% 
            		if(list!=null && list.size()!=0){
            		for(Users u : list){
            	%>
            	
				<tr>
					<form action="<%=request.getContextPath()%>/admin/userupdate/end" method="post">
						<input type="hidden" value="<%=u.getUserId() %>" name="userid" >
						<input type="hidden" value="<%=u.getUserStatus() %>" name="userstatus" >
					
						<td><%=u.getUserId() %></td>
						<td><%=u.getUserName() %></td>
						
						<% if(u.getUserStatus()==0){%>
							<td>탈퇴된회원</td>
						<% }
						else{ %>
							<td>가입된회원</td>
						<% }%>
						
						<td>
							<% if(u.getUserStatus() == 1 ){%>
								<button>탈퇴</button>
							<% }
							else{ %>
								<button>복구</button>
							<% }%>
							
						</td>
					</form>
				</tr>
				
				
				
				<%}
            		} 
				else{ %>
					<p>가입된 회원이 없다.</p>
				<% }%>
			
		</div>
	</div>
</main>