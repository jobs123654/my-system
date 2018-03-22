$('#logout').click(function () {
    window.location="ulogout";
});
var isOpen=false;
var clwith= $('#cl').css('width');
var mwith= $('#main').css('width');
var df= $('#df').css('width'),s=500;
$('#df').click(function () {
   if(isOpen)
   {
       $('#cl').animate({
           'width':clwith
       },s);
       $('#main').animate({
           'width':mwith
       },s);
       $('#df').animate({
           'width':df
       },s,function () {
           $('#celan').show();
       });

       isOpen=false;
   }else{
       $('#cl').animate({
           'width':'3%'
       },s);
       $('#main').animate({
           'width':'97%'
       },s);
       $('#df').animate({
           'width':'80%'
       },s);
       $('#celan').hide();
       isOpen=true;
   }

});

// $.datetimepicker.setLocale('ch');
$('.center').css('height',document.body.clientHeight*0.79);
$('.sib').click(function () {
    var e=$(this).siblings('.son');
    if(e.css('display')=='none')
    {
        $(this).siblings('.son').show(400);

        $(this).children('span').text("-");
    }else{

        $(this).siblings('.son').hide(400);
        $(this).children('span').text("+");
    }

    $(this).parent().siblings('li').find('.son').hide(400);
    $(this).parent().siblings('li').find('.sib').children('span').text(">");
});


$('.son li').click(function () {
    var url="";
   var item=$('.son li').index(this),thisItem=$('#celan li').index($(this).parent().parent());


  
   switch (thisItem+item)
   {
       case 0:
       url='cshow';
           break;
       case 1:
    	   url='ishow';
           break;
           case 6:
        	   url="uuserList";
        	   break;
       case 5:
           url="umanage"
           break;
       case 7:

           break;
       case 10:
        url="uconfig";
           break;
       case 11:
    	   url="uconfig1";
//           $.post("uconfig1", {},
//        		   function(data, textStatus, req) {
//                   alert("数据恢复成功！");
//                  })
    	   
           break;
       case 14:

           break;
       case 15:

           break;
       case 16:

           break;
       default:;
   }

   if(url!="")
   {
       $('iframe').attr('src',url);
   }
});





