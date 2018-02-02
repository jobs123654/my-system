 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
 <head>
    <base href="<%=basePath%>">
   
    
    <title>错误报告</title>
	
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#warn
	{
	margin:20% 36%;
	
	}
	</style>
  </head>
  
  <body>
  <div id="warn">
   <h1>账号或密码错误！</h1>
   <hr/>
  </div>
  </body>
  <script>
   $(function(){
    setTimeout(function() {
    	window.history.back();
    },1000);
  });
  </script>
</html>
