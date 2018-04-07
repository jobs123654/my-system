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
    
<title>保险详情</title>
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
	   <div id="" style="position: relative;top: 3%;">
	  <label style="position: relative;top: -1%;left:5% ">  <a href="home">首页</a>/保险详情</label>
	  <label style="margin-left: 80%">  <a  onclick="history.back()">返回</a></label>
	 </div>
	</div>

	<div class="header-bottom">
	  
	
	
		 <hr>
  <!-- start slider -->
   
    <!--/slider -->
     <div class="main">
	  <div class="wrap">
		
		
			
			<table class="table table-bordered">
			
           	 
           	  <tr>
           	 	<td>名称</td><td>
           	 	<c:out value="${i.name }"></c:out>
           	 	</td>
           	 </tr>
           	 <tr>
           	 	<td>分类</td><td>
           	 	 <c:out value="${i.cname }"></c:out>
           	 	</td>
           	 	
           	 </tr>
           	  <tr>
           	 	<td>保险对象</td><td>
           	 	<c:out value="${i.obj}"></c:out>
           	 	</td>
           	 </tr>
           	  <tr>
           	 	<td>保险期限</td><td>
           	 	<c:out value="${i.lit }"></c:out>
           	 	</td>
           	 </tr>
           	 
           	  <tr>
           	 	<td>被保人年龄</td><td>
           	 		<c:out value="${i.insuredage}"></c:out>
           	 	</td>
           	 </tr>
           	  <tr>
           	 	<td>职业类别</td><td>
           	 	<c:out value="${i.proclassify}"></c:out>
           	 		
           	 	</td>
           	 </tr>
           	 <tr>
           	 	<td>供应商</td><td>
           	 		<c:out value="${i.supplier}"></c:out>
           	 		
           	 	</td>
           	 </tr>
           	 
           	  <tr>
           	 	<td>保费</td><td>
           	 		<c:out value="${i.premium}"></c:out>
           	 		
           	 	</td>
           	 </tr>
           	 <tr>
           	 	<td>保险责任和金额</td><td>
           	 		<pre style="width: 900px">
           	 		<c:out value="${i.duty}"></c:out>
           	 		</pre>
           	 		
           	 	</td>
           	 </tr>
           	 
           	  <tr>
           	 	   <td>各职业等级保额限制</td><td>
           	 		<pre style="width: 900px">
           	 		<c:out value="${i.prolimit}"></c:out>
           	 		</pre>
           	 		
           	 	
           	 		
           	 	</td>
           	 </tr>
           	 
           	 <tr>
           	 	<td>投保须知</td><td>
           	 		
           	 		
           	 		<pre style="width: 900px">
           	 		<c:out value="${i.notice}"></c:out>
           	 		</pre>
           	 	
           	 	</td>
           	 </tr>
           	 	 <tr>
           	 	   <td>特别告知</td><td>
           	 		<pre style="width: 900px">
           	 		<c:out value="${i.inform}"></c:out>
           	 		</pre>
           	 		
           	 	
           	 		
           	 	</td>
           	 </tr>
           	 
           	 
           	  <tr>
           	 	   <td>特别约定</td><td>
           	 		<pre style="width: 900px">
           	 		<c:out value="${i.sa}"></c:out>
           	 		</pre>
           	 		
           	 	
           	 		
           	 	</td>
           	 </tr>
           	  <tr>
           	 	   <td>备注</td><td>
           	 		<pre style="width: 900px">
           	 		<c:out value="${i.others}"></c:out>
           	 		</pre>
           	 		
           	 	
           	 		
           	 	</td>
           	 </tr>
           	 
           	 
           	  <tr>
           	 	<td>&nbsp;</td>
           	 </tr>
		</table>
		

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