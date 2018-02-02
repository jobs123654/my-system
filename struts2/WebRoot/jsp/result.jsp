<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>搜索结果</title>
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
  </head>
  
  <body>
   
    <div class="container-fluid">
     <div class="row">
  
       <h6>搜索结果&nbsp;&nbsp;共有   <s:property value="result.size()"/>  条记录</h6>
       <hr/>
       <div class="col-md-12">
 
     <table class="table table-striped">
   <thead>
   
      <th>仪器编号</th>
       <th>仪器名称</th>
       <th>仪器型号</th>
       <th>所属类型</th>
       
       <!-- <th>glyphicon glyphicon-pencil 修改
       
       <span class="glyphicon glyphicon-cd">
         查看
       </span></th>
        <th><span class="glyphicon glyphicon-trash"></span></th> -->
        <th>查看</th>
        
       
        
   </thead>
   <tbody style="margin-left:10%">
   
   <s:iterator value="result" id="u"> 
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
      
      
      
   </tr>
   </s:iterator>
   </tbody>
  </table>
  
  
  <div class="" style="position:fixed;left:40%;top:80%">
 
  </div>
  </div>
       
       
     </div>
     </div>
  </body>
</html>
