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
 
     <table class="table table-striped">
   <thead>
   
      <th>仪器编号</th>
       <th>仪器名称</th>
       <th>仪器型号</th>
       <th>所属类型</th>
        <!-- 
        <th>简要介绍</th>
        <th>当前状态</th>
       <th>制造商</th>
       <th>网址</th> -->
       <!-- <th>glyphicon glyphicon-pencil 修改
       
       <span class="glyphicon glyphicon-cd">
         查看
       </span></th>
       <th><span class="glyphicon glyphicon-trash"></span></th> -->
        <th>查看</th>
        <s:if test="#session.user.role==1">
        <th>修改</th>
        <th>删除</th> 
       </s:if>
       
        
   </thead>
   <tbody style="margin-left:10%">
   
   <s:iterator value="list" id="u"> 
      <tr>
      <td>
            <s:property value="tid"/>
      </td>
       <td>
      <s:property value="tname"/>
      </td>
       <td>
      <s:property value="tmodel"/>
      </td>
       <td>
      <s:property value="tclassify"/>
      </td>
       <td>
        <a href='proInfo?tid=<s:property value="tid"/> '><span class="glyphicon glyphicon-eye-open"></span></a>
      </td>
      
      <s:if test="#session.user.role==1">
       <td>
       
       <a href='proUpdate?tid=<s:property value="tid"/> '>
        <span class="glyphicon glyphicon-pencil"></span>
       </a>
       
      </td>
       <td>
       <a href='proDelete?tid=<s:property value="tid"/> '>
        <span class="glyphicon glyphicon-trash"></span> 
       </a>
      
      </td>
      </s:if>
      
   </tr>
   </s:iterator>
   </tbody>
  </table>
  
  
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
