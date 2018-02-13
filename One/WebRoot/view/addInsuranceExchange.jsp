<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
 <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta http-equiv="pragma" content="no-cache"> 

     <meta http-equiv="cache-control" content="no-cache"> 

     <meta http-equiv="expires" content="0">   
    <title>万众保险业务员端</title>
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/jquery.datetimepicker.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.11.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://at.alicdn.com/t/font_234130_nem7eskcrkpdgqfr.css">
    <script src="js/jquery.datetimepicker.full.js"></script>
    <script src="js/schedule.js"></script>

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
    <header class="row">
        
 
   
   
   <div class="col-md-12 row">
   <div class="col-md-10">
	 <h5 style="padding-left: 2%">保险业务/<a href="ishow" >业务数据</a>/添加业务</h5>
   <hr>
	  </div>
	  
    <div class="col-md-2">
	     <button id="back" class="btn btn-default">返回</button>
	  </div>
   </div>
	  
        <form action="iadd" method="post" class="form-horizontal col-md-offset-1">

            <table class="table table-responsive">
                <tr>
                    <td>   投保人姓名: </td><td> <input required="required" class="form-control"type="text" name="insuranceExchange.orderName" id="id"> </td>
                </tr>
                <tr>
                    <td> 证件类型:</td>
                    <td>  
                    <select autofocus="autofocus" class="form-control" required="required"name="insuranceExchange.orderCardType">
               
                  <option value="居民身份证">居民身份证</option>
                  <option value="军官证">军官证</option>
                    <option value="士兵证">士兵证</option>
                      <option value="警官证">警官证</option>
                        <option value="其它">其它 </option>
                </select>
                    
                </tr>
                <tr>
                    <td> 证件号码:</td>
                    <td><input type="text"required="required" class="form-control" name="insuranceExchange.orderCardNumber" id="name">  </td>
                </tr>
                <tr>
                    <td>    出生日期：</td>
                    <td> <input type="text" class="form-control"required="required" name="insuranceExchange.orderBirthday" id="birthday"> </td>
                </tr>  
                
                <tr>
                <td>  性别:</td>
                <td>
                <label>男</label>
                <input  type="radio" name="insuranceExchange.orderSex" value="0">
                <label>女</label>
                   <input  type="radio" name="insuranceExchange.orderSex" value="1">
                </td>
            </tr>
            <tr>
                <td>  手机号:</td>
                <td>    <input type="text" required="required" class="form-control"name="insuranceExchange.orderNumber"</td>
            </tr> 
             <tr>
                <td>  邮箱:</td>
                <td>    <input type="text" required="required" class="form-control"name="insuranceExchange.orderEmail"</td>
            </tr>

                <tr>
                <td>   保险名称:</td>
                <td>   <input type="text" class="form-control"required="required" name="insuranceExchange.xianName" id="id"></td>
            </tr>  <tr>
                <td>  开始日期:</td>
                <td> <input type="text" class="form-control"required="required" name="insuranceExchange.xianStartDate" id="startdate"> </td>
            </tr>  <tr>
                <td> 结束日期:</td>
                <td>  <input type="text" class="form-control"required="required" name="insuranceExchange.xianEndDate" id="enddate"></td>
            </tr> 
            <tr>
            <td><hr></td>
            </tr>
            <tr>
                <td>  被保人姓名:</td>
                <td><input  class="form-control"type="text"required="required" name="insuranceExchange.enjoyName" id=""> </td>
            </tr>
             <tr>
                <td> 与投保人关系：</td>
                <td> <input type="text" class="form-control" required="required"name="insuranceExchange.enjoyLink" id="sex"> </td>
            </tr>    <tr>
                <td>证件类型:</td>
                
              
                
                <td> 
                <select autofocus="autofocus" class="form-control"required="required" name="insuranceExchange.enjoyCardType">
                <option value="居民身份证">居民身份证</option>
                  <option value="军官证">军官证</option>
                    <option value="士兵证">士兵证</option>
                      <option value="警官证">警官证</option>
                        <option value="其它">其它 </option>
                        
                </select>
                 </td>
            </tr>  <tr>
                <td>  证件号码:</td>
                <td>  <input type="text"required="required"  class="form-control" name="insuranceExchange.enjoyCardNumber">  </td>
            </tr>  <tr>
                <td>  出生日期：</td>
                <td> <input type="text" required="required" class="form-control"name="insuranceExchange.enjoyBirthday" id="birthday1"> </td>
            </tr>  <tr>
                <td> 性别:</td>
                <td>  
                <label>男</label>
                <input  type="radio"required="required" name="insuranceExchange.enjoySex" value="0">
                <label>女</label>
                   <input  type="radio"required="required" name="insuranceExchange.enjoySex" value="1">
                </td>
            </tr>
             <tr>
                <td> 手机:</td>
                <td>  <input type="text"required="required" class="form-control" name="insuranceExchange.enjoyNumber" id="number"> </td>
            </tr>
            
              <tr>
                <td> 邮箱:</td>
                <td>  <input type="text"required="required" class="form-control" name="insuranceExchange.enjoyEmail" id="number"> </td>
            </tr>
                <tr>
                    <td></td>
                    <td> <button  class="btn btn-default"id="submit">添加</button>&nbsp; <button class="btn btn-default" id="reset">取消</button></td>

                    <td></td>
                </tr>
            </table>

        </form>


    </header>


</div>
</div>

<script src="js/index.js"></script>
<script src="js/index1.js"></script>
<script type="text/javascript">
$('#birthday1,#birthday,#startdate,#enddate').datetimepicker({

    lang:"ch", //语言选择中文 注：旧版本 新版方法：$.datetimepicker.setLocale('ch');
    format:"Y-m-d",      //格式化日期
    timepicker:false,    //关闭时间选项
    yearStart:1950,     //设置最小年份
    yearEnd:2050,        //设置最大年份
    todayButton:false  //关闭选择今天按钮
});
</script>
</body>
</html>