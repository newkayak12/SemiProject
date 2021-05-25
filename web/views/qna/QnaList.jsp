<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List, com.qna.model.vo.Qna" %>

<%
	String qnaPageBar = (String)request.getAttribute("qnaPageBar");
	List<Qna> list = (List<Qna>)request.getAttribute("list");
%>

<%@ include file="/views/common/header.jsp"%> 

   
	<div id="qna-contianer">
		
		<span class = "Menu-name"> Q & A</span>
		
		<table id="qna-table">
			<thead class="thead-color">
				<th>NO</th>
				<th>IMAGE</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
			</thead>
			
			<%if(list.isEmpty()){ %>
        		<td colspan="6">조회하실 Q&A가 없습니다.</td>
        	<%}
				else{
        		for(Qna q : list){%>
			<tr>
				<td>
					<a href = "<%=request.getContextPath() %>/qna/qnadetail?nSeq=<%=q.getqSeq()%></a>">
						<%=q.getqSeq() %>
					</a> 
				</td>
				
				<td>
					<img src="../images/dummy.jpg" alt="" style="width : 50px; height : 60px;">
				</td>
				
				
				<td class="notice-title">
					<a href = "<%=request.getContextPath() %>/qna/qnadetail?nSeq=<%=q.getqSeq()%></a>">
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
	

	<div>
		<input type="button" value="문의하기" class="notice-btn blue" onclick="qnaPost();">
	</div>
</div>
<script>
	const qnaPost=()=>{
		if(<%= userid != null && checkAdmin.equals("0")%>){
			location.assign("<%=request.getContextPath() %>/post/postStart");	
		}
		else{
			if(confirm("회원에게만 글쓰기 권한이 있습니다.")){
				location.replace("<%=request.getContextPath()%>/views/member/login.jsp");
			}
			else{
				location.replace("<%=request.getContextPath()%>/views/member/login.jsp");
			}
		}
		
	}
</script>



<%@include file="/views/common/footer.jsp"%> 