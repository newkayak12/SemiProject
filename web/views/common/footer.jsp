<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<footer>
	
	    <div id="footer-container">
	
	
	        <span id="footer_copyright">
	            <p><a href="<%=request.getContextPath()%>">die Kleidung</a></p>
	        </span>
	        
	        <span id="footer_contactus">
	        	
	            <p id = "company-map">서울특별시 강남구 테헤란로 14길 6 남도빌딩</p>
				<p>1544-9970</p>
	            <p>Kleidung@naver.com</p>
	        </span>
	        
	        <span id="footer_submenu">
	            <p onclick = "toNotice();">Notice</p>
	            <p onclick = "toQna();">Q&A</p>
	        </span>
	        
	        <span id="footer_info">
	            <p>Acount</p>
	            <p>하나은행 661-910265-45729</p>
	            <p>신한은행 910-910265-67832</p>
	        </span>
   
	    </div>
	    
	</footer>
	
	<script>
		const toNotice=()=>{
			location.assign("<%=request.getContextPath()%>/notice/list");
		}
		
		const toQna=()=>{
			location.assign("<%=request.getContextPath()%>/qna/qnaList");
		}
		
	
	</script>
</body>
</div>
</html>