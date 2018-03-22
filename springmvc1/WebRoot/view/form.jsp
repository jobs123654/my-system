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
  </head>
  
  <body>
    <a href="get/123">click</a><br>
     from map: ${sessionScope.you.name }<br>
    <form action="testModel" method="post">
     <table>
     <caption>post</caption>
       <tr>
          <td>Name</td>
          <td>
          <input type="text" name="name" value="222">
          </td>
       </tr>
        
         <tr>
          <td><input type="submit" value="submit"></td>
          <td>
          <input type="reset" value="reset">
          </td>
       </tr>
     </table>
    </form>
    
     <form action="delete" method="post">
     <table>
     <caption>delete</caption>
       <tr>
          <td>Name</td>
          <td>
          <input type="text" name="name">
          <input type="hidden" value="DELETE" name="_method">
          
          </td>
       </tr>
        
         <tr>
          <td><input type="submit" value="submit"></td>
          <td>
          <input type="reset" value="reset">
          </td>
       </tr>
     </table>
    </form>
     <form action="put" method="post">
     <table>
     <caption>put</caption>
       <tr>
          <td>Name</td>
          <td>
          <input type="text" name="name">
          <input type="hidden" value="PUT" name="_method">
          
          </td>
       </tr>
       
         <tr>
          <td><input type="submit" value="submit"></td>
          <td>
          <input type="reset" value="reset">
          </td>
       </tr>
     </table>
    </form>
  </body>
</html>
