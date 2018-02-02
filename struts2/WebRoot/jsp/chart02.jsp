<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
   <script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
   <script type="text/javascript" src="../js/bootstrap.min.js"></script>
   <link charset="utf-8" href="../css/bootstrap-theme.css">
   <script type="text/javascript">
   $(function(){
  
   })
   </script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:400px"></div>
   <div class="col-md-5">
  <label class="control-label">当前图表</label>
   <select class="form-control">
   <option>仪器损坏记录</option>
   <option>仪器库</option>
   
   </select>
   </div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
    <script type="text/javascript">
         $('select').bind('change', function() {
         	var v=$(this).val();
         	if(v=='仪器损坏记录'){
         	window.location='chart02.jsp';
         	}
            if (v=="仪器库")
            {
            window.location='chart01.jsp';
            }
         	
         });
    
        // 路径配置
        
        var obj=function(h,c){
        this.h=h;
        this.c=c;
        }
        obj.prototype={
        constructor: obj,
        getC:function()
        {
        return this.c;
        },
        getH:function(){
        return this.h;
        
        }
        
        };
        var h=[],c=[],con=[];
       
        var myChart = echarts.init(document.getElementById("main"));
        var month=[],data=[];
        for(var i=1;i<13;i++)
        {
        month.push(i+" 月");
        }
        
        
    setTimeout(function(){
    
    
    $.post("dDR", {}, 
    
    function(data) {
    var d=JSON.parse(data);
    
    console.log(d);
    
        for(var i=0;i<d.length;i++)
        {
        
         var o=new obj(d[i][0], d[i][1]);
         con.push(o);
        }
        
       for(var i in con)
       {
         h.push(con[i].getH());
        c.push(con[i].getC());
       }	
    
    console.log(c+" 你好");
    
    /*111  */
   
   
   
    var option = {
        title : {
            text: '仪器损坏记录图',
            
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['损坏量']
        },
        //右上角工具条
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : month
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value} 件'
                }
            }
        ],
        series : [
            {
                name:'损坏量',
                type:'line',
                data:c,
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        
                        {type : 'min', name: '最小值'}
                    ]
                },
                
            },
           /*  {
                name:'最低气温',
                type:'line',
                data:[1, -2, 2, 5, 3, 2, 0],
                markPoint : {
                    data : [
//                        {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                        {type : 'min', name: '周最低'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均值'}
                    ]
                }
            } */
        ]
    };

    // 为echarts对象加载数据
    myChart.setOption(option);
   
   
    })
    
    /* 222 */
    },300);
    
    
    
        
    </script>
</body>