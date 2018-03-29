<%@page import="com.Entity.User"%>
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
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
   <form action="ut" method="post">
   id:<c:out value="${user.id }"></c:out>
    
     <input type="text" name="name" value= <c:out value="${user.name }"></c:out> />
      <input type="text" name="id" value= <c:out value="${user.id }"></c:out> />
     <input type="submit" value="submit"> 
    
   </form>
   
   <hr>
   <a href="#" onclick="history.back()">add</a>
  </body>
</html>
