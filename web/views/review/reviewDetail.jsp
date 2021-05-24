<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.*, java.util.List" %>    

<%@ include file = "/views/common/header.jsp"%>

<%
	List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
	
%>
	
<main>
	 
	<div id="reviewDetail-container" >
	
		<p class="section_title">Review</p>
	
	
		<div id="reviewDetail-inner-container">
		
			<span><%=reviewList.get(0).getReviewTitle() %></span>
			<br>
			<span>작성자 : <%=reviewList.get(0).getUserId() %></span>
			
			
			<!-- 상품이미지, 상품정보 div -->
			<div id="reviewDetail-inner2-container">
			
				<a href="<%=request.getContextPath() %>/product/detail?pid=<%=reviewList.get(0).getProductId()%>&category=<%=reviewList.get(0).getCategoryId()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=reviewList.get(0).getProductFile()%>" width="150px" height="150px"></a>
				<br>
				<span><%=reviewList.get(0).getProductName() %>/<%=reviewList.get(0).getProductOptionColor() %></span>
				
			</div>
			
		</div>
		
		
		 <!-- 사용자가 업로드한 사진과 내용 -->
		 <div id="reviewDetail-userImage_reviewContents">
		 
		 	<img src="<%=request.getContextPath() %>/upload/review/<%=reviewList.get(0).getReviewFile()%>">
		 	
		 	<div><%=reviewList.get(0).getReviewContents() %></div>
		 	
		 </div>
		 
		 
		 
		 
		 
		 
		 <!-- 댓글 영역 div-->
		 <!-- 댓글도 수정삭제 버튼 필요 -->
		<div id="review_comment_container">
		 	
		 	
		 	<!-- 댓글 입력창 -->
		 	<div id="review_insert_comment">
		 	
		 		<form action="<%=request.getContextPath()%>/review/insertReviewComment" method="post" id="" name="" onsubmit="return fn_insertComment();">
		 			 
		 			  <!-- hidden으로 받을 값 : 댓글을 작성한 사용자의 아이디, 해당하는 리뷰번호  -->
		 			 <input type="hidden" name="userId" id="userId" value="<%=userid%>">
		 			 <input type="hidden" name="reviewNo" id="reviewNo" value="<%=reviewList.get(0).getReviewNo()%>">
		 			 
		 			 <textarea name="reviewCommentContent" id="reviewCommentContent" rows="3" cols="55"></textarea>
		 			 
		 			 <button type="submit" id="btn_r_comment">등록</button>
		 			 
		 		</form>
		 		
		 	</div>
		 	
		 	
		 	<!-- 댓글 목록 -->
		 	<div id="">
		 	
		 		<table>
		 			<% if(reviewList != null || !reviewList.isEmpty() ) { %>
		
						<% for(Review r : reviewList) { %>
			
							<tr>
		 						<td><%=r.getCommentUserId() %></td>
		 						<td><%=r.getReviewComment() %></td>
		 						<td><%=r.getReviewCommentDate()%></td>
		 					</tr>
			
						<% } %>
		
		
					<% } %>
		 			
		 		</table>
		 	
		 	</div>
		 	
		 	
		</div>
		 
		 
		 
		 
		 
		
		<!-- 수정, 삭제 버튼 div -->
		<div id="reviewDetail-buttons">
		
			<% if( userid != null && (userid.equals("admin") || userid.equals(reviewList.get(0).getUserId()) ) ) { %>
				<button onclick="fn_review_update();">수정</button>
				<button onclick="fn_review_delete();">삭제</button>
			<% } %>
			
			<button onclick="location.assign('<%=request.getContextPath()%>/review/list')">목록</button>
		</div>
		
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