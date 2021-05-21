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
</head>

<body>

<%
	String userid = null;
	String checkAdmin = null;
		
		// 로그인한 상태이면
		if(session.getAttribute("user")!=null){
			
			Users user = (Users) session.getAttribute("user");
			
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
		        
		            <li><a href="<%=request.getContextPath()%>/IList.do">SHOP</a>
		            	<ul>
		            		<li><a href="">OUTTER</a></li>
		            		<li><a href="">TOP</a></li>
		            		<li><a href="">BOTTOM</a></li>
		            		<li><a href="">ACC</a></li>
		            	</ul>
		            </li>
		            
		            <li>
			            <a href="">BOARD</a>
			            <ul>
			            	<li><a href="<%=request.getContextPath()%>/notice/list">NOTICE</a></li>
			            	<li><a href="">Q&A</a></li>
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
	                <li><a href="<%=request.getContextPath()%>">die Kleidung</a></li>
	           </ul> 
         
	        </div>
	
	
	
<!-- -------------------------------- -->

	        <div id="header-signContainer">
	
				<% if( checkAdmin != null && checkAdmin.equals("1") ) { %>  
		            
		            <ul id="admin_menu">
		            	<li><a href="">ADMIN</a></li>
		            </ul>
	            
	            <% } %> 
	            
	  			       
<!-- -------------------------------- -->
	
	
	            <ul id="login_menu">
	            
	        		 <%if(userid == null){ %>
	        		 
	         			<!-- 로그인을 안 했을 떄 -->
	                	<li><a href="<%=request.getContextPath()%>/sign/signin/start">SIGN IN</a></li>
					
					<%} else { %>
					
						<!-- 로그인을 했을 때 --> 
	                	<li><a href="<%=request.getContextPath()%>/sign/signout">SIGN OUT</a></li>
	        		
	        		<%} %>       
	        		
	            </ul>
	           
 <!-- -------------------------------- -->

	            
	            <ul id="mypage_menu">
	            
	            <% if(userid !=null){ %>    
		        
		            <li><a href="<%=request.getContextPath()%>/IList.do"><img src="<%=request.getContextPath()%>/images/user.png" height="35px" width="35px"></a>
		            	<ul>
		            		<li><a href="<%=request.getContextPath() %>/cart/list">CART</a></li>
		            		<li><a href="<%=request.getContextPath() %>/order/list">ORDER</a></li>
		            		<li><a href="">PROFILE</a></li>
		            	</ul>
		            </li>
		            
		         <% } else { %>  
		         
		         	<li><a href="<%=request.getContextPath()%>/views/member/login.jsp"><img id="header_mypageIcon" src="<%=request.getContextPath()%>/images/user.png" height="35px" width="35px"></a></li>
		         
		         <% } %> 
		            
		        </ul>
	
<!-- -------------------------------- -->
	
	        </div>

    </header>
 
 