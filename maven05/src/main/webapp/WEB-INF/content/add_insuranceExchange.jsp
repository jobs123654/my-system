<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>添加保单</title>
<meta name="viewport" content="widtd=device-widtd, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
  <link rel="stylesheet" href="css/jquery.datetimepicker.css">
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/myStyle.css" rel="stylesheet" type="text/css" media="all" />

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>

<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>

<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!--start slider -->
    <link rel="stylesheet" href="css/fwslider.css" media="all">
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/css3-mediaqueries.js"></script>
    <script src="js/fwslider.js"></script>
<!--end slider -->
<script src="js/jquery.easydropdown.js"></script>
</head>
<body>
     <div class="header-top">
	    <div class="wrap"> 
			  <div class="header-top-left">
			       
        <!--  <form class="search" action="" metdod="post">	  
        				<input type="text" name="s" class="textbox" value="Search" onfocus="tdis.value = '';" onblur="if (tdis.value == '') {tdis.value = 'Search';}">
        				<input type="submit" value="Subscribe" id="submit" name="submit">
        				<div id="response"> </div>
        		 </form>
         -->  
         
   				    <div class="clear"></div>
   			 </div>

			 <div class="cssmenu">
				<ul>
						<li>你好,</li> 
					<li><a >
					<c:out value="${yw.id}"></c:out>
					</a></li> |
					<li><a href="ulogout">退出</a></li>
				</ul>
			</div>


			<div class="clear"></div>
 		</div>
	</div>

	<div class="header-bottom">
	  
	</div>
	     <div class="row">
	      <label class="pull-left" style="position: relative;top: -1%;left:5% ">  <a href="index">首页</a>/添加保单</label>
	      <label class="pull-right" style="position: relative;top: -1%;right:5%" >  <a  onclick="history.back()">
	               返回
	       </a>
	      </label>
	     </div>
	     
		 <hr>
  <!-- start slider -->
   
    <!--/slider -->
     <div class="main">
	  <div class="wrap">
		
		 <form action="add_insuranceExchange" method="post" class="form-horizontal col-md-offset-1">

            <table class="table table-responsive">
                <tr>
                    <td>   投保人姓名: </td><td> <input required="required"type="text" name="orderName" id="id"> </td>
                </tr>
                <tr>
                    <td> 证件类型:</td>
                    <td>  
                    <select autofocus="autofocus" required="required"name="orderCardType">
               
                  <option value="居民身份证">居民身份证</option>
                  <option value="军官证">军官证</option>
                    <option value="士兵证">士兵证</option>
                      <option value="警官证">警官证</option>
                        <option value="其它">其它 </option>
                </select>
                    
                </tr>
                <tr>
                    <td> 证件号码:</td>
                    <td><input type="text"required="required" name="orderCardNumber" id="name">  </td>
                </tr>
                <tr>
                    <td>    出生日期：</td>
                    <td> <input type="text"required="required" name="orderBirthday" id="birthday"> </td>
                </tr>  
                
                <tr>
                <td>  性别:</td>
                <td>
                <label>男</label>
                <input  type="radio" name="orderSex" value="0">
                <label>女</label>
                   <input  type="radio" name="orderSex" value="1">
                </td>
            </tr>
            <tr>
                <td>  手机号:</td>
                <td>    <input type="text" required="required"name="orderNumber"</td>
            </tr> 
             <tr>
                <td>  邮箱:</td>
                <td>    <input type="text" required="required"name="orderEmail"</td>
            </tr>

                <tr>
                <td>   保险名称:</td>
               
                <td>   <input type="text"  value="<c:out value="${secure.name}"></c:out>" name="xianName" id="id"></td>
            </tr>  <tr>
                <td>  开始日期:</td>
                <td> <input type="text"required="required" name="xianStartDate" id="startdate"> </td>
            </tr>  <tr>
                <td> 结束日期:</td>
                <td>  <input type="text"required="required" name="xianEndDate" id="enddate"></td>
            </tr> 
            <tr>
            <td><hr></td>
            </tr>
            <tr>
                <td>  被保人姓名:</td>
                <td><input type="text"required="required" name="enjoyName" id=""> </td>
            </tr>
             <tr>
                <td> 与投保人关系：</td>
                <td> <input type="text" required="required"name="enjoyLink" id="sex"> </td>
            </tr>    <tr>
                <td>证件类型:</td>
                
             
                
                <td> 
                <select autofocus="autofocus"required="required" name="enjoyCardType">
                <option value="居民身份证">居民身份证</option>
                  <option value="军官证">军官证</option>
                    <option value="士兵证">士兵证</option>
                      <option value="警官证">警官证</option>
                        <option value="其它">其它 </option>
                        
                </select>
                 </td>
            </tr>  <tr>
                <td>  证件号码:</td>
                <td>  <input type="text"required="required"  name="enjoyCardNumber">  </td>
            </tr>  <tr>
                <td>  出生日期：</td>
                <td> <input type="text" required="required"name="enjoyBirthday" id="birthday1"> </td>
            </tr>  <tr>
                <td> 性别:</td>
                <td>  
                <label>男</label>
                <input  type="radio"required="required" name="enjoySex" value="0">
                <label>女</label>
                   <input  type="radio"required="required" name="enjoySex" value="1">
                </td>
            </tr>
             <tr>
                <td> 手机:</td>
                <td>  <input type="text"required="required" name="enjoyNumber" id="number"> </td>
            </tr>
            
              <tr>
                <td> 邮箱:</td>
                <td>  <input type="text"required="required" name="enjoyEmail" id="number"> </td>
            </tr>
                <tr>
                    <td></td>
                    <td> <button id="reset">添加</button>&nbsp; <button id="reset">取消</button></td>

                    <td></td>
                </tr>
                   <tr>
                <td></td>
                <td>  <input type="text"name="enjoyEmail" id="number"> </td>
            </tr>
            </table>

        </form>


	   <div class="clear"></div>
	</div>
	</div>
	</div>
   <div class="footer">
		
		<div class="footer-bottom">
			<div class="wrap">
	             <div class="copy" style="margin-left: 40%">
			        <p>Copyright &copy; 2018.Company name All rights reserved.<a target="_blank" href="http//www.zjf88.com/"></a></p>
		         </div>
				<div class="f-list2">
				
			    </div>
			    <div class="clear"></div>
		      </div>
	     </div>
	</div>
	<script src="js/jquery.datetimepicker.full.js"></script>
	<script src="js/index.js"></script>
	
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