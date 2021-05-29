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
 ProductQna result = null;	
		if(o!=null){
			
			result = (ProductQna) o;
			
		}
		
 Object j  = request.getSession().getAttribute("user");
 Users user = null;
 
 		if(j!=null){
 			user = (Users) j;
 			
 		}
 		
 		
 		/* System.out.println(result.getQnaProductSeq()); */

%>



</head>
<body>
	<table>
		<tr>
			<th width="80px" style="text-align: left;">글 제목</th>
			<td colspan="3" width="400px" style="text-align: center;"><%=result.getQnaTitle() %></td>
			
		</tr>
		<tr>
			
			<th width="75px" style="text-align: left;">작성자</th>
			<td width="160px"><%=result.getQnaUserId() %></td>
			<th width="85px" style="text-align: left;">작성일</th>
			<td width="190px"><%=result.getQnaDate() %></td>
		</tr>
		<tr>
			<th colspan="4" width="160px" style="text-align: left;">
				글 내용
			</th>
		</tr>
		<tr>
			<td colspan="4" width="160px" height="100px">
			 <%=result.getQnaContent() %>
			</td>
		</tr>
		
	</table>
<%
	if(user!=null && (user.getUserId().equals(result.getQnaUserId())|| user.getUserAdmin().equals("1"))){		
%>
	<table>
		<tr>
			<td>
				<span id ="writer"><%=user.getUserId() %></span>
				<%=user.getUserAdmin().equals("1")? "[관리자]":"[사용자]" %>
			</td>
			<td>
				<textarea cols="50" rows="2" id = "comment"></textarea>
			
			</td>
			<td>
				<button onclick = "fn_postcomment()">등록</button>
			
			</td>
		</tr>	
	</table>

<%	} %>
	
	<table id="commentbox">
<%
		if(user!=null && (user.getUserId().equals(result.getQnaUserId())|| user.getUserAdmin().equals("1"))){
			
%>

<%--
			<tr >
				
				
				 <td><%=result.get(i).getQnaCommentUserId() %></td>
			
				<td><%=result.get(i).getQnaCommentcontent() %></td>
			
				<td><%=result.get(i).getQnaCommentDate() %></td> 
				
				ajax
			</tr>	
--%>
	


<%
			
		}
%>

		
	</table>
	
	
	<div style="display: flex; justify-content: center; align-items: center; margin-bottom: 0px; margin-top: 200px">
		<button onclick = "window.close">닫기</button>
	</div>

</body>

<script>


	const fn_postcomment = () =>{
		let writer = $("#writer").html().trim();
		let comment = $("#comment").val();
		console.log(writer.trim())
		console.log(comment)
		
			 $.ajax({
				url:"<%=request.getContextPath()%>/product/qna/post/ajax",
				data:{"writer":writer,"comment":comment, "qseq":"<%=result.getQnaProductSeq()%>"},
				success:data=>{
					console.log(data)
					
					$("#comment").val("")
					fn_comment()
					
				}
				
				
			}) 
		
		
	}

	$(function(){
		fn_comment();
	})


	const fn_comment=()=>{
		
		$.ajax({
			url:"<%=request.getContextPath()%>/product/qna/comment/ajax",
			data:{"qseq":"<%=result.getQnaProductSeq() %>"},
			success: data =>{
					console.log(data)
				$("#commentbox").html("")
				
				for(let j = 0; j<data.length; j++){
					
					$("#commentbox").append($("<tr>").append( $("<td>").html(data[j]["qnaCommentUserId"]+"<%=user.getUserAdmin().equals("1")? "[관리자]":"[사용자]"%>").css("width","160px"))  .append($("<td>").html(data[j]["qnaCommentcontent"]).css("width","320px")).append($("<td>").html(data[j]["qnaCommentDate"]).css("width","100px")))
					
					
				}
				
					
					/* $("#commentbox").append($("<tr>").append($("<td>").attr("colspan","3").css("text-align","right").append($("<button>").attr("onclick","window.close()").html("닫기").css({"width":"50px","height":"20px","background-color":"rgb(11, 53, 152)","border-radius":"0px","color":"white"})))) */
			}
			
			
		})
		
	}


</script>

</html>