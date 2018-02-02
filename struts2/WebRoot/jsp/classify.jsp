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
    
     <title>仪器分类</title>
	 <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
     <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
     <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	   <link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
	   <style type="text/css">
	   .cla{
	   background: ;
	   
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
   
   
    <div class="container-fluid">
     <div class="row">
    
    <h6 style="margin-left:1% ">仪器分类</h6>
        <hr/>
         
           
           
           <s:iterator value="classifies">
           <div class="cla col-md-offset-2" >
          <a>
           <div class="thumbnail">
            <label>类别号:<s:property value="cid"/>  </label><br/>
            <label>名称:<s:property value="cname"/></label><br/>
              <label>说明:<s:property value="content"/></label><br/>
           <s:if test="#session.user.role==1">
            <label><a href='cUpdate?cid=<s:property value="cid"/>' ><span class="glyphicon glyphicon-pencil"></span></a> &nbsp;&nbsp;<a href="cDelete?cid=<s:property value="cid"/>"><span  class="glyphicon glyphicon-remove"></span></a></label>
           </s:if>
             </div>
           </a>
           </div>
           </s:iterator>
           
           <!-- 添加 -->
            <s:if test="#session.user.role==1">
              <a class="btn" id="addClassify"  data-toggle="modal" data-target="#myModal">
            <img src="image/add.jpg" width=50 height=50 style="border-radius:50%" />
           </a>
            </s:if>
         
           
           <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加类别</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" method="post" action="cAdd">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">编号</label>
    <div class="col-sm-10">
      <input type="number" name="cid" class="form-control" id="inputEmail3">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">名称</label>
    <div class="col-sm-10">
      <input type="text" name="cname" class="form-control" id="inputPassword3" >
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">说明</label>
    <div class="col-sm-10">
    <textarea rows="2" cols="20" name="content" class="form-control" ></textarea>
      
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">确认</button>
    </div>
  </div>
</form>
      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-primary">确认</button>
        
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        
      </div> -->
    </div>
  </div>
</div>
<div class="" style="position:fixed;left:40%;top:88%">
    <form class="form-inline" action="cResult" method="post">
  <div class="form-group col-md-5" >
      <button style="position:fixed;left:59%;top:88%;" type="submit" class="btn btn-default">查询</button>
     <input type="text" class="form-control" name="cname"  id="exampleInputName2" placeholder="分类名称" style="float:left">
     
     
  </div>
 
</form>
  </div>

</div>
</div>
  </body>
</html>
