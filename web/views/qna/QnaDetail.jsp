<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.util.List, com.qna.model.vo.Qna, java.sql.Date, com.qna.model.vo.QnaComment" %>

<% 
	Qna q = (Qna)request.getAttribute("qna");
	List<QnaComment> comments=(List<QnaComment>)request.getAttribute("qna");
%>

<%@include file = "/views/common/header.jsp" %>

<div id="qna-detail-container">

		<!-- Q&A 리스트 뜨는 부분 -->

		<span class = "Menu-name"><%=q.getqTitle() %></span>
		
        <table id="qna-deatil">
	        <tr>
	            <th class="blue border-white">TITLE</th>
	            <td><%=q.getqTitle() %></td>
	        </tr>
	        <tr>
	            <th class="blue border-white">WRITER</th>
	            <td><%=q.getUserId() %></td>
	        </tr>
	        
	        <tr>
	            <th class="blue border-white">DATE</th>
	            <td><%=q.getqDate() %></td>
	        </tr>
	        <tr>
	        	<td colspan = "2">
	        		<div class="content-background" name="qnaContent" style="border : 1px solid grey;">
	        			<%if(q.getqFile()!=null){ %>
	        				<img src = "<%=request.getContextPath() %>/upload/qna/<%=q.getqFile()%>" style="width : 150px; height: auto;"><br>
	        			<%} else{%>
	        				<img src = "<%=request.getContextPath() %>/upload/qna/noimage.png">
	        			<%} %>
	        			<%=q.getqContents() %>
	        		</div>
	        	</td>
	        </tr>
	    
	    
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
	    
	        <!-- 관리자랑 로그인 사람 중 해당 게시글을 쓴 사람만 수정하기 삭제하기 버튼이 뜸 -->
	        <%if((userid!=null && userid.equals(q.getUserId())) || (checkAdmin!=null&&checkAdmin.equals("1"))) {%>
		         <tr>
	        		<td colspan="2" style="text-align : end; border-bottom : none;">
		                <input type="button" class="notice-btn blue" value="수정하기" onclick="location.assign('<%=request.getContextPath() %>/qna/qnaModifyStart?qSeq=<%=q.getqSeq()%>')">
		            </td>
		          </tr>
			<%} %> 
    	</table>
    	
    	
    	
    	
    	<!-- 댓글 부분 -->
    	<div id="comment-container">
	    
	    <!-- 댓글 입력하는 부분 -->
	    	<div class="comment-editor">
	    		<form action="<%=request.getContextPath() %>/qna/inserQnaComment" method="post">
	    			<textarea name="content" cols="55" rows="2"></textarea>
	    			<input type="hidden" name = "userId" value="<%=q.getUserId() %>">
	    			<input type = "hidden" name = "qnaRef" value = "<%=q.getqSeq() %>">
	    			<!-- 댓글 시퀀스넘버는 자동부여, 날짜는 sysdate로 집어넣으면 됨. -->
	    			<button type="submit" id="btn-insert">등록</button>
	    		</form>
	    	</div>
	    	
	   	<!-- 입력된 댓글이 나오는 부분 -->
	   	<table id="tbl-comment">
	   	<%for(QnaComment qc : comments){ %>
		   	<tr class="postedComment">
		   	
							<td>
								<sub class="comment-writer"><%=qc.getUserId()%></sub>
								<sub class="comment-date"><%=qc.getqDate() %></sub>
								<br>
								<%=qc.getqComment() %>
							</td>
							<td>
								<%if(userid!=null){%>
								<button class="btn-reply" value="<%=qc.getqSeq()%>">답글</button>
								<%} %>
								
								<!-- 1. 로그인한 상태 + 관리자일 경우   /2. 로그인한 상태 + 해당 댓글을 작성한 사람일 경우 -->
								<%if(userid!=null&& checkAdmin.equals("1") || userid!=null && userid.equals("") )
										{ %>
								<button class="btn-delete">삭제</button>
								<%} %>
							</td>
				</tr>
				<%} %>
		</table>

    </div>
	
</div>
    

<%@include file="/views/common/footer.jsp"%> 