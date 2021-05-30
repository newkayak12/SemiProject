<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List, com.users.model.vo.Users" %>

<%@ include file="/views/common/header.jsp"%>

<% 
	List<Users> list = (List<Users>)request.getAttribute("userlist");
%>


<main>

	<ul class="text_align_center border_bottom_blue">
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/product/manage">상품 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/reviewManage">리뷰 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="">주문 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/userselect/start">회원 관리</a></li>
	</ul>




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
				
				<% } %>
            		
            	<% } else { %>
            	
					<p>가입된 회원이 없습니다</p>
					
				<% } %>
			</table>
		</div>
	</div>
	
</main>

<%@ include file = "/views/common/footer.jsp"%>