<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "com.productqna.model.vo.ProductQna" %>
<%@ page import = "com.users.model.vo.Users" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>COMMENT</title>
<script src ="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

<%

 Object o = request.getAttribute("result");
 List<ProductQna> result = new ArrayList();	
		if(o!=null){
			
			result = (List<ProductQna>) o;
			
		}
		
 Object j  = request.getSession().getAttribute("user");
 Users user = null;
 
 		if(j!=null){
 			user = (Users) j;
 			
 		}
 		
 		
 		System.out.println(result.get(0).getQnaProductSeq());

%>



</head>
<body>
	<table>
		<tr>
			<th width="160px">글 제목</th>
			<td colspan="3" width="160px"><%=result.get(0).getQnaTitle() %></td>
			
		</tr>
		<tr>
			<th width="75px">작성자</th>
			<td width="75px"><%=result.get(0).getQnaUserId() %></td>
			<th width="85px">작성일</th>
			<td width="85px"><%=result.get(0).getQnaDate() %></td>
		</tr>
		<tr>
			<th colspan="4" width="160px">
				글 내용
			</th>
		</tr>
		<tr>
			<td colspan="4" width="160px" height="50px">
			 <%=result.get(0).getQnaContent() %>
			</td>
		</tr>
		
	</table>
<%
	if(user!=null && (user.getUserId().equals(result.get(0).getQnaUserId())|| user.getUserAdmin().equals("1"))){		
%>
	<table>
		<tr>
			<td id ="writer">
				<%=user.getUserId() %>
			</td>
			<td>
				<textarea cols="50" rows="2" id = "comment"></textarea>
			
			</td>
			<td>
				<button onclick = "fn_postcomment">등록</button>
			
			</td>
		</tr>	
	</table>

<%	} %>
	
	<table id="commentbox">
<%
		if(user!=null && (user.getUserId().equals(result.get(0).getQnaUserId())|| user.getUserAdmin().equals("1"))){
			for(int i =0; i<result.size(); i++){
%>
			<tr >
				<%--
				
				 <td><%=result.get(i).getQnaCommentUserId() %></td>
			
				<td><%=result.get(i).getQnaCommentcontent() %></td>
			
				<td><%=result.get(i).getQnaCommentDate() %></td> 
				
				ajax
				--%>
			</tr>	
	


<%
			}
		}
%>
	</table>

</body>

<script>


	const fn_postcomment = () =>{
		let writer = $("#writer").html();
		let comment = $("#comment").html();
		
			$.ajax({
				url:"<%=request.getContextPath()%>/product/qna/post/ajax",
				data:{"writer":writer,"comment":comment, "qseq":"<%=result.get(0).getQnaProductSeq()%>},
				success:data=>{
					
					
				}
				
				
			})
		
		
	}

	$(function(){
		fn_comment();
	})


	const fn_comment=()=>{
		$.ajax({
			url:"<%=request.getContextPath()%>/product/qna/comment/ajax",
			data:{"qseq":"<%=result.get(0).getQnaProductSeq() %>"},
			success: data =>{
					console.log(data)
				
				for(let j = 0; j<data.length; j++){
					
					$("#commentbox").append($("<tr>").append( $("<td>").html(data[j]["qnaCommentUserId"]).css("width","160px"))  .append($("<td>").html(data[j]["qnaCommentcontent"]).css("width","160px")).append($("<td>").html(data[j]["qnaCommentDate"]).css("width","160px")))
					
					
					
							
					
					
					
					
					
					
					
				}
				
			}
			
			
		})
		
	}


</script>

</html>