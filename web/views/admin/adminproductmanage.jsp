<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>
<main>
	<div id = "productmanage-container">
		<p>상품 관리 페이지</p>
		
		<div>
			<input type = "button" value="상품 등록">
		</div>
	
		<div>
			<p>상품 리스트</p>
			<table>
				<tr>
					<th>상품 번호</th>
					<th>카테고리 이름</th>
					<th>상품명</th>
					<th>대표 사진</th>
					<th>색상</th>
					<th>사이즈</th>
					<th>재고</th>
				</tr>
				
				<tr id="products_admin_list">
					
				<tr>
			
			</table>
		</div>	
	</div>
</main>

<script>
	$(function(){
		let tr = $("#products_admin_list");
		
		
		
	})
</script>

<%@ include file = "/views/common/footer.jsp"%>