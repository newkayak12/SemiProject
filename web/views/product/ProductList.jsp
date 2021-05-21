<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.product.model.vo.Product" %>
<%@include file="/views/common/header.jsp" %>

<%
	List<Product> list = (List<Product>)request.getAttribute("list");
%>

<script>
	function hearttoggle(){
		const heart = document.querySelectorAll(".heart");
		heart.classList.toggle("active");
	}
</script>
<main id ="category-container">

	<nav class="categoty-bar">
		<ul id="category-bar">
			<li>ALL</li>
			<li>OUTER</li>
			<li>TOP</li>
			<li>BOTTOM</li>
			<li>ETC</li>
		</ul> 
	</nav>
	
	
	<div id="sort-container">
		<ul>
			<li>인기순</li>
			<li>높은가격순</li>
			<li>낮은가격순</li>
		</ul>
	</div>
	

	<div id="items-container"3>
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
		</div>

		</div>
</main>
<%@include file="/views/common/footer.jsp" %>

</body>
</html>