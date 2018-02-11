<%@page import="com.tool.Tool"%>
<%@page import="com.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/login.css" type="text/css" rel="stylesheet" />
<script src="js/jquery-1.11.1.js"></script>
<title>万众保险业务员端</title>
</head>
<body>
<%
User user=new User();

Cookie []cookies=Tool.getHttpServletRequest().getCookies();

for(Cookie c:cookies)
{
  if(c.getName().equals("number"))
  {
    user.setUseNumber(c.getValue());
  }
  if(c.getName().equals("password"))
  {
    user.setUserPassword(c.getValue());
  }
}

 %>
  <div class="box1">
    <div class="box2">
      <h1>万众保险业务员端</h1>
      <form action="ulogin" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="30%" align="right">工号：</td>
    <td width="40%"><input name="user.useNumber" type="text" value="<%=user.getUseNumber()==null?"":user.getUseNumber() %>" class="box_inp1"/></td>
    <td width="30%"></td>
  </tr>
  <tr>
    <td align="right">密码：</td>
    <td><input name="user.userPassword" type="password" value="<%=user.getUserPassword() ==null?"":user.getUserPassword() %>"  class="box_inp1"/></td>
    <td><input name="user.isRemember" id="re" type="checkbox"  
    style="float:left; display:inline; margin-top:9px; margin-right:3px"/>
    &nbsp;记住密码</td>
  </tr>
 
   
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" name="button" id="button" value="提交" class="subbtm"/></td>
     <td><input type="button" name="register" id="register" value="注册" class="subbtm"/></td>
    <td>&nbsp;</td>
     <td>&nbsp;</td>
  </tr>
  <tr id="tish" style="display: none;">
  <td></td>
  <td>请持有效证件去现场办理</td>
  </tr>
</table>
      </form>
    </div>
    </div>
<script type="text/javascript">



$('#register').click(function(){

   $("#tish").show();
   setTimeout(function() {
   	  $("#tish").hide();
   }, 3000)
});
</script>
</body>

</html>
