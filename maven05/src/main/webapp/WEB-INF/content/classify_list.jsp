<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>保险分类</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/myStyle.css" rel="stylesheet" type="text/css" media="all" />

<link href='http//fonts.googleapis.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery1.min.js"></script>
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
			       
         <form class="search" action="result_user_list" method="post">	  
				<input type="text" name="name" placeholder="关键字" class="textbox" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" style="background: url('img/search.png') no-repeat 0px 3px" value="Subscribe" id="submit" name="submit">
				<div id="response"> </div>
		 </form>
   			 </div>

			 <div class="cssmenu">
				<ul>
					<li class="active"><a href="login.html">Account</a></li> |
					<li><a href="checkout.html">Wishlist</a></li> |
					
					<li><a href="login.html">欢迎回来,
					 <c:out value="${user.name}"></c:out>
					</a></li>|
					<li><a href="logout">退出</a></li>
				</ul>
			</div>


			<div class="clear"></div>
 		</div>
 		
 		
	</div>

	
	  <div id="" style="position: relative;top: 3%;">
	  <label style="margin-left: 5%">  <a href="home">首页</a>/分类列表</label>
	  <label style="margin-left: 80%">  <a title="添加" href="show_add_classify">+</a></label>
	 </div>
		 <hr>
  
     <div class="main" style="overflow: auto;">
	  <div class="wrap">
		
		<table class="table table-bordered">
			<thead>
				<th>编号</th>
				<th>名称</th>
				<th>所属分类</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>删除</th>
				<th>修改</th>
			</thead>
           <tbody>
           	 <c:forEach items="${list }" var="i">
           	 <tr>
           	 	<td>
           	 	  <c:out value="${ i.id}"></c:out>
           	 	</td>
           	 		<td>
           	 	  <c:out value="${ i.cname}"></c:out>
           	 	</td>
           	 	<td>
           	 	  <c:out value="${ i.fid}"></c:out>
           	 	</td>
           	 		<td>
           	 	  <c:out value="${ i.uid}"></c:out>
           	 	</td>
           	 	<td>
           	 	  <c:out value="${ i.time}"></c:out>
           	 	</td>
           	 		<td>
           	 	   <a href="delete_classify?id=<c:out value="${ i.id}"></c:out>">&times</a>
           	 	</td>
           	 	</td>
           	 		<td>
           	 	   <a href="show_update_classify?id=<c:out value="${ i.id}"></c:out>">/</a>
           	 	</td>
           	 </tr>
           	 </c:forEach>
           </tbody>
		</table>
        <hr>
   
      <div style="text-align: center; position: absolute;top: 84%;left: 40%">
    
   
   
     <c:if test="${page.stop>0}">
            <c:if test="${page.current!=1 }">
			    <a href="classify_list?c=<c:out value="${page.current -1}"></c:out>"> [pre]</a>
			   </c:if>
         
             <c:forEach begin="${page.start}" end="${page.stop}" var="i">
			      <a href="classify_list?c=<c:out value="${i }"></c:out>">
			      <c:out value="${i }"></c:out>
			     </a>
			   </c:forEach>
			   
			     <c:if test="${page.current!=page.totalPage }">
 <a href="classify_list?c=<c:out value="${page.current +1}"></c:out>"> [next]</a>    
[<c:out value="${page.current }"></c:out> /<c:out value="${page.totalPage }"></c:out> ]
   </c:if>
     </c:if>
     
     
  
      </div>
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

</body>
</html>