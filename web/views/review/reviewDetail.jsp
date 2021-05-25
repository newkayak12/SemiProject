<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.*, java.util.List" %>    

<%@ include file = "/views/common/header.jsp"%>

<%
	List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
	
%>


<style>
	div#review_reply_list tr{
		border : 1px solid gray;
		padding : 5px;
		margin : 10px !important;
	}

	div#review_reply_list td{
		border : 1px solid gray;
		padding : 10px;
		margin : 10px !important;
		
	}
	
	div#review_reply_list td strong{
		font-size : 15px;
		color : rgb(80, 80, 80);
	}
	
	div#review_reply_list td span{
		display : inline-block;
	
		font-size : 12px;
		color : gray;
	
	}
	
	div#review_reply_list td p{
		margin-left : 10px !important;
	}
	
	div#review_reply_list td *{
		padding : 5px;
		margin : 5px;
	}
	
	
	
	/* div#review_comment_container>div>form{
		padding : 10px 10px 10px 0px;
	}
	 */
	div#review_insert_comment form{
		display: flex;
    	flex-direction: row;
    	justify-content: space-between;
    	
    	padding : 10px 0px 10px 0px;
	}
	
	div#review_insert_comment form button{
		margin-left : 10px;
		
		border-radius : 0;
		background-color : white;
	}
</style>
	
<main>

	<p class="section_title">Review</p>
	
	<div id="reviewDetail-container" >
	
		<div id="reviewDetail-inner-container">
		
			<p>
				<%=reviewList.get(0).getReviewTitle() %> 
				<br><br>
				POSTED BY : <%=reviewList.get(0).getUserId() %>
			</p>
			
			
			<!-- 상품이미지, 상품정보 div -->
			<div id="reviewDetail-inner2-container">
			
				<a href="<%=request.getContextPath() %>/product/detail?pid=<%=reviewList.get(0).getProductId()%>&category=<%=reviewList.get(0).getCategoryId()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=reviewList.get(0).getProductFile()%>" width="110px" height="160px"></a>

				<br>
				<span><%=reviewList.get(0).getProductName() %></span>
				
			</div>
			
		</div>
		
		
		 <!-- 사용자가 업로드한 사진과 내용 -->
		 <div id="reviewDetail-userImage_reviewContents">
		 
		 
		 		<img src="<%=request.getContextPath() %>/upload/review/<%=reviewList.get(0).getReviewFile()%>">
		 	
		 		<div><%=reviewList.get(0).getReviewContents() %></div>
		 	
		 	
		 	 	<!-- 수정, 삭제 버튼 div -->
				<div id="reviewDetail-buttons-container" style="display: flex; justify-content: flex-end;">
				
					<% if( userid != null && (userid.equals("admin") || userid.equals(reviewList.get(0).getUserId()) ) ) { %>
						<button onclick="fn_review_update();" style="width:70px; height:35px;">MODIFY</button>
						<button onclick="fn_review_delete();" style="width:70px; height:35px;">DELETE</button>
					<% } %>
					
					<button onclick="location.assign('<%=request.getContextPath()%>/review/list')" style="width:70px; height:35px;">LIST</button>
				</div>
		 	
		 	
		 </div>
		
	</div>
	
	<div id="review_comment_outter_container">
		 
		<div id="review_comment_container" >	 	
		 	
		 	<!-- 댓글 목록 -->
		 	<div id="review_reply_list">
		 	
		 		<table>
		 			<% if(reviewList != null || !reviewList.isEmpty() ) { %>
		
						<% for(Review r : reviewList) { %>
			
							<tr>
		 						<td>
		 							<span><strong><%=r.getCommentUserId() %></strong></span><span><%=r.getReviewCommentDate()%></span>
		 							<br>
		 							<p><%=r.getReviewComment() %></p>
		 						</td>
		 					</tr>
			
						<% } %>
		
		
					<% } %>
		 			
		 		</table>
		 	
		 	</div>
		 	
		 	
		 	<!-- 댓글 영역 div-->
		 <!-- 댓글도 수정삭제 버튼 필요 -->
		 	
		 	
		 	<!-- 댓글 입력창 -->
		 	<div id="review_insert_comment">
		 	
		 		<form action="<%=request.getContextPath()%>/review/insertReviewComment" method="post" id="" name="" onsubmit="return fn_insertComment();">
		 			 
		 			  <!-- hidden으로 받을 값 : 댓글을 작성한 사용자의 아이디, 해당하는 리뷰번호  -->
		 			 <input type="hidden" name="userId" id="userId" value="<%=userid%>">
		 			 <input type="hidden" name="reviewNo" id="reviewNo" value="<%=reviewList.get(0).getReviewNo()%>">
		 			 
		 			 <textarea name="reviewCommentContent" id="reviewCommentContent" rows="5" cols="110"></textarea>
		 			 
		 			 <button type="submit" id="btn_r_comment" style="width:95px; height:95px;">등록</button>
		 			 
		 		</form>
		 		
		 	</div>
		 	
		</div> <!-- 댓글 div -->
		
	</div>
		 

</main>


<script>

	const fn_review_update = () => {
		
		location.replace("<%=request.getContextPath()%>/review/modify/start?no=<%=reviewList.get(0).getReviewNo()%>");
	}
	
	
	
	const fn_review_delete = () => {
		
		let result = confirm("정말 삭제하시겠습니까?");
		
		// 확인버튼 누르면 -> true 
		// 취소버튼 누르면 -> false 
		
		if(result) {
			
			location.replace("<%=request.getContextPath()%>/review/delete?no=<%=reviewList.get(0).getReviewNo()%>");
		}
		
	}
	
	const fn_insertComment = () => {
		
		const content = $("#reviewCommentContent");
		
		if(<%= userid == null%>) {
			
				alert("로그인이 필요한 서비스입니다");
				location.assign("<%=request.getContextPath()%>/sign/signin/start");
				return false;
			
		} else {
		
				if(content.val().length == 0 || $.trim(content.val()).length == 0) {
					alert("댓글 내용을 입력해주세요");
					content.focus();
					return false;
				} else {
					return true;
				} 
		}
	
	}
	
	
</script>
	 
	
<%@ include file = "/views/common/footer.jsp"%>