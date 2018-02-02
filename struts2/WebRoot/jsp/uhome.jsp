<%@page import="com.model.User"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>welcome</title>
	
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
   <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
   <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
   <style type="text/css">
   iframe{
   width:100%;
   height:100%
   }
   #left_item{
    cursor: pointer
   }
   .dog{
     background-color: #1d2024 ;
      opacity: 1;
      color:white;
   }
   .dog h2{
   font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
   }
    .height,.blue{
    color:white;
   font-size: 14px;
   font-weight:400;
   }
   .height{
  
   background-color:  #1d2024 
   }
   .blue{
   
   background-color: #ccc
   }
   </style>
  </head>
  
  <body>
  <% 
      User user=new User();
      user=(User)request.getSession().getAttribute("user");
      //user.setName("122");
  %>
  <div class="container-fluid">
  <div class="row">
  <div class="col-md-12 dog" style="height:80px;padding-top:5px;" >
    <div class="col-md-4 " style="margin-left:37%"> <h2 >测绘仪器信息管理系统</h2></div>
  </div>
     <div class="panel panel-default col-md-2"style="height:84.8%" >
    <div class="panel-heading">
    
    
    </div>
    <div class="panel-body" >
    
  <ul class="list-group" id="left_item">
  <li class="list-group-item height">系统首页</li>
  <li class="list-group-item">全部仪器</li>
  <li class="list-group-item">仪器分类</li>
  <li class="list-group-item">申请记录</li> 
</ul>
    </div>
    <div class="panel-footer"></div>
    
</div>

<div class="panel panel-default col-md-10"  style="height:84.8%">
    <div class="panel-heading" >
     <!--  <div class="col-md-5">
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      </div> -->
     
     <div class="col-md-2 col-md-offset-9" style="margin-top:-1%"> 
    
     <span class="glyphicon glyphicon-user"></span><sapn id="logout" href="" ><s:property value="#session.user.name"/>
     
      <span title="退出" style="cursor:pointer" class="col-md-offset-3 glyphicon glyphicon-triangle-right"></span></span></div>
    <input type="hidden" value=' <s:property value="#session.user.uid"/>' id="mid"/>
    </div>
    <div class="panel-body" style="height:500px">
        <iframe src="jsp/login_info.jsp"></iframe>
    </div>
    
  </div>
  <div class="col-md-12 dog" style="height:80px;padding-top:14px" >
    <div class="col-md-4 col-md-offset-5"> <h5> Copyright ©2017   WDY</h5></div>
  </div>
  </div>
  </div>
  <script>
  $(function(){
  var w=document.body.clientHeight;
$('#left_item li').mouseenter(function() {
 if($(this).hasClass('height'))
 {
 return;
 }
 	  $(this).addClass("blue").siblings().removeClass('blue');
 }).mouseleave(function() {
 	$('#left_item li').each(function(i, element) {
 		$(this).removeClass('blue');
 	})
 });


  $('#left_item li').click(function() {
  $(this).addClass("height").siblings().removeClass('height');
  	var index=$('#left_item li').index(this);
  	
  	
  	switch(index)
  	{
  
  	  case 0:
  	  
  	 
  	  	 $('iframe').attr("src","jsp/login_info.jsp");
  	
  	  break;
  	   case 1:
  	  $('iframe').attr("src","proList");
  	  break;
  	   case 2:
  	  $('iframe').attr("src","cClassifyList");
  	  break;
  	   case 3:
  	$('iframe').attr("src","ugetRequest?uid="+$('#mid').val());
  	  break;
  	 
  	 
  	}
  });
     $('#logout').click(function() {
     	window.location="userLogout";
     })
  });
  </script>
  </body>
</html>
