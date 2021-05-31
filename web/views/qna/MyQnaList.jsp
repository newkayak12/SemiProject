<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.util.List, com.qna.model.vo.Qna" %>

<%
	String qnaPageBar = (String)request.getAttribute("qnaPageBar");
	String MyProductDetailQnaPageBar = (String)request.getAttribute("MyProductDetailQnaPageBar");
	List<Qna> list = (List<Qna>)request.getAttribute("list");
	
%>


<%@ include file ="/views/common/header.jsp" %>

<div id = "myQnaList-container">
	<span>나의 게시글 관리</span>
	
	
	
	
	
	<!-- 일반 Q&A : Q&A 게시판에서 직접 작성 -->
	<div id = "General-QNA">
		<span class="Qna-category">일반 Q&A</span>
		
			<table id="Myqna-table">
				<thead class="thead-color-grey">
					<th>NO</th>
					<th>TITLE</th>
					<th>WRITER</th>
					<th>DATE</th>
				</thead>
				
				<%if(list.isEmpty()){ %>
	        		<td colspan="5">조회하실 Q&A가 없습니다.</td>
	        	<%}
					else{
	        		for(Qna q : list){%>
				<tr>
					<td>
						<%=q.getqSeq() %> 
					</td>
										
					<td class="notice-title">
						<a href = "<%=request.getContextPath() %>/qna/qnadetail?qSeq=<%=q.getqSeq()%>">
							<%=q.getqTitle() %>
						</a>
					</td>
					
					<td>
						<%=q.getUserId() %>
					</td>
					
					<td>
						<%=q.getqDate() %>
					</td>
					
				</tr>
				<%}
	            }%>
	
			</table>
		
		
		<div>
			<%=qnaPageBar %>
		</div> 
	

		<div class = "Qna-Post">
			<input type="button" value="문의하기" class="notice-btn black-btn" onclick="qnaPost2();">
		</div>
		
	</div>
	
	
	
	
	
	<!-- 상품 Q&A : 상품 detail Q&A 에서 작성 -->
	<div id = "Product-QNA">
		
		<span id = "Product-Qna-section" class="Qna-category" style="color : white;">상품 Q&A</span>
		
		<!-- 여기에 Ajax로 상품 Q&A 뜰 거임. -->
	
	</div> 
	
	
	
	
	<!-- 내가 쓴 리뷰 보여주기 -->
	<div id ="My-Review" >
		<span id = "My-Review-section" class="Qna-category" style="color : white;">Review</span>
	
	</div>
	
	
	
	
	<script>
		// 이 jsp들어오자마자 상품 Q&A 화면에 뜨게 하기 
		$(document).ready(function(){
			$("#Product-Qna-section").bind("click", function(){
				
				$.ajax({
					url:"<%=request.getContextPath()%>/qna/MyProductDetailQna",
					type : "get", 
					dataType : "html", 
					success : data=>{
						console.log(data);
						$("#Product-QNA").html(data);
					}
				})

			})
			
			$("#Product-Qna-section").trigger("click");
			
		});
		
		
		// 이 jsp 들어오자마자 내 Review 화면 뜨게 하기 
		
		$(document).ready(function(){
			$("#My-Review-section").bind("click", function(){
				
				$.ajax({
					url:"<%=request.getContextPath()%>/review/MyReviewList",
					type : "get", 
					dataType : "html", 
					success : data=>{
						console.log(data);
						$("#My-Review").html(data);
					}
				})

			})
			
			$("#My-Review-section").trigger("click");
			
		});
		
		
		// 일반 Q&A
		const qnaPost2=()=>{
			if(<%= userid != null && checkAdmin.equals("0")%>){
				location.assign("<%=request.getContextPath() %>/qna/qnaPostStart");	
			}
			else{
				if(confirm("일반회원에게만 글쓰기 권한이 있습니다.")){
					location.replace("<%=request.getContextPath()%>/views/member/login.jsp");
				}
				else{
					location.replace("<%=request.getContextPath()%>/views/member/login.jsp");
				}
			}
			
		}
		

	</script>
	
</div>


<%@include file="/views/common/footer.jsp"%>