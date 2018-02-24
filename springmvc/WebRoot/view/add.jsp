<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
   
    <form action="user1" method="post">
         Name:<input type="text" name="name" value="${user.name }">${name}<br>
         Pwd:<input type="text" name="pwd"  value="${user.pwd }">${pwd }<br>
         email:<input type="text" name="email"  value="${user.email }">${email}<br>
        <input type="submit" value="post">
    </form>
    <a href="map">click</a>
  </body>
</html>
