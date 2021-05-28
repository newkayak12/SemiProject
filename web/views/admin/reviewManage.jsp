<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.Review, java.util.List" %>  
    
<%@ include file = "/views/common/header.jsp"%>

<%

	String reviewPageBar = (String)request.getAttribute("reviewPageBar");

	List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
	
%>

<main>

	<ul class="text_align_center">
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/product/manage/admin">상품 관리</a></li>
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/admin/reviewManage">리뷰 관리</a></li>
		<li class="hrz_li"><a href="">Q&A 관리</a></li>
		<li class="hrz_li"><a href="">주문 관리</a></li>
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/admin/userselect/start">회원 관리</a></li>
	</ul>

	<table class="boardTable_margin_width">
		<thead class="thead-color">
        	<th>리뷰번호</th>
            <th>제목</th>
            <th>상품이름</th>
            <th>작성날짜</th>
            <th>리뷰삭제여부</th>
            <th>신고횟수</th>
            <th>비공개처리</th>
        </thead>
        
        <% if( reviewList != null && reviewList.size() != 0 ) { %>
        
        	<% for( Review r : reviewList ) { %>
        	
        		<tr>
		        	<td class="text_align_center"><%=r.getReviewNo() %></td>
		        	<td><%=r.getReviewTitle() %></td>
		        	<td><%=r.getProductName() %></td>
		        	<td><%=r.getReviewDate() %></td>
		        	<td>
		        		<% if( r.getReviewDelete().equals("1") ) { %>
		        			정상
		        		<% } else { %>
		        			삭제
		        		<% } %>
		        	</td>
		        	<td><%=r.getReviewReportCount() %></td>
		        	<td>
		        		<button>비공개처리</button>
		        	</td>
        		</tr>
        	
        	<% } %>
        
        <% } else { %>
        
        <% } %>
        
	</table>
	
	<div class="text_align_center margin_center_width_1000">	
		<br>
		<%=reviewPageBar %>
	</div>
	

</main>

<%@ include file = "/views/common/footer.jsp"%>