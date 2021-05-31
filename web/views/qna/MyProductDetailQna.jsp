<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="java.util.List, com.productqna.model.vo.ProductQna" %>

<%
	String MyProductDetailQnaPageBar = (String)request.getAttribute("MyProductDetailQnaPageBar");
	List<ProductQna> list = (List<ProductQna>)request.getAttribute("list");
	
%>
 
 <div id = "Product-QNA">
		
		<span id = "Product-Qna-section" class="Qna-category" style="cursor : pointer; left: 270px;">상품 Q&A</span>
		
		<!-- 여기에 Ajax로 상품 Q&A 뜰 거임. -->
		<table id="MyProductqna-table">
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
			        		for(ProductQna pq : list){%>
						<tr>
							<td>
								<%=pq.getQnaProductSeq() %> 
							</td>
												
							<td id ="MyProductqna-detail-title" class="notice-title" style="cursor : pointer;">
								<%=pq.getQnaTitle() %>
							</td>
							
							<td>
								<%=pq.getQnaUserId()%>
							</td>
							
							<td>
								<%=pq.getQnaDate() %>
							</td>
							
						</tr>
						<%}
			            }%>
			
					</table>
				
		
		<div>
			<%=MyProductDetailQnaPageBar %>
		</div> 
			
	
	</div>
	
	<script>
	 $("#MyProductqna-detail-title").click(function(){
		 location.assign("<%=request.getContextPath()%>/qna/MyProDetailQnaDetailStartServlet?qSeq=<%=list.get(0).getQnaProductSeq()%>")
		 
	 })
	</script>
	
	
		
		