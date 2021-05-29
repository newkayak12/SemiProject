<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.Review, java.util.List" %>  
    
<%@ include file = "/views/common/header.jsp"%>

<%

	String reviewPageBar = (String)request.getAttribute("reviewPageBar");

	List<Review> reviewList = (List<Review>)request.getAttribute("reviewList");
	
%>

<main>

	<ul class="text_align_center border_bottom_blue">
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/product/manage">상품 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/reviewManage">리뷰 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="">Q&A 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="">주문 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/userselect/start">회원 관리</a></li>
	</ul>
	
	<p class="text_align_center section_title margin_50">리뷰관리</p>

	<table id="admin_reviewlist" class="boardTable_margin_width">
		<thead class="thead-color">
        	<th>리뷰번호</th>
        	<th>작성자아이디</th>
        	<th>주문번호</th>
            <th>제목</th>
            <th>상품이름</th>
            <th>작성날짜</th>
            <th>조회수</th>
            <th>리뷰삭제여부</th>
            <th>비공개처리</th>
        </thead>
        
        <% if( reviewList != null && reviewList.size() != 0 ) { %>
        
        	<% for( Review r : reviewList ) { %>
        	
        		<tr onclick="location.assign('<%=request.getContextPath()%>//review/detail?no=<%=r.getReviewNo()%>')">
        		
        			<form action="<%=request.getContextPath()%>/admin/reviewHidden" method="post">
			        	
			        	<input type="hidden" name="reviewNo" value="<%=r.getReviewNo() %>">
			        	<input type="hidden" name="rDelete" value="<%=r.getReviewDelete()%>">
			        	
			        	<td class="text_align_center"><%=r.getReviewNo() %></td>
			        	<td class="text_align_center"><%=r.getUserId() %></td>
			        	<td class="text_align_center"><%=r.getOrderNumber() %></td>
			        	<td class="text_align_center"><%=r.getReviewTitle() %></td>
			        	<td class="text_align_center"><%=r.getProductName() %></td>
			        	<td class="text_align_center"><%=r.getReviewDate() %></td>
			        	<td class="text_align_center"><%=r.getReviewCount() %></td>
			        	<td class="text_align_center">
			        		<% if( r.getReviewDelete().equals("1") ) { %>
			        			정상(공개)
			        		<% } else { %>
			        			삭제(비공개)
			        		<% } %>
			        	</td>
			        	<td class="text_align_center">	
			        		<% if( r.getReviewDelete().equals("1") ){%>
								<button>비공개처리</button>
							<% } else{ %>
								<button>공개처리</button>
							<% }%>
							
			        	</td>
			        	
		        	</form>
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

<script>
	$("#btn_review_hidden").click( (e) => {
		
	} );

	
</script>

<%@ include file = "/views/common/footer.jsp"%>