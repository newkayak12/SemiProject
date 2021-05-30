<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="com.qna.model.vo.Qna, java.util.Date, java.text.SimpleDateFormat" %>
<%
	Qna q=(Qna)request.getAttribute("qna");
%>
   
<%@ include file="/views/common/header.jsp"%> 

<%
		Date now = new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    String today = sf.format(now);
%>

<div id="qnaModi-container">
	<span class = "Menu-name"> Q & A 수정 </span>
    <form action="<%=request.getContextPath() %>/qna/qnaModifyEnd" method="post" enctype="multipart/form-data">
  		
  		<input type="hidden" name = "qSeq" value="<%=q.getqSeq()%>">
        
        <table id="tbl-qnaPost">
	        <tr>
	            <th class="blue border-white">TITLE</th>
	            <td>
	            	<input type="text" name="qnaTitle" id="qnaTitle"  value ="문의합니다." style="height : 10px; width : 250px;" readonly>
	            </td>
	        </tr>
	        <tr>
	            <th class="blue border-white">WRITER</th>
	            <td>
	            	<input type="text" name="qnaWriter" id="qnaWriter" placeholder = "아이디를 입력하시오" style="height : 10px; width : 250px;"" required>
	            </td>
	        </tr>
	        
	        <tr>
	            <th class="blue border-white">DATE</th>
	            <td><input type="text" name="qnaDate" value="<%=today %>" style="height : 10px; width : 250px;""></td>
	        </tr>
	 
	        <tr>
	             <td colspan = "2" style="border : 1px solid grey;">
	            	<textarea rows="30" cols="90" class="content-background" name="qnaContent">
<%=q.getqContents() %>
	            	</textarea>
	            </td>
	        </tr>
	        
	        <tr>
	        	<!-- 기존에 있던 파일값 첨부파일에 들어있고, 새로 파일 집어넣으면 갱신되는 로직 -->
				<td colspan="2">
				
				<span>첨부파일</span> 
				<%if(q.getqFile()!=null){ %>
				
				
	            	<input type="file" name="up_file" id="up_file">
	            	
	            	<input type="hidden" name="oriFile" value="<%=q.getqFile()%>">
	        
	        
	        		 <span id="fname" style="margin: 0;"><%=q.getqFile()%></span>
	        		 
	            	<%} else{%>
	            	
	            		<input type="file" name="up_file">
	            	<%} %>
            	</td>
            	<%System.out.println(q.getqFile()); %>
			</tr>
	        
	        <tr>
	            <td colspan="2" style="text-align : end;">
	                <input type="submit" value="등록하기" class="notice-btn blue" >
	            	<input type="button" value="취소하기" class="notice-btn white" onclick="goBack();">
	            </td>
	        </tr>
    	</table>
    </form>
</div>

 <script>
    	const goBack=()=>{
    		window.history.back();
    	}
    	
    	$(function(){
    		$("input[name=up_file]").change(e => {
    			if($(e.target).val()==""){
    				$("#fname").css({"display" : "inline-block"});
    			}else{
    				$("#fname").css({"display" : "none"});
    			}
    		});
    	});
    	


 </script>
 
 <%@include file="/views/common/footer.jsp"%>