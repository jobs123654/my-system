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
    
<title>保险管理</title>
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
	 <label style="margin-left: 5%">  <a href="home">首页</a>/保险列表</label>
	  <label style="margin-left: 80%">  <a title="添加" href="show_add_secure">+</a></label>
	 </div>
	 
	 
		 <hr>
  
     <div class="main" style="overflow: auto;">
	  <div class="wrap">
		
		 <!-- private int id;
  private String name;//保险名称
  private String classify="电子";//保单类型
  private String obj;//保险对象
  private String lit;//保险期限
  
  private String  insuredage;//被保人年龄
  
  private String proclassify;//职业类别
  private String supplier;//供应商********
  private String duty;//保险责任和金额
  private String notice;//投保须知
  
  private int cid;//分类id
  
  private String  inform;//特别告知 将一下内容涵盖 -->
		
		<table class="table table-bordered">
			<thead>
				<th>编号</th>
				<th>名称</th>
				<th>保单类型</th>
				<th>保险种类</th>
				<th>保险对象</th>
				<th>保险期限</th>
				
				<th>被保人年龄</th>
				<th>供应商</th>
				<!-- <th>保险责任和金额</th>
				<th>投保须知</th>
				<th>特别告知</th> -->
				<th>详情</th>
				<th>删除</th>
				<th>编辑</th>
			</thead>
           <tbody>
           	 <c:forEach items="${list }" var="i">
           	 <tr>
           	 	<td>
           	 	  <c:out value="${ i.id}"></c:out>
           	 	</td>
           	 		<td>
           	 	  <c:out value="${ i.name}"></c:out>
           	 	</td>
           	 		<td>
           	 	  <c:out value="${ i.classify}"></c:out>
           	 	</td>
           	 		<td>
           	 	  <c:out value="${ i.cname}"></c:out>
           	 	</td>
           	 		<td>
           	 	  <c:out value="${ i.obj}"></c:out>
           	 	</td>
           	 		<td>
           	 	  <c:out value="${ i.lit}"></c:out>
           	 	</td>
           	 	</td>
           	 		<td>
           	 	  <c:out value="${ i.insuredage}"></c:out>
           	 	</td>
           	 	<td>
           	 	  <c:out value="${ i.supplier}"></c:out>
           	 	</td>
           	 	<%-- <td>
           	 	  <c:out value="${ i.duty}"></c:out>
           	 	</td>
           	 	<td>
           	 	  <c:out value="${ i.notice}"></c:out>
           	 	</td>
           	 	<td>
           	 	  <c:out value="${ i.inform}"></c:out>
           	 	</td>
           	 	 --%>
             	
           	 
           	 		<td>
           	 	   <a href="show_secure_info?id=<c:out value="${ i.id}"></c:out>">*</a>
           	 	</td>
           	 	</td>
           	 		<td>
           	 	   <a href="delete_secure?id=<c:out value="${ i.id}"></c:out>">&times</a>
           	 	</td>
           	 	</td>
           	 		<td>
           	 	   <a href="show_update_secure?id=<c:out value="${ i.id}"></c:out>">/</a>
           	 	</td>
           	 </tr>
           	 </c:forEach>
           </tbody>
		</table>
        <hr>
      <div style="text-align: center; position: absolute;top: 84%;left: 40%">
    
   
   
     <c:if test="${page.stop>0}">
            <c:if test="${page.current!=1 }">
			    <a href="secure_list?c=<c:out value="${page.current -1}"></c:out>"> [pre]</a>
			   </c:if>
         
             <c:forEach begin="${page.start}" end="${page.stop}" var="i">
			      <a href="secure_list?c=<c:out value="${i }"></c:out>">
			      <c:out value="${i }"></c:out>
			     </a>
			   </c:forEach>
			   
			     <c:if test="${page.current!=page.totalPage }">
 <a href="secure_list?c=<c:out value="${page.current +1}"></c:out>"> [next]</a>    
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