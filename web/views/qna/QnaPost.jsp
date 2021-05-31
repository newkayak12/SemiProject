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
   <span class = "Menu-name"> Q & A </span>
    <form action="<%=request.getContextPath() %>/qna/qnaPostEnd" method="post" enctype="multipart/form-data">
  
        <table id="tbl-qnaPost">
           <tr>
               <th class="blue border-white">TITLE</th>
               <td>
                  <input type="text" name="qnaTitle" id="qnaTitle"  value ="상품문의" style="height : 10px; width : 250px;" readonly>
               </td>
           </tr>
           <tr>
               <th class="blue border-white">WRITER</th>
               <td>
                  <input type="text" name="qnaWriter" id="qnaWriter" readonly value="<%=user.getUserId()%>"placeholder="아이디를 입력하시오." style="height : 10px; width : 250px;"" required>
               </td>
           </tr>
           
           <tr>
               <th class="blue border-white">DATE</th>
               <td><input type="text" name="qnaDate" value="<%=today %>" style="height : 10px; width : 250px;"></td>
           </tr>
    
           <tr>
               <td colspan = "2" style="border : 1px solid grey;">
                  <textarea rows="30" cols="90" class="content-background" name="qnaContent">
성함 : 
연락처 :
주문번호 :
                  </textarea>
               </td>
           </tr>
           
           <tr>
            <td colspan="2"><span>첨부파일</span> <input type="file" name="up_file" ></td>
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