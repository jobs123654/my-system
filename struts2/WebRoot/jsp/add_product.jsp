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
    
    <title>添加仪器</title>
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
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
  <div class="col-md-12">
  <form class="form-horizontal" enctype="multipart/form-data" action="proAdd" method="post">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">仪器编号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="" name="tid" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label" >仪器名称</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="tname" >
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label" >仪器型号</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="tmodel" >
    </div>
  </div>
  
 <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label" >所属类型</label>
    <div class="col-sm-10">
    <select  class="form-control" name="tclassify">
     <option>请选择类型</option>
    <s:iterator value="classifyList">
     <option>
     <s:property value="cname"/>
     </option>
    </s:iterator>
    
      
     
     
     
      </select>
    </div>
  </div>
   <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label" >简介</label>
    <div class="col-sm-10">
      <textarea type="text" name="tcontent" class="form-control" cols="30" rows="5" id="inputEmail3" >
      </textarea>
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">上传图片</label>
    <div class="col-sm-10">
      <input type="file" name="tpath" class="form-control" id="inputEmail3" >
    </div>
  </div>
  
  <!-- <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">当前状态</label>
    <div class="col-sm-10">
       <label class="col-sm-2 control-label">未占用</label>
    </div>
  </div> -->
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">制造商</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="taddress" >
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">访问</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="turl" >
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">添加</button>
    </div>
  </div>
</form>
  
  
  
  
    
    
     
  </div>
  
    <%--  <button class="btn" id="addProduct">
      <span title="添加" class="glyphicon glyphicon-chevron-up"></span>
     </button> --%>
      </div>
      </div>
   
 
   
  </body>
</html>
