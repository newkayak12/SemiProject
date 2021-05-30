<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		alert('<%=request.getAttribute("msg")%>')
		location.assign('<%=request.getContextPath()%><%=request.getAttribute("loc")%>')
		
		<%
		
		Object o = request.getAttribute("close");
		String close = null;
			if(o!= null){
				
				close = (String) o;
			}
			
			
		if(close != null){
		%>
		
			<%=close%>
		
		<%}%>
	</script>

</body>
</html>