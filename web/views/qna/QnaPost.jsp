<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.qna.model.vo.Qna, java.util.Date, java.text.SimpleDateFormat" %>

<%@ include file="/views/common/header.jsp"%> 

<%
		Date now = new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    String today = sf.format(now);
%>

<div id="qnaPost-container">
	<span class = "Menu-name">상품문의</span>
    <form action="<%=request.getContextPath() %>/qna/post/end" method="post">
  
        <table id="tbl-qnaPost">
	        <tr>
	            <th class="blue border-white">TITLE</th>
	            <td>
	            	<input type="text" name="qnaTitle" id="qnaTitle" style="height : 10px;" required>
	            </td>
	        </tr>
	        <tr>
	            <th class="blue border-white">WRITER</th>
	            <td>
	            	<input type="text" name="qnaWriter" id="qnaWrite" style="height : 10px;" required>
	            </td>
	        </tr>
	        
	        <tr>
	            <th class="blue border-white">DATE</th>
	            <td><input type="text" name="qnaDate" value="<%=today %>" style="height : 10px;"></td>
	        </tr>
	 
	        <tr>
	            <td colspan = "2" style="border : 1px solid grey;">
	            	<textarea rows="30" cols="90" class="content-background" name="qnaContent">
	            		성함 : <br>
	            		연락처 : <br>
	            		주문번호 : <br>
	            	</textarea>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2" style="text-align : end;">
	                <input type="submit" value="등록하기" class="notice-btn blue"  onclick="">
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
 </script>
 
 <%@include file="/views/common/footer.jsp"%>