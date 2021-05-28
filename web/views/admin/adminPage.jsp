<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "/views/common/header.jsp"%>

<main>

	<ul class="text_align_center">
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/product/manage/admin">상품 관리</a></li>
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/admin/reviewManage">리뷰 관리</a></li>
		<li class="hrz_li"><a href="">Q&A 관리</a></li>
		<li class="hrz_li"><a href="">주문 관리</a></li>
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/admin/userselect/start">회원 관리</a></li>
	</ul>
	
</main>	
	
<%@ include file = "/views/common/footer.jsp"%>