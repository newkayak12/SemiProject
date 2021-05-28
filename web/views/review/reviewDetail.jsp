<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.*, java.util.List" %>    

<%@ include file = "/views/common/header.jsp"%>

<%
	List<Review> review = (List<Review>)request.getAttribute("review");
	
	if(review != null && review.size() != 0) {
		for(Review r : review) {
			System.out.println("reviewDetail.jsp에서 테스트, r : " + r);
		}
	}

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
				<%=review.get(0).getReviewTitle() %> 
				<br><br><br><br><br><br>
				POSTED BY : <%=review.get(0).getUserId() %>
				<br>
				<%=review.get(0).getReviewDate()%> | 조회수 <%=review.get(0).getReviewCount() %>
			</p>
			
			
			<!-- 상품이미지, 상품정보 div -->
			<div id="reviewDetail-inner2-container">
			
				<a href="<%=request.getContextPath() %>/product/detail?pid=<%=review.get(0).getProductId()%>&category=<%=review.get(0).getCategoryId()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=review.get(0).getProductFile()%>" width="110px" height="160px"></a>

				<br>
				<span><%=review.get(0).getProductName() %></span>
				
			</div>
			
		</div>
		
		
		 <!-- 사용자가 업로드한 사진과 내용 -->
		 <div id="reviewDetail-userImage_reviewContents">
		 
		 
		 		<img src="<%=request.getContextPath() %>/upload/review/<%=review.get(0).getReviewFile()%>">
		 	
		 		<div><%=review.get(0).getReviewContents() %></div>
		 	
		 	
		 	 	<!-- 수정, 삭제 버튼 div -->
				<div id="reviewDetail-buttons-container" style="display: flex; justify-content: flex-end;">
				
					<% if( userid != null && (checkAdmin.equals("1") || userid.equals(review.get(0).getUserId()) ) ) { %>
						<button onclick="fn_review_update();" style="width:70px; height:35px;">수정</button>
						<button onclick="fn_review_delete();" style="width:70px; height:35px;">삭제</button>
					<% } %>
					
					<button onclick="location.assign('<%=request.getContextPath()%>/review/reviewReportCount')" style="width:70px; height:35px;">신고</button>
					<button onclick="location.assign('<%=request.getContextPath()%>/review/list')" style="width:70px; height:35px;">목록</button>
				</div>
		 	
		 	
		 </div>
		
	</div>
	
	<div id="review_comment_outter_container">
		 
		<div id="review_comment_container" >	 	
		 	
		 	<!-- 댓글 목록 -->
		 	<div id="review_reply_list">
		 	
		 		<table>
		 			<% if(review != null || !review.isEmpty() ) { %>
		
						<% for(Review r : review) { %>
						
							<% if( r.getCommentUserId() != null && r.getReviewComment() != null && r.getReviewCommentDate() != null && r.getReviewCommentNo() != null) { %>
				
								<tr>
			 						<td>
			 							<span><strong><%=r.getCommentUserId() %></strong></span>
			 							<span><%=r.getReviewCommentDate()%></span>
			 							
			 										
			 							<% if(userid != null && userid.equals(r.getCommentUserId())) { %>
			 							
			 								<button class="review_comment_modify" >수정</button>
			 								<button class="review_comment_delete">삭제</button>
			 						
			 										<input  type ="hidden"  value ="<%=r.getReviewCommentNo()%>">
			 										<input  type ="hidden"  value ="<%=r.getReviewNo()%>">
			 							
			 							<% } %>
		 							
		 							<br>
		 							
		 							<p id="rcommentContent"><%=r.getReviewComment() %></p>
		 						</td>
		 					</tr>
		 					
		 					<% } %>
			
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
		 			 <input type="hidden" name="reviewNo" id="reviewNo" value="<%=review.get(0).getReviewNo()%>">
		 			 
		 			 <textarea name="reviewCommentContent" id="reviewCommentContent" rows="5" cols="110"></textarea>
		 			 
		 			 <button type="submit" id="btn_r_comment" style="width:95px; height:95px;">등록</button>
		 			 
		 		</form>
		 		
		 	</div>
		 	
		</div> <!-- 댓글 div -->
		
	</div>
		 

</main>


<script>

	// 리뷰 수정
	const fn_review_update = () => {
		
		location.replace("<%=request.getContextPath()%>/review/modify/start?no=<%=review.get(0).getReviewNo()%>");
	}
	
	
	// 리뷰 삭제
	const fn_review_delete = () => {
		
		let result = confirm("정말 삭제하시겠습니까?");
		
		// 확인버튼 누르면 -> true 
		// 취소버튼 누르면 -> false 
		
		if(result) {
			
			location.replace("<%=request.getContextPath()%>/review/delete?no=<%=review.get(0).getReviewNo()%>");
		}
		
	}
	
	// 댓글 등록
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
	
	// 댓글 수정
	$(".review_comment_modify").click( (e) => {
		
		
		
		/* console.log( $(e.target) ); */ // 버튼이 선택된다
		
		// console.log( $(e.target).parent() ); // td가 선택된다
		
		// console.log( $(e.target).parent().find("p") );
		
		
		// 1. 댓글 수정 버튼을 누르면 원래 댓글 보이던 태그와 수정버튼, 삭제버튼을 감춤
		$(e.target).parent().find("p").css("display", "none");
		$(e.target).css("display", "none");
		$(e.target).next().css("display", "none");
		
		
		
		// 2. 원래 보이던 댓글을 
		const oldCommentContent = $(e.target).parent().find("p").text();
		
				/* console.log(oldCommentContent); */
				
				
		// 3. 입력창에 띄움 
		const newComment = $("<textarea>").attr( {
			
			name : "",
			class : "newComment",
			rows : "3",
			cols : "80"
			
		} ).text( oldCommentContent );
				
				
		// 4. 댓글 등록 버튼
		const newButton = $("<button>").attr( {
			
			name : "", 
			class : "newButton"
			
		} ).text("등록");
		
		
		// 5. td에 댓글입력창과 등록버튼을 추가
		$(e.target).parent().append(newComment);
		$(e.target).parent().append(newButton);
		
		
		// 6. 가려져있는 태그에서 코멘트번호와 리뷰번호를 가져옴
		/* const commentNo = $("#hiddenCommentNo").text(); */ 
		const commentNo = $(e.target).next().next().val();
		
									console.log(commentNo);
		
		
		/* const reviewNo = $("#hiddenReviewNo").text(); */
		const reviewNo = $(e.target).next().next().next().val();
		
									console.log(reviewNo);
		
		
		// 7. 입력창에서 새로 수정한 댓글을 가져옴
		
		/* const commentContent = $("#newComment").val();  */
		// 이렇게 하면 등록버튼을 클릭하기 전에 값을 가져오므로, 수정된 댓글이 아닌 이전 댓글이 불러와진다 두둥 !! 
		
				
		
		$(".newButton").click( (e) => {
			
			// console.log( $(e.target).prev().val() ); 선생님이 써주신 부분
			
			const commentContent = $(e.target).prev().val();
					/* 
					console.log("commentNo" + commentNo);
					console.log("reviewNo" + reviewNo);
					console.log("commentContent" + commentContent); */
					
			location.replace("<%=request.getContextPath()%>/review/commentmodify?commentNo=" + commentNo 
							 + "&commentContent=" + commentContent 
							 + "&reviewNo=" + reviewNo + "");
			
		} ); 
		
		
		
	} );
	
	
	
	// 댓글 삭제
	$(".review_comment_delete").click( (e) => {
		
		const del = confirm("댓글을 삭제하시겠습니까?");
		
		const commentNo = $(e.target).next().val();
		const reviewNo = $(e.target).next().next().val();
		
		if(del) {
			location.replace("<%=request.getContextPath()%>/review/commentdelete?commentNo=" + commentNo + "&reviewNo=" + reviewNo + "");
		}
		
	});
	
</script>
	 
	
<%@ include file = "/views/common/footer.jsp"%>