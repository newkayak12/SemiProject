<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&display=swap" rel="stylesheet">

</head>
<style>
#error-body{
	display: flex;
	justify-content: center;
	align-content: center;
	width:100%;
	height:1000px;
}

#error-container{
	display: flex;
	flex-direction:column;
	justify-content:center;
	align-content: center;
	background-color:  rgb(9, 74, 169);
	width:100%;
	height:700px;
	margin:0px;
}
#error-container{
display: flex;
	flex-direction:row;
	justify-content:center;
	align-content: center;
}
#error_image{
	width:400px;
	
	
}

#error_message{
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

#return{
	text-align: center;
	text-decoration: none;
	color: white;
	
}
h1, h2{
color:white;}
</style>
<body id="error-body">
	
	<div id="error-container">
	
		<div id="error-container">
			<span id="error_message">
				<div style="display: flex;  flex-direction: column; justify-content: center;">
					<h1>앗, 이런!</h1>
					<h2>페이지를 로드하는데 문제가 생겼습니다.</h2>
				</div>
				<div id="logo">
					<a href = "<%=request.getContextPath()%>/"> 
							<h1 id="return"> die kleidung</h1>
					</a>
				</div>
			</span>
			<span style="	display: flex;
    justify-content: center;
    align-items: center;
			">
				<img id ="error_image"alt="" src="<%=request.getContextPath()%>/images/error/error_yj2.png">
			</span>
		</div>
		
	
	</div>

</body>
</html>