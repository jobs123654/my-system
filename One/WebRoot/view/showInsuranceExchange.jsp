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
	   <h5>保险业务/业务数据</h5>
	  
	    <hr> 
	  </div>
	  <div class="col-md-7">
	       <form action="igetResilt" method="post" class="form-inline">
	<div class="form-group">
    
    投保人姓名<input type="radio" class="form-control"name="insuranceExchange" id="exampleInputPassword3" placeholder="">
   保险名称 <input type="radio" class="form-control" name="insuranceExchange" id="exampleInputPassword3" placeholder="">
    创建时间<input type="radio" class="form-control" name="insuranceExchange" id="exampleInputPassword3" placeholder="">
  </div>
	       <div class="form-group">
   
    <input type="email" class="form-control" id="search" placeholder="保险名称/投保人姓名">
  </div>
  
  
  <button type="button" id="get_result"  class="btn btn-default">查询</button>
	       </form>
	  </div>
	  <div class="col-md-2">
	     <button id="addI" class="btn btn-default">添加业务</button>
	  </div>
	  
   </div>
     
       <div class="col-md-12">
       <table class="table " >
           <thead>
           <th>投保人姓名</th>
           <th>证件类型</th>
           <th>证件号码</th>
           <th>出生日期</th>
           <th>性别</th>
            <th>手机号</th>
           <th>邮箱</th>
           
           
          <!--  <th>被保人姓名</th>
           <th>与投保人关系</th>
          
           <th>证件类型</th>
           <th>证件号码</th>
           <th>出生日期</th>
           <th>性别</th>
               <th>邮箱</th>
               
           <th>保险名称</th>
           <th>开始日期</th>
           <th>结束日期</th>
            -->
               <th>员工号</th>
                   <th>创建时间</th>
                   <th>详情</th>
                     <th>更新</th>
                      <th>下载</th>
           </thead>
           <tbody>
             <s:iterator value="list" id="item">
               <tr> 
                <td><s:property value=" orderName"/></td>
              <td><s:property value=" orderCardType"/></td>
              <td><s:property value="orderCardNumber"/></td>
              <td><s:property value="orderBirthday"/></td>
            
              <td>
                <s:if test="orderSex==0">
                男
              </s:if>
              <s:else>
              女
              </s:else>
              </td>
                <td><s:property value="orderNumber"/></td>
              <td><s:property value="orderEmail"/></td>
              
             
             
           <%--    <td><s:property value="enjoyName"/></td>
              <td><s:property value="enjoyLink"/></td>
              
              <td><s:property value="enjoyCardType"/></td>
              <td><s:property value="enjoyCardNumber"/></td>
              <td><s:property value="enjoyBirthday"/></td>
              <td>
              <s:if test="enjoySex==0">
                男
              </s:if>
              <s:else>
              女
              </s:else>
              </td>
              <td><s:property value="enjoyEmail"/></td>
             
              <td><s:property value="xianName"/></td>
              <td><s:property value="xianStartDate"/></td>
              <td><s:property value="xianEndDate"/></td>
               --%>
             
             
               
               <td><s:property value="useNumber"/></td>
                <td><s:property value="createTime"/></td>
                
                 <td><a href="igetinsuranceExchangeInfo?insuranceExchange.id=<s:property value="id"/>"><span class="glyphicon glyphicon-hand-up" title="详情"></span></a></td>
<td><a href="iupdate?insuranceExchange.id=<s:property value="id"/>"><span  class="glyphicon glyphicon-pencil"></span></a></td>

 
<td><a href="idownLoad?insuranceExchange.id=<s:property value="id"/>"><span  class="glyphicon glyphicon-download-alt"></span></a></td>
                 
               </tr>
             </s:iterator>
           </tbody>
       </table>
       
       
       <div class="col-md-5 col-md-offset-4" style="position: fixed;top: 93%" id="page">
           <label>第&nbsp;<s:property value="pageManage.currentpage"/>&nbsp;页</label>
           <s:if test="%{pageManage.currentpage!=1}">
              <a href="igetInfo?pageManage.currentpage=<s:property value="pageManage.currentpage-1"/>"> <button class="btn">上一页</button></a>
           </s:if>
           
           <s:bean name="org.apache.struts2.util.Counter" id="c">
             <s:param name="first" value="1"></s:param>
                  <s:param name="last" value="pageManage.totalpage"></s:param>
             <s:iterator status="s">
           
               <s:if test="%{#s.getIndex()>pageManage.currentpage-3&&#s.getIndex() <pageManage.currentpage+2}">
               <a href="igetInfo?pageManage.currentpage=<s:property/>"><button class="btn"><s:property/></button> </a> 
               </s:if>
               
             </s:iterator>
           </s:bean>
           <s:if test="%{pageManage.currentpage!=pageManage.totalpage}">
           <a href="igetInfo?pageManage.currentpage=<s:property value="pageManage.currentpage+1"/>"> <button class="btn">下一页</button></a>
           </s:if>
           <label>共&nbsp;<s:property value="pageManage.totalpage"/>&nbsp;页</label>
       </div>
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