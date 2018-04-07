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
<title>支付页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
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
<style type="text/css">
 .s1{

 
 }
 .s1 {

 
 }
</style>
</head>
<body>
     <div class="header-top">
	   <div class="wrap"> 
			  <div class="header-top-left">
			  	   
   				    <div class="clear"></div>
   			 </div>
			 <div class="cssmenu">
				<ul>
					
					<li>你好,</li> 
					<li><a >
					<c:out value="${yw.id}"></c:out>
					</a></li> |
					<li><a href="ulogout">退出</a></li>
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
			<!-- <li class="active grid"><a href="index.html">首页</a></li> -->
			<li><a class="color4" href="#">保险产品</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								
								<ul>
									<li><a href="womens.html">意外保险</a></li>
									<li><a href="womens.html">健康保险</a></li>
									
								</ul>	
							</div>							
						</div>
					
					  </div>
					</div>
				</li>				
				<li><a class="color5" href="#">客户中心</a>
				<div class="megapanel">
					<div class="col1">
							<div class="h_nav">
								<h4>Contact Lenses</h4>
								<ul>
									<!-- <li><a href="add_insuranceExchange">添加保单</a></li>
									<li><a href="insuranceExchange_list">保单列表</a></li> -->
									<li><a href="mens.html">Lorem ipsum </a></li>
									<li><a href="mens.html">Planned replacement</a></li>
								</ul>	
							</div>							
						</div>
					</div>
				</li>
				<li><a class="color6" href="other.html">个人中心</a></li>
			</ul>
			</div>
		</div>
	   <div class="header-bottom-left" style="width: 120%">
         <div class="search">	  
				<!-- input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" value="搜索"> -->
				
		 </div>
	  
    </div>
     <div class="clear"></div>
     </div>
     
	</div>
  <hr>
<div class="main">
	<div class="wrap">
		<div class="section group">
		  <div class="cont span_2_of_3 row" style="text-align: center;">
		  
		  	<!-- 内容  where the money come from?  go ?-->
		 
		     <table class="table table-bordered">
		     <caption>订单信息</caption>
		       <tr>
		         <td>订单号:</td><td>20180404163910</td>
		       </tr>
		        <tr>
		         <td>支付金额:</td><td>10000.0</td>
		       </tr>
		        <tr>
		         <!-- <td>请选择支付方式:</td><td>
		            <label>支付宝</label>
		              <input type="radio" class="form-control" name="method"/>
		               <label>微信</label>
		              <input type="radio" class="form-control" name="method"/>
		               <label>支付宝</label>
		              <input type="radio" class="form-control" name="method"/>
		         </td> -->
		       </tr>
		       
		         <tr>
		         <td>支付密码:</td><td>
		          <input type="password" class="form-control">
		         </td>
		       </tr>
		       
		       <tr>
		         <td></td><td></td>
		       </tr>
		     </table>
		    <div class="col-md-12">
		       <button class="btn">确认支付</button>&nbsp;&nbsp;
		       <button class="btn">返回</button>
		    </div>
		  
		 
		
		     
		  	 						 			    
		
		     </div>
			
	</div>
	</div>
  <div class="clear"></div>
</div>





   <div class="footer" style="width: 100%">
		
		<div class="footer-bottom">
			<div class="wrap">
	               <div class="copy" style="padding-left: 40%">
			        <p>Copyright &copy; 2018.Company name All rights reserved.</p>
		         </div>

			    <div class="clear"></div>
		      </div>
	     </div>
	 </div>
	 <script type="text/javascript">
	
	 </script>
</body>
</html>