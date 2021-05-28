<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/views/common/header.jsp" %>

<%@ page import="com.product.model.vo.Product, com.review.model.vo.Review" %>
<%@ page import="java.util.List" %>

<%

	Object o = request.getAttribute("productlist");
	List<Product> product = null;
	String colorflag ="";
	String sizeflag = "";
	
		if(o !=null){
			product = (List<Product>) o;				
		}
		
	List<Review> reviewList = (List<Review>)request.getAttribute("reviewlist");

%>

<%if(product !=null){ %>

	<main id="productdetail-main">
	
		<div id="productcontent-container">
		
		
		
		
		
		
			<div id="product_table-container"> 
			
<!-- 상품 상세 선택 테이블 -->	<table id="product-table">
							
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
													System.out.println(colorflag);
													if(i==0){
													colorflag += "|"+product.get(i).getProductOptionColor()+"|";
											%>
											 	
											 	
											 	<option name="prodcut_color-select" value="<%=product.get(i).getProductOptionColor() %>">
											 		<%=product.get(i).getProductOptionColor() %>
										 		</option>
										 		
										 		
											<%
													} else {
														
														
															System.out.println( "scan" + product.get(i).getProductOptionColor());
														if( !colorflag.contains(product.get(i).getProductOptionColor())){
															colorflag += "|"+product.get(i).getProductOptionColor()+"|";
											%>
											
												<option name="prodcut_color-select" value="<%=product.get(i).getProductOptionColor() %>">
											 		<%=product.get(i).getProductOptionColor() %>
										 		</option>
											
											<%	}
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
												
														if(i==0){
													sizeflag += "|"+product.get(i).getProductOptionSize()+"|";
											%>
											
											
											 	<option name="prodcut_size-select" value="<%=product.get(i).getProductOptionSize() %>">
											 		<%=product.get(i).getProductOptionSize() %>
										 		</option>
										 		
										 		
											<%
											
														} else {
															
															if(!sizeflag.contains(product.get(i).getProductOptionSize())){
																sizeflag += "|"+product.get(i).getProductOptionSize()+"|";
														
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
							
			
<!-- 상품 상세 선택 테이블 -->	</table>
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
								/* System.out.println(b); */
							%>
							
							<%=	c %>
							
							<%= b %>
						</div>				
						<div>
							<img alt="사진1" src="<%=request.getContextPath()%>/upload/product/<%=product.get(0).getProductFileDetail1()%>" width="500px">
							
							<img alt="사진2" src="<%=request.getContextPath()%>/upload/product/<%=product.get(0).getProductFileDetail2()%>" width="500px">
						</div>
					</div>
	
					<div id="menu_content-notice">
						<table>
							<tr>
								<td>
									배송 안내
								</td>
							</tr>
							
							<tr>
								<td>
									* 주문 후 배송준비기간은 2-7일이 소요됩니다.(주말 및 휴일 제외)<br> 
									간혹 더 지연되는 경우도 있기에 넉넉히 주문 부탁드립니다.<br> <br> 
									
									* 제주도 (편도 5500원), 산간지역의 경우 지역배송비가 추가될 수 있습니다.<br><br>  
									
									** 자세한 사항은 NOTICE의 구매전 필독에서 확인 부탁드립니다 :-) !<br> 
								</td>
							</tr>
							
							<tr>
								<td>
									교환 및 반품 안내
								</td>
							</tr>
							
							<tr>
								<td>
									교환 및 반품안내
									* 교환 또는 반품을 원하시는 고객님께서는,<br>
									택배를 받으신 후 7일이내로 Q&A게시판 또는 고객센터 통해 교환,환불신청을 접수 후<br>
									반품 시 동봉되어있는 양식서 작성 후 제품과 함께 보내주세요 !<br><br>
									
									-대한통운 이용 시<br>
									고객님께서 직접 대한통운 (1588-1255) 전화 연결 혹은 인터넷 접수를 통하여 반품 접수(운임 신용) 해주세요 !<br>
									접수 후 2-3일 이내 기사님께서 고객님께 연락 후 방문해주셔서 상품 회수를 진행합니다.<br><br>
									
									- 타 택배 이용 시<br>
									직접 타 택배사 방문, 접수하여 보내주시면 됩니다<br>
									바온과 계약되어있는 택배회사가 아니기때문에 배송비 선불 결제 후 보내주셔야 합니다 !<br>
									(타 택배 이용시 반품주소 :  서울특별시 강남구 테헤란로14길 6 남도빌딩 4층 402호 diekleidung / 02-1234-5678)<br>
									잘못된 주소지로 작성해주실 경우 반송될 수 있습니다  :(<br><br>
									
									* 자세한 사항은 NOTICE의 교환 & 환불 안내에서 확인 부탁드립니다 :-) !
								</td>
							</tr>
						</table>
					</div>
					
					
					
					<div id="menu_content-review">
						
						<div id="p_review_reviewListContainer">
						
							<p class="section_title">Review</p>
							
							
							<% if(reviewList != null && reviewList.size() != 0) { %>
							
								<table id="p_reviewTable">
										
									<% for(Review r : reviewList) { %>
									
										<!-- 리뷰 삭제여부 컬럼 : r_delete,  1 : 삭제안함 (디폴트), 0 : 삭제함 -->
										<% if(r.getReviewDelete().equals("1")) { %>
												
											<tr>
												<!-- 상품이미지 -->
												<td width="200px" style="padding:20px;">
				
													<a href="<%=request.getContextPath() %>/product/detail?pid=<%=r.getProductId()%>&category=<%=r.getCategoryId()%>"><img src="<%=request.getContextPath() %>/upload/product/<%=r.getProductFile() %>" width="150px" height="200px"></a>
				
												</td>
												
												<!-- 작성자아이디, 상품이름, 리뷰제목 -->
												<td width="500px" style="padding:20px;">
													<a class="blackText" href="<%=request.getContextPath()%>/review/detail?no=<%=r.getReviewNo()%>">
														<p class="bolderText"><%=r.getProductName() %></p>
														<p><%=r.getReviewTitle() %></p>
														<p><%=r.getUserId() %>님</p>
													</a>
												</td>
												
												<!-- 리뷰이미지 -->
												<td width="200px" style="padding:20px;">
													<a href="<%=request.getContextPath()%>/review/detail?no=<%=r.getReviewNo()%>"><img src="<%=request.getContextPath() %>/upload/review/<%=r.getReviewFile()%>" width="150px" height="200px"></a>
												</td>
											
											</tr>
											
										<% } %>
												
									<% } %>
									
								</table>
									
							<% } else { %>
								
								<p>리뷰가 없습니다</p>
								
							<% } %>
							
								<button onclick="location.assign('<%=request.getContextPath()%>/review/list')">리뷰게시판으로 가기</button>
							
						</div>
						
					</div> <!-- div id=menu_content-review -->
					
					
					<div id="menu_content-qna">
						
						<table id="qna-table">
							<!-- <tr>
								<th>작성자</th>
								<th>글 제목</th>
								<th>작성일</th>
								
							</tr> -->
							
						</table>
						
						
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
		
		let tables = $("#qna-table");
		$.ajax({
			url:"<%=request.getContextPath()%>/product/qna/ajax",
			data:{"cid":"<%=product.get(0).getCategoryId()%>","pid":"<%=product.get(0).getProductId()%>"},
			success: data =>{
				tables.html("");
				tables.append($("<tr>").append($("<th>").html('작성자')).append($("<th>").html('글 제목')).append($("<th>").html('작성일')))
				
					


		
				console.log(data)
				for(let i =0 ; i<data.length; i++){
					
					console.log(data[i]["qnaProductSeq"])
					tables.append($("<tr>").append($("<td>").css("text-align","center").html(data[i]["qnaUserId"]))
						.append($("<td>").css("text-align","center").html(data[i]["qnaTitle"]).attr("onclick",'fn_detailshow('+data[i]["qnaProductSeq"]+',"'+data[i]["qnaUserId"]+'")'))
						.append($("<td>").css("text-align","center").html(data[i]["qnaDate"])))
					
				}
				
			}
			
		})
		 
		
		
		
	})
	
	
	const fn_detailshow=(e,f)=>{
		let info = e;
		let id = f;
		
		console.log(e)
		console.log(f)
		
		
		window.open("<%=request.getContextPath()%>/qna/product/detail?qseq="+info+"&writer="+id ,'qna','width=500, height=600');
		
	}
	
	
	const fn_buynow=()=>{
		
	let flag = $("#product_stock").val();
	
		if(<%=userid!=null%>){
			
				if(flag == 0){
					
					alert('상품을 선택해주세요!')
					
				}else{
					
				let pname = "<%=product.get(0).getProductName() %>";
				let pid = "<%= product.get(0).getProductId()%>";
				let size =$("#product_size-select").val();
				let color= $("#product_color-select").val();
				<%-- let pname = "<%=product.get(0).getProductName()%>"; --%>
				let price = "<%=product.get(0).getProductPrice()%>";
				let stock = $("#product_stock").val();
				let category = "<%= product.get(0).getCategoryId()%>";
				
				location.assign("<%=request.getContextPath()%>/order/place/page/start?pid="+pid+"&size="+size+"&color="+color+"&price="+price+"&stock="+stock+"&category="+category+"&flag=page&pname"+pname);
				
				}	
			
		} else {
			
			alert('로그인이 필요한 서비스입니다.')
			
		}
	
	} 
	

	const fn_cart =()=>{

		
	
		
		 console.log("<%= product.get(0).getCategoryId()%>");
		
		let flag = $("#product_stock").val();
	
		if(<%=userid!= null%>){
		
					if(flag == 0){
						
						alert('상품을 선택해주세요!')
						
					} else {
						
						//쿠키 순서 품번_카테고리 번호_사이즈_색깔_제품이름_제품가격_제품개수
						
						
						if(confirm('카트에 추가하시겠습니까??')==true){
							let pid = "<%= product.get(0).getProductId()%>";
							let size =$("#product_size-select").val();
							let color= $("#product_color-select").val();
							<%-- let pname = "<%=product.get(0).getProductName()%>"; --%>
							let price = "<%=product.get(0).getProductPrice()%>";
							let stock = $("#product_stock").val();
							let category = "<%= product.get(0).getCategoryId()%>";
							$("#cartadder").val(pid+'@'+size+'@'+color+'@'+price+'@'+stock+'@'+category);
							
							/* alert($("#cartadder").val()+"카트 저장하기") */
							/* 카트 */
							
							
							location.assign("<%=request.getContextPath()%>/cart/post?cartlist="+$('#cartadder').val()+"&pid=<%=product.get(0).getProductId()%>&category=<%= product.get(0).getCategoryId()%>");
						}
					}
		
		
		} else {
			 alert('로그인이 필요한 서비스입니다.')
			
		}
	}
	
	$("#product_stock").change((e)=>{
		$("#product_total-container").html("") 
		let size = $("#product_size-select").val()
		let color = $("#product_color-select").val()
		let total = $("#product_stock").val()*<%=product.get(0).getProductPrice()%>
		$("#product_total-container").append($("<p>").html("사이즈 :"+size)).append($("<p>").html("색상 :" +color)).append($("<p>").html("총 가격 :" +total))
		
		/* result.html(size <br>)
		
		<br>color<br>total); */
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