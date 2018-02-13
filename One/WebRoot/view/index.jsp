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
        a{
            color:white;
        }
        a:hover{
            text-decoration:none;
          color: #5bc0de;
        }
        a:visited{
          color: #ccc;
        }
        .center:first-child,header,footer{
            background-color: #3c7fb5;
        }
        .center:last-child,header{
            color: white;
        }
       .row,.center{
           
        }
       
        header, footer
        {
            height: 60px;
            line-height: 60px;
        }
        
        .center{
            height: 560px;
        }
        .son{
            display: none;
        }
        iframe{
            width: 100%;
            height: 100%;
        }
 .sib{
 font-size:1.5em
 }
 .son a{
 font-size:1.1em
 }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <header class="col-md-12">


            <h3 class="col-md-3" style="vertical-align:center;margin-top: 1%;margin-left: 1%" ><span><img alt=""width="10%" height="10%" src="img/logo.png"> </span>万众保险</h3>
            <table class="pull-left col-md-offset-7 " >
                <tr>

                    <td> <span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;欢迎<s:property value="#session.user.useNumber"/> 登录</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;&nbsp;&nbsp;</td>
                    <td><span class=" glyphicon glyphicon-off" id="logout" style="cursor: pointer"></span>退出</td>


                </tr>
            </table>
        </header>
    </div>
    <div class="row">
        <!--侧栏-->
        <div  id="cl" class="col-md-2 pull-left center row" >
            <ul id="celan"  class="col-md-8  center-block" style="text-align: center;vertical-align: center;margin-top: 40%">
                <li ><a href="#" onclick="return false" class="btn sib"> 保险管理 <span>+ </span></a>

                    <ul class="son">
                        <li > <a class="btn" href="#" onclick="return false">保险名录</a></li>
                        <li ><a class="btn"href="#" onclick="return false">业务数据</a></li>
                        
                    </ul>
                </li>
                <%-- <li><a onclick="return false" href="#" class="sib">员工管理 <span>  ></span></a>

                    <ul class="son">
                        <li><a  onclick="return false"href="#">11111111</a></li>
                        <li><a href="#" onclick="return false">11111111</a></li>
                        <li><a href="#" onclick="return false">11111111</a></li>
                    </ul>
                </li>
                <li><a href="#" class="sib" onclick="return false">其它管理 <span> ></span></a>

                    <ul class="son">
                        <li><a href="#"onclick="return false">11111111</a></li>
                        <li><a href="#"onclick="return false">11111111</a></li>
                        <li><a href="#"onclick="return false">11111111</a></li>
                    </ul>
                </li> --%>


            </ul>
            <hr  class="col-md-0 pull-right" id="df"  style="width: 5%;cursor: pointer; height: 90%; background-color: #ccc">
        </div>
        <!--主面板-->
       
            <iframe  class="col-md-10 pull-right center" id="main" src="view/welcome.jsp"></iframe>

    </div>
    <div class="row">
        <footer class="col-md-12"></footer>
    </div>
</div>

<script src="js/index.js"></script>
</body>
</html>