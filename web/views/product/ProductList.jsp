<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.List"%>
<%@ page import= " com.product.model.vo.Product" %>
<%@include file="/views/common/header.jsp" %>

<%
	List<Product> list = (List<Product>)request.getAttribute("list");
%>

<style>
*{
	margin : 0px !important;
 	padding : 0px !important;
}

#category-container{
	position:relative;
	top:100px;
}

</style>


<script>
	function hearttoggle(){
		const heart = document.querySelectorAll(".heart");
		heart.classList.toggle("active");
	}
</script>
<main id ="category-container">

	<nav class="categoty-bar">
		<ul id="category-bar">
			<li><a href= "<%=request.getContextPath()%>/product/list?category=all">ALL</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=c01">OUTTER</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=c02">TOP</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=c03">BOTTOM</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=c04">ETC</a></li>
		</ul> 
	</nav>
	
	
	<div id="sort-container">
		<ul>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=all&sort=p_view_count">인기순</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=all&sort=high">높은가격순</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=all&sort=low">낮은가격순</a></li>
		</ul>
	</div>
	

	<div id="items-container" style="margin : 0px !important; padding : 0px !important;" >
		
		<!-- 첫번째 상품  -->
		<div>
			<div class="img-container">
				<a href="<%=request.getContextPath()%>/pdetail">
					<img class="product-thumbnail" src ="<%=request.getContextPath() %>/images/pants1.jpg" style='width : 100%; height : 100%;'>
				</a>
				
				<a href="<%=request.getContextPath()%>/pdetail">
					<div class="text">
						<p>DB에서 받아온 상품 상세설명</p>
					</div>
				</a>
			</div>

			<div class="content-container">
				<span>상품</span>
				<span>가격</span><span>하트</span>
			</div>
		</div>
		

		
		<div>
	<!-- PageBar -->
		</div>
		
		
	</div>
</main>
<%@include file="/views/common/footer.jsp" %>

</body>
</html>