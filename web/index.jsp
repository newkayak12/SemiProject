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
			
			<div id="review_bestReviewerTable" style="display: flex; align-items: center;">
			
				<div style="padding:auto; margin: auto; width : 1000px; display:flex; justify-content: space-around; background-color: white;" id="reviewmain-table">
					
					<!-- <tr id="reviewmain-table">
						
					<%-- 
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
						</td> --%>
					</tr> -->
					
				</div>
				
			</div>
			
	</div>
		
	
	
	
	
	<div id="todayspick">
		
		<p class="section_title">Today's pick</p>
		
		<div id="slideshow" style="display: flex; justify-content: space-around !important; margin: 0px; padding:0px; width:1300px">
		
			<div id="video">
			
			
				<!-- <button id="btn_prev">&lang;</button> -->
			
				<!-- <img src="<%=request.getContextPath()%>/images/slideshow_img1.jpg" width="400px" height="300px">
			
				<div id="disc" style="display:inline-block;"> 상품설명 블라블라블라 어쩌구저쩌구 샬랴샬랴 </div>
				
				<button id="btn_next">&rang;</button> -->


		

					
						<iframe width="560" height="315" src="https://www.youtube.com/embed/ZvE_j5psy6Y" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
					

			</div>
			
			
			<div id="slideshowcontent" style="width:520px; display: flex; text-align: center; align-items: center;">
				Breezy fabrics. Bright hues. Statement silhouettes. Embrace the warmer weather in styles you can’t help feeling optimistic in. 
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

		/* 
		
review  
		
		
		
		
/* productId: "9"
productName: "랩 탑"
productOptionColor: "gray"
productOptionSize: "M"
reviewCount: "7" 
reviewFile: "reviewFileName2"
reviewNo: "28"
userId: "qwerty2"
		
		
		*/
		let container_review = $("#reviewmain-table");
		$.ajax({
			url:"<%=request.getContextPath()%>/main/review/list/ajax",
			success:data2 =>{
				
					for(let i=0; i<data2.length; i++){
						console.log(data2[i]["reviewNo"])
						let reviewno = data2[i]["reviewNo"]
						
						
						
						
						
						
									container_review.append($("<div>").css({"text-align":"center"}).append($("<a>").attr({
										"href": "<%=request.getContextPath()%>/review/detail?no="+reviewno,
										"width":"300px",
										"height":"500px",
										"margin":"0px",
										"padding":"0px"
												
									}).css({"text-decoration":"none","color":"black"})
									.append($("<p>").html(i+1+"위").css("text-align","center")).append( $("<img>").attr({"src":"<%=request.getContextPath()%>/upload/review/"+data2[i]["reviewFile"],"width":"250px","height":"350px"})).append($("<div>").append($("<span>").html(data2[i]["productName"])).append($("<span>").html(data2[i]["productPrice"])))              )
									
									)
											
											
											
											
						// let cotents2 =	$("td").css({"text-align":"center"})
						
						// 			content2.append($("<p>").html(i+1+"위").css("text-align","center"))
						// 			content2.append( $("<img>").attr({"src":"<%=request.getContextPath()%>/upload/review/"+data2[i]["reviewFile"],"width":"200px","height":"200px"}))
						// 			content2.append($("<div>").append($("<span>").html(data2[i]["productName"])).append($("<span>").html(data2[i]["productPrice"])))
						// 			console.log(contents2);
									
					}




			}
		
		});
		
/* 상품 ajax */		
		
		$.ajax({
			url: "<%=request.getContextPath()%>/main/product/list/ajax",
			success:data=>{
				$("#contents_imgs").html("");
				// let contentimg= $("#contents_imgs")
				let container = $("#contents_imgs");
				

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
							"height" : "250px"
							}).css({
								"display":"flex",
								"flex-direction":"column",
								"justify-content":"center",
								"margin":"0px",
								"padding":"0px",
								"box-sizing":"border-box",
							    "align-items": "center",
							    "text-decoration":"none",
							    "color":"black"
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
								"height" : "250px"
								}).css({
									"display":"flex",
									"flex-direction":"column",
									"justify-content":"center",
									"margin":"0px",
									"padding":"0px",
									"box-sizing":"border-box",
									"align-items": "center",
									"text-decoration":"none",
									"color":"black"
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
							"height" : "250px"
							}).css({
								"display":"flex",
								"flex-direction":"column",
								"justify-content":"center",
								"margin":"0px",
								"padding":"0px",
								"box-sizing":"border-box",
								"align-items": "center",
								"text-decoration":"none",
								"color":"black"
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
							"height" : "250px"
							}).css({
								"display":"flex",
								"flex-direction":"column",
								"justify-content":"center",
								"margin":"0px",
								"padding":"0px",
								"box-sizing":"border-box",
								"align-itmes":"center",
								"text-decoration":"none",
								"color":"black"
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
		
		
		
	})


</script> 

<%@ include file = "/views/common/footer.jsp"%>