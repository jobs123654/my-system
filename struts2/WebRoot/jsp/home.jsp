<%@page import="com.model.User"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>welcome</title>
	
	<script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
   <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
   <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css"/>
  <link rel="stylesheet" href="http://10.128.121.109:8080/struts2/js/jquery.contextmenu.css">
  <link href="http://10.128.121.109:8080/struts2/css/c1.css" rel="stylesheet" id="cssfile"/>  
   <style type="text/css">
   iframe{
   width:100%;
   height:100%
   }
   #left_item{
    cursor: pointer
   }
   .height,.blue{
    color:white;
   font-size: 14px;
   font-weight:400;
   }
   .height{
  
   background-color:  #1d2024 
   }
   .blue{
   
   background-color: #ccc
   }
   #info{
   border-radius: 50%;
   background-color: red;
   color:white;
   }
   
   .dog h2{
   font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
   }
   </style>
  </head>
  
  <body>
  <% 
      User user=new User();
      user=(User)request.getSession().getAttribute("user");
      //user.setName("122");
  %>
  <div class="container-fluid">
  <div class="row">
  
  <div class="col-md-12 dog" style="height:80px;padding-top:5px;" >
    <div class="col-md-4 " style="margin-left:37%"> <h2 >测绘仪器信息管理系统</h2></div>
  </div>
     <div class="panel panel-default col-md-2"style="height:84.8%" >
    <div class="panel-heading">
    
    
    </div>
    <div class="panel-body" >
    <s:property value="requests_no"/>
  <ul class="list-group" id="left_item">
   <li class="list-group-item height">系统首页</li>
  <li class="list-group-item">全部仪器</li>
  <li class="list-group-item">仪器分类</li>
 
  
  <s:if test="#session.user.role==1">
  <li class="list-group-item">仪器申请&nbsp;<span id="info"><s:property value="requests_no"/></span></li>
  <li class="list-group-item">损坏登记</li>
  <li class="list-group-item">用户列表</li> 
   <li class="list-group-item">数据备份</li> 
  
  </s:if>
  
  <s:else>
  <li class="list-group-item">申请记录</li> 
  </s:else>
 
</ul>
    </div>
    <div class="panel-footer"></div>
    
</div>

