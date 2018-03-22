<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
       
       
       
       
       <div class="col-md-5" style="margin:14% 30%">
		  <h1>
		    <img alt="" src="images/success.png" width="200" height="200">
		  </h1>
		 
		<h2 class="center-block">操作成功正在跳转...</h2>
</div>
    </div>
</div>

<script type="text/javascript">
setTimeout(function() {
 window.history.back();
}, 2000);
</script>
</body>
</html>