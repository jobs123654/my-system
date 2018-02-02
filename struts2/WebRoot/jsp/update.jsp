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
    
    <title>修改信息</title>
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
   
   
   <div class="col-md-12">
  <form class="form-horizontal" enctype="multipart/form-data" action="proUpdate" method="post">
  <table class="table">
    <tr>
     
     
     
     <tr>
      <td>仪器编号</td>
      <td><input type="text" class="form-control"  value='<s:property value="product.tid" />' name="tid"/></td>
     </tr>
     <tr>
     
     
    
     
      <td>仪器名称</td>
      <td><input type="text" class="form-control" value='<s:property value="product.tname" />' name="tname" /></td>
     </tr>
     <tr>
      <td>仪器型号</td>
      <td> <input type="text"class="form-control"  value='<s:property value="product.tmodel"/>' name="tmodel"/></td>
     </tr>
     <tr>
      <td>所属类别</td>
      <td>
       <select  class="form-control" name="tclassify">
       
      
         <s:iterator value="classifyList">
         <option>
            <s:property value="cname"/>
         </option>
    </s:iterator>
      </select>
       </td>
     </tr>
    
     <td>当前图片</td>
      <td>
    
      <img src='<s:property value="product.path"/>'  alt="..." width=200 height=210 class="img-thumbnail">
     </td>
     </tr>
    
     <tr>
      <td>重新上传图片</td>
      <td><input class="form-control" class="form-control" type="file" name="tpath" value='<s:property value="product.tid"/>'/>
      <input class="form-control" class="form-control" type="hidden" name="path" value='<s:property value="path"/>'/>
      </td>
     </tr>
     <tr>
     <tr>
      <td>制造商</td>
      <td><input class="form-control"  type="text" value='<s:property value="product.taddress"/>' name="taddress" />  </td>
     </tr>
     <tr>
      <td>服务地址</td>
      <td>
      <input class="form-control" type="text" value='<s:property value="product.turl"/>' name="turl" />
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
