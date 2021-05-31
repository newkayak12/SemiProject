<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.review.model.vo.Review, java.util.List" %>  
<%
	String reviewPageBar = (String)request.getAttribute("reviewPageBar");

	List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
	
	List<Review> bestReviewList = (List<Review>)request.getAttribute("bestReviewList");
%>
	
	
	<span id = "My-Review-section" class="Qna-category">Review</span>
	
	
	<% if(reviewList != null && reviewList.size() != 0) { %>
				
					<table id="MyreviewTable">
							
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
										<a class="blackText" href="<%=request.getContextPath()%>/review/detail?no=<%=r.getReviewNo()%>">
											<p class="bolderText"><%=r.getProductName() %></p>
											<p><%=r.getReviewTitle() %></p>
											<p class="grayText"><%=r.getUserId() %>님</p>
											<p class="grayText">조회수 <%=r.getReviewCount() %></p>
										</a>
									</td>
									
									<!-- 리뷰이미지 -->
									<td width="200px" style="padding:20px;">
										<a href="<%=request.getContextPath()%>/review/detail?no=<%=r.getReviewNo()%>"><img src="<%=request.getContextPath() %>/upload/review/<%=r.getReviewFile()%>" width="150px" height="200px"></a>
									</td>
									
								</tr>
								
							<% } %>
									
						<% } %>
					
				</table>
					
			<% } else { %>
				
				<p>아직 작성된 리뷰가 없습니다.</p>
				
			<% } %>

		
		
		
		<div id="MyreviewList_pagebar">
			
			<%=reviewPageBar %>
		</div>
</div>