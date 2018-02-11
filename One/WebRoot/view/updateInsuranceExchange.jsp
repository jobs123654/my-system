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
    <title>业务数据修改</title>
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
	   <h5 style="padding-left: 2%">保险业务/<a href="ishow" >业务数据</a>/修改业务</h5>
	   <hr>
	  </div>
	  <div class="col-md-2">
	     <button id="back" class="btn btn-default">返回</button>
	  </div>
    
    
        
       
              
        <form action="iupdate" method="post" class="form-horizontal col-md-offset-1">

            <table class="table table-responsive">
                <tr>
                    <td>   投保人姓名: </td><td> <input type="text" class="form-control" name='insuranceExchange.orderName' value='<s:property value="insuranceExchange.orderName"/>'  id="id"> </td>
                </tr>
                <tr>
                    <td> 证件类型:</td>
                    <td>  
                    
                    <select autofocus="autofocus" class="form-control" name="insuranceExchange.orderCardType">
                <s:if test="insuranceExchange.orderCardType=='居民身份证'">
                <option value="居民身份证" selected="selected">居民身份证</option>
               </s:if>
               <s:else>
                 <option value="居民身份证">居民身份证</option>
               </s:else>
               
                <s:if test="insuranceExchange.orderCardType=='军官证'">
                <option value="军官证" selected="selected">军官证</option>
               </s:if>
               <s:else>
                 <option value="军官证">军官证</option>
               </s:else>
               <s:if test="insuranceExchange.orderCardType=='士兵证'">
                <option value="士兵证" selected="selected">士兵证</option>
               </s:if>
               <s:else>
                 <option value="士兵证">士兵证</option>
               </s:else>
               <s:if test="insuranceExchange.orderCardType=='警官证'">
                <option value="警官证" selected="selected">警官证</option>
               </s:if>
               <s:else>
                 <option value="警官证">警官证</option>
               </s:else><s:if test="insuranceExchange.orderCardType=='其它'">
                <option value="其它" selected="selected">其它</option>
               </s:if>
               <s:else>
                 <option value="其它">其它</option>
               </s:else>
               
               
               
                </select>
                    
                    </td>
                </tr>
                <tr>
                    <td> 证件号码:</td>
                    <td><input type="text"  class="form-control"name="insuranceExchange.orderCardNumber" value='<s:property value="insuranceExchange.orderCardNumber"/>' id="name">  </td>
                </tr>
                <tr>
                    <td> 出生日期：</td>
                    <td> <input type="text" class="form-control"name="insuranceExchange.orderBirthday"value='<s:property value="insuranceExchange.orderBirthday"/>'  id="birthday"> </td>
                </tr>  <tr>
                <td>  性别:</td>
                <td>
                
                  <label>男</label>
                  <s:if test="insuranceExchange.orderSex==0">
                  <input  type="radio" name="insuranceExchange.orderSex" value="0" checked="checked">
                  </s:if>
                  
                  <s:else>
                      <input  type="radio" name="insuranceExchange.orderSex" value="0" >  
                  </s:else> 
                
                    <label>女</label>
                
                
                   <s:if test="insuranceExchange.orderSex==1">
                  <input  type="radio" name="insuranceExchange.orderSex" value="1" checked="checked">
                  </s:if>
                  <s:else>
                  <input  type="radio" name="insuranceExchange.orderSex" value="1" >  
                  </s:else> 
                   
                
                
                  </td>
            </tr>  <tr>
                <td>  邮箱:</td>
                <td>    <input type="text" class="form-control"name="insuranceExchange.orderEmail"  value='<s:property value="insuranceExchange.orderEmail"/>'/></td>
            </tr>

                <tr>
                <td>   保险名称:</td>
                <td>   <input type="text"class="form-control" name="insuranceExchange.xianName" value='<s:property value="insuranceExchange.xianName"/>' id="id"></td>
            </tr>  <tr>
                <td>  开始日期:</td>
                <td> <input type="text"class="form-control" name="insuranceExchange.xianStartDate"value='<s:property value="insuranceExchange.xianStartDate"/>'id="startdate"> </td>
            </tr>  <tr>
                <td> 结束日期:</td>
                <td>  <input type="text" class="form-control"name="insuranceExchange.xianEndDate" value='<s:property value="insuranceExchange.xianEndDate"/>' id="enddate"></td>
            </tr>    <tr>
                <td>  被保人姓名:</td>
                <td><input type="text" class="form-control"name="insuranceExchange.enjoyName" value='<s:property value="insuranceExchange.enjoyName"/>' id=""> </td>
            </tr> 
            <tr>
                <td> 与投保人关系：</td>
                <td> <input type="text" class="form-control"name="insuranceExchange.enjoyLink" value='<s:property value="insuranceExchange.enjoyLink"/>'" id="sex"> </td>
            </tr>
             <tr>
                <td>证件类型:</td>
                <td> 
                
                
                <select autofocus="autofocus"  class="form-control" name="insuranceExchange.enjoyCardType">
               
               <s:if test="insuranceExchange.enjoyCardType=='居民身份证'">
                <option value="居民身份证" selected="selected">居民身份证</option>
               </s:if>
               <s:else>
                 <option value="居民身份证">居民身份证</option>
               </s:else>
               
                <s:if test="insuranceExchange.enjoyCardType=='军官证'">
                <option value="军官证" selected="selected">军官证</option>
               </s:if>
               <s:else>
                 <option value="军官证">军官证</option>
               </s:else>
               <s:if test="insuranceExchange.enjoyCardType=='士兵证'">
                <option value="士兵证" selected="selected">士兵证</option>
               </s:if>
               <s:else>
                 <option value="士兵证">士兵证</option>
               </s:else>
               <s:if test="insuranceExchange.enjoyCardType=='警官证'">
                <option value="警官证" selected="selected">警官证</option>
               </s:if>
               <s:else>
                 <option value="警官证">警官证</option>
               </s:else><s:if test="insuranceExchange.enjoyCardType=='其它'">
                <option value="其它" selected="selected">其它</option>
               </s:if>
               <s:else>
                 <option value="其它">其它</option>
               </s:else>
               
               
                 
                </select>
                </td>
            </tr>  <tr>
                <td>  证件号码:</td>
                <td>  <input type="text"class="form-control" name="insuranceExchange.enjoyCardNumber" value='<s:property value="insuranceExchange.enjoyCardNumber"/>' >  </td>
            </tr>  <tr>
                <td>  出生日期：</td>
                <td> <input type="text" class="form-control"name="insuranceExchange.enjoyBirthday"value='<s:property value="insuranceExchange.enjoyBirthday"/>' id="birthday1"> </td>
            </tr>  <tr>
                <td> 性别:</td>
                <td> 
                 
             <label>男</label>
                 <s:if test="insuranceExchange.enjoySex==0">
                  <input  type="radio" name="insuranceExchange.enjoySex" value="0" checked="checked">
                  </s:if>
                  <s:else>
                <input  type="radio" name="insuranceExchange.enjoySex" value="0" >  
                  </s:else> 
                
                <label>女</label>
                  <s:if test="insuranceExchange.enjoySex==1">
                  <input  type="radio" name="insuranceExchange.enjoySex" value="1" checked="checked">
                  </s:if>
                  <s:else>
                <input  type="radio" name="insuranceExchange.enjoySex" value="1" >  
                  </s:else> 
                

</td>
            </tr> 
             <tr>
                <td> 邮箱:</td>
                <td>  <input type="text"class="form-control" name="insuranceExchange.enjoyEmail"value='<s:property value="insuranceExchange.enjoyEmail"/>'  id="number"> </td>
            </tr>
             <tr>
                <td> 员工号:</td>
                <td>  <input type="text" class="form-control"name="insuranceExchange.useNumber" value='<s:property value="insuranceExchange.useNumber"/>' id="number"> </td>
            </tr>
             <tr>
                <td> 创建时间:</td>
                <td>  <input type="text" class="form-control"name="insuranceExchange.createTime" value='<s:property value="insuranceExchange.createTime"/>'id="number"> </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <button class="btn btn-default" id="submit">更新</button>&nbsp; <button class="btn btn-default" id="reset">取消</button></td>

                    <td>
                    <input type="hidden" class="form-control"name="insuranceExchange.id" value='<s:property value="insuranceExchange.id"/>'id="number"> 
                    </td>
                </tr>
            </table>

        </form>


   


</div>
<script src="js/index.js"></script>
<script src="js/index1.js"></script>

</div>
</body>
</html>