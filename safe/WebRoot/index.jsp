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
  <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    
  <form action="uLogin" method="post">
   Id:<input type="text" name="user.useNumber" id="id">  <br>

   pass:<input type="text" name="user.userPassword" id="pass">  <br>
   
    Name:<input type="text" name="user.userName" id="name">  <br>

   Sex:<input type="text" name="user.userSex" id="sex">  <br>
   
   Number:<input type="text" name="user.userNumber" id="number">  <br>
 
  </form>
  
   <button id="submit">click</button>
 
   <script type="text/javascript">
   var c=document.getElementById("canvas");
   if(c.getContext("2d"))
   {
   var c=c.getContext("2d");
   
   
   }
   
   var i=document.body.clientHeight;
   $('#submit').click(function()
   {
     $.post(
     'ugetInfo?user.useNumber='+$('#id').val()
  ,
     {},
     function(d)
     {
      alert(d);
     }
     );
   });
   </script>
  </body>
</html>
