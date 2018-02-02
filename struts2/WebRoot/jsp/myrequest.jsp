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
    
    <title>个人申请</title>
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
	<style type="text/css">
	#addProduct{
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
   <th>使用时间</th>
   <th>申请状态</th>
   <th></th>
   </thead>
   <tbody style="margin-left:10%">
   
   
   
   <s:iterator value="requests1" id="u"> 
   <tr>
   
      <td>
            <s:property value="product.tid"/>
      </td>
      
      
   
      <td>
            <s:property value="product.tname"/>
      </td>
   
      <td>
            <s:property value="request.day"/>&nbsp;&nbsp;天
      </td>
  
        
      <td>
      <s:if test="request.status==0">
             未批准
      </s:if>
      <s:else>
             已批准
      </s:else>
        
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
   
   <script type="text/javascript">
   $(function(){
    $('.glyphicon-trash').click(function(){
       setTimeout(function(){
        window.location="http://10.128.121.109:8080/struts2/proList";})
    },1000);
     $('.glyphicon-ok').click(function(){
      var id=$(this).siblings('input').val();
      
      $.post(
      "http://10.128.121.109:8080/struts2/rOK?id="+id,
      
       {}, 
       function(data, textStatus, req) {
      	
       })
    setTimeout(function(){
    alert("已批准");
    window.location="http://10.128.121.109:8080/struts2/rRequestList";
    },1300);  
    })
   /*  $('#addProduct').click(function() {
    	window.location="http://10.128.121.109:8080/struts2/proAdd";
    }) */
   });
   </script>
   
  </body>
</html>
