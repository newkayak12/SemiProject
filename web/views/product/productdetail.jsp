<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp" %>
<%@ page import="com.product.model.vo.Product" %>
<%@ page import="java.util.List" %>
<%
	Object o = request.getAttribute("productlist");
	List<Product> product = null;
	String colorflag ="";
	String sizeflag = "";
	
		if(o !=null){
			product = (List<Product>) o;				
		}

%>
<%if(product !=null){ %>
<main id="productdetail-main">



	<div id="productcontent-container">
	
		<div id="product_table-container"> 
			<table id="product-table">
				<tr>
					<td rowspan="9"> <img src="<%=request.getContextPath() %>/upload/product/<%=product.get(0).getProductFile() %>" alt="img"></td>
					<td>
						<%=product.get(0).getProductName() %>
						<input type="hidden" value="<%=%>">
					</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<td>
						<!-- <p>가격</p> -->
						<%=product.get(0).getProductPrice() %>
					</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<td>
						<select name="product_color-select" id="product_color-select">
								<option name="prodcut_color-select">
							 		------ 선택 사항 없음 ------  
						 		</option>
							<% 
							
								for(int i=0; i<product.size(); i++) {
									colorflag += "|"+product.get(i).getProductOptionColor()+"|";
								
									if(i==0){
								
							%>
							 	
							 	
							 	<option name="prodcut_color-select">
							 		<%=product.get(i).getProductOptionColor() %>
						 		</option>
						 		
						 		
							<%
							
									} else {
										
										
										if( !colorflag.contains(product.get(i).getProductOptionColor())){
									
							
							
							%>
								<option name="prodcut_color-select">
							 		<%=product.get(i).getProductOptionColor() %>
						 		</option>
							
							<%	
							
										}
									}
								}
							
							%>
						</select>					
					</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<td>
					
						<select name="product_size-select" id="product_size-select">
								<option name="prodcut_size-select">
							 		------ 선택 사항 없음 ------  
						 		</option>
							
							<% 
							
								for(int i=0; i<product.size(); i++) {
									sizeflag += "|"+product.get(i).getProductOptionSize()+"|";
								
										if(i==0){
								
							%>
							
							
							 	<option name="prodcut_size-select">
							 		<%=product.get(i).getProductOptionSize() %>
						 		</option>
						 		
						 		
							<%
							
										} else {
											
											if(!colorflag.contains(product.get(i).getProductOptionSize())){
										
										
							%>
								
							 	<option name="prodcut_size-select">
							 		<%=product.get(i).getProductOptionSize() %>
						 		</option>
						 	
								
							<%				
											}
										}
										
								}		
							
							
							
							%>





						</select>	
							
					</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<td rowspan ="2">
						//// 누르면 아이템의 개수와 색, 가격이 담긴 태그가 추가됨
					</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<!-- <td>stock</td> -->
				</tr>
				<tr>
					<!-- <td></td> -->
					<td rowspan="2"> 
						<span id="totalvalue"> total value</span>
					</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<!-- <td>total</td> -->
				</tr>
				<tr>
					<!-- <td></td> -->
					<td>
						<button type="button" id="buynow-btn" onclick="fn_buynow()">Buy now</button>
						<button type="button" id="cart-btn" onclick="fn_cart()">Cart</button>
					</td>
				</tr>	
			
			</table>
		</div>
	
		<div id="detailbox-container">
			<div id="menu_select-container">
				<span id="detailbtn" onclick="fn_detail()">Detail</span>
				<span id="noticebtn">Notice</span>
				<span id="reviewbtn">Review</span>
				<span id="qnabtn">Q&A</span>
			</div>
			
		<%if(product!=null){ %>	
			<div id="menu_content-container">
				<div id="menu_content-img" class="menu_content-container1">
					<div id="menu_content-p">
						<%
							String[] a = product.get(0).getProductExplain().split("@");
							String c = a[0];
							String b = a[1].replaceAll("-", "<br><br>-");
							System.out.println(b);
						%>
						
						<%=	c
						%>
						
						<%=
							b
						%>
					</div>				
					<div>
						<img alt="사진1" src="<%=request.getContextPath()%>/upload/product/<%=product.get(0).getProductFileDetail1()%>" width="500px">
						
						<img alt="사진2" src="<%=request.getContextPath()%>/upload/product/<%=product.get(0).getProductFileDetail2()%>" width="500px">
					</div>
				</div>

				<div id="menu_content-notice">
					notice
				</div>
				
				<div id="menu_content-review">
					review
				</div>
				
				<div id="menu_content-qna">
					qna
				</div>
				
			</div>
			
			
			
			
			
		<%} %>
		</div>
	</div>

<script>
	const fn_detail=()=>{
		
		
		$("#menu_content-img").css("display","flex");
		$("#menu_content-notice").css("display","none");
		$("#menu_content-review").css("display","none");
		$("#menu_content-qna").css("display","none");
	}
	
	$("#noticebtn").click(()=>{
		$("#menu_content-img").css("display","none");
		$("#menu_content-notice").css("display","flex");
		$("#menu_content-review").css("display","none");
		$("#menu_content-qna").css("display","none");
	})
	
	$("#reviewbtn").click(()=>{
		$("#menu_content-img").css("display","none");
		$("#menu_content-notice").css("display","none");
		$("#menu_content-review").css("display","flex");
		$("#menu_content-qna").css("display","none");
	})
	
	$("#qnabtn").click(()=>{
		$("#menu_content-img").css("display","none");
		$("#menu_content-notice").css("display","none");
		$("#menu_content-review").css("display","none");
		$("#menu_content-qna").css("display","flex");
	})
	
	
	const fn_buynow=()=>{
		
		
	}
	
	const fn_cart = ()=>{
		//쿠키 순서 품번_카테고리 번호_사이즈_색깔_제품이름_제품가격_제품개수
		let pid = "";
		let size = $("#product_size-select").val();
		let color = $("#product_color-select");
		let name = "<%=product.get(0).get%>";
		let price = "";
		let stock = "";
		
		
		
		<%
		 Cookie cookie = new Cookie("cart","_");
		 cookie.setMaxAge(60*60*24*365*100);
		%>
		
		location.assign("<%=request.getContextPath()%>/cart/list");
		
	}
	
</script>
	
	
	
	
</main>

<%} %>

<%@ include file ="/views/common/footer.jsp"%>