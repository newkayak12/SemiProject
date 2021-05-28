<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="com.review.model.vo.Review, java.util.List" %>  
<%
	String reviewPageBar = (String)request.getAttribute("reviewPageBar");

	List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
	
	List<Review> bestReviewList = (List<Review>)request.getAttribute("bestReviewList");
%>    
    
<%@ include file = "/views/common/header.jsp"%>

	<main id="main_reviewList">

		<div id="review_bestReviewerContainer">
		
		<p class="section_title">Best Reviewer</p>
			
			<div id="review_bestReviewerTable">
			
				<table class="boardTable_margin_width">
					
					<tr>
						<% if( bestReviewList != null && bestReviewList.size() != 0 ) { %>
						
							<% int num = 1; %>
						
							<% for(Review br : bestReviewList) { %>
							
								<td>
									<p class="blueText"><%=num %></p>
									<a href="<%=request.getContextPath()%>/review/detail?no=<%=br.getReviewNo()%>"><img src="<%=request.getContextPath() %>/upload/review/<%=br.getReviewFile()%>" width="250px" height="350px"></a>
									<p class="blueSmallText"><%=br.getProductName() %></p>
									<p class="grayText"><%=br.getUserId()%>님</p>
									<%-- <p>price : <%=br.get %></p> --%>
								</td>
							
							<% num++; %>	
								
							<% } %>
							
						<% } %>
						
						<%-- 
						<td>
							<p class="blueText">2</p>
							<img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px">
							<p class="blueText">상품이름</p>
							<p>price : 가격</p>
						</td>
						
						<td>
							<p class="blueText">3</p>
							<img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px">
							<p class="blueText">상품이름</p>
							<p>price : 가격</p>
						</td>
						 --%>
						
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
			
			
		</div>
		
		
		
		<div id="reviewList_pagebar">
			
			<br>
			<%=reviewPageBar %>
		</div>
		
	</main>	
		

<%@ include file = "/views/common/footer.jsp"%>