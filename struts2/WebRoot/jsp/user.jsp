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
    <title>用户列表</title>
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
   
       <th>ID</th>
       <th>账号</th>
       <th>密码</th>
       <th>角色</th>
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
        <th>注册时间</th>
       
        <th>删除</th>
        
   </thead>
   <tbody style="margin-left:10%">
   
   <s:iterator value="users" id="u"> 
      <tr>
      <td>
            <s:property value="uid"/>
      </td>
       <td>
      <s:property value="name"/>
      </td>
      
       <td>
      <s:property value="pwd"/>
       </td>
        <td>
        <s:if test="role==0">
                   用户     
        </s:if>
      <s:else>
      管理员
      </s:else>
       </td>
       
        <td>
      <s:property value="rtime"/>
       </td>
       <td>
       <s:if test="uid==1">
        <a disabled="true"  title="删除需谨慎！"><span class="glyphicon glyphicon-remove"></span></a>
       </s:if>
       <s:else>
        <a disabled="true" href='uDelete?uid=<s:property value="uid"/> ' title="删除需谨慎！"><span class="glyphicon glyphicon-remove"></span></a>
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
    if(confirm("你确定要删除该用户吗？删除用户后其相关数据也会被删除。"))
    {
    
       
     setTimeout(
     function(){
               window.location="http://10.128.121.109:8080/struts2/proList";}) 
    },1000);
    
    }
      
   
   /*  $('#addProduct').click(function() {
    	window.location="http://10.128.121.109:8080/struts2/proAdd";
    }) */
    
    })
   });
   </script>
   
  </body>
</html>
