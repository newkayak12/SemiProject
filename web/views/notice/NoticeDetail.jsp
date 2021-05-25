<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.notice.model.vo.Notice, java.sql.Date" %>
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
        		<div class="content-background" name="noticeContent" style="border : 1px solid grey;"><%=n.getnContent() %></div>
        	</td>
        </tr>
        <tr>
            <td colspan="2" style="text-align : end;">
                <input type="button" class="notice-btn blue" value="수정하기" onclick="location.assign('<%=request.getContextPath() %>/notice/modify/start/admin?nSeq=<%=n.getnSeq()%>')">
                
                <input type="button" class="notice-btn white" value="삭제하기" onclick="deleteNotice();">
            </td>
        </tr>
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