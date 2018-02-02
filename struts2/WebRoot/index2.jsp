<%@page import="com.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测绘仪器信息管理系统 </title>
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<script type="text/javascript" src="./js/jquery-1.11.1.js"></script>
   <script type="text/javascript" src="./js/bootstrap.min.js"></script>
   <link charset="utf-8" href="./css/bootstrap-theme.css">
	 <link type="text/css" charset="utf-8" href="./css/style.css">
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
	<style>
  body{
	
	 background:  url("image/bg1.png") repeat;
}
     #inputEmail3
     {
     background: url("image/zh.png") repeat;
     }
      #inputEmail4
     {
     background: url("image/mm.png") no-repeat;
     }
     label{
     color:white
     }
     #img{
      width:10%;
     }
     #img img{
      border-radius: 10%
     }
	</style>
  </head>
  
  <body>
  <%
   User user=new User("","");
   Cookie[] cookies=request.getCookies();
   if(cookies!=null&&cookies.length>0)
   {
   for(Cookie cookie:cookies)
   {
  
    
     if(cookie.getName().equals("name"))
     {
   
     user.setName(cookie.getValue());
    
     }
      if(cookie.getName().equals("pwd"))
     {
     user.setPwd(cookie.getValue());
     }
   }
   }
   
   
   
    
  
   %>
 <div class="container-fluid">
 
  <div class="row">
      
     <div  class="col-md-3" id="img" style="position:absolute; top:10%;left:10%">
       <img alt="" src="image/1.png" width="200" height="140">
       <img alt="" src="image/2.png" width="200" height="140">
       <img alt="" src="image/3.png" width="200" height="140">
     </div>
     
   
   
   
    <div class="col-md-4 col-md-offset-6  " style="border:1px solid #ccc;box-shadow:1px 2px 2px white; margin-top:14%;padding-top:1%"">
    
    <form class="form-horizontal" action="userLogin" method="post">
   <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
    <div class="col-sm-7">
      <input type="text" class="form-control" name="name" value='<%=user.getName() %>' id="inputEmail3"  placeholder="">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-7">
      <input type="password" class="form-control" name="pwd" value='<%=user.getPwd() %>' id="inputEmail4" placeholder="">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-6">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="auto" class="col-sm-2"> 自动登录
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">登录</button>&nbsp;&nbsp;&nbsp;
       <button type="reset" id="register" class="btn btn-default col-md-offset-3">注册</button>
    </div>
  </div>
</form> 
    
    </div>
    
  
  </div>
</div>
  
 
  
  <script type="text/javascript">
  $(function(){
    $('#register').click(function() {
    	window.location="http://localhost:8080/struts2/jsp/register.jsp";
    });
    
    setTimeout(function() {
    	$.post("uGet", {},
    	 function(data, textStatus, req) {
    		var d=JSON.parse(data);
    		
    		console.log(d[0]);
    	   
    	})
    }, 1000)
  });
   
  </script>
  </body>
</html>
