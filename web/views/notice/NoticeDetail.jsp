<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ page import="com.notice.model.vo.Notice, java.sql.Date" %>
<% 
	Notice n=(Notice)request.getAttribute("notice");
%>    
   
<%@ include file="/views/common/header.jsp"%> 

<%
	pageContext.setAttribute("crcn", "\r\n"); //스페이스나 개행처리
	pageContext.setAttribute("br", "<br/>"); // br태그
%>

<div id="notice-detail-container">
	<span class = "Menu-name"><%=n.getnTitle() %></span>
	
        <table id="tbl-deatil-notice">
        <tr>
            <th class="blue border-white">TITLE</th>
            <td><%=n.getnTitle() %></td>
        </tr>
        <tr>
            <th class="blue border-white">WRITER</th>
            <td>Kleidung</td>
        </tr>
        
        <tr>
            <th class="blue border-white">DATE</th>
            <td><%=n.getnDate() %></td>
        </tr>
        <tr>
        	<td colspan = "2">
        		<div class="content-background" name="noticeContent" style="border : 1px solid grey;">
        			<%=n.getnContent() %>
        		
        		</div>
        	</td>
        </tr>
        <%if(userid!=null && checkAdmin.equals("1")){ %>
        <tr>
            <td colspan="2" style="text-align : end;">
                <input type="button" class="notice-btn blue" value="수정하기" onclick="location.assign('<%=request.getContextPath() %>/notice/modify/start/admin?nSeq=<%=n.getnSeq()%>')">
                
                <input type="button" class="notice-btn white" value="삭제하기" onclick="deleteNotice();">
            </td>
        </tr>
        <%} %>
        
    </table>
    </div>
    <script>
	    const deleteNotice=()=>{
    		if(confirm("정말 삭제하시겠습니까?")){
    			location.replace('<%=request.getContextPath() %>/notice/delete/admin?nSeq=<%=n.getnSeq()%>');
    		}
    	}
    </script>
    
<%@include file="/views/common/footer.jsp"%>