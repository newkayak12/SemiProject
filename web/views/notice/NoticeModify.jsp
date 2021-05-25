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

<div id="modi-container">
	<span class = "Menu-name">게시글 수정</span>
    <form action="<%=request.getContextPath() %>/notice/modify/end/admin" method="post">
  		<input type="hidden" value="<%=n.getnSeq() %>" name = "noticeno">
        <table id="tbl-modi">
	        <tr>
	            <th class="blue border-white">TITLE</th>
	            <td>
	            	<input type="text" name="noticeTitle" id="noticeTitle" value="<%=n.getnTitle() %>" style="height : 15px;" required>
	            </td>
	        </tr>
	        <tr>
	            <th class="blue border-white">WRITER</th>
	            <td>
	            	<input type="text" name="noticeWriter" id="noticeWrite" 
	            	value="Kleidung" style="height : 15px;" readonly>
	            </td>
	        </tr>
	        
	        <tr>
	            <th class="blue border-white">DATE</th>
	            <td><input type="text" name="noticeDate" value="<%=today %>"></td>
	        </tr>
	 
	        <tr>
	            <td colspan = "2" style="border : 1px solid grey;">
	            	<textarea rows="30" cols="90" class="content-background" name="noticeContent"><%=n.getnContent() %></textarea>
	            </td>
	        </tr>
	        
	        <tr>
	            <td colspan="2" style="text-align : end;">
	            	<%if(session.getAttribute("user")!=null &&checkAdmin.equals("1")) {%>
		                <input type="submit" value="수정완료" class="notice-btn blue"  onclick="">
		            	<input type="button" value="수정취소" class="notice-btn white" onclick="goBack();">
	            	<%} %> 
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