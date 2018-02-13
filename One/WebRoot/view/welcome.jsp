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
       
       
       
       
       <div class="jumbotron" style="margin-top:14%">
		  <h1>您好!</h1>
		 
		<h2 class="center-block">欢迎登录万众保险业务员端</h2>
</div>
    </div>
</div>

<script src="js/index.js"></script>
</body>
</html>