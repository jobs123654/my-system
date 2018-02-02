<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>产品分类</title>
	 <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
     <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
     <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	   <link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
	   
	   
	   <style type="text/css">
	   .cla{
	
	   width:10%;
	   
	   border-radius: 50%;
	   
	   float:left;
	   margin-left: 1%;
	   }
	   span{
	   cursor: pointer;
	   }
	   #addClassify{
	     position:fixed;
	     top:85%;
	     left:90%
	   }
	   </style>
  </head>
  
  <body>
    <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">仪器故障登记</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" method="post" action="dAdd">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">仪器编号</label>
    <div class="col-sm-7">
      <input type="number" name="tid" class="form-control" id="inputEmail3">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">故障说明</label>
    <div class="col-sm-7">
    <textarea rows="2" cols="40" name="msg"  class="form-control" ></textarea>
      
    </div>
  </div>
  
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">提交</button>
    </div>
  </div>
</form>
      </div>
     
    </div>
  </div>
</div>
   
   
    <div class="container-fluid">
     <div class="row">
  
           
           
           <table class="table">
           <thead>
              <th>仪器编号</th>
              <th>故障说明</th>
              <th>当前状态</th>
              <th>登记时间</th>
       
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
       
        <th>修改</th>
        <th>删除</th> 
           </thead>
           
           <tbody>
            <s:iterator value="damageRegistrations" id="u"> 
      <tr>
      <td>
     <s:property value="tid"/>
      </td>
       <td>
      <s:property value="msg"/>
      </td>
       <td>
      <s:property value="status"/>
      </td>
       <td>
      <s:property value="time"/>
      </td>
      
      
    
       <td>
       
       <a href='dUpdate?id=<s:property value="id"/> '>
        <span class="glyphicon glyphicon-pencil"></span>
       </a>
       
      </td>
       <td>
       <a href='dDelete?id=<s:property value="id"/> '>
        <span class="glyphicon glyphicon-trash"></span> 
       </a>
      
      </td>
      
      
   </tr>
   </s:iterator>
           </tbody>
           </table>
           
          
           
           <!-- 添加 -->
          
           <a class="btn"  id="addClassify" data-toggle="modal" data-target="#myModal">
            <img src="image/add.jpg" width=50 height=50 style="border-radius:50%" />
           </a>
           
         
           
          

</div>
</div>
  </body>
</html>
