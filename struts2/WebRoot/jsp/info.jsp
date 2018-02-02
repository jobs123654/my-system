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
    
    <title>仪器信息</title>
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
   <table class="table">
    <tr>
      <td>仪器快照</td>
      <td>
    
      <img src='<s:property value="product.path"/>'   alt="..." width=200 height=210 class="img-thumbnail">
     </td>
     </tr>
     <tr>
      <td>仪器编号</td>
      <td><s:property value="product.tid"/></td>
     </tr>
     <tr>
      <td>仪器名称</td>
      <td><s:property value="product.tname"/></td>
     </tr>
     <tr>
      <td>仪器型号</td>
      <td><s:property value="product.tmodel"/></td>
     </tr>
     <tr>
      <td>所属类别</td>
      <td><s:property value="product.tclassify"/></td>
     </tr>
    
     <tr>
      <td>制造商</td>
      <td><s:property value="product.taddress"/></td>
     </tr>
     <tr>
      <td>服务地址</td>
      <td>
      <s:property value="product.turl"/>
      </td>
     </tr>
     <tr>
      <td>当前状态</td>
      <td>
     
      <s:if test="product.status==false">
                  未占用
      
      </s:if>
       <s:else>
                   占用
       </s:else>
        </td>
     </tr>
   
     
     
   </table>
  </div>
  </div>
   
  </body>
  <script>
  
  </script>
</html>
