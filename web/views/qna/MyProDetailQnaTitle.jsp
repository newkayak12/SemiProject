<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.util.List, com.productqna.model.vo.ProductQna" %>

<%
	ProductQna pq = (ProductQna)request.getAttribute("pq");
%>

	<div id="qna-detail-container">

		<!-- Q&A 리스트 뜨는 부분 -->

		<span class = "Menu-name"><%=pq.getQnaTitle() %></span>
	
		
        <table id="qna-deatil">
	        <tr>
	   
	            <th class="blue border-white">TITLE</th>
	            <td><%=pq.getQnaTitle() %></td>
	        </tr>
	        <tr>
	            <th class="blue border-white">WRITER</th>
	            <td><%=pq.getQnaUserId() %></td>
	        </tr>
	        
	        <tr>
	            <th class="blue border-white">DATE</th>
	            <td><%=pq.getQnaDate() %></td>
	        </tr>
	        <tr>
	        	<td colspan = "2" style="border-bottom : none !important;" >
	        		<div class="content-background text-center" name="qnaContent" style="border : 1px solid grey;">
	        			
	        			<br><%=pq.getQnaContent() %>
	        		</div>
	        	</td>
	        </tr>
	    </table>
	    
	    <!-- Q&A 수정버튼 누르는 거  -->
	    
	   <!-- String userid = null;
			String checkAdmin = null;
			Object qwerty = session.getAttribute("user");
			// 로그인한 상태이면
			if(qwerty!=null){
				
				Users user = (Users) qwerty;
				
					if(user!=null){
						
						userid = user.getUserId();
						checkAdmin = user.getUserAdmin(); // 1이면 admin계정, 0이면 일반사용자
					}
		} -->
	        <!--
	        	1. 목록 버튼은 항상 뜰 수 있게하기
	        	2. 삭제하기 버튼은 admin 또는 본인이 쓴 글 안에서만 뜨게 하기
	         -->
	         
	         <div id = "btn-container">
		        	<input type="button" class="notice-btn white btn-width" value="목록" onclick="back();">
	         </div>

<%@ include file ="/views/common/header.jsp" %>

<%@ include file ="/views/common/footer.jsp" %>