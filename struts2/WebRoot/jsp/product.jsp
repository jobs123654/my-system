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
    
    <title>全部产品</title>
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
	<style type="text/css">
	.addProduct{
	 position:fixed;
	 top:85%;
	 left:90%
	}
	</style>
  </head>
  
  <body>
  <div class="container-fluid">
  <div class="row">
  
  
  <div class="col-md-12">
    <di class="row">
     <s:iterator value="list" id="u"> 
       <div class="col-md-2">
    
    <div class="thumbnail">
      <img src= '<s:property value="path" />' alt="...">
      <div class="caption">
        <h6>
        <s:property value="tid"/> <s:property value="tname"/>
        </h6>
       
        <p><a href='proInfo?tid=<s:property value="tid"/>' class="btn btn-primary" role="button">详细信息>></a> </p>
      </div>
    </div>
  </div>
    </s:iterator> 
    </di>
   
  
  <div class="" style="position:fixed;left:40%;top:80%">
  <nav class="col-md-5 col-md-offset-8" >
     
</nav>
  </div>
  </div>
  
     <s:if test="#session.user.role==1">
     <a href="proAdd" class="btn addProduct">
      <img src="image/add.jpg" width=50 title="添加" height=50 style="border-radius:50%"/>
     </a> 
     </s:if>
     <s:else>
      <a href="r_Request" class="btn addProduct">
      <img src="image/add.jpg" width=50 title="申请" height=50 style="border-radius:50%"/>
     </a> 
     </s:else>
      </div>
      </div>
   
   <script type="text/javascript">
   $(function(){
    $('.glyphicon-trash').click(function(){
       setTimeout(function(){
        window.location="http://10.128.121.109:8080/struts2/proList";})
    },1000);
    
   
   /*  $('#addProduct').click(function() {
    	window.location="http://10.128.121.109:8080/struts2/proAdd";
    }) */
   });
   </script>
   
  </body>
</html>