<div class="panel panel-default col-md-10"  style="height:84.8%">
    <div class="panel-heading" >
     <!--  <div class="col-md-5">
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      </div> -->
     
     <div id="mythingy" class="col-md-2 col-md-offset-9" style="margin-top:-1%;position:relative"> 
    
     <span class="glyphicon glyphicon-user" id="User" style="cursor:pointer"></span><sapn id="logout" href="" ><s:property value="#session.user.name"/>
     
     <span title="退出" style="cursor:pointer" class="col-md-offset-3 glyphicon glyphicon-triangle-right"></span></span></div>
    <input type="hidden" value=' <s:property value="#session.user.uid"/>' id="mid"/>
    <span class="glyphicon glyphicon-bell" id="bell" style="position:absolute;left:90%;top:0%;cursor:pointer;display:none"></span>
    </div>
    <div class="panel-body" style="height:500px">
        <iframe src="jsp/login_info.jsp"></iframe>
    </div>

  </div>
  
  <div class="col-md-12 dog" style="height:80px;padding-top:14px" >
    <div class="col-md-4 col-md-offset-5"> <h5> Copyright ©2017   WDY</h5></div>
  </div>
  </div>
  </div>
 
  
  <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
 
 
  <script type="text/javascript" src="js/jquery.jqprint-0.3.js"></script>
  
   <script type="text/javascript" src="js/jquery.contextmenu.js"></script>
  <script>
  
  function print()
  {
  $('iframe').jqprint();
  }
  
  $(function(){
  var w=document.body.clientHeight;
 $('#left_item li').mouseenter(function() {
 if($(this).hasClass('height'))
 {
 return;
 }
 	  $(this).addClass("blue").siblings().removeClass('blue');
 }).mouseleave(function() {
 	$('#left_item li').each(function(i, element) {
 		$(this).removeClass('blue');
 	})
 });
  $('#left_item li').click(function() {
  $(this).addClass("height").siblings().removeClass('height');
  	var index=$('#left_item li').index(this);
  	
  	if($(this).text()=="申请记录")
  	{
  	 $('iframe').attr("src","ugetRequest?uid="+$('#mid').val());
  	 return false;
  	 }
  	switch(index)
  	{
  
  	  case 0:
  	  
  	 
  	  	 $('iframe').attr("src","jsp/login_info.jsp");
  	
  	  break;
  	   case 1:
  	  $('iframe').attr("src","proList");
  	  break;
  	   case 2:
  	  $('iframe').attr("src","cClassifyList");
  	  break;
  	   case 3:
  	  $('iframe').attr("src","rRequestList");
  	  break;
  	   case 4:
  	  $('iframe').attr("src","dList");
  	  break;
  	   case 5:
  	  $('iframe').attr("src","uUserList");
  	  break;
  	    case 6:
  	  $('iframe').attr("src","backups");
  	  break;
  	 
  	}
  });
     $('#logout').click(function() {
     	window.location="userLogout";
     });
     
     $('#User').click(function(){
      $('iframe').attr("src","uEdit");
     });
     var f=true;
     var bell=null;
     
     //查询有无没有批准的申请
     var t=setInterval(function() {
     
     	$.post(
     	"rGetList",
        {},
        function(data){
        var d=JSON.parse(data);
         if(d.length>0)
         {
         console.log(d);
        if($('#bell').css('display')=='none')
     	{
     	 $('#bell').css('display','block');
     	}else{
     	$('#bell').css('display','none');
     	}
     	
   
     
         }else{
         
         $('#bell').hide();
         console.log("yes");
         clearInterval(t);
         }
        }	
     	);
     	
     }, 1300);
     
      /*  	 $('iframe').attr("src","jsp/login_info.jsp");
  	
  	  break;
  	   case 1:
  	  $('iframe').attr("src","proList");
  	  break;
  	   case 2:
  	  $('iframe').attr("src","cClassifyList");
  	  break;
  	   case 3:
  	  $('iframe').attr("src","rRequestList");
  	  break;
  	   case 4:
  	  $('iframe').attr("src","dList");
  	  break;
  	   case 5:
  	  $('iframe').attr("src","uUserList");
  	  break;
  	    case 6:
  	  $('iframe').attr("src","backups");
  	  break; */
  	  
  	  var index=0;
     $('body').contextPopup({

          title: '附加功能',

          items: [

            {
            label:'表单打印',    
             icon:'icons/shopping-basket.png',          
               action:function() { 
              var src=$('iframe').attr("src");
              
           
				window.history.pushState('forward', null, "#");
				window.history.forward(1);
			 print();	
				 
               return false;
               } 
               
               },

            {label:'动态图表', icon:'icons/receipt-text.png',             
            
               action:function() {
               
               window.history.pushState('forward', null, "#");
				window.history.forward(1);
               $('iframe').attr('src','jsp/chart01.jsp');
               } },

            {label:'系统换肤',         icon:'icons/application-monitor.png',         
            action:function() { 
            if(index=0)
            {
            changeSyle('c1');
            }
            else if(index==1)
            {
            changeSyle('c2');
            }
            else{
            changeSyle('c3');
            index=0;
            }
            
            
            index++;
            window.history.pushState('forward', null, "#");
				window.history.forward(1);
             } },
            
          ]

        });
  });
  
  function changeSyle(name){  
            css=document.getElementById("cssfile");  
            css.href=name+".css";  
            document.styleSheets[0].href='http://10.128.121.109:8080/struts2/css/'+name+".css";  
            console.log(css.href);  
         
          
        }  
    
  </script>
  
  </body>
</html>
