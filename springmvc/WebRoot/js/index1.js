$('#addI').click(function(){
	window.location="view/addInsuranceExchange.jsp";
})

$('input[name=insuranceExchange]').click(function(){
	    if($(this).is(':checked')&&$('input[name=insuranceExchange]').index(this)==2)
		{
	    	$('#myModal').modal();
	    	
		}
});
var timepiker=function(e)
{
e.datetimepicker({

    lang:"ch", //语言选择中文 注：旧版本 新版方法：$.datetimepicker.setLocale('ch');
    format:"Y-m-d",      //格式化日期
    timepicker:false,    //关闭时间选项
    yearStart:1950,     //设置最小年份
    yearEnd:2050,        //设置最大年份
    todayButton:false    //关闭选择今天按钮

});	
}

$('#start,#end').click(function(){
	timepiker($(this));
})

$('#search_').click(function(){
	window.location='igetResult?queryModel.startTime='+$('#start').val()+"&&queryModel.endTime="+$('#end').val();
});
$('#search_,#close_').click(function(){
	
	$('input[name=insuranceExchange]').eq(2).attr('checked',false);
});
$('#get_result').click(function () {
	var i=null;
      	$('input[name=insuranceExchange]').each(function(e){
		  if($(this).is(":checked"))
			  {
			   i=$('input[name=insuranceExchange]').index(this);
			  }
	     });
	   if(i==null||$('#search').val()=="")
		{
		alert("查询类型和内容不得为空！");
		return false;
		}
	   
	
	var field="";
	switch(i)
	{
	case 0:
		field="insuranceExchange.orderName";
		break;
	case 1:
		field="insuranceExchange.xianName";
		break;
	case 2:
	
		break;
	}
	  window.location='igetResult?'+field+"="+$('#search').val();
	});
$('#back').click(function(){
	
	window.history.back();
});


