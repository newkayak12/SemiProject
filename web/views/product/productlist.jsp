<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.List"%>
<%@ page import= " com.product.model.vo.Product" %>
<%@include file="/views/common/header.jsp" %>

<%
	Object o = request.getAttribute("result");
	List<Product> list = null;
	if(o!=null){
		
		list = (List<Product>) o;
		
	}
%>


<script>
	function hearttoggle(){
		const heart = document.querySelectorAll(".heart");
		heart.classList.toggle("active");
	}
</script>

	<nav class="category-bar">
		<ul id="category-bar">
			<li><a href= "<%=request.getContextPath()%>/product/list?category=all">ALL</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=c01">OUTTER</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=c02">TOP</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=c03">BOTTOM</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=c04">ETC</a></li>
		</ul> 
	</nav>
	
<main id ="category-container">

	<div id="search-product-container">
		<ul>
			<li>
				<input type="text">
				<button id="search-product">검색</button>
			</li>
		</ul>
	</div>
	
	<div id="sort-container">
		<ul>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=all&sort=p_view_count">인기순</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=all&sort=high">높은가격순</a></li>
			<li><a href= "<%=request.getContextPath()%>/product/list?category=all&sort=low">낮은가격순</a></li>
		</ul>
	</div>
	
	
<!-- /////////////////////////////////////////////// -->

	<div id ="grid-container">
		
		
		<% if(list!=null&&list.size()>0) {
		
			for(Product p : list){
		%>
			<div class = "grid_itembox">
					
				<div class="cover">
						<img alt="" src="<%=request.getContextPath()%>/upload/product/<%=p.getProductFile()%>">
						
						<div class="explain">
							<p><%=p.getProductName() %></p>
							<p><%=p.getProductPrice() %></p>
						</div>
				</div>
					
				
				 <a class = "thumbnail" href="<%=request.getContextPath()%>/product/detail?pid=<%=p.getProductId()%>&category=<%=p.getCategoryId()%>">
				 <%String[] a = p.getProductExplain().split("@"); %>
					<p><%= a[0]%></p>
				</a>
				
			</div>
			
		<%}
		
		} %>	
		
		
		
	
	
	</div>


		
	
	<div id="pageBar">
		<%=request.getAttribute("pageBar") %>
	</div>

</main>


<script>
	$("#search-product").click( (e) => {
		
		const keyword = $(e.target).prev().val();
		
				/* console.log(keyword); */
				
		location.replace("<%=request.getContextPath()%>/product/searchProductStart?keyword=" + keyword + "")
		
	} );
</script>


<%@include file="/views/common/footer.jsp" %>
