<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
  <div class="container-fluid">
  <div class="row">
  
  <div class="jumbotron" style="margin-top:10%">
   <h3>欢迎进入</h3>
   <h3>测绘仪器管理信息系统</h3>
  <form class="navbar-form navbar-left" role="search" action="proGetProductByName">
        <div class="form-group">
          <input type="text" name="tname" class="form-control" placeholder="仪器名称">
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form><br/>
  
</div> 
  </div>
  
  </div>
  
  
   
  </body>
  
</html>
