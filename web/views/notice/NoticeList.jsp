<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List, com.notice.model.vo.Notice" %>
<%
	List<Notice> list = (List<Notice>)request.getAttribute("list");
%>
   
<%@ include file="/views/common/header.jsp"%> 
	<div id = notice-container>
		
		<span class = "notice">Notice</span>
		
        <table id="tbl-notice">
            <thead class="thead-color">
                <th>NO</th>
                <th>TITLE</th>
                <th>WRITER</th>
                <th>DATE</th>
            </thead>
            
        <%if(list.isEmpty()){ %>
        	<td colspan="4">조회된 공지사항이 없습니다.<%System.out.println(list); %></td>
        <%} 
          else{ 
            for(Notice n : list){%>
            <tr>
	            <td><%=n.getnSeq() %></td>
	            <td class="notice-title">
	            	<a href="<%=request.getContextPath()%>/notice/detail?nSeq=<%=n.getnSeq()%>">
	            	<%=n.getnTitle() %>
	            	</a>
	            </td> 
	            <td>
	            	<%=n.getUserId() %>
	            </td>
	            <td>
	            	<%=n.getnDate() %>
	            </td>
             </tr> 
            <%}
            }%>
        </table>
        
        <%if(session.getAttribute("user")!=null &&checkAdmin.equals("1")) {%>
        	<input type="button" value="공지작성" class="notice-btn blue" onclick="noticeWrite();">
		<%} %> 
	
	</div>
	<script>
		const noticeWrite=()=>{
			location.assign("<%=request.getContextPath()%>/notice/post/start/admin");	
		}		
	</script>

<%@include file="/views/common/footer.jsp"%>