<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>update Policyholder</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
               添加 http://localhost:8080/safe/iadd?insuranceExchange.xianName=xxx&&..其它属性
               更新  http://localhost:8080/safe/iupdate?insuranceExchange.xianName=xxx&&..其它属性
               删除 http://localhost:8080/safe/idelete？insuranceExchange.id=1
               
              信息请求：http://localhost:8080/safe/igetInsuranceExchangeInfo?insuranceExchange.useNumber=1111
  <body>
  <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    
  <form action="iupdate" method="post">
  
<input type="hidden" name="insuranceExchange.id" value="1"/> 
 投保人 姓名:<input type="text" name="insuranceExchange.orderName" id="id">  <br>

  证件类型:<input type="text" name="insuranceExchange.orderCardType" id="pass">  <br>
   
    证件号码:<input type="text" name="insuranceExchange.orderCardNumber" id="name">  <br>

   出生日期：<input type="text" name="insuranceExchange.orderBirthday" id="sex">  <br>
   
   性别:<input type="text" name="insuranceExchange.orderSex" id="number">  <br>
 
 邮箱:<input type="text" name="insuranceExchange.orderEmail" id="number">  <br>
  <hr>
   保险名称:<input type="text" name="insuranceExchange.xianName" id="id">  <br>

    开始日期:<input type="text" name="insuranceExchange.xianStartDate" id="pass">  <br>
 
   结束日期:<input type="text" name="insuranceExchange.xianEndDate" id="name">  <br>

  与投保人关系：<input type="text" name="insuranceExchange.enjoyLink" id="sex">  <br>
   
  姓名:<input type="text" name="insuranceExchange.enjoyName" id="number">  <br>
 
  证件类型:<input type="text" name="insuranceExchange.enjoyCardType" id="number">  <br>
  
   
    证件号码:<input type="text" name="insuranceExchange.enjoyCardNumber">  <br>


   出生日期：<input type="text" name="insuranceExchange.enjoyBirthday" id="sex">  <br>
   
   性别:<input type="text" name="insuranceExchange.enjoySex" id="number">  <br>
 
   邮箱:<input type="text" name="insuranceExchange.enjoyEmail" id="number">  <br>
   员工号:<input type="text" name="insuranceExchange.useNumber" id="number">  <br>
   <button id="submit">更新</button>  
  </form>
   
 
 <script type="text/javascript" src="js/"></script>
   <script type="text/javascript">
   $('#getnum').click(function(){
   $.post(
   'pgetPolicyholderNum',
   {},
   function(d)
   {
   alert(d);
   }
   );
   });
   </script>
  </body>
</html>
