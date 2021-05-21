<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List, com.notice.model.vo.Notice" %>
<%
	List<Notice> list = (List<Notice>)request.getAttribute("list");
%>
   
<%@ include file="/views/common/header.jsp"%> 
	<div id = notice-container>
		
		<span id ="notice">Notice</span>
		
        <table id="tbl-notice">
            <thead class="thead-color">
                <th>No</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </thead>
            
        <%if(list.isEmpty()){ %>
        	<td colspan="4">조회된 공지사항이 없습니다.<%System.out.println(list); %></td>
        <%} 
          else{ 
            for(Notice n : list){%>
            <tr>
	            <td><%=n.getnSeq() %></td>
	            <td>
	            	<a href="<%=request.getContextPath()%>/notice/noticeView?nSeq=<%=n.getnSeq()%>">
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
	
	</div>




<%@include file="/views/common/footer.jsp"%>