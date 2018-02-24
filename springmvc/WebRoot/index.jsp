<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
form {
	margin: 20% 40%;
}
</style>
</head>
<body>
    <form  method="post" action="dog" enctype="multipart/form-data">
     <input type="file" name="dog" >
       <input type="text" name="des" >
     <input type="submit" value="click" id="click">     
    </form>
    <hr>
    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <a href="js/jquery-1.11.1.js">cc</a>
    
    <button id="request">requestJson</button>
    
    <a href="requestJson" >click</a>
 
    <script>
  $(function(){
  
  $("#request").click(function(){
   /*  $.post("requestJson",
    "name=abc",
     function(data, textStatus, req) {
    alert(data); 
    }) */
  
  
    $.ajax({
           type:'post',
          url:'${pageContext.request.contextPath}/requestJson',
         /*  contentType:"application/json;charset=utf-8", */
          data: "name=abc",
		    success:function(data)
		    {
		    alert(data);
		    },
    });
             
  
    })
    
  
    
  })
    
    </script>
</body>

</html>