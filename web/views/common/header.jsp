<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.users.model.vo.Users" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>die Kleidung</title>

<script src ="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script src ="<%=request.getContextPath()%>/js/script.js"></script>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&display=swap" rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_yj.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_jh.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_sh.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_ws.css">

<link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/favicon.png"/>

<script>
	$("#logout").click(()=>{
		
		function kakaoLogout() {
		    if (Kakao.Auth.getAccessToken()) {
		      Kakao.API.request({
		        url: '/v1/user/unlink',
		        success: function (response) {
		        	console.log(response)
		        },
		        fail: function (error) {
		          console.log(error)
		        },
		      })
		      Kakao.Auth.setAccessToken(undefined)
		    }
		  }  
		
	})


</script>
</head>

<body>
<%
	String userid = null;
	String checkAdmin = null;
		Object qwerty = session.getAttribute("user");
	Users user = null;
		// 로그인한 상태이면
		if(qwerty!=null){
			
			user = (Users) qwerty;
			
				if(user!=null){
					
					userid = user.getUserId();
					checkAdmin = user.getUserAdmin(); // 1이면 admin계정, 0이면 일반사용자
				}
		}
%>

    <header>
<!-- -------------------------------- -->    	
    	<nav>
    
	    	<ul id="header-menuContainer">
		        
		            <li><a href="<%=request.getContextPath()%>/product/list">SHOP</a>
		            	<ul>
		            		<li><a href="<%=request.getContextPath()%>/product/list?category=c01">OUTTER</a></li>
		            		<li><a href="<%=request.getContextPath()%>/product/list?category=c02">TOP</a></li>
		            		<li><a href="<%=request.getContextPath()%>/product/list?category=c03">BOTTOM</a></li>
		            		<li><a href="<%=request.getContextPath()%>/product/list?category=c04">ACC</a></li>
		            	</ul>
		            </li>
		            
		            <li>
			            <a href="<%=request.getContextPath()%>/notice/list">BOARD</a>
			            <ul>
			            	<li><a href="<%=request.getContextPath()%>/notice/list">NOTICE</a></li>
			            	<li><a href="<%=request.getContextPath()%>/qna/qnaList">Q&A</a></li>
			            </ul>
			        </li>
			        
			        <li>
		            	<a href="<%=request.getContextPath()%>/review/list">REVIEW</a>
		            </li>
		            
		        </ul>
	        </nav>
	        
<!-- -------------------------------- -->
	
	        <div id="header-logoContainer">
	        
	            <ul id="logo">
	            
	                <%-- <li><a href="<%=request.getContextPath()%>">die Kleidung</a></li> --%>
	                
	                <li><a href="<%=request.getContextPath()%>">die Kleidung</a></li>
	           </ul> 
         
	        </div>
	
	
	
<!-- -------------------------------- -->

	        <div id="header-signContainer">
	
				  
		            
		            <ul id="admin_menu">
		            	<li>
				            	<% if( checkAdmin != null && checkAdmin.equals("1") ) { %>
		            		<a href="<%=request.getContextPath()%>/admin/adminPageStart">
				            		ADMIN
		            		</a>
				            	<% } else { %> 
							<p>				            	
				            		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				            </p>		
				            	<% } %>
		            	</li>
		            </ul>
	            
	            
	            
	  			       
<!-- -------------------------------- -->
	
	
	            <ul id="login_menu">
	            
	        		 <%if(userid == null){ %>
	        		 
	         			<!-- 로그인을 안 했을 떄 -->
	                	<li><a href="<%=request.getContextPath()%>/sign/signin/start">SIGN IN</a></li>
					
					<%} else { %>
					
						<!-- 로그인을 했을 때 --> 
	                	<li><a href="<%=request.getContextPath()%>/sign/signout" id="logout">SIGN OUT</a></li>
	        		
	        		<%} %>       
	        		
	            </ul>
	           

	           <!-- -------------------------------- -->
	
	
	            <ul id="mypage_menu">
	            
		           	<!-- 로그인하면 -->
		            <% if(userid !=null){ %>    
			        
			            <li>
				            <a href="<%=request.getContextPath()%>/sign/mypage/start">
				            	<img src="<%=request.getContextPath()%>/images/user.png" height="35px" width="35px">
				            </a>
			            	<ul>
			            		<li><a href="<%=request.getContextPath() %>/cart/list">CART</a></li>
			            		<li><a href="<%=request.getContextPath() %>/order/list">ORDER</a></li>
			            		<li><a href="<%=request.getContextPath() %>/sign/mypage/start">PROFILE</a></li>
			            	</ul>
		            	</li>
			            
			         <!-- 로그인 되어있지않으면 -->
			         <% } else { %>  
			         
			         	<li><a href="<%=request.getContextPath()%>/views/member/login.jsp"><img id="header_mypageIcon" src="<%=request.getContextPath()%>/images/user.png" height="35px" width="35px"></a></li>
			         
			         <% } %> 
		            
		        </ul>
	
<!-- -------------------------------- -->
	
	        </div>

    </header>
 
 