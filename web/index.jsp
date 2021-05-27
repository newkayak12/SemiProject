<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.product.model.vo.Product, java.util.List" %>
<%@ include file = "/views/common/header.jsp"%>
<%
	List<Product> products = (List<Product>)request.getAttribute("products");
%>

<main id="mainPage-main">

	
	<div id="main_bestReviewerContainer">
		
		<p class="section_title">Best Reviewer</p>
			
			<div id="review_bestReviewerTable">
			
				<table style="margin-left: auto; margin-right: auto; width : 1000px;">
					
					<tr id="reviewmain-table">
						<td>
							<p class="whiteBolderText">1</p>
							<img src="<%=request.getContextPath() %>/images/dummy.jpg" width="250px" height="350px">
							<p class="orangeText">상품이름</p>
							<p class="whiteText">price : 가격</p>
						</td>
						
						<%-- <td>
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
						</td> --%>
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
			<span id="popularity">인기순</span>
			<span id="highest">높은가격순</span>
			<span id="lowest">낮은가격순</span>
		<div>
		
		<div id="contents_imgs">
		
		
			<!--
			<div class="img">img1</div>
			<div class="img">img2</div>
			<div class="img">img3</div>
			<div class="img">img4</div>
			<div class="img">img5</div>
			<div class="img">img6</div>
			<div class="img">img7</div>
			<div class="img">img8</div>
			<div class="img">img9</div> 
			-->
			
		</div>

	</div>
	
	
	
	
	
	
	

</main>

