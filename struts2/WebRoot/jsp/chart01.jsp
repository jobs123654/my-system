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
   <option>仪器库</option>
   <option>仪器损坏记录</option>
   </select>
   </div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
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
         	
         })
    
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
        setTimeout(function() {
        	$.post(
        'proClassify',
        {},
        function(data){
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
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                var option = {
                    tooltip: {
                        show: true
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
                    legend: {
                        data:['仪器库']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : h
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"仪器库",
                            "type":"bar",
                            "data":c
                        }
                    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
        
        
        
        
                 }
        );
        }, 10)
        
    </script>
</body>