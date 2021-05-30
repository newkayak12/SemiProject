<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "/views/common/header.jsp"%>

<main style="height : 600px !important; display: flex; align-items: center; justify-content: center; flex-direction:column">

	<ul class="text_align_center border_bottom_blue">
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/product/manage">상품 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/reviewManage">리뷰 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/order/list">주문 관리</a></li>
		<li class="hrz_li"><a class="blackText" href="<%=request.getContextPath()%>/admin/userselect/start">회원 관리</a></li>
	</ul>
	
	<div style="height : 430px;">
		<p class="section_title" style="text-align : center; margin-top : 100px;">관리할 메뉴를 선택하세요</p>
	</div>
	
</main>	
	
<%@ include file = "/views/common/footer.jsp"%>