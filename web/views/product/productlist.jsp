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
	
	String sortFlag = (String)request.getAttribute("sortFlag");
	
	String searchKeyword = (String)request.getAttribute("keyword");
	list.get(0).getCategoryId();
	
	String cate = "all";
	Object z = request.getAttribute("category");
	
	
	if(z!=null){
		cate = (String)z;
		 
	}
%>

<style>
 a{
 	text-decoration: none;
 	color:orange;
 }
 
 #category-bar a{
 
 
 text-decoration: none;
 	color: rgb(9, 74, 169);
 }
 
 	
 	<%if(cate.equals("all")){%>
 	
 	#catebarall{
 		color:orange !important;
 	}
 	
 	<%} else if(cate.equals("c01")){%>
 	
 	#catebarc01{
 		color:orange !important;
 	}
 	
 	
 	<%} else if(cate.equals("c02")){%>
 	
 	#catebarc02{
 		color:orange !important;
 	}
 	
 	
 	<%} else if(cate.equals("c03")) {%>
 	
 	#catebarc03{
 		color:orange !important;
 	}
 	
 	
 	<%} else {%>
 	
 	#catebarc04{
 		color:orange !important;
 	}
 	
 	
 	<%} %>
 	
 	
 	
 
 
 
</style>



	<nav class="category-bar">
		<ul id="category-bar">
			<li><a  id="catebarall" href= "<%=request.getContextPath()%>/product/list?category=all">ALL</a></li>
			<li><a id="catebarc01" href= "<%=request.getContextPath()%>/product/list?category=c01">OUTTER</a></li>
			<li><a id="catebarc02" href= "<%=request.getContextPath()%>/product/list?category=c02">TOP</a></li>
			<li><a id="catebarc03" href= "<%=request.getContextPath()%>/product/list?category=c03">BOTTOM</a></li>
			<li><a id="catebarc04" href= "<%=request.getContextPath()%>/product/list?category=c04">ACC</a></li>
		</ul> 
	</nav>
	
<main id ="category-container">

	<!-- 검색 부분 --> 
	<div id="search-product-container">
		<ul>
			<li>
				<% if( searchKeyword != null ) { %>
					<input type="text" value="<%=searchKeyword%>" list="datalists" style="width:200px" id="searchbar">
				<% } else { %>
					<input type="text" list="datalists" style="width:200px" id="searchbar">
				<% } %>
					<datalist id="datalists">
					
					</datalist>
					<button id="search-product">검색</button>
			</li>
		</ul>
	</div>
	
	<% if(sortFlag.equals("0")) { %>
	
		<div id="sort-container">
			<ul>
				<li><a href= "<%=request.getContextPath()%>/product/list?category=<%=cate %>&sort=p_view_count">인기순</a></li>
				<li><a href= "<%=request.getContextPath()%>/product/list?category=<%=cate %>&sort=high">높은가격순</a></li>
				<li><a href= "<%=request.getContextPath()%>/product/list?category=<%=cate %>&sort=low">낮은가격순</a></li>
			</ul>
		</div>
	
	<% } %>
	
	
<!-- /////////////////////////////////////////////// -->

<% if(list!=null&&list.size()>0) { %>

	<div id ="grid-container">
		
			<% for(Product p : list){ %>
			
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
				
			<% } %>
			
	</div>		
			
		
		<% } else { %>
		
			<div id="nosearchresult-container">
			
				<div>
					<strong>검색결과가 없습니다!</strong><br><br>
					정확한 검색어 인지 확인하시고 다시 검색해 주세요.
				</div>
				
			</div>
		
	<%} %>	
		
		
	
	<div id="pageBar">
		<%=request.getAttribute("pageBar") %>
	</div>

</main>


<!-- <script>
	function hearttoggle(){
		const heart = document.querySelectorAll(".heart");
		heart.classList.toggle("active");
	}
</script>
 -->


<script>

	// 검색부분
	$("#search-product").click( (e) => {
		
		const keyword = $("#searchbar").val()
		console.log(keyword);
		
		 if(keyword.length == 0) {
			
			alert("검색어를 입력해주세요.");
			return;
		} 
		
				/* console.log(keyword); */
				
		location.replace("<%=request.getContextPath()%>/product/searchProduct?keyword=" + keyword);
		
	} );
	
	$("#searchbar").keyup(()=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/product/search/ajax",
			data:{"keyword":$("#searchbar").val()},
			success:data=>{
				console.log(data);
				$("#datalists").html("");
				for(let i=0; i<data.length; i++){
				let option =  $("<option>").attr("value",data[i]["productName"]).html(data[i]["productName"]);
				$("#datalists").append(option);
					
				}
				
			}
		})
	})
	
</script>


<%@include file="/views/common/footer.jsp" %>
