<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改登记信息</title>
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
    	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	form{
	margin:10% 34%
	}
	</style>
  </head>
  
  <body>
   <div class="container-fluid">
  <div class="row">
   
   <div class="col-md-12">
   <form  class="form-horizontal" enctype="multipart/form-data" action="dUpdate" method="post">
   <table class="table">
    <tr>
     
     
     
     <tr>
      <td>仪器编号</td>
      <input type="hidden" class="form-control" id="dog"  value='<s:property value="damageRegistration.id" />' name="id"/>
      <td><input type="text" class="form-control"  value='<s:property value="damageRegistration.tid" />' name="tid"/></td>
     </tr>
     <tr>
     
     
    
     
      <td>故障说明</td>
      <td>
       <textarea class="form-control" rows="3" cols="20" name="msg" >
     <s:property value="damageRegistration.msg" />
     
       </textarea>
    
      </td>
     </tr>
     
     <tr>
      <td>当前状态</td>
      <td>
      
     <select class="form-control"  name="status">
       <option>待修复</option>
       <option>已修复</option>
       
     </select>
      </td>
     </tr>
   
    
     </tr>
      <td>
     <button type="submit" class="btn btn-default">更新</button>
      </td>
     </tr>
      
     
     
      
   </table>
  
  </form>
  </div>
  </div>
  </div>
   
  </body>
  <script>
   $(function(){
  
   })
  </script>
</html>
