<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>spring mvc</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	form{
	  margin: 20% 30%;
	}
	</style>
  </head>
  
  <body>
   hello spring mvc! <br>
   <form action="upload" method="post" enctype="multipart/form-data">
    Name:<input type="text" name="name"><br>
    Pwd:<input type="password" name="pwd"><br>
    File:<input type="file" name="file">
    <input type="submit" value="click">
   </form>
  </body>
</html>
