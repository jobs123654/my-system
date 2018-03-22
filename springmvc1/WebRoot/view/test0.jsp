<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test0.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
  </head>
  
  <body>
   <button id="testJson">testJson</button>
   <script type="text/javascript">
   function User(name,pwd)
   {
   this.name=name;
   this.pwd=pwd;
   }
   
   $('#testJson').click(function(){
    var user=new User("111","222");
    $.post(
    'testJson',
     user, 
     function(data, textStatus, req) {
      var d=JSON.parse(data);
      console.log(d.name+" \n "+d.pwd);
    });
   });
   </script>
  </body>
</html>
