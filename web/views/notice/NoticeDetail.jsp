<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.notice.model.vo.Notice" %>
<% 
	Notice n=(Notice)request.getAttribute("notice");
%>    
   
<%@ include file="/views/common/header.jsp"%> 
	<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
</style>

<div id="notice-detail-container">
	<span class = "notice">NOTICE : <%=n.getnSeq() %></span>
	
        <table id="tbl-deatil-notice">
        <tr>
            <th class="blue">TITLE</th>
            <td><%=n.getnTitle() %></td>
        </tr>
        <tr>
            <th class="blue">WRITER</th>
            <td><%=n.getUserId() %></td>
        </tr>
        
        <tr>
            <th class="blue">DATE</th>
            <td><%=n.getnDate() %></td>
        </tr>
        <tr>
        	<td colspan = "2" class="content-background clip" ><%=n.getnContent() %></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align : end;">
                <input type="button" class="notice-btn blue" value="수정하기" onclick="location.assign('<%=request.getContextPath() %>/notice/noticeUpdate?nSeq=<%=n.getnSeq()%>')">
                <input type="button" class="notice-btn white" value="삭제하기" onclick="">
            </td>
        </tr>
    </table>
    </div>
<%@include file="/views/common/footer.jsp"%>