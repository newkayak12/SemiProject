<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.main.model.vo.MainProduct, java.util.List" %>
<%@ include file = "/views/common/header.jsp"%>
<%
	List<MainProduct> products = (List<MainProduct>)request.getAttribute("products");
%>

<main id="mainPage-main">

	
	<div id="main_bestReviewerContainer">
		
		<p class="section_title">Best Reviewer</p>
			
			<div id="review_bestReviewerTable">
			
				<table style="margin-left: auto; margin-right: auto; width : 1000px;">
					
					<tr>
						<td>
							<p class="whiteBolderText">1</p>
							<img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px">
							<p class="orangeText">상품이름</p>
							<p class="whiteText">price : 가격</p>
						</td>
						
						<td>
							<p class="whiteBolderText">2</p>
							<img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px">
							<p class="orangeText">상품이름</p>
							<p class="whiteText">price : 가격</p>
						</td>
						
						<td>
							<p class="whiteBolderText">3</p>
							<img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px">
							<p class="orangeText">상품이름</p>
							<p class="whiteText">price : 가격</p>
						</td>
					</tr>
					
				</table>
				
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
	
	
	
	
	<%-- <div id="main_products">
		<div id ="grid-container">
		
		
		<% if( products!=null && products.size() > 0 ) { %>
		
			<%	for(int i=0; i < 9; i++) { %>
					
				<% 	MainProduct p = products.get(i); %>
			
				<div class = "grid_itembox">
						
					<div class="cover" style="display:inline-block;">
							<img alt="" src="<%=request.getContextPath()%>/upload/product/<%=p.getProductFile()%>">
							
							<div class="explain">
								<p><%=p.getProductName() %></p>
								<p><%=p.getProductPrice() %></p>
							</div>
					</div>
				</div>
				
				<%  if( i == 8) break; %>
				
			<% } %>
			
		<% } else { %>	
			
			<p> 공사중 ... </p>
			
		<% } %>
		
		</div>
	</div> --%>
	

</main>

<%-- <script>
	(function(){
		location.assign("<%=request.getContextPath()%>/main/product/list");
		return;
	})();
</script> --%>

<%@ include file = "/views/common/footer.jsp"%>