<script>
	$(function(){
		
		$.ajax({
			url: "<%=request.getContextPath()%>/main/product/list/ajax",
			success:data=>{
				$("#contents_imgs").html("");
				// let contentimg= $("#contents_imgs")
				let container = $("#contents_imgs");
				console.log(data);

				let divtag = $("<div>").css({
					"display":"flex",
					"justify-content":"center",
					"margin":"0px",
					"padding":"0px",
					"box-sizing":"border-box"

				})

				let atag = $("<a>");
				let imgtag = $("<img>");
				let spantag = $("<span>");

				for(let i=0; i<data.length; i++){
					let content = data[i];
					let productid = data[i]["productId"];
					let categoryid = data[i]["categoryId"];
					let productname = data[i]["productName"];
					let productPrice = data[i]["productPrice"];
					let productFile = data[i]["productFile"];


					console.log(productFile);
					$("#contents_imgs").append( $("<div>").css({
						"display":"flex",
						"justify-content":"center",
						"margin":"0px",
						"padding":"0px",
						"box-sizing":"border-box",
						"align-itmes":"center"
					}).append($("<a>").attr({
							"href":"<%=request.getContextPath()%>/product/detail?pid="+productid+"&category="+categoryid,
							"margin":"0px",
							"padding" :"0px",
							"width" : "230px",
							"height" : "250px",
							"text-decoration":"none",
							"color":"black"
							}).css({
								"display":"flex",
								"flex-direction":"column",
								"justify-content":"center",
								"margin":"0px",
								"padding":"0px",
								"box-sizing":"border-box",
							    "align-items": "center"
							}).append($("<img>").attr({"src":"<%=request.getContextPath()%>/upload/product/"+productFile,
					"width":"200px"
					})).append($("<div>").css({
						"display":"flex",
						"justify-content":"center",
						"align-items": "center"
					}).append($("<span>").html(productname)).append($("<span>").html(productPrice)))
					
					
					));
				}


			}
		})
	
	})
	
	
	$("#highest").click(()=>{
		
		
			$.ajax({
				url: "<%=request.getContextPath()%>/main/product/list/ajax?sort=high",
				success:data=>{
					$("#contents_imgs").html("");
					// let contentimg= $("#contents_imgs")
					let container = $("#contents_imgs");
					console.log(data);

					let divtag = $("<div>").css({
						"display":"flex",
						"justify-content":"center",
						"margin":"0px",
						"padding":"0px",
						"box-sizing":"border-box"

					})

					let atag = $("<a>");
					let imgtag = $("<img>");
					let spantag = $("<span>");

					for(let i=0; i<data.length; i++){
						let content = data[i];
						let productid = data[i]["productId"];
						let categoryid = data[i]["categoryId"];
						let productname = data[i]["productName"];
						let productPrice = data[i]["productPrice"];
						let productFile = data[i]["productFile"];


						console.log(productFile);
						$("#contents_imgs").append( $("<div>").css({
							"display":"flex",
							"justify-content":"center",
							"margin":"0px",
							"padding":"0px",
							"box-sizing":"border-box",
							"align-itmes":"center"
						}).append($("<a>").attr({
								"href":"<%=request.getContextPath()%>/product/detail?pid="+productid+"&category="+categoryid,
								"margin":"0px",
								"padding" :"0px",
								"width" : "230px",
								"height" : "250px",
								"text-decoration":"none",
								"color":"black"
								}).css({
									"display":"flex",
									"flex-direction":"column",
									"justify-content":"center",
									"margin":"0px",
									"padding":"0px",
									"box-sizing":"border-box",
									"align-items": "center"
								}).append($("<img>").attr({"src":"<%=request.getContextPath()%>/upload/product/"+productFile,
						"width":"200px"
						})).append($("<div>").css({
							"display":"flex",
							"justify-content":"center",
							"align-items": "center"
						}).append($("<span>").html(productname)).append($("<span>").html(productPrice)))
						
						
						));
					}


				}
			})
			
			
			
			
			
			
	})
	
	$("#popularity").click(()=>{
		
		$.ajax({
			url: "<%=request.getContextPath()%>/main/product/list/ajax",
			success:data=>{
				$("#contents_imgs").html("");
				// let contentimg= $("#contents_imgs")
				let container = $("#contents_imgs");
				console.log(data);

				let divtag = $("<div>").css({
					"display":"flex",
					"justify-content":"center",
					"margin":"0px",
					"padding":"0px",
					"box-sizing":"border-box"

				})

				let atag = $("<a>");
				let imgtag = $("<img>");
				let spantag = $("<span>");

				for(let i=0; i<data.length; i++){
					let content = data[i];
					let productid = data[i]["productId"];
					let categoryid = data[i]["categoryId"];
					let productname = data[i]["productName"];
					let productPrice = data[i]["productPrice"];
					let productFile = data[i]["productFile"];


					console.log(productFile);
					$("#contents_imgs").append( $("<div>").css({
						"display":"flex",
						"justify-content":"center",
						"margin":"0px",
						"padding":"0px",
						"box-sizing":"border-box",
						"align-itmes":"center"
					}).append($("<a>").attr({
							"href":"<%=request.getContextPath()%>/product/detail?pid="+productid+"&category="+categoryid,
							"margin":"0px",
							"padding" :"0px",
							"width" : "230px",
							"height" : "250px",
							"text-decoration":"none",
							"color":"black"
							}).css({
								"display":"flex",
								"flex-direction":"column",
								"justify-content":"center",
								"margin":"0px",
								"padding":"0px",
								"box-sizing":"border-box",
								"align-items": "center"
							}).append($("<img>").attr({"src":"<%=request.getContextPath()%>/upload/product/"+productFile,
					"width":"200px"
					})).append($("<div>").css({
						"display":"flex",
						"justify-content":"center",
						"align-items": "center"
						
					}).append($("<span>").html(productname)).append($("<span>").html(productPrice)))
					
					
					));
				}


			}
		})
		
		
		
		
		
	})
	
	
	
	$("#lowest").click(()=>{
	
		
		$.ajax({
			url: "<%=request.getContextPath()%>/main/product/list/ajax?sort=low",
			success:data=>{
				$("#contents_imgs").html("");
				// let contentimg= $("#contents_imgs")
				let container = $("#contents_imgs");
				console.log(data);

				let divtag = $("<div>").css({
					"display":"flex",
					"justify-content":"center",
					"margin":"0px",
					"padding":"0px",
					"box-sizing":"border-box"

				})

				let atag = $("<a>");
				let imgtag = $("<img>");
				let spantag = $("<span>");

				for(let i=0; i<data.length; i++){
					let content = data[i];
					let productid = data[i]["productId"];
					let categoryid = data[i]["categoryId"];
					let productname = data[i]["productName"];
					let productPrice = data[i]["productPrice"];
					let productFile = data[i]["productFile"];


					console.log(productFile);
					$("#contents_imgs").append( $("<div>").css({
						"display":"flex",
						"justify-content":"center",
						"margin":"0px",
						"padding":"0px",
						"box-sizing":"border-box",
						"align-itmes":"center"
					}).append($("<a>").attr({
							"href":"<%=request.getContextPath()%>/product/detail?pid="+productid+"&category="+categoryid,
							"margin":"0px",
							"padding" :"0px",
							"width" : "230px",
							"height" : "250px",
							"text-decoration":"none",
							"color":"black"
							}).css({
								"display":"flex",
								"flex-direction":"column",
								"justify-content":"center",
								"margin":"0px",
								"padding":"0px",
								"box-sizing":"border-box",
								"align-itmes":"center"
							}).append($("<img>").attr({"src":"<%=request.getContextPath()%>/upload/product/"+productFile,
					"width":"200px"
					})).append($("<div>").css({
						"display":"flex",
						"justify-content":"center",
						"align-items": "center"
					}).append($("<span>").html(productname)).append($("<span>").html(productPrice)))
					
					
					));
				}


			}
		})
		
		/* $("#reviewmain-table"). */
		
		
/* 
categoryId: "c04"
productExplain: "오픈 토 레더 힐 <br><br>\n모든 시즌에 잘 어울리는 광택있는 스타일의 힐입니다. 가죽 소재로 만들어졌으며, 오픈 스퀘어 토로 이루어져 있습니다. 특별한 행사나 저녁 모임에 활용하기 좋습니다.\n@\n- 오픈 스퀘어 토\n- 폭신한 안창\n- 발목의 가죽 끈, 내부의 커버드 엘라스틱\n- 가죽으로 감싼 굽\n\n100% 염소 가죽 / 안감: 100% 염소 가죽 / 밑창: 100% 가죽\n\n힐: 8.5cm\n"
productFile: "product_20213922_03_3937572_828571.jpg"
productFileDetail1: "product_20213922_03_3937572_828572.jpg"
productFileDetail2: "product_20213922_03_3937572_828573.jpg"
productId: 3
productName: "오픈 토 레더 힐"
productPrice: "250000"
productStock: 0
productViewCount: 0 
*/
		let tr = $("#reviewmain-table");
		$.ajax({
			url:"<%=request.getContextPath()%>/main/review/list/ajax",
			success:data=>{
				
				for(let i=0; i<data.length; i++){
					let content = data[i];
					
					tr.append().css({
						"display":"flex",
						"justify-content":"center",
						"align-itmes":"center"

					})
					
					
					

				}
				
			}
			
		})
		
		
	
		
		
		
	})
</script> 

<%@ include file = "/views/common/footer.jsp"%>
