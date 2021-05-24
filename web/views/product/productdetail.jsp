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
					<td rowspan="8"> <img src="<%=request.getContextPath() %>/upload/product/<%=product.get(0).getProductFile() %>" alt="img"></td>
					<td><%=product.get(0).getProductName() %></td>
				</tr>
				
				
				<tr>
					<!-- <td></td> -->
					<td>
						<!-- <p>가격</p> -->
						<%=product.get(0).getProductPrice() %> 원
					</td>
				</tr>
				<tr>
					<!-- <td></td> -->
					<td>
						<select name="product_color-select" id="product_color-select" onchange="fn_colorselect()">
								<option name="prodcut_color-select" value="------ 선택 사항 없음 ------">
							 		------ 선택 사항 없음 ------  
						 		</option>
							<% 
							
								for(int i=0; i<product.size(); i++) {
									colorflag += "|"+product.get(i).getProductOptionColor()+"|";
								
									if(i==0){
								
							%>
							 	
							 	
							 	<option name="prodcut_color-select" value="<%=product.get(i).getProductOptionColor() %>">
							 		<%=product.get(i).getProductOptionColor() %>
						 		</option>
						 		
						 		
							<%
							
									} else {
										
										
										if( !colorflag.contains(product.get(i).getProductOptionColor())){
									
							
							
							%>
								<option name="prodcut_color-select" value="<%=product.get(i).getProductOptionColor() %>">
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
					
						<select name="product_size-select" id="product_size-select" disabled onchange="fn_sizeselect()"> 
								<option name="prodcut_size-select" value="------ 선택 사항 없음 ------">
							 		------ 선택 사항 없음 ------  
						 		</option>
							
							<% 
							
								for(int i=0; i<product.size(); i++) {
									sizeflag += "|"+product.get(i).getProductOptionSize()+"|";
								
										if(i==0){
								
							%>
							
							
							 	<option name="prodcut_size-select" value="<%=product.get(i).getProductOptionSize() %>">
							 		<%=product.get(i).getProductOptionSize() %>
						 		</option>
						 		
						 		
							<%
							
										} else {
											
											if(!colorflag.contains(product.get(i).getProductOptionSize())){
										
										
							%>
								
							 	<option name="prodcut_size-select" value="<%=product.get(i).getProductOptionSize() %>">
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
					<td>
						<input type="number" id="product_stock" name="product_stock" max="999" min="1" value="0" disabled>
							


						</select>
					</td>
				</tr>
				
					<!-- <td></td> -->
					<!-- <td>stock</td> -->
				
				<tr>
					<!-- <td></td> -->
					<td rowspan="2">
						<div id ="product_list-container">
						
						</div>
						<div id = "product_total-container">
						 
						</div>
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
						<button type="button" id="cart-btn" onclick="fn_cart()";>Cart</button>
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

<input type = "hidden" id = "cartadder" name="cartadder">
	
	
	
	
</main>

<%} %>
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
	
	const fn_cart =()=>{
		
		
		let flag = $("#product_stock").val();
		
		if(flag == 0){
			
			alert('상품을 선택해주세요!')
			
		} else {
			
			//쿠키 순서 품번_카테고리 번호_사이즈_색깔_제품이름_제품가격_제품개수
			
			
			if(confirm('카트에 추가하시겠습니까??')==true){
				let pid = "<%= product.get(0).getProductId()%>";
				let size =$("#product_size-select").val();
				let color= $("#product_color-select").val();
				let pname = "<%=product.get(0).getProductName()%>";
				let price = "<%=product.get(0).getProductPrice()%>";
				let stock = $("#product_stock").val();
				$("#cartadder").val(pid+'_'+pname+'_'+size+'_'+color+'_'+price+'_'+stock);
				/* 카트 */
				
				
				location.assign("<%=request.getContextPath()%>/cart/post?cartlist="+$('#cartadder').val()+"&pid=<%=product.get(0).getProductId()%>&category=<%= product.get(0).getCategoryId()%>");
			}
		}
	}
	
	$("#product_stock").change((e)=>{
		
		
		let total = $("#product_stock").val()*<%=product.get(0).getProductPrice()%>
		$("#product_total-container").html("총 가격 : "+ total+"원");
	})
	
	
	const fn_colorselect=()=>{
		console.log($("#product_color-select").val());
		if($("#product_color-select").val() != '------ 선택 사항 없음 ------'){
			$("#product_size-select").removeAttr("disabled")

		} else {

			$("#product_size-select").attr("disabled","disabled");
			$("#product_size-select").val('------ 선택 사항 없음 ------');

		}
		
	}
	 
	const fn_sizeselect=()=>{
		if($("#product_size-select").val() != '------ 선택 사항 없음 ------'){

			$("#product_stock").removeAttr("disabled");

		} else {

			$("#product_stock").attr("disabled","disabled")
			$("#product_stock").val(1);


		}

	}
	
</script>

<%@ include file ="/views/common/footer.jsp"%>