<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.Review" %>    

<%@ include file = "/views/common/header.jsp"%>

<%
	Review r = (Review)request.getAttribute("review");
%>
	
<main>
	
	<div id="reviewDetail-container" >
	
		<p class="section_title">Review</p>
	
	
		<div id="reviewDetail-inner-container">
		
			<span><%=r.getReviewTitle() %></span>
			<br>
			<span>작성자 : <%=r.getUserId() %></span>
			
			
			<!-- 상품이미지, 상품정보 div -->
			<div id="reviewDetail-inner2-container">
			
				<img src="<%=request.getContextPath() %>/upload/review/<%=r.getProductFile() %>" width="150px" height="150px">
				<br>
				<span><%=r.getProductName() %>/<%=r.getProductOptionColor() %></span>
			
			</div>
			
		</div>
		
		
		 <!-- 사용자가 업로드한 사진과 내용 -->
		 <div id="reviewDetail-userImage_reviewContents">
		 	<%-- <%=r.getReviewFile() %> 으로 불러온 사진파일 보여줘야함--%>
		 	<img src="<%=request.getContextPath() %>/upload/review/<%=r.getReviewFile()%>">
		 	<div><%=r.getReviewContents() %></div>
		 </div>
		 
		 
		 <!-- 댓글 영역 div-->
		 <!-- 댓글도 수정삭제 버튼 필요 -->
		 <div>
		 	
		 </div>
		
		<!-- 버튼 div -->
		<div id="reviewDetail-buttons">
		
			<% if( userid != null && (userid.equals("admin") || userid.equals(r.getUserId()) ) ) { %>
				<button onclick="fn_review_update();">수정</button>
				<button onclick="fn_review_delete();">삭제</button>
			<% } %>
			
			<button onclick="location.assign('<%=request.getContextPath()%>/review/list')">목록</button>
		</div>
		
	</div>

</main>


<script>

	const fn_review_update = () => {
		
		location.replace("<%=request.getContextPath()%>/review/modify/start?no=<%=r.getReviewNo()%>");
	}
	
	const fn_review_delete = () => {
		
		let result = confirm("정말 삭제하시겠습니까?");
		
		// 확인버튼 누르면 -> true 
		// 취소버튼 누르면 -> false 
		
		if(result) {
			
			location.replace("<%=request.getContextPath()%>/review/delete?no=<%=r.getReviewNo()%>");
		}
		
	}
	
</script>

	
<%@ include file = "/views/common/footer.jsp"%>