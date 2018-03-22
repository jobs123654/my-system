<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
 <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>万众保险业务员端</title>
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/jquery.datetimepicker.css">
    
    <script src="js/jquery.datetimepicker.full.js"></script>

    <style>
        li{
            list-style-type: none;
        }
        
        a:hover{
            text-decoration:none;
          color: #5bc0de;
        }
        table {
	font-size: 0.5em
}

    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
	   <div class="col-md-12 row">
	  <div class="col-md-3">
	   <h5>员工管理/员工列表</h5>
	  
	    <hr> 
	  </div>
	  <div class="col-md-7">
	      
	  </div>
	  
	  
   </div>
     
       <div class="col-md-12">
       <table class="table " >
           <thead>
           <th>工号</th>
           <th>密码</th>
           <th>删除</th>
           <th>修改</th>
           
           </thead>
           <tbody>
             <s:iterator value="list" id="item">
               <tr> 
            
                <td><s:property value="useNumber"/></td>
               <td><s:property value="userPassword"/></td>
               
                 <td><a href="udeleteEmployee?user.id=<s:property value="id"/>"><span class="glyphicon glyphicon-trash" title="删除"></span></a></td>
<td><a href="uupdateInfo?user.id=<s:property value="id"/>"><span title="更新" class="glyphicon glyphicon-pencil"></span></a></td>

                 
               </tr>
             </s:iterator>
           </tbody>
       </table>
       
       
      
       </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close"  aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">创建时间</h4>
      </div>
      <div class="modal-body">
          <form class="form-horizontal">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">时间点1</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="start" name="queryModel.startTime">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">时间点2</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="queryModel.endTime" id="end" >
    </div>
  </div>
  
  <!-- <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div> -->
</form>
      </div>
      <div class="modal-footer">
        <button type="button" id="search_" class="btn btn-primary"  data-dismiss="modal">查询</button>
        <button type="button" id="close_" class="btn btn-default" data-dismiss="modal">取消</button>
       
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script src="js/index1.js"></script>

</body>
</html>