<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="com.review.model.vo.Review, java.util.List" %>  
<%
	String reviewPageBar = (String)request.getAttribute("reviewPageBar");

	List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
%>    
    
<%@ include file = "/views/common/header.jsp"%>

	<main>

		<div id="review_bestReviewerContainer">
		
		<p class="section_title">Best Reviewer</p>
			
			<div id="review_bestReviewerTable">
			
				<table style="margin-left: auto; margin-right: auto; width : 1000px;">
				
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
					</tr>
					
					<tr>
						<td><img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px"></td>
						<td><img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px"></td>
						<td><img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px"></td>
					</tr>
					
					<tr>
						<td>
							id님<br>
							<span>상품이름 옵션</span>
						</td>
						<td>
							id님<br>
							<span>상품이름 옵션</span>
						</td>
						<td>
							id님<br>
							<span>상품이름 옵션</span>
						</td>
						
					</tr>
					
				</table>
			</div>
			
		</div>
		
		
		
		
		<div id="review_reviewListContainer">
		
			<p class="section_title">Review</p>
			
			<!-- 여기에 리뷰 보는 순서 정하는 옵션창 들어가야함 -->
			
			
			<!-- div클릭시 해당 글로 이동 -->
			<% if(reviewList != null && reviewList.size() != 0) { %>
			
				<table id="reviewTable">
						
					<% for(Review r : reviewList) { %>
					
						<!-- 리뷰 삭제여부 컬럼 : r_delete,  1 : 삭제안함 (디폴트), 0 : 삭제함 -->
						<% if(r.getReviewDelete().equals("1")) { %>
								
							<tr>
								<!-- 상품이미지 -->
								<td width="200px" style="padding:20px;">

									<a href="<%=request.getContextPath() %>/product/detail?pid=<%=r.getProductId()%>&category=<%=r.getCategoryId()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=r.getProductFile() %>" width="150px" height="200px"></a>

								</td>
								
								<!-- 작성자아이디, 상품이름, 리뷰제목 -->
								<td width="500px" style="padding:20px;">
									<a href="<%=request.getContextPath()%>/review/detail?no=<%=r.getReviewNo()%>"><%=r.getProductName() %><br><%=r.getReviewTitle() %><br><%=r.getUserId() %>님<br></a>
								</td>
								
								<!-- 리뷰이미지 -->
								<td width="200px" style="padding:20px;">
									<a href="<%=request.getContextPath()%>/review/detail?no=<%=r.getReviewNo()%>"><img src="<%=request.getContextPath() %>/upload/review/<%=r.getReviewFile()%>" width="150px" height="200px"></a>
								</td>
								
								<%-- 좋아요 기능 뺄수도? <td>
									<img src="<%=request.getContextPath() %>/images/heart.png" id="reviewLike" width="30px" height="30px">
									<span><%=r.getReviewLike() %></span>
								</td> --%>
								
							</tr>
							
						<% } %>
								
					<% } %>
					
				</table>
					
			<% } else { %>
				
				<p>리뷰가 없습니다</p>
				
			<% } %>
			
			
		</div>
		
		
		
		<div id="reviewList_pagebar">
			
			<br>
			<%=reviewPageBar %>
		</div>
		
	</main>	
		

<%@ include file = "/views/common/footer.jsp"%>