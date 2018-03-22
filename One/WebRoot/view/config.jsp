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
   <div class="col-md-12 row">
	  <div class="col-md-3">
	   <h5>系统工具/数据库备份</h5>
	  
	    <hr> 
	  </div>
    <header class="row" style="margin-top: 10%">
        
 
   
   
                 
				 
	  
        <form action="uconfig" method="post" class="form-horizontal col-md-offset-1">

            <table class="table table-responsive">
               
                <tr>
                    <td>   Mysql用户名: </td>
                    <td> <input required="required" class="form-control"type="text" name="m_user" id="number"> </td>
                </tr>
                 <tr>
                    <td>   Mysql密码: </td>
                    <td> <input required="required" class="form-control"type="text" name="m_pwd" id="number"> </td>
                </tr>
                 <tr>
                    <td>   目标数据库: </td>
                    <td> <input required="required" class="form-control"type="text" name="m_db" id="number"> </td>
                </tr>
                <tr>
                    <td>   Mysql安装目录: </td>
                    <td> <input required="required" class="form-control"type="text" name="mysqlPath" id="number"> </td>
                </tr>
                
                <tr>
                    <td> </td>
                    <td>
                    <span class="text-primary">例如：D:\phpStudy2016\MySQL</span>
                     </td>
                </tr>
              
             
               <tr>
                    <td> 数据库备份文件的存放位置</td>
                    <td>
                    <span class="text-primary">默认 X:\xxxx\Tomcat\webapps\safeweb\db\</span>
                     </td>
                </tr>
                <tr>
                    <td> 数据定期备份</td>
                    <td>
                    <span class="text-primary">默认 自配置生效起，每7天执行1次</span>
                     </td>
                </tr>
                            <tr>
                    <td></td>
                    <td> <button  class="btn btn-default"id="submit">确认</button>&nbsp; <button class="btn btn-default" id="reset">重置</button></td>

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

$('#number').on('input',function(){
 var v=$(this).val();
 $('#pwd').val(v);
})
</script>
</body>
</html>