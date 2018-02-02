<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
	
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
   <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
   <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
  </head>
  
  <body>
 
<div class="container-fluid">

<!-- head -->


<!-- left and right-->
  <div class="row">
  
   

<div class="panel panel-primary col-md-8" style="margin:10% 20%">
    <div class="panel-heading">欢迎注册</div>
    <div class="panel-body">
       <form class="form-horizontal" action="userRegister" method="post">
  <div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
    <div class="col-sm-8">
      <input type="text"  class="form-control" id="inputEmail3"name="name" ><span id="dog" style="visibility: hidden" >用户名已注册</span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-8">
      <input type="password" class="form-control" name="pwd" id="inputPassword4">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
    <div class="col-sm-8">
      <input type="password" class="form-control" id="inputPassword5" placeholder="">
      <span id="msg" style="display: none" >两次密码不一致</span>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button id="btn" type="submit" class="btn btn-default">注册</button>&nbsp;&nbsp;&nbsp;
       <button type="reset" id="register" class="btn btn-default col-md-offset-3">取消</button>
    </div>
  </div>
</form> 
    </div>
    <div class="panel-footer"></div>
  </div>
  
  </div>
  </div>
  <script type="text/javascript">
  $(function(){
    
    $('input[name=name]').blur(function() {
    var v=$(this).val();
    	$.post("uGet", {},
    	 function(data, textStatus, req) {
    		var d=JSON.parse(data);
    		console.log(d[0].name);
    		for(var i=0;i<d.length;i++)
    		{
    		  if(v==d[i].name)
    		  {
    		  
    		   $("#dog").css("visibility","visible");
    		   
    		   
    		  }
    		  else{
    		  
    		  $("#dog").css("visibility","hidden");
    		   
    		  }
    		  
    		}
    	
    	   
    	});
    	});
    	
    	
    	$('#inputPassword5').bind("input",function() {
    		var v=$(this).val(),v1=$("#inputPassword4").val();
    		if(v!=v1){
    		$('#msg').show();
    		}else
    		{
    	   
    		$('#msg').hide();
    		}
    		
    	})
    	$('#register').click(function(){
    	window.history.back();
    	});
    });
    </script>
  </body>
  
</html>
