<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/views/common/header.jsp"%>


<main id="mainPage-main">

	<div id="bestReviewers">
	
		<p class="section_title">Best Reviewer</p>
		
		<!-- 이미지태그 3개  : 가로배열로-->
		<div id="img_name_price">
		
			<img src="<%=request.getContextPath() %>/images/dummy.jpg">
			<img src="<%=request.getContextPath() %>/images/dummy.jpg">
			<img src="<%=request.getContextPath() %>/images/dummy.jpg">
		
			<div id="inner_nameprice">
				<div class="name_price">상품명 <br>가격</div>
				<div class="name_price">상품명 <br>가격</div>
				<div class="name_price">상품명 <br>가격</div>
			</div>
		</div>

	</div>
	
	
	
	
	<div id="todayspick">
		
		<p class="section_title">Today's pick</p>
		
		<div id="slideshow">
		
			<div id="slides">
			
				<!-- <button id="btn_prev">&lang;</button> -->
			
				<img src="<%=request.getContextPath()%>/images/slideshow_img1.jpg" width="400px" height="300px">
			
				<div id="disc" style="display:inline-block;"> 상품설명 블라블라블라 어쩌구저쩌구 샬랴샬랴 </div>
				
				
				
				<button id="btn_next">&rang;</button>
				 
			</div>
			
		</div>
		
		
		
	</div>
	
	
	
	<div id="contents">
	
		<div id="contents_sort">
			<span>인기순</span>
			<span>높은가격순</span>
			<span>낮은가격순</span>
		<div>
		
		<div id="contents_imgs">
			<div class="img">img1</div>
			<div class="img">img2</div>
			<div class="img">img3</div>
			<div class="img">img4</div>
			<div class="img">img5</div>
			<div class="img">img6</div>
			<div class="img">img7</div>
			<div class="img">img8</div>
			<div class="img">img9</div>
		</div>

	</div>
	

</main>

<%@ include file = "/views/common/footer.jsp"%>
