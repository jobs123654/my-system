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
    
    <title>修改类别信息</title>
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <div class="container-fluid">
  <div class="row">
   <s:debug></s:debug>
   
   <div class="col-md-12">
  <form class="form-horizontal" enctype="multipart/form-data" action="cUpdate" method="post">
  <table class="table">
    <tr>
     
     
     
     <tr>
      <td>编号</td>
      <td><input type="text" class="form-control"  value='<s:property value="classify.cid" />' name="cid"/></td>
     </tr>
     <tr>
     
     
    
     
      <td>名称</td>
      <td><input type="text" class="form-control" value='<s:property value="classify.cname" />' name="cname" /></td>
     </tr>
     
     <tr>
      <td>备注</td>
      <td>
      <textarea rows="3" cols="20" name="content" >
     <s:property value="classify.content" />
     
       </textarea>
    
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
  
  </script>
</html>
