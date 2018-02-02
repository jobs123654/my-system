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
    
    <title>申请记录</title>
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
    <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
	<style type="text/css">
	#addProduct{
	 position:fixed;
	 top:88%;
	 left:90%
	}
	.glyphicon-ok
	{
	  cursor:pointer;
	}
	#fg{
	position:fixed;
	left:59%;
	top:88%;
	}
	</style>
  </head>
  
  <body>
  <div class="container-fluid">
  <div class="row">
  
  
  <div class="col-md-12">
   
     <table class="table table-striped">
   <thead>
   
      <th>用户ID</th>
       <th>仪器ID</th>
       <th>时长</th>
       <th>申请时间</th>
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
        <th>状态</th>
         <th>删除</th>
        
   </thead>
   <tbody style="margin-left:10%">
   
   <s:iterator value="requests" id="u"> 
      <tr>
      <td>
         <s:property value="uid"/>
      </td>
       <td>
      <s:property value="pid"/>
      </td>
       <td>
      <s:property value="day"/>&nbsp;&nbsp;天
      </td>
       <td>
       
      <s:property value="rtime"/>
      </td>
       <td>
       
         <s:if test="status==0">
            <a href='rOK?id=<s:property value="id"/> '><span class="glyphicon glyphicon-ok btn" > </span></a>
            <input type="hidden"  value=' <s:property value="id"/>'/>
        
         </s:if>
         <s:else>
                     已批准
         </s:else> 
      
      </td>
      
       
       <td>
       <a href='rDelete?tid=<s:property value="id"/> '>
        <span class="glyphicon glyphicon-trash btn"></span> 
       </a>
      
      </td>
   </tr>
   </s:iterator>
   </tbody>
  </table>
  
  
  <div class="" style="position:fixed;left:40%;top:88%">
    <form class="form-inline" action="rJl" method="post">
  <div class="form-group col-md-5" >
      <button id="fg" type="submit" class="btn btn-default">查询</button>
     <input type="text" class="form-control" id="exampleInputName2" placeholder="仪器编号或用户ID" style="float:left">
     
     
  </div>
 
</form>
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
    
    /* $('.glyphicon-ok').click(function(){
      var id=$(this).siblings('input').val();
     
      $.post(
      "http://10.128.121.109:8080/struts2/rOK?id="+id,
      
       {}, 
       function(data, textStatus, req) {
      	
       })
    setTimeout(function(){
    alert("已批准");
    window.location="rRequestList";
    },2000);  
    }) */
    
    
   /*  $('#addProduct').click(function() {
    	window.location="http://10.128.121.109:8080/struts2/proAdd";
    }) */
    $('#exampleInputName2').blur(function() {
    	   var v=$('#exampleInputName2').val(),s="";
    	    if(v.length==4)
         {
        s="pid";
        }else{
       s="uid";
        }
    
    $('#exampleInputName2').attr('name',s);
    
    })
    })
    $('#fg').click(function(){
  
   
    
   });
   </script>
   
  </body>
</html>
