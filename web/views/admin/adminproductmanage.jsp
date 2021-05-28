<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "/views/common/header.jsp"%>

<main>

	<ul class="text_align_center">
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/admin/product/manage">상품 관리</a></li>
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/admin/reviewManage">리뷰 관리</a></li>
		<li class="hrz_li"><a href="">Q&A 관리</a></li>
		<li class="hrz_li"><a href="">주문 관리</a></li>
		<li class="hrz_li"><a href="<%=request.getContextPath()%>/admin/userselect/start">회원 관리</a></li>
	</ul>


	<div id = "productmanage-container" style="margin-top: 50px;">
	
		<p style="text-align: center;" class="section_title margin_50">상품 관리</p>

		
		<div id ="productaddbtn-container" style="display: flex; justify-content: flex-end;">
			<input type = "button" value="상품 등록" id="productadd" >
		</div>
	
	
	
		<div>
		
			<table id="products_admin_list" style="display: flex; justify-content: center">
			
				<tr>
					<th>상품 번호</th>
					<th>카테고리 이름</th>
					<th>상품명</th>
					<th>가격</th>
					<th>대표 사진</th>
				</tr>
				
			</table>
			
		</div>	
		
		
	</div>
	
	
</main>

<script>

	$("#productadd").click(()=>{
		
		 window.open("<%=request.getContextPath()%>/product/post/admin","product","width=500,height=600");
		
		 fn_list();
	})


	
	const fn_list = () =>{
		
		$.ajax({
			
			url:"<%=request.getContextPath()%>/product/list/admin",
			
			success: data =>{
				//상품번호 //카테고리 // 상품명 // 대표사진 //색상 // 사이즈 // 재고
				

	//cId: "c04"
	//color: "black"
	//pDetail: "12"
	//pExplain: "청키 레더 앵클 첼시 부츠 <br><br>\n스테이트먼트 스타일의 앵클 부츠입니다. 부드러운 가죽 소재로 만들어졌으며, 청키한 고무 밑창이 대조적인 느낌을 줍니다.\n@\n- 라운드 토\n- 앞면 풀 탭\n- 신축성 있는 골지 패널\n- 청키한 고무 밑창\n\n100% 가죽 / 안감: 100% 가죽 / 밑창: 100% 써모플라스틱 러버\n\n힐: 3.7cm\n"
	//pFile: "product_20213922_03_3937572_828574.jpg"
	//pFiledetail1: "product_20213922_03_3937572_828575.jpg"
	//pFiledetail2: "product_20213922_03_3937572_828576.jpg"
	//pId: "4"
	//pName: "청키 레더 앵클 첼시 부츠"
	//pPrice: "335000"
	//size: "240cm"
	//stock: 54 
		
				for(let i=0; i<data.length; i++){
					
					let tr = $("<tr>");
					tr.append($("<td>").append(data[i]["pId"])).css({"border":"1px black solid", "border-collapse":"collapse"})
					tr.append($("<td>").append(data[i]["cId"])).css({"border":"1px black solid", "border-collapse":"collapse"})
					tr.append($("<td>").append($("<a>").html(data[i]["pName"]).attr("onclick","window.open('<%=request.getContextPath()%>/admin/product/detail','product detail','width=500,height=600')")    )).css({"border":"1px black solid", "border-collapse":"collapse"})
					tr.append($("<td>").append(data[i]["pPrice"])).css({"border":"1px black solid", "border-collapse":"collapse"})
					tr.append($("<td>").append($("<img>").attr("src","<%=request.getContextPath()%>/upload/product/"+data[i]["pFile"]).css({"width":"100px"}))).css({"border":"1px black solid", "border-collapse":"collapse"})
					
					$("#products_admin_list").append(tr);
					
				}
				
			}
		})
		
		
	}	
	
	$(function(){	
		
		 fn_list(); 
	})
	
</script>

<%@ include file = "/views/common/footer.jsp"%>