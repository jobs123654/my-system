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


    <style>
      table {
	 font-size: 4px
    }
    
        li{
            list-style-type: none;
        }
        
        a:hover{
            text-decoration:none;
          color: #5bc0de;
        }


    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
	   <div class="col-md-12 row">
	  <div class="col-md-10">
	   <h5>搜索结果&nbsp;&nbsp;&nbsp;共<span><s:property value="list.size()"/></span>&nbsp;条记录</h5>
	   <hr>
	  </div>
	  <div class="col-md-2">
	     <button id="back" class="btn btn-default">返回</button>
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
           <th>邮箱</th>
           
           <!-- <th>保险名称</th>
           <th>开始日期</th>
           <th>结束日期</th>
           <th>与投保人关系</th>
           <th>被保人姓名</th>
           <th>证件类型</th>
           <th>证件号码</th>
           <th>出生日期</th>
           <th>性别</th>
               <th>邮箱</th> -->
               <th>员工号</th>
                   <th>创建时间</th>
                   <th>详情</th>
                    <th>更新</th>
           </thead>
           <tbody>
             <s:iterator value="list" id="item">
               <tr> 
                <td><s:property value=" orderName"/></td>
              <td><s:property value=" orderCardType"/></td>
              <td><s:property value="orderCardNumber"/></td>
              <td><s:property value=" orderBirthday"/></td>
              <td>
                <s:if test="orderSex==0">
                男
              </s:if>
              <s:else>
              女
              </s:else>
              </td>
              <td><s:property value="orderEmail"/></td>
              
             
             
              <%-- <td><s:property value="xianName"/></td>
              <td><s:property value="xianStartDate"/></td>
              <td><s:property value="xianEndDate"/></td>
              <td><s:property value="enjoyLink"/></td>
              <td><s:property value="enjoyName"/></td>
              <td><s:property value="enjoyCardType"/></td>
              <td><s:property value="enjoyCardNumber"/></td>
              <td><s:property value="enjoyBirthday"/></td>
              <td><s:property value="enjoySex"/></td>
              <td><s:property value="enjoyEmail"/></td> --%>
             
               
               
               <td><s:property value="useNumber"/></td>
                <td><s:property value="createTime"/></td>
                 <td><a href="igetinsuranceExchangeInfo?insuranceExchange.id=<s:property value="id"/>"><span class="glyphicon glyphicon-hand-up" title="详情"></span></a></td>
                                  <td>
                                  <a href="iupdate?insuranceExchange.id=<s:property value="id"/>">
                                  <span class="glyphicon glyphicon-pencil"></span></a></td>
                
               </tr>
             </s:iterator>
           </tbody>
       </table>
       </div>
    </div>
</div>
<script src="js/index1.js"></script>
</body>
</html>