<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  </head>
  
  <body>
  home page <br>
  
 from model: ${requestScope.key.name }<br>
 
 from map: ${requestScope.you.name }<br>
 
  <c:forEach items="${list}" var="item">
    ${item.id }----${item.name }----${item.uid }<br>
  </c:forEach>
  
  
  <a href="${page.previousPage}">previous</a>
  ${ar.length }
  <c:forEach items="${total}" var="item" >
     <a href="booklist/${item}">${item}</a> &nbsp;&nbsp;
  </c:forEach>
  
  <a href="${page.nextPage}">next</a>
  </body>
</html>
