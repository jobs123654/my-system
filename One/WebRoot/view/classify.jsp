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
       
       <div class="col-md-5 col-md-offset-3" style="margin-top: 4%" >
       <label>业务类型</label>
           <select class="form-control " id="s1">
            <option value="1">产险</option>
            <option value="2">寿险</option>
        </select>
        <br>
        <br>
        
          <label>一级分类</label>
        <select class="form-control" id="s2">
        
          <s:iterator value="list" id="item">
              <option value='<s:property value="#item.id"/>'> 
                <s:property value="#item.cname"/>
               </option>          
          </s:iterator>
        </select>
        <br>
        <br>
        <label>二级分类</label>
        <select id="s3" class="form-control" >
          
        </select>
        
        <br>
        <br>
         <label>三级分类</label>
        <select id="s4" class="form-control" >
          
        </select>
       </div>
        
    </div>
</div>

<script src="js/index.js"></script>
<script type="text/javascript">
function addData(param,o)
{
 
 $.post("cgetClassifyInfo?"+param,
  {}, 
 function(data, textStatus, req) {
   
    
     var d=JSON.parse(data);
     console.log(d.length)
     $(o).find('option').remove();
     for(var i in d)
     {
        var o1=$("<option value='"+d[i].id+"' >"+d[i].cname+"</option>");
       
       $(o).append(o1);
      
     } 
 })
 
}
  $('#s1').bind("change",function(){
    var v=$(this).val();
 
    addData("classify.intro="+v, "#s2");
  $('#s4,#s3').find('option').remove();
    //alert($('#s2 option:selected').val())
    //addData("classify.fid="+$('#s2 option:selected').val(), "#s3");
    
  });
  
  $('#s2').bind("change",function(){
 var v=$(this).val();
   addData("classify.fid="+v, "#s3");
  $('#s4').find('option').remove();
   // addData("classify.fid="+$('#s3').val(), "#s4");
     
  });
  
   $('#s3').bind("change",function(){
 var v=$(this).val();
  addData("classify.fid="+v, "#s4");

  });
</script>
</body>
</html>