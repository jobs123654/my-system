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
    
<title>添加保险分类</title>
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
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!--start slider -->
    <link rel="stylesheet" href="css/fwslider.css" media="all">
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
	  <label style="margin-left: 5%">  <a href="home">首页</a>/添加保险分类</label>
		 <hr>
  <!-- start slider -->
   
    <!--/slider -->
     <div class="main">
	  <div class="wrap">
		
		<form action="add_classify"  method="post">
			
			<table class="table table-bordered">
			
           	 <tr>
           	 	<td>分类名称</td><td>
           	 		<input type="text" name="cname" required>
           	 	</td>
           	 </tr>
           	 <tr>
           	 	<td>所属分类</td><td>
           	 	<select  name="fid" style="width:20%">
           	 	  <option value="0">=请选择=</option>
           	 	  <option value="一年期(含以下)电子保单类产品">一年期(含以下)电子保单类产品</option>
           	 	  <option value="汽车保险产品">汽车保险产品</option>
           	 	  <option value="长期寿险电子保单类产品">长期寿险电子保单类产品</option>
           	 	  <option value="其他产品 ">其他产品 </option>
           	 	</select>
           	 	
           	 	</td>
           	 </tr>
           	  <tr> 
           	 	<td>创建人</td><td><input type="text"  name="uid" value="<c:out value="${user.name }"></c:out>"></td>
           	 </tr>
           	  <tr>
           	 	<td>
           	 	
           	 	</td><td>
           	 		
           	 		<input type="submit" name="" value="提交">&nbsp;
           	 		<input type="reset" name="" value="取消">
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
				
			    <div class="clear"></div>
		      </div>
	     </div>
	</div>

</body>
</html>