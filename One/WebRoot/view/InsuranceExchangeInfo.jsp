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
    <title>业务数据详情</title>
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/jquery.datetimepicker.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.datetimepicker.full.js"></script>

    <style>
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
	   <h5 style="padding-left: 2%">保险业务/<a href="ishow" >业务数据</a>/详细业务</h5>
	   <hr>
	  </div>
	  <div class="col-md-2">
	     <button id="back" class="btn btn-default">返回</button>
	  </div>
    
    
        
       
              
        <form action="iupdate" method="post" class="form-horizontal col-md-offset-1">

            <table class="table table-responsive">
                <tr>
                    <td>   投保人姓名: </td><td> 
                      <label><s:property value="insuranceExchange.orderName"/></label>
                    </td>
                </tr>
                <tr>
                    <td> 证件类型:</td>
                    <td>  
                    
                   <label><s:property value="insuranceExchange.orderCardType"/></label>
                    
                    </td>
                </tr>
                <tr>
                    <td> 证件号码:</td>
                    <td>
                      <label>  <s:property value="insuranceExchange.orderCardNumber"/></label>
                    </td>
                </tr>
                <tr>
                    <td> 出生日期：</td>
                    <td> 
                      <label>  <s:property value="insuranceExchange.orderBirthday"/></label>
                    </td>
                </tr>  <tr>
                <td>  性别:</td>
                <td>
                
                 
                  <label>  <s:property value="insuranceExchange.orderSex==0?'男':'女'"/></label>
                
                  </td>
            </tr> 
             <tr>
                <td>  手机号:</td>
                
                
                <td>    
                   <label>  <s:property value="insuranceExchange.orderNumber"/></label>
            </td>
            </tr>
 
             <tr>
                <td>  邮箱:</td>
                
                
                <td>    
                   <label>  <s:property value="insuranceExchange.orderEmail"/></label>
            </td>
            </tr>
 
 
           <tr>
                <td>  被保人姓名:</td>
                <td>
                         <label>  <s:property value="insuranceExchange.enjoyName"/></label>
                </td>
            </tr> 
            <tr>
                <td> 与投保人关系：</td>
                <td> 
                  <label>  <s:property value="insuranceExchange.enjoyLink"/></label>
               </td>
            </tr>
             <tr>
                <td>证件类型:</td>
                <td> 
                <label><s:property value="insuranceExchange.enjoyCardType"/></label>
             
                </td>
            </tr>  <tr>
                <td>  证件号码:</td>
                <td> 
                
                 <label><s:property value="insuranceExchange.enjoyCardNumber"/></label>
             
                </td>
            </tr>  <tr>
                <td>  出生日期：</td>
                <td> 
                    <label><s:property value="insuranceExchange.enjoyBirthday"/></label>
              </td>
             </tr>  <tr>
                <td> 性别:</td>
                <td> 
                 <label>  <s:property value="insuranceExchange.enjoySex==0?'男':'女'"/></label>
            

</td>
            </tr> 
             <tr>
                <td>  手机号:</td>
                
                
                <td>    
                   <label>  <s:property value="insuranceExchange.enjoyNumber"/></label>
            </td>
            </tr>
 
             <tr>
                <td> 邮箱:</td>
                <td> 
                
                 <label><s:property value="insuranceExchange.enjoyEmail"/></label>
               </td>
            </tr>
               

              <tr>
                <td>   保险名称:</td>
                <td>  
                <label>  <s:property value="insuranceExchange.xianName"/></label>
               </td>
            </tr>  <tr>
                <td>  开始日期:</td>
                <td> 
                 <label>  <s:property value="insuranceExchange.xianStartDate"/></label>
                 </td>
            </tr>  <tr>
                <td> 结束日期:</td>
                <td> 
                       <label>  <s:property value="insuranceExchange.xianEndDate"/></label>
              </td>
            </tr>  
            
            
             <tr>
                <td> 员工号:</td>
                <td> 
                  <label><s:property value="insuranceExchange.useNumber"/></label>
             </td>
            </tr>
             <tr>
                <td> 创建时间:</td>
                <td>  
                 <label><s:property value="insuranceExchange.createTime"/></label>
               </td>
                </tr>
               <%--  <tr>
                    
                    <td> <a href="iupdate?insuranceExchange.id=<s:property value="insuranceExchange.id"/>"><button class="btn btn-default" id="submit">去更新</button>&nbsp;</a> </td>

                    
                </tr> --%>
            </table>

        </form>


   


</div>
<script src="js/index.js"></script>
<script src="js/index1.js"></script>

</div>
</body>
</html>