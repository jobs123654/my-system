<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>信息修改</title>
<meta name="viewport" content="widtd=device-widtd, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/myStyle.css" rel="stylesheet" type="text/css" media="all" />

<link href='http//fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/myStyle.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>

<!--start slider -->
    <link rel="stylesheet" href="css/fwslider.css" media="all">
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/css3-mediaqueries.js"></script>
    <script src="js/fwslider.js"></script>
<!--end slider -->
<script src="js/jquery.easydropdown.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/myScript.js"></script>
</head>
<body>
     <div class="header-top">
	    <div class="wrap"> 
			  <div class="header-top-left">
			       
        <!--  <form class="search" action="" metdod="post">	  
        				<input type="text" name="s" class="textbox" value="Search" onfocus="tdis.value = '';" onblur="if (tdis.value == '') {tdis.value = 'Search';}">
        				<input type="submit" value="Subscribe" id="submit" name="submit">
        				<div id="response"> </div>
        		 </form>
         -->
	 
       
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
	  
	</div>
	 <label style="margin-left: 5%">  <a href="home">首页</a>/业务员信息更改</label>
		 <hr>
  <!-- start slider -->
   
    <!--/slider -->
     <div class="main">
	  <div class="wrap">
		
		<form action="update_user" enctype="multipart/form-data" method="post">
			
			<table class="table table-bordered">
			
           	 <tr>
           	 	<td>工号</td><td>
           	 	
           	 		<input type="text" name="id" disabled="disabled" value="<c:out value="${u.id }"></c:out>">
           	 	</td>
           	 </tr>
           	  <tr>
           	 	<td>姓名</td><td><input type="text" name="name" value="<c:out value="${u.name }"></c:out>"> </td>
           	 </tr>
           	  <tr>
           	 	<td>密码</td><td><input type="text" name="password" value="<c:out value="${u.password}"></c:out>"></td>
           	 </tr>
           	  <tr>
           	 	<td>身份证号</td><td><input type="text" name="identity" value="<c:out value="${u.identity }"></c:out>"></td>
           	 </tr>
           	  <tr>
           	 	<td>性别</td><td>
           	 		
           	 		
           	 		<c:if test="${u.sex eq 0 }">
           	 		 <label>男</label>
           	 		  <input type="radio" name="sex" value="0" checked="checked">
           	 		  <label>女</label>
           	 		<input type="radio" name="sex" value="1">
           	 		</c:if>
           	 		
           	 		
           	 		
           	 		
           	 	
           	 		<c:if test="${u.sex eq 1 }">
           	 		<label>男</label>
           	 		  <input type="radio" name="sex" value="0"><label>女</label>
           	 		<input type="radio" name="sex" value="1" checked="checked">
           	 		</c:if>
           	 			
           	 		
           	 		
           	 	</td>
           	 </tr>
           	  <tr>
           	 	<td>头像
           	 	
           	 	
           	 	 <input type="hidden" name="id" value="<c:out value="${u.id }"></c:out>">
           	 	  <input type="hidden" name="picpath" value="<c:out value="${u.picpath }"></c:out>">
           	 	 
           	 	</td>
           	 	
           	 	<td>
           	 	<img alt=""  class="img"  src="<c:out value="${u.picpath }"></c:out>">
           	 		<input type="file" name="file">
           	 		
           	 	</td>
           	 </tr>
           	 <tr>
           	 	<td>手机号</td><td>
           	 		
           	 		<input type="number" name="phone" value="<c:out value="${u.phone }"></c:out>">
           	 	</td>
           	 </tr>
           	 <tr>
           	 	<td>
           	 	
           	 	</td><td>
           	 		
           	 		<input type="submit" name="" value="提交">&nbsp;
           	 		<input class="cancel" type="button" name="" value="返回">
           	 	</td>
           	 	
           	 </tr>
          
		</table>
		</form>

	   <div class="clear"></div>
	</div>
	</div>
	</div>
   <div class="footer">
		
		<div class="footer-bottom">
			<div class="wrap">
	             <div class="copy" style="margin-left: 40%">
			        <p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http//www.zjf88.com/"></a></p>
		         </div>
				<div class="f-list2">
				
			    </div>
			    <div class="clear"></div>
		      </div>
	     </div>
	</div>

</body>
</html>