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
					<td rowspan="9"> <img src="" alt="hello"></td>
					<td><%=product.get(0).getProductName() %></td>
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
					<td rowspan="2">total</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<!-- <td>total</td> -->
				</tr>
				<tr>
					<!-- <td></td> -->
					<td>
						<button type="button" id="buynow-btn">Buy now</button>
						<button type="button" id="cart-btn">Cart</button>
					</td>
				</tr>	
			
			</table>
		</div>
	
		<div id="detailbox-container">
			<div id="menu_select-container">
				<span>Detail</span>
				<span>Notice</span>
				<span>Review</span>
				<span>Q&A</span>
			</div>
			<div id="menu_content-container">
			
			</div>
		</div>
	</div>


	
	
	
	
</main>

<%} %>

<%@ include file ="/views/common/footer.jsp"%>