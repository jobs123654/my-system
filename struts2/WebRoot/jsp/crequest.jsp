<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>申请仪器</title>
	<script type="text/javascript" src="http://localhost:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://localhost:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://localhost:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://localhost:8080/struts2/css/bootstrap.css">
	<style type="text/css">
	#addProduct{
	 position:fixed;
	 top:90%;
	 left:90%
	}
	</style>
  </head>
  
  <body>
  <div class="container-fluid">
  <div class="row">
  <div class="col-md-7" style="margin:15% 30%">
  <form class="form-horizontal" enctype="multipart/form-data" action="r_Request" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">仪器编号</label>
    <div class="col-sm-7">
    
      <input type="hidden" class="form-control" id="" value='<s:property value="#session.user.uid"/>' name="uid" >
      <input type="text" id="pid" class="form-control" name="pid" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label" >使用时间</label>
    <div class="col-sm-7">
      <input type="number" class="form-control" id="inputEmail3" name="day" >
    </div>
  </div>
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" id="dog"  class="btn btn-default">申请</button>
    </div>
  </div>
</form>
  
  
  
  
    
    
     
  </div>
  
    <%--  <button class="btn" id="addProduct">
      <span title="添加" class="glyphicon glyphicon-chevron-up"></span>
     </button> --%>
      </div>
      </div>
   
 
   <script type="text/javascript">
   $(function(){
          $('#pid').blur(function(){
         $.post(
      'proGetInfo?tid='+$(this).val(),
      {},
      function(data){
      
      console.log(data);
      var d=JSON.parse(data);
     
       if(d[0]['status']==1)
       {
       alert("当前仪器已被占用！");
      
       
       }else{
         
       }
      }
      
      
      );
    });
   });
   </script>
  </body>
</html>
