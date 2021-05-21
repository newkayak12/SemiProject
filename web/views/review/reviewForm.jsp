<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.review.model.vo.Review"%>    
    
<%@ include file = "/views/common/header.jsp"%>

<%
	
	String orderNo= null;
	//orderlist.jsp에서 글쓰기 버튼을 눌렀을 때 가져오는 값
	String order_no = (String)request.getParameter("orderNo");

	if(orderNo != null) {
		orderNo = order_no;
	} else{
		orderNo = "";
	}
%>


<main id="reviewForm_main">

	<div id="reviewForm-container" >
	
		<h1>REVIEW</h1>
	
		<form action="<%=request.getContextPath()%>/review/post/end" method="post" enctype="multipart/form-data">
		
			<table>
				<tr>
					<th>상품선택</th>
					<td>
						<img src="<%=request.getContextPath() %>/images/noimage.jpg" name="" id="" width="100px" height="100px">
						<button onclick="fn_selectProduct();">상품선택</button>
					</td>
					<%-- <td>
						<img src="<%=request.getContextPath() %>/images/pants1.jpg" name="" id="" width="100px" height="100px">
						<span>상품이름</span><span>색상/사이즈</span>
					</td> --%>
				</tr>
			
			
				<tr>
					<th>제&nbsp;&nbsp;&nbsp;목</th>
					<td><input type="text" name="reviewTitle" id="reviewTitle" size="95" required></td>
				</tr>
				
				<tr>
					<th>작성자</th>
					<%-- value에 <%=loginMember.getMemberId()%> --%>
					<td><input type="text" name="reviewWriter" id="reviewWriter" value="<%=userid %>" readonly required size="95"></td>
				</tr>
				
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="up_file"></td>
				</tr>
				
				<tr>
					<th>내&nbsp;&nbsp;&nbsp;용</th>
					<td><textarea rows="25" cols="80" name="reviewContent" required></textarea></td>
				</tr>
				
				<tr>
					<th colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</th>
				</tr>
			</table>
			
		</form>
		
	</div>
	
</main>

<script>
	const fn_selectProduct = () => {
		
		/* 테스트용 alert("함수실행"); */
		
		const url = "<%=request.getContextPath()%>/selectReviewProduct?orderNo=<%=orderNo%>";
		const title = "selectReviewProduct";
		const status = "left=500px, top=100px, width=300px, height=300px";
		
		window.open("", title, status); 
		
	}
</script>

<%@ include file = "/views/common/footer.jsp"%>