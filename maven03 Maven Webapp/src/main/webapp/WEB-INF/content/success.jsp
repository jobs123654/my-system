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
   <c:forEach var="i" items="${list }">
     <p>
      <c:out value="${i.name}"></c:out><a href="ut?id=<c:out value="${i.id}"></c:out>">up</a><a href="del?id=<c:out value="${i.id}"></c:out>">del</a>
     </p>
   </c:forEach>
   <hr>
   <c:if test="${page.current!=1 }">
    <a href="page?c=<c:out value="${page.current -1}"></c:out>"> [pre]</a>
   </c:if>
     <c:forEach begin="${page.start}" end="${page.stop}" var="i">
      <a href="page?c=<c:out value="${i }"></c:out>">
      <c:out value="${i }"></c:out>
     </a>
   </c:forEach>
    <c:if test="${page.current!=page.totalPage }">
<a href="page?c=<c:out value="${page.current +1}"></c:out>"> [next]</a>    [<c:out value="${page.current }"></c:out> /<c:out value="${page.totalPage }"></c:out> ]
   </c:if>

   <hr>
   <a href="#" onclick="history.back()">add</a>
  </body>
</html>
