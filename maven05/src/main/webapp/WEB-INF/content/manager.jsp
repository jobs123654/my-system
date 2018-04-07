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
<title>万众保险后台管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href='http//fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!--start slider -->
    <link rel="stylesheet" href="css/fwslider.css"media="all">
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/css3-mediaqueries.js"></script>
    <script src="js/fwslider.js"></script>
<!--end slider -->
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
					
					<li><a href="login.html">欢迎回来,
					 <c:out value="${user.name}"></c:out>
					</a></li>|
					<li><a href="logout">退出</a></li>
				</ul>
			</div>
			<div class="clear"></div>
 		</div>
	</div>
	<div class="header-bottom">
	    <div class="wrap">
			<div class="header-bottom-left">
				<div class="logo">
					<a href="index.html"><img src="img/logo.png" alt=""/></a>
				</div>
				<div class="menu">
	            <ul class="megamenu skyblue">
			<li class="active grid"><a href="index.html">首页</a></li>
			<li><a class="color4" href="#">保险管理</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								
								<ul>
									<li><a href="secure_list">保险列表</a></li>
									<!-- <li><a href="womens.html">添加保险</a></li> -->
									
									  <li><a href="classify_list">分类列表</a></li>
									
									<!-- 	<li><a href="show_add_classify">添加分类</a></li> -->
									
								</ul>	
							</div>							
						</div>
						
						
					  </div>
					</div>
				</li>				
				<li><a class="color5" href="#">业务数据</a>
				<div class="megapanel">
					<div class="col1">
							<div class="h_nav">
								<h4></h4>
								<ul>
									<!-- <li><a href="mens.html">Daily-wear soft lenses</a></li>
									<li><a href="mens.html">Extended-wear</a></li>
									<li><a href="mens.html">Lorem ipsum </a></li>
									<li><a href="mens.html">Planned replacement</a></li> -->
								</ul>	
							</div>							
						</div>
						
					</div>
				</li>
				<li><a class="color6" href="other.html">业务员管理</a>
				<div class="megapanel">
					<div class="col1">
							<div class="h_nav">
								<h4></h4>
								<ul>
									
									<li><a href="user_list">业务员列表</a></li>
									<!-- <li><a href="mens.html">Lorem ipsum </a></li>
									<li><a href="mens.html">Planned replacement</a></li> -->
								</ul>	
							</div>							
						</div>
						
					</div>
				</li>
				<li><a class="color6" href="other.html">账户管理</a>
				<div class="megapanel">
					<div class="col1">
							<div class="h_nav">
								<h4></h4>
								<ul>
									
									<li><a href="manager_list">账户列表</a></li>
									
								</ul>	
							</div>							
						</div>
						
					</div>
				</li>
				<li><a class="color7" href="other.html">会员管理</a></li>
			</ul>
			</div>
		</div>
	   
	  
    </div>
     <div class="clear"></div>
     </div>
	</div>
  <!-- start slider -->
    <div id="fwslider">
        <div class="slider_container">
            <div class="slide"> 
                <!-- Slide image -->
                    <img src="img/banner.jpg" alt=""/>
                <!-- /Slide image -->
                <!-- Texts container -->
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <!-- Text title -->
                        <h4 class="title">Aluminium Club</h4>
                        <!-- /Text title -->
                        
                        <!-- Text description -->
                        <p class="description">Experiance ray ban</p>
                        <!-- /Text description -->
                    </div>
                </div>
                 <!-- /Texts container -->
            </div>
            <!-- /Duplicate to create more slides -->
            <div class="slide">
                <img src="img/banner1.jpg" alt=""/>
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <h4 class="title">consectetuer adipiscing </h4>
                        <p class="description">diam nonummy nibh euismod</p>
                    </div>
                </div>
            </div>
            <!--/slide -->
        </div>
        <div class="timers"></div>
        <div class="slidePrev"><span></span></div>
        <div class="slideNext"><span></span></div>
    </div>
    <!--/slider -->
<div class="main">
	<div class="wrap">
		<div class="section group">
		  <div class="cont span_2_of_3">
		 
			
		 	 						 			    
		  </div>
			<div class="rsidebar span_1_of_left">
				
	   <div class="clear"></div>
	</div>
	</div>
	</div>
   <div class="footer">
		
		
		<div class="footer-bottom">
			<div class="wrap">
	               <div class="copy" style="padding-left: 40%">
			        <p>Copyright &copy; 2018.Company name All rights reserved.</p>
		         </div>
				<div class="f-list2">
				
			    </div>
			    <div class="clear"></div>
		      </div>
	     </div>
	</div>
<div style="display:none"><script src='http//v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>