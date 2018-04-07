<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http//fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
    <div class="header-top">
			<div class="wrap"> 
			  <div class="header-top-left">
			  	   <div class="box">
			  	  
   				     
   				    </div>
   				    <div class="box1">
   				      
   				    </div>
   				    <div class="clear"></div>
   			 </div>
			 <div class="cssmenu">
				<ul>
					<li class="active"><a href="login.html">Account</a></li> |
					<li><a href="checkout.html">Wishlist</a></li> |
					<li><a href="checkout.html">Checkout</a></li> |
					<li><a href="login.html">登录</a></li> 
					<!-- <li><a href="register.html">Sign Up</a></li> -->
				</ul>
			</div>
			<div class="clear"></div>
 		</div>
	 </div>
	<div class="header-bottom">
	    <div class="wrap">
			<div class="header-bottom-left">
				<div class="logo" style="padding-left: 65%">
					
					<h1 >
					
					<a href="login.jsp">
					万众保险业务端
					</a>
					</h1>
					
					
				</div>
				
		</div>
	   <div class="header-bottom-right">
         <!-- <div class="search">	  
				<input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" value="Subscribe" id="submit" name="submit">
				<div id="response"> </div>
		 </div> -->
    </div>
     <div class="clear"></div>
     </div>
	</div>
        <div class="login">
          	<div class="wrap"style="padding-left: 30%">
				
				<div class="col_1_of_login span_1_of_login" >
				<div class="login-title" >
	           		<h4 class="title"></h4>
					<div id="loginbox" class="loginbox" >
						<form action="login" method="post" name="login" id="login-form">
						  <fieldset class="input">
						    <p id="login-form-username">
						      <label for="modlgn_username">工号</label>
						      <input id="modlgn_username" type="text" name="id" class="inputbox" size="18" autocomplete="off">
						    </p>
						    <p id="login-form-password">
						      <label for="modlgn_passwd">密码</label>
						      <input id="modlgn_passwd" type="password" name="password" class="inputbox" size="18" autocomplete="off">
						    </p>
						    <div class="remember">
							    <p id="login-form-remember">
							      <label for="modlgn_remember"><a href="#">忘记密码? </a></label>&nbsp;&nbsp;
							       <label for="modlgn_remember"><a href="mlogin">管理员登录 </a></label>
							   </p>
							    <input type="submit"  class="button" value="登录">
							    
							    <div class="clear"></div>
							 </div>
						  </fieldset>
						 </form>
						 <p>
									
						  <c:out value="${msg.msg}"></c:out>
						 </p>
					</div>
			    </div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		
     <div class="footer" style="margin-top: 8%">
				
		<div class="footer-bottom" >
			<div class="wrap">
	            <div class="copy" style="padding-left: 40%">
			           <p>Copyright &copy; 2018.Company name All rights reserved.</p>
		        </div>
			  <div class="f-list2">
				<!-- <ul>
					<li class="active"><a href="about.html">About Us</a></li> |
					<li><a href="delivery.html">Delivery & Returns</a></li> |
					<li><a href="delivery.html">Terms & Conditions</a></li> |
					<li><a href="contact.html">Contact Us</a></li> 
				</ul> -->
			  </div>
				<div class="clear"></div>
		      </div>
			</div>
		</div>

</body>
</html>