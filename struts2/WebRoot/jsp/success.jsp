<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#warn
	{
	margin:20% 36%;
	
	}
	</style>
  </head>
  
  <body>
  <div id="warn">
   <h1>操作成功！</h1>
   <hr/>
  </div>
  </body>
  <script>
   $(function(){
    setTimeout(function() {
    	//window.location="proList";
    	window.history.back();
    },1000);
  });
  </script>
</html>
