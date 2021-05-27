<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.notice.model.vo.Notice, java.util.Date, java.text.SimpleDateFormat" %>

   
<%@ include file="/views/common/header.jsp"%> 

<%
		Date now = new Date();
	    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	    String today = sf.format(now);
%>

<div id="post-container">
	<span class = "Menu-name">공지사항 작성</span>
    <form action="<%=request.getContextPath() %>/notice/post/end/admin" method="post">
  
        <table id="tbl-post">
	        <tr>
	            <th class="blue border-white">TITLE</th>
	            <td>
	            	<input type="text" name="noticeTitle" id="noticeTitle" style="height : 10px; width : 250px;" required>
	            </td>
	        </tr>
	        <tr>
	            <th class="blue border-white">WRITER</th>
	            <td>
	            	<input type="text" name="noticeWriter" id="noticeWrite" 
	            	value="Kleidung" style="height : 10px; width : 250px;" readonly>
	            </td>
	        </tr>
	        
	        <tr>
	            <th class="blue border-white">DATE</th>
	            <td><input type="text" name="noticeDate" value="<%=today %>" style="height : 10px; width : 250px;"></td>
	        </tr>
	 
	        <tr>
	            <td colspan = "2" style="border : 1px solid grey;">
	            	<textarea rows="30" cols="90" class="content-background" name="noticeContent"></textarea>
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