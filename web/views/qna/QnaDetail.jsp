<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "com.qna.model.vo.Qna, java.util.List, com.qna.model.vo.QnaComment" %>

<% 
	Qna q = (Qna)request.getAttribute("qna");
	List<QnaComment> comments = (List<QnaComment>)request.getAttribute("comments"); 
%>

<%
	pageContext.setAttribute("crcn", "\r\n"); //스페이스나 개행처리
	pageContext.setAttribute("br", "<br/>"); // br태그
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
	        	<td colspan = "2" style="border-bottom : none !important;" >
	        		<div class="content-background text-center" name="qnaContent" style="border : 1px solid grey;">
	        			<%if(q.getqFile()!=null){ %>
	        				<img src = "<%=request.getContextPath() %>/upload/qna/<%=q.getqFile()%>" style="width : 100px; height: auto;"><br>
	        			<%} %>
	        			<br><%=q.getqContents() %>
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
	         	<%if((userid!=null && checkAdmin.equals("1"))  ||  ( userid!=null&& userid.equals(q.getUserId()))){ %>
		            <input type="button" class="notice-btn blue btn-width" value="수정하기" onclick="qnaModi();">
		        	<%} %>
		        	<input type="button" class="notice-btn white btn-width" value="목록" onclick="back();">
	         </div>
	        	
    	
    	
    	
    	<!-- 댓글 부분 -->
    	<div id="comment-container" style="margin : 0px 0px;">
    	
	    
	    <!-- 댓글 입력하는 부분 -->
	    	<div class="comment-editor">
	    		<form id = "qna-co-form" action="<%=request.getContextPath() %>/qna/inserQnaComment" method="post">
	    			<textarea name="content" cols="55" rows="2"></textarea>
	    			<input type="hidden" name="userId" id="userId" value="<%=userid%>">
	    			<input type = "hidden" name = "qnaRef" value = "<%=q.getqSeq() %>">
	    			<!-- 댓글 시퀀스넘버는 자동부여, 날짜는 sysdate로 집어넣으면 됨. -->
	    			<button type="submit" id="btn-insert" class="notice-btn blue btn-width">등록</button>
	    		</form>
	    	</div>
	    	
	    	
	    	
	   <!-- 입력된 댓글이 나오는 부분 -->
	   	<table id="tbl-comment">
				<%if(comments!=null){ 
					for(QnaComment qc : comments){%>
					<tr class="border-bottom">
						<td>
							<sub class="comment-writer"><%=qc.getUserId() %></sub><br>
							<p class="comment-content"><%=qc.getqComment() %></p>
							<sub class="grey-small"><%=qc.getqDate() %></sub>
							
						</td>
						<td style="text-align: end;">
							<%if(userid!=null && checkAdmin.equals("1") || userid!=null && userid.equals(qc.getUserId())){ %>
							<button class="btn-modify notice-btn white btn-width qna_comment_modify">수정</button>
							<button class="btn-delete notice-btn grey btn-width" onclick="qnaCommentDelete();">삭제</button>
							
							<!-- 댓글 수정이나 삭제는 seq값들 hidden으로 보내줘야 함 -->
							<input  type ="hidden"  name = "CommentSeq" value ="<%=qc.getqSeq()%>">
			 				<input  type ="hidden"  name = "QnaSeq" value ="<%=q.getqSeq()%>">
							<%} %>
						</td>
					</tr>	
					
					<%}
					}%>	 
			</table>

    </div> 
	
</div>

<script>
	const back=()=>{
		window.history.back();
	}
	
	const qnaModi=()=>{
			location.assign('<%=request.getContextPath() %>/qna/qnaModi?qSeq=<%=q.getqSeq()%>')
	}
	
	const qnaCommentDelete=()=>{
		if(confirm("정말로 삭제하시겠습니까?")){
			location.assign('<%=request.getContextPath() %>/qna/qnaCommentDelete?qSeq=<%=q.getqSeq()%>')
		}else{
			return;
		}
	}
	
	const qnaCommentModify=()=>{
		location.assign('<%=request.getContextPath() %>/qna/qnaModi?qSeq=<%=q.getqSeq()%>')
	}
	
	
	
	// 댓글 수정하는 부분

		$(".qna_comment_modify").click( (e) => {
		
		
		
		// 1. 댓글 수정 버튼을 누르면 원래 댓글 보이던 태그와 수정버튼, 삭제버튼을 감춤
		$(e.target).parent().parent().find("p").css("display", "none");
		$(e.target).css("display", "none");
		$(e.target).next().css("display", "none");
		
		
		
		// 2. 원래 보이던 댓글을 
		const oldCommentContent = $(e.target).parent().parent().find("p").text();
		
				/* console.log(oldCommentContent); */
				
				
		// 3. 입력창에 띄움 
		const newComment = $("<textarea>").attr( {
			
			name : "",
			class : "newComment",
			rows : "4",
			cols : "50",
			
		} ).text( oldCommentContent );
				
	   newComment.css(
		   'vertical-align', 'bottom'
	   )
				
	
				
		// 4. 댓글 등록 버튼
		const newButton = $("<button>").attr( {
			
			name : "", 
			class : "newButton notice-btn grey btn-width",
			
			
		} ).text("수정완료");
		
		
		
		// 5. td에 댓글입력창과 등록버튼을 추가
		$(e.target).parent().parent().append(newComment);
		$(e.target).parent().parent().append(newButton);
		
		
		// 6. 가려져있는 태그에서 코멘트번호와 리뷰번호를 가져옴
		/* const commentNo = $("#hiddenCommentNo").text(); */ 
		const commentNo = $(e.target).next().next().val();
		
									console.log(commentNo);
		
		
		/* const reviewNo = $("#hiddenReviewNo").text(); */
		const QnaNo = $(e.target).next().next().next().val();
		
									console.log(QnaNo);
		
		
		// 7. 입력창에서 새로 수정한 댓글을 가져옴
		
		/* const commentContent = $("#newComment").val();  */
		// 이렇게 하면 등록버튼을 클릭하기 전에 값을 가져오므로, 수정된 댓글이 아닌 이전 댓글이 불러와진다 두둥 !! 
		
				
		
		$(".newButton").click( (e) => {
			
			const commentContent = $(e.target).prev().val();
					
					
			location.replace("<%=request.getContextPath()%>/qna/commentmodify?qSeq=" + commentNo 
							 + "&commentContent=" + commentContent 
							 + "&QnaNo=" + QnaNo + "");
			
			
		} ); 
		
		
		
	} );
</script>    

<%@include file="/views/common/footer.jsp"%> 

