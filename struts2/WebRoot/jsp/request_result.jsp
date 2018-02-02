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
   
    
    
 
    
    
       <h6>查询结果&nbsp;&nbsp;共有   <s:property value="list.size()"/>  条记录</h6>
       <hr/>
       <div class="col-md-12">
 
     <table class="table table-striped">
   <thead>
   
       <th>用户账号</th>
       <th>仪器编号</th>
       <th>申请时间</th>
       <th>使用时间</th>
       <th>处理者</th>
       <th>处理时间</th>
       
       <!-- <th>glyphicon glyphicon-pencil 修改
       
       <span class="glyphicon glyphicon-cd">
         查看
       </span></th>
        <th><span class="glyphicon glyphicon-trash"></span></th> -->
        <th>删除</th>
        
       
        
   </thead>
   <tbody style="margin-left:10%">
   
   <s:iterator value="list" id="u"> 
     <tr>
     <td>
      <s:property value="user.name"/>
     </td>
     <td>
      <s:property value="request.pid"/>
     </td>
     
     <td>
      <s:property value="request.rtime"/>
     </td>
      <td>
      <s:property value="request.day"/>&nbsp;&nbsp;天
     </td>
     
      <td>
                  管理员[root]
     </td>
     <td>
     <s:property value="request.dtime"/>
     </td>
     <td><span class="glyphicon glyphicon-trash"></span></td>
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
