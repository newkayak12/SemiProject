<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.notice.model.vo.Notice, java.util.Date, java.text.SimpleDateFormat" %>
<%
	Notice n=(Notice)request.getAttribute("notice");
%>
   
<%@ include file="/views/common/header.jsp"%> 

<%
		Date now = new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    String today = sf.format(now);
%>

<div id="post-container">
	<span class = "notice">게시글 작성</span>
    <form action="<%=request.getContextPath() %>/notice/post/end/admin">
  
        <table id="tbl-post">
	        <tr>
	            <th class="blue">TITLE</th>
	            <td>
	            	<input type="text" name="noticeTitle" id="noticeTitle" style="height : 15px;" required>
	            </td>
	        </tr>
	        <tr>
	            <th class="blue">WRITER</th>
	            <td>
	            	<input type="text" name="noticeWriter" id="noticeWrite" 
	            	value="Kleidung" style="height : 15px;" readonly>
	            </td>
	        </tr>
	        
	        <tr>
	            <th class="blue">DATE</th>
	            <td><input type="text" name="noticeDate" value="<%=today %>"></td>
	        </tr>
	 
	        <tr>
	            <td colspan = "2" style="border : 1px solid grey;">
	            	<textarea rows="30" cols="90" class="content-background" name="content"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2">
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