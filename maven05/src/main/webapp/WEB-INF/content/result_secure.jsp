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
    
<title>筛选结果</title>
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
 
	
	
	<div class="row">
	    
	      
	      <label  class="pull-left" style="position: relative;top: -1%;left:5% ">  <a href="index">首页</a>/筛选结果&nbsp; 
 <c:out value="${sum}"></c:out>
   记录</label>
	      <label class="pull-right" style="position: relative;top: -1%;right:5%" >  <a  onclick="history.back()">
	               返回
	       </a>
	      </label>
	     </div>
		 <hr>
  
     <div class="main">
	  <div class="wrap">
		
		 <ul class="row list-group">
		       <c:forEach items="${list }" var="s" >
		            
          <li class="list-group-item row" >
           <a class="pull-left" ><c:out value="${s.name}"></c:out></a>&nbsp;
           
        
            <a href="add_insuranceExchange?id=<c:out value="${s.id }"></c:out>" class="pull-right" >
           <span title="购买" class="glyphicon glyphicon-hand-right">    
           </span>
            </a>
          
          </li>		            
		           
		            
		            
		            	
	</c:forEach>
		       </ul>
        <hr>
   
      <div style="text-align: center;">
    
   
   
     <c:if test="${page.stop>0}">
            <c:if test="${page.current!=1 }">
			    <a href="result_user_list?c=<c:out value="${page.current -1}"></c:out>&&name=<c:out value="${user.name}"></c:out>" > [pre]</a>
			   </c:if>
         
             <c:forEach begin="${page.start}" end="${page.stop}" var="i">
			      <a href="result_user_list?c=<c:out value="${i}"></c:out>&&name=<c:out value="${user.name}"></c:out>">
			      <c:out value="${i}"></c:out>
			     </a>
			     
			   </c:forEach>
			   
			     <c:if test="${page.current!=page.totalPage }">
 <a href="result_user_list?c=<c:out value="${page.current +1}"></c:out>&&name=<c:out value="${user.name}"></c:out>"> [next]</a>    
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