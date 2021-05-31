<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.Review, java.util.List"%>    
    
<%@ include file = "/views/common/header.jsp"%>

<%
	List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
	String reviewNo = (String)request.getAttribute("reviewNo");
	
	System.out.println("reviewFormModify.jsp에서 테스트, reviewNo : " + reviewNo);
	
	if(reviewList != null) {
		for(Review r : reviewList) {
			System.out.println("reviewFormModify.jsp에서 테스트, r : " + r);
		}
	} else {
		System.out.println("reviewFormModify.jsp에서 테스트, reviewList는 null !!!!!!! ");
	}
%>


<main id="reviewForm_main">

	<div id="reviewForm-container" >
	
		<h1>REVIEW</h1>
	
		<form action="<%=request.getContextPath()%>/review/modify/end" method="post" enctype="multipart/form-data">
		
			<input type="hidden" id="reviewNo" name="reviewNo" value="<%=reviewNo%>">
		
			<table id = "reviewForm-table">
			
				<tr>
					<th>상품</th>
					
					<td>
						<img src="<%=request.getContextPath() %>/upload/product/<%=reviewList.get(0).getProductFile()%>" name="" id="" width="100px" height="100px">
						<span><%=reviewList.get(0).getProductName() %></span>
						<span><%=reviewList.get(0).getProductOptionColor() %></span>
						<span><%=reviewList.get(0).getProductOptionSize()%></span>
						
					</td>
				</tr>
			
				<tr>
					<th>제&nbsp;&nbsp;&nbsp;목</th>
					<td><input type="text" name="reviewTitle" id="reviewTitle" size="95" value="<%=reviewList.get(0).getReviewTitle() %>" required></td>
				</tr>
				
				<tr>
					<th>작성자</th>
					<td><input type="text" name="reviewWriter" id="reviewWriter" value="<%=userid %>" readonly required size="95"></td>
				</tr>
				
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="up_file" value="<%=request.getContextPath() %>/upload/review/<%=reviewList.get(0).getReviewFile() %>"></td>
				</tr>
				
				<tr>
					<th>내&nbsp;&nbsp;&nbsp;용</th>
					<td><textarea rows="25" cols="80" name="reviewContent" required><%=reviewList.get(0).getReviewContents() %></textarea></td>
				</tr>
				
				<tr>
					<th colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</th>
				</tr>
				
			</table>
			
		</form>
		
	</div>
	
</main>

<%@ include file = "/views/common/footer.jsp"%>