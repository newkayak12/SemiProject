<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style_sh.css">
</head>
<body id="error-body">
	
	<div id="error-container">
	
		<div id="error_box">
			<span id="error_message">
				<h1>앗, 이런!</h1>
				<h2>페이지를 로드하는데 문제가 생겼습니다.</h2>
			</span>
			<span>
				<img id ="error_image"alt="" src="<%=request.getContextPath()%>/images/error/OOPS.png">
			</span>
		</div>
		<div id="logo">
			<a href = ""> 
				<h1> die kleidung</h1>
			</a>
		</div>
	
	</div>

</body>
</html>