<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据备份</title>
	
  <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/jquery-1.11.1.js"></script>
   <script type="text/javascript" src="http://10.128.121.109:8080/struts2/js/bootstrap.min.js"></script>
   <link charset="utf-8" href="http://10.128.121.109:8080/struts2/css/bootstrap-theme.css">
	
	<link rel="stylesheet" type="text/css" href="http://10.128.121.109:8080/struts2/css/bootstrap.css">
  </head>
  
  <body>
 
<div class="container-fluid">

<!-- head -->


<!-- left and right-->
  <div class="row">
  
   

<div class="panel panel-primary col-md-8" style="margin:1.3% 20%">
    <div class="panel-heading">数据备份</div>
    <div class="panel-body">
       <div class="form-horizontal">
  <div class="form-group" >
    <label for="inputEmail3" class="col-sm-2 control-label">文件名称</label>
    <div class="col-sm-8">
      <input type="text"  class="form-control" value="default" id="in" name="name" ><span id="dog" style="visibility: hidden" >用户名已注册</span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">输出位置</label>
    <div class="col-sm-8" style="position:relative">
     
       <input type="text" value="d:\root"  class="form-control" id="outpath" name="name">
       <!-- <input type="button" class="btn" id="pig" style="position:absolute;top:3.3%;left:96%" value="选择"> -->
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-3 control-label">设置自动备份时间</label>
    <div class="col-sm-8">
      <input type="checkbox" class="form-control" id="set_time">
    </div>
  </div>
  <div id="extra" style="display:none">
  <div class="form-group col-md-12">
    <label for="inputPassword3" class="col-sm-2 control-label">执行</label>
    <div class="col-sm-8">
     <select class="form-control">
     <option>每周</option>
     <option>每月</option>
    
     </select>
      
    </div>
  
   <div class="form-group col-md-12">
  
    <label for="inputPassword3" class="col-sm-2 control-label">具体在:</label>
     <div class="col-sm-8" id="ic">
     <input type="checkbox" value="1" id="">星期一&nbsp;&nbsp;
     <input type="checkbox" value="2">星期二&nbsp;&nbsp;
     <input type="checkbox"value="3" id="">星期三&nbsp;&nbsp;
     <input type="checkbox"value="4"  id="">星期四&nbsp;&nbsp;
     <input type="checkbox" value="5"id="">星期五&nbsp;&nbsp;<br>
     <input type="checkbox" value="6" id="">星期六&nbsp;&nbsp;
     <input type="checkbox" value="7">星期日&nbsp;&nbsp;&nbsp;&nbsp;
     <span class="btn text-success">00:00</span>
     <br>
    </div>
  </div>
  </div>
  
 
</div> 

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button  id="db"  class="btn btn-default">确定</button>&nbsp;&nbsp;&nbsp;
       <button type="reset" id="register" class="btn btn-default col-md-offset-3">取消</button>
      </div>
  </div>
    </div>
    <div class="panel-footer"></div>
  </div>
  
  <!-- 动画 -->
  
  <div id="dh" style="display:none;position:absolute;left:35%;top:32%;">
  <img alt="" src="image/cache.gif" width=200 height=200 style="border-radius:100px; opacity: 0.8">
  </div>
  
  </div>
  </div>
  <script type="text/javascript">
  
  $('#pig').click(function(){
  try {
 
        var Message = "\u8bf7\u9009\u62e9\u6587\u4ef6\u5939"; //选择框提示信息
        var Shell=new XMLHttpRequest("Shell.Application")
       // var Shell = new ActiveXObject("Shell.Application");
        var Folder = Shell.BrowseForFolder(0, Message, 64, 17); //起始目录为：我的电脑
        //var Folder = Shell.BrowseForFolder(0, Message, 0); //起始目录为：桌面
        if (Folder != null) {
            Folder = Folder.items(); // 返回 FolderItems 对象
            Folder = Folder.item(); // 返回 Folderitem 对象
            Folder = Folder.Path; // 返回路径
            if (Folder.charAt(Folder.length - 1) != "\\") {
                Folder = Folder + "\\";
            }
            document.getElementById(path).value = Folder;
            return Folder;
        }
    }
    catch (e) {
        alert(e.message);
    }
  
  })
 
  $(function(){
          var s="";
      	    $('#ic input[type=checkbox]').each(function(){
      	      if($(this).is(':checked'))
      	      {
      	      s+=$(this).val()+',';
      	      }
      	    });
    $('#db').click(function(){
   
         var s="";
      	    $('#ic input[type=checkbox]').each(function(){
      	      if($(this).is(':checked'))
      	      {
      	      s+=$(this).val()+',';
      	      }
      	    });
      	     $('#dh').show();
      	 
     $.post(
      "backups?filename="+$("#in").val()+"&&filepath="+$("#outpath").val()+"&&special="+s,
       {}, 
       function(data) {
      	setTimeout(function() {
      	
      if($('#set_time').is(":checked"))
     {
   
    setTimeout(function() {
    	  $('#dh').hide();
    	  alert("设置成功！");
    }, 2000);
     }
     else{
       $('#dh').hide();
     alert("备份成功");
    
     }
      		
      		
      	}, 1500);
      	    }); 
      	   
      	    
      	    
      	
    });
  
   $('#set_time').click(function() {
    
    	if($(this).is(":checked"))
    	{
    	  $("#extra").show(500);
    	}else{
    	 $("#extra").hide(500);
    	}
    })
    
    
   
    });
    </script>
  </body>
  
</html>
