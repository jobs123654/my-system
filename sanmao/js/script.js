/*
   所有的居民区，学校 基本的查询
 *
 *
 *
 *
 * */

//------------------------------------------------------------------------------


$('.close').click(function () {

    $(this).parent().parent().parent().hide(100);

});
var i=0;
var t=setInterval(function () {
    if(i<=300)
    {
        $('#pro').css('width',i).text(Math.ceil((i/300)*100)+'%');
        i+=10;
    }else{
        clearInterval(t);
        $('.progress').hide();
    }
},90)



$('#query').click(function () {

    if($('#search').val()=="")
    {
        alert("请输入关键字");
        return;
    }
    var v=$('#search').val();
    markers.clearMarkers();
    if(v.indexOf('中')>-1||v.indexOf('幼儿')>-1||v.indexOf('小学')>-1)
    {
        getFeaturesBySQL('school',v);
    }else
    {
        getFeaturesBySQL("xiaoqu",v);
    }

    // clearFeatures();
    closeInfoWin();
});
/*
$('#querySchool').click(function () {

    if($('#search').val()=="")
    {
        alert("请输入关键字");
        return;
    }
    markers.clearMarkers();
    // markers.clearMarks();
    getFeaturesBySQL('school',$('#search').val());
    // clearFeatures();
    closeInfoWin();
});*/
$('#line').click(function () {
    distanceMeasure();
});
$('#area').click(function () {
    areaMeasure();
});
//划片模拟
$('#huapian').click(function () {
    // drawGeometry1();
    queryBySQL('school');
    queryBySQL('xiaoqu');
});
//学区房推荐
$('#tuijian').click(function () {
    system.searchXC=[];
    console.log(eventPoint);
    if(eventPoint==undefined)
    {
        alert("请选择学校");
        return false;
    }
    range.removeAllFeatures();
    drawCompleted(eventPoint,false,0.006);
    setTimeout(function () {
    // alert(eventPoint+"  "+system.searchXC.length);
        findClosestFacilities(eventPoint);
        $('#xuequ').find('ul').empty();
        if(system.searchXC.length>0)
        {
            for(var i in system.searchXC)
            {
                var item=system.searchXC[i];
                console.log(item);
                $('#xuequ').find('ul').append($("<li class='list-group-item'>"+item.data.NAME+"</li>"));
                $('#xuequ').show(100);//留
            }
        }

    },500);

});

//新增小区
$('#add_xq').click(function () {
    // var point= new SuperMap.Geometry.Point(0,0);
    // var pointVector = new SuperMap.Feature.Vector(point);
    // pointVector.style=style1;
    // range.addFeatures([pointVector]);

    drawPoint.activate();
});


$('#ex_school').click(function () {
    if(eventPoint==undefined)
    {
        alert("请选择学校");
        return false;
    }
    // Math.ceil(Math.random()*200+900)
    var n=prompt("请输入学校最大容量",system.getSchoolElement(eventPoint.data.NAME).num);
   var o= system.getSchoolElement(eventPoint.data.NAME);
    o.num=n;
     drawCompleted(eventPoint,true,0.08);

            setTimeout(function () {
                if(system.searchXC.length>0)
                {
                    $('#xq_list').empty();
                    $('#xq_panel').show(100);

                    for(var i in system.searchXC)
                    {
                        var item=system.searchXC[i];
                        $('#xq_list').append($('<li class="list-group-item">'+item.data.NAME+'</li>'));

                    }
                }
            },1000);
});

//学校迁址
$('#school_name').bind('input propertychange',function () {
    var o=system.getSchoolElement($(this).val());
    if(o!=null) {
        $('#rl').val(o.num);
    }
    if($(this).val()==''){
        $('#rl').val('');
    }
});
$('#ok').click(function () {

    drawSchoolPoint.activate();
});
$('#theme_school1').click(function () {

    map.addLayer(themeLayer);
    addThemeLayer();
});
$('#theme_school2').click(function () {

    map.addLayer(themeLayer1);
    addSimpleThemeLayer();
});

//----------------------------------------初始化百度地图-----------------------------------------------------------------
// D:\SuperMapiServer8C\iClient\forJavaScript\examples\images
var tileLayer,baiduLayer ,layer,vector, themeLayer,  infowin1,themeLayer1,drawLine, map ,drawCircle,drawPolygon,drawPoint,drawSchoolPoint,road, range,markers,infowin=null,eventPoint,facilityPoints =[], n = 0,style = {
        strokeColor: "#304DBE",
        strokeWidth: 1,
        pointerEvents: "visiblePainted",
        fillColor: "#304DBE",
        pointRadius: 15,
        externalGraphic: "../img/markerflag.png",

    },
    style1 = {
        strokeColor: "#304DBE",
        strokeWidth: 1,
        pointerEvents: "visiblePainted",
        fillColor: "#304DBE",
        pointRadius: 15,
        externalGraphic: "../img/markerflag_select.png",

    },style2= {
        strokeColor: "#304DBE",
        strokeWidth: 1,
        pointerEvents: "visiblePainted",
        fillColor: "#304DBE",
        pointRadius: 15,
        externalGraphic: "../img/markerbig_select.png",
    },linestyle = {
        strokeColor: "#304DBE",
        strokeWidth: 3,
        pointerEvents: "visiblePainted",
        fill: false
    };
var host = document.location.toString().match(/file:\/\//) ? "http://localhost:8090" : 'http://' + document.location.host;
// url = host + "/iserver/services/map-china400/rest/maps/China";
url = "http://localhost:8090/iserver/services/map-yang/rest/maps/map";//地图服务
url1="http://localhost:8090/iserver/services/data-yang/rest/data";//数据服务
url2="http://localhost:8090/iserver/services/transportationAnalyst-yang/rest/networkanalyst/BuildNetwork@yang";//网络分析
// url2=host+"/iserver/services/data-world/rest/data";

function init() {

    document.getElementById('map').style.height=window.innerHeight+"px";
    //添加比例尺控件
    // var map0=map=new BMap.Map('map');
    // map0.centerAndZoom(new BMap.Point( 108.21 , 40.86), 3);


    // map0.addControl(new BMap.ScaleControl());
    // //添加导航控件
    // map0.addControl(new BMap.NavigationControl());
    //
    // //设置鼠标滑轮放大缩小地图可用
    // map0.enableScrollWheelZoom(true);
    //初始化定位

   //  map = new SuperMap.Map("map",{controls:[
   //          new SuperMap.Control.Navigation() ,
   //          new SuperMap.Control.Zoom(),
   //          new SuperMap.Control.LayerSwitcher(),
   //          new SuperMap.Control.MousePosition()
   //      ]});
   // var baiduLayer = new SuperMap.Layer.Baidu();
   //  vector = new SuperMap.Layer.Vector("vector");
   //  map.addLayers([baiduLayer,vector]);
   //
   //  map.setCenter(new SuperMap.LonLat(13155574.21000 , 4784679.86000), 7);


    // baiduLayer = new SuperMap.Layer.Baidu();

    //
    markers = new SuperMap.Layer.Markers("Markers");


    layer = new SuperMap.Layer.TiledDynamicRESTLayer("World", url, {transparent: true, cacheEnabled: true},{ maxResolution: "auto" , useCanvas:false,useCORS:true});


    range=new SuperMap.Layer.Vector("range");

    road=new SuperMap.Layer.Vector("road");

    vector=new SuperMap.Layer.Vector("vector");

//---------------------------------------------------------------
    themeLayer = new SuperMap.Layer.Graph("ThemeLayer", "Pie");
    themeLayer.themeFields = ["CON2015", "CON2016", "CON2017"];

    // 配置图表参数
    themeLayer.chartsSetting = {
// width，height，codomain 分别表示图表宽、高、数据值域；此三项参数为必设参数
        width: 100,
        height: 100,
        codomain: [0, 40000], // 允许图表展示的值域范围，此范围外的数据将不制作图表
// 饼图扇形（表示字段值的图形）样式
        sectorStyle: { fillOpacity: 0.8 },
// 按字段设置饼图扇形 (样式与 themeLayer.themeFields 数组中的字段名称一一对应)
        sectorStyleByFields: [{ fillColor: "#FFB980" }, { fillColor: "#5AB1EF" }, { fillColor: "#B6A2DE" }, { fillColor: "#2EC7C9" }, { fillColor: "#D87A80" }],
// 饼图扇形 hover 样式
        sectorHoverStyle: { fillOpacity: 1 }
    };

    // 注册专题图 mousemove, mouseout事件(注意：专题图图层对象自带 on 函数，没有 events 对象)
    themeLayer.on("mousemove", showInfoWin);
    themeLayer.on("mouseout", closeInfoWin);



    //---------------------------------------------------------


    //几何查询
    drawCircle = new SuperMap.Control.DrawFeature(vector, SuperMap.Handler.RegularPolygon,{handlerOptions:{sides:50}});

    drawCircle.events.on({"featureadded": drawCompleted});

    //模拟新增地物
    drawPoint = new SuperMap.Control.DrawFeature(range, SuperMap.Handler.Point);
    drawPoint.events.on({"featureadded": drawPointCompleted});

    drawSchoolPoint = new SuperMap.Control.DrawFeature(vector, SuperMap.Handler.Point);
    drawSchoolPoint.events.on({"featureadded": drawSchoolPointCompleted});



    // /*距离测量*/
    drawLine = new SuperMap.Control.DrawFeature(vector, SuperMap.Handler.Path, { multi: true });
    //
    layer.events.on({"layerInitialized":addLayer});

    map = new SuperMap.Map("map",{controls:[
            new SuperMap.Control.Zoom() ,
            new SuperMap.Control.Navigation() ,
            new SuperMap.Control.LayerSwitcher(),
            new SuperMap.Control.Navigation({
                dragPanOptions: {
                    enableKinetic: true
                }
            })],

    });
// 注册地图 mousemove，用于获取当前鼠标在地图中的像素位置
    map.events.on({"mousemove":function(e){
            infowinPosition = e.xy.clone();
// 偏移
            infowinPosition.x += 40;
            infowinPosition.y -= 25;
        }});
    // vector.events.on({"onSelect":mouseClickHandler,
    //     "touchstart":mouseClickHandler //假如要在移动端的浏览器也实现点击弹框，则在注册touch类事件
    // });
    // map.addLayers([layer,vector]);
    //


    // /*
    // 注册featureadded事件,触发drawCompleted()方法
    // 例如注册"loadstart"事件的单独监听
    // events.on({ "loadstart": loadStartListener });
    // */
    drawLine.events.on({"featureadded": drawLineCompleted});



    drawPolygon = new SuperMap.Control.DrawFeature(vector, SuperMap.Handler.Polygon);

    drawPolygon.events.on({"featureadded": drawPolygonCompleted});

    var  selectFeature = new SuperMap.Control.SelectFeature([vector,range],{onSelect:mouseClickHandler,onUnselect:onUnFeatureSelect});


    // 创建一个三维柱状统计专题图图层
    themeLayer1 = new SuperMap.Layer.Graph("ThemeLayer1", "Bar3D");

// 指定用于专题图制作的属性字段
    themeLayer1.themeFields = ["num"];
// 压盖处理权重
    themeLayer1.overlayWeightField = "num";

// 配置图表参数
    themeLayer1.chartsSetting = {
// width，height，codomain 分别表示图表宽、高、数据值域；此三项参数为必设参数
        width: 30,
        height: 100,
        codomain: [0, 40], // 允许图表展示的值域范围，此范围外的数据将不制作图表
        xShapeBlank: [0, 0, 0], // 水平方向上的空白间距参数
        YOffset: -50, // 向上偏移 50 像素
        useAxis: false, // 不显示坐标轴
        useBackground: false // 不显示背景框
    };

// 注册 click 事件
    themeLayer1.on("click", moveToCapital)


    map.addControl(selectFeature);
    // map.addControl(drawLine);
    selectFeature.activate();
    map.addControl(drawLine);
    map.addControl(drawCircle);
    map.addControl(drawPolygon);
    map.addControl(drawPoint);
    map.addControl(drawSchoolPoint);
}
//获取单值数据
//获取 feature 数据, 专题图的数据必须是 SuperMap.Feature.Vector
function addSimpleThemeLayer() {
    clearThemeLayer1();
    var queryParam, queryBySQLParams, queryBySQLService;
    queryParam = new SuperMap.REST.FilterParameter({
        name: "school@yang",
// 只统计人口 > 1000000 的首都城市
        attributeFilter: "SmID>0"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParam]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(url, {
        eventListeners: {"processCompleted": processSimpleCompleted, "processFailed": processFailed}});
    queryBySQLService.processAsync(queryBySQLParams);
}
function processSimpleCompleted(queryEventArgs) {
    var i, result = queryEventArgs.result;
    if (result && result.recordsets) {

        for (i=0; i<result.recordsets.length; i++) {
            if (result.recordsets[i].features) {
// 向专题图层添加用于制作专题图的feature数据
                console.log(result.recordsets[i].features);
                themeLayer1.addFeatures(result.recordsets[i].features);
            }
        }
    }
}
/*function addSimpleThemeLayer() {
    alert(system.sc.length);
    if(system.sc.length>0)
    {
        for(var i in system.sc)
        {
            var item=system.sc[i];
            var point= new SuperMap.Geometry.Point(item.x,    item.y);
            var pointVector = new SuperMap.Feature.Vector(point);

            pointVector.style=style;

            themeLayer1.addFeatures(pointVector);
            // vector.addFeatures([pointVector]);
        }

    }

}*/
//清除专题------
function clearThemeLayer1() {
    themeLayer1.clear();
    closeInfoWin();
}
// 移除地图弹窗
function closeInfoWin1() {
    if(infowin1) {
        try {
            map.removePopup(infowin1);
        }
        catch(e) {
            alert(e.message);
        }
    }
}
//模拟新增小区/学校
function drawPointCompleted(drawGeometryArgs) {
    var feature = new SuperMap.Feature.Vector();
    feature.geometry = drawGeometryArgs.feature.geometry,
        feature.style = style1;

    range.addFeatures(feature);
    var name=prompt("请输入小区名称","新增小区1");

   var f=new xq("a"+Math.ceil(Math.random()*200),name,feature.geometry.x,feature.geometry.y,230);
   system.xc.push(f);


    drawPoint.deactivate();
}
//模拟新增小区/学校
function drawSchoolPointCompleted(drawGeometryArgs) {
    var feature = new SuperMap.Feature.Vector();
    feature.geometry = drawGeometryArgs.feature.geometry,
        feature.style = style;

        vector.addFeatures(feature);

    var sname=$('#school_name').val(),rl=$('#rl').val();
    var o=system.getSchoolElement(sname);
    console.log(o);
    system.school={
        name:o.name,
        info:o.info
    };
   /* var name=prompt("请输入小区","新增小区1");

    var f=new xq("a"+Math.ceil(Math.random()*200),name,feature.geometry.x,feature.geometry.y,230);
    system.xc.push(f);
*/
    drawSchoolPoint.deactivate();
}
//---------------------------------------------------------定位
function  fixedPosition() {

    var point= new SuperMap.Geometry.Point(117.85438940045049,    39.7191740900123);
    var pointVector = new SuperMap.Feature.Vector(point);
    pointVector.style={
        fillColor:"red",
        strokeColor:"yellow",
        pointRadius: 15,
        externalGraphic: "../img/markerbig.png"
    };

    vector.addFeatures([pointVector]);

}
function onUnFeatureSelect() {
    closeInfoWin();
    markers.clearMarkers();
}
function addLayer(){
    // themeLayer1,themeLayer,
    map.addLayers([layer, road,range,vector,markers]);
//显示地图范围
    map.setCenter(new SuperMap.LonLat( 118.21 , 39.86 ), 0);
}
// 定位到首都城市
function moveToCapital(e){
    if(e.target && e.target.refDataID){
        // closeInfoWin();-----------------------关闭单值

// 获取图形对应的 feature
        console.log(themeLayer1.getFeatureById(e.target.refDataID));
        var fea = themeLayer1.getFeatureById(e.target.refDataID);
// feature 的 bounds 中心
        var geoCenter = fea.geometry.getBounds().getCenterLonLat();
// 定位到 feature 的 bounds 中心
        var lonLat = new SuperMap.LonLat(geoCenter.lon, geoCenter.lat);
        map.setCenter(lonLat, 4);

// 弹窗内容
        var contentHTML = "<div style='color: #000; background-color: #fff'>";
        contentHTML += "名称:<strong><i>" + fea.data.NAME + "</i></strong>";

        contentHTML += "<hr style='margin: 3px'>";
        contentHTML += "区域统计:<strong>" + fea.data.num + "</strong> &nbsp;个";
        contentHTML += "</div>";

        infowin1 = new SuperMap.Popup(
            "infowin1",
            lonLat,
            new SuperMap.Size(180, 60),
            contentHTML,
            true,
            false,
            null);
        infowin1.setBackgroundColor("#fff");
        infowin1.setOpacity(0.8);
        if(infowin1) map.removePopup(infowin1);
        map.addPopup(infowin1);
    }
}

//构建专题地图
function addThemeLayer() {
    clearThemeLayer();

    var features = [];
    for(var i = 0, len = system.sc.length; i < len; i++){
// 省居民消费水平（单位：人）信息
        var provinceInfo =system.sc[i];
        var geo = new SuperMap.Geometry.Point(provinceInfo.x, provinceInfo.y);
        var attrs = {};
        attrs.NAME = provinceInfo.name;
        attrs.CON2015 = provinceInfo.con[0];
        attrs.CON2016 = provinceInfo.con[1];
        attrs.CON2017 = provinceInfo.con[2];


        var fea = new SuperMap.Feature.Vector(geo, attrs);
        features.push(fea);
    }

    themeLayer.addFeatures(features);//---dog
}
// 清除专题图层中的内容
function clearThemeLayer() {
    themeLayer.clear();
    closeInfoWin();
}
// 显示地图弹窗
function showInfoWin(e){
// e.target 是图形对象，即数据的可视化对象，饼状图中是扇形。
// 图形对象的 refDataID 属性是数据（feature）的 id 属性，它指明图形对象是由那个数据制作而来;
// 图形对象的 dataInfo 属性是图形对象表示的具体数据，他有两个属性，field 和 value;
    if(e.target && e.target.refDataID && e.target.dataInfo){
        closeInfoWin();
// 获取图形对应的数据 (feature)
        var fea = themeLayer.getFeatureById(e.target.refDataID);

        var info = e.target.dataInfo;

// 弹窗内容
        var contentHTML = "<div style='color: #000; background-color: #fff'>";
        contentHTML += "名称:<strong><u>" + fea.attributes.NAME + "</u></strong>";
     console.log(e);
        contentHTML += "<hr style='margin: 3px'>";
        switch(info.field){
            case "CON2015":
                contentHTML += "15年招生数量:&nbsp;<strong>" + info.value + "</strong>（人）";
                break;
            case "CON2016":
                contentHTML += "16年招生数量:&nbsp;<strong>" + info.value + "</strong>（人）";
                break;
            case "CON2017":
                contentHTML += "17年招生数量: &nbsp;<strong>" + info.value + "</strong>（人）";
                break;

            default:
                contentHTML += "No Data";
        }
        contentHTML += "</div>";

// 弹出框大小
        var infowinSize = (SuperMap.Browser.name == "firefox")? new SuperMap.Size(180, 60): new SuperMap.Size(180, 60);

// 弹出窗地理位置
        var lonLat = map.getLonLatFromPixel(infowinPosition);
        infowin = new SuperMap.Popup(
            "infowin",
            lonLat,
            infowinSize,
            contentHTML,
            false,
            false,
            null);
        infowin.setBackgroundColor("#fff");
        infowin.setOpacity(0.8);
        if(infowin) map.removePopup(infowin);
        map.addPopup(infowin);
    }
}

//----------------------------------------id查询----------------------------
function getFeaturesByIDs(name,a) {
    vector.removeAllFeatures();

    var getFeaturesByIDsParameters, getFeaturesByIDsService;
    getFeaturesByIDsParameters = new SuperMap.REST.GetFeaturesByIDsParameters({
        returnContent: true,
        // datasetNames: ["World:Countries"],//数据集
        datasetNames:["yang:"+name],    //xiaoqu  school  学校 科研教育__point
        fromIndex: 0,
        toIndex:-1,
        IDs: a
    });

    getFeaturesByIDsService = new SuperMap.REST.GetFeaturesByIDsService(url1, {
        eventListeners: {"processCompleted": processCompleted0, "processFailed": processFailed}});
    getFeaturesByIDsService.processAsync(getFeaturesByIDsParameters);
}
function processCompleted0(getFeaturesEventArgs) {
    var s="";
    var i, len, features, feature, result = getFeaturesEventArgs.result;
    if (result && result.features) {
        features = result.features
        clearElements();
        for (i=0, len=features.length; i<len; i++) {
            feature = features[i];
            if(feature.data.FID_科研教)
            {

                feature.style = style;
               
            }
            if(feature.data.FID_小区_P)
            {
                s+=feature.data.NAME+"\n";
                feature.style = style1;

            }

            vector.addFeatures(feature);

        }
    }

}
//------------------------------------------备用------------------------------------
/*sql查询*/
function getAllElement(dataset) {
    // vector.removeAllFeatures();
    var getFeatureParam, getFeatureBySQLService, getFeatureBySQLParams;

    getFeatureParam = new SuperMap.REST.FilterParameter({
        name: "yang@"+dataset,
        // attributeFilter: "SmID = 160"
        attributeFilter: "SMID>0"//模糊查询
    });
    getFeatureBySQLParams = new SuperMap.REST.GetFeaturesBySQLParameters({
        queryParameter: getFeatureParam,
        datasetNames:["yang:"+dataset]
    });

    getFeatureBySQLService = new SuperMap.REST.GetFeaturesBySQLService(url1, {
        eventListeners: {"processCompleted": processGetAllCompleted, "processFailed": processFailed}});

    getFeatureBySQLService.processAsync(getFeatureBySQLParams);
}
function  processGetAllCompleted(getFeaturesEventArgs) {
    var s="";
    var i, len, features, feature, result = getFeaturesEventArgs.result;
    if (result && result.features) {
        features = result.features
        clearElements();
        console.log(features.length);
        for (i=0, len=features.length; i<len; i++) {
            feature = features[i];
            if(feature.data.FID_科研教)
            {
                system.sc.push(new school(feature.data.SMID,feature.data.SMX,feature.data.SMY));

            }
            if(feature.data.FID_小区_P)
            {
                system.xc.push(new xq(feature.data.SMID,feature.data.SMX,feature.data.SMY));
                facilityPoints.push(new SuperMap.Geometry.Point(feature.geometry.x, feature.geometry.y));
            }

            // vector.addFeatures(feature);
            // console.log(feature.geometry.x+"    "+feature.geometry.y);

        }
    }

}


/*
* 全部查询
* */
function queryBySQL(dataset) {


    var queryParam, queryBySQLParams, queryBySQLService;
    queryParam = new SuperMap.REST.FilterParameter({
        name: dataset+"@yang",
        // attributeFilter: "Pop_1994>1000000000 and SmArea>900"
        attributeFilter:"SMID>0"
    });
    queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
        queryParams: [queryParam]
    });
    queryBySQLService = new SuperMap.REST.QueryBySQLService(url, {
        eventListeners: {"processCompleted": processCompleted1, "processFailed": processFailed}});
    queryBySQLService.processAsync(queryBySQLParams);
}
function processCompleted1(queryEventArgs) {
    var i, j, feature,
        result = queryEventArgs.result;
    if (result && result.recordsets) {
        for (i=0; i<result.recordsets.length; i++) {
            if (result.recordsets[i].features) {
                for (j=0; j<result.recordsets[i].features.length; j++) {
                    feature = result.recordsets[i].features[j];
// console.log(feature);
                    if(feature.data.FID_科研教)
                    {
                        system.sc.push(new school(feature.data.SmID,feature.data.NAME,feature.data.SmX,feature.data.SmY,Math.ceil(Math.random()*200+900)));

                    }
                    if(feature.data.FID_小区_P)
                    {
                        system.xc.push(new xq(feature.data.SmID,feature.data.NAME, feature.data.SmX,feature.data.SmY,Math.ceil(Math.random()*100+100)));
                        facilityPoints.push(new SuperMap.Geometry.Point(feature.geometry.x, feature.geometry.y));
                    }

                }
                console.log("划片成功！"+system.sc[0].con);
            }
        }
    }
  for(var i in system.xc)
  {

      if(system.xc[i].name.indexOf("新增")>-1)
      {
          console.log(system.xc[i]);
      }


  }

}
/*-------------------------------sql查询*/
function getFeaturesBySQL(dataset,name) {
    vector.removeAllFeatures();
    var getFeatureParam, getFeatureBySQLService, getFeatureBySQLParams;

    getFeatureParam = new SuperMap.REST.FilterParameter({
        name: "yang@"+dataset,
        // attributeFilter: "SmID = 160"
        attributeFilter: "NAME like '%"+name+"%'"//模糊查询
    });
    getFeatureBySQLParams = new SuperMap.REST.GetFeaturesBySQLParameters({
        queryParameter: getFeatureParam,
        datasetNames:["yang:"+dataset]
    });

    getFeatureBySQLService = new SuperMap.REST.GetFeaturesBySQLService(url1, {
        eventListeners: {"processCompleted": processCompleted, "processFailed": processFailed}});

    getFeatureBySQLService.processAsync(getFeatureBySQLParams);
}
//几何圆查询
//画圆
function drawGeometry1() {
//先清除上次的显示结果
//     clearStatus();
    drawCircle.activate();
}

//缓冲区查询 默认查询小区 true
function drawCompleted(f,b,d) {
    range.removeAllFeatures();
    var c=["yang:xiaoqu"];

    if(b)
    {
        c.push("yang:cunzi")
        // d =localStorage.getItem("range")?localStorage.getItem("range"):'0.5';
       
    }

    // console.log("------------------------"+f[0])
    var feature = new SuperMap.Feature.Vector();
    feature.geometry = f.geometry?f.geometry:f.feature.geometry;
    feature.style = style;
    vector.addFeatures(feature);

    var getFeatureParameter, getFeatureService;
    getFeatureParameter = new SuperMap.REST.GetFeaturesByBufferParameters({
        bufferDistance: d,
//attributeFilter: "SMID > 0",
        datasetNames: c,
        returnContent:true,
        geometry: feature.geometry
    });
    getFeatureService = new SuperMap.REST.GetFeaturesByBufferService(url1, {
        eventListeners: {
            "processCompleted": processCompleted,
            "processFailed": processFailed
        }
    });
    getFeatureService.processAsync(getFeatureParameter);
}

//---------------------------------------------------------------------------------
function processCompleted(getFeaturesEventArgs) {
var s="";
    system.searchXC=[];
    var i, len, features, feature, result = getFeaturesEventArgs.result;
    if (result && result.features) {
        features = result.features

        for (i=0, len=features.length; i<len; i++) {
            feature = features[i];

            if(feature.data.FID_科研教)
            {
                feature.style = style;
                vector.addFeatures(feature);
            }
          else  if(feature.data.FID_小区_P)
            {
                s+=feature.data.NAME+"\n";
                feature.style = style1;
                facilityPoints.push(new SuperMap.Geometry.Point(feature.geometry.x, feature.geometry.y));
                system.searchXC.push(feature);

                range.addFeatures(feature);
            }
            else if(feature.data.FID_村_POI)
            {
                feature.style = style2;
                system.searchXC.push(feature);

                range.addFeatures(feature);
            }
        }
    }
    // console.log(s);
    drawCircle.deactivate();
}
function processFailed(e) {
    alert("失败:"+e.error.errorMsg);
}
//清除要素
function clearFeatures() {
//先清除上次的显示结果
//     system.xc=[];
    // system.sc=[];
    // system.searchXC=[];
    console.log(map.getLayersByName('ThemeLayer'));
    if(map.getLayersByName('ThemeLayer').length>0)
    {
        map.removeLayer(themeLayer);
    }
    if(map.getLayersByName('ThemeLayer1').length>0)
    {
        map.removeLayer(themeLayer1);
    }




    road.removeAllFeatures();
    range.removeAllFeatures();
    vector.removeAllFeatures();
    vector.refresh();
    console.clear();
    $('#search').val("");
    closeInfoWin();
    markers.clearMarkers();
eventPoint=null;
}

//-------------------------------------注册点击函数-----------------------------------------
function mouseClickHandler(event){

    closeInfoWin();


    var contentHTML,name,info;
    if(event.data.SMID!=null)
    {
       name=event.data.NAME;

    }else{
        name=system.school.name;
    }
    info=system.infoContain[Math.ceil(Math.random()*(system.infoContain.length-1))];
    console.log( );
    contentHTML="<div style='width:120px; font-size:12px;font-weight:bold ; opacity: 0.8'>";
    contentHTML += "位置: <u>"+name;


//初始化FramedCloud类



//添加覆盖物到标记图层
//      markers.addMarker(marker);


    if(event.data.FID_科研教||event.data.NAME==null)
    {

        contentHTML+="</u><br> 简介:"+info+"<br> 容纳学生："+system.getSchoolElement(event.data.NAME).num+' 人';
        contentHTML += "</div>";

        clearElements();
        setTimeout(function () {
            if(confirm("是否显示详细信息？")){
                /* 小区/村庄 列表*/
                drawCompleted(event,true,localStorage.getItem("range"));

                if(localStorage.getItem('near')!="no")
                {


                    setTimeout(function () {

                        // alert(system.searchXC.length);
                        if(system.searchXC.length>0)
                        {

                            $('#xq_list').empty();


                            for(var i in system.searchXC)
                            {
                                var item=system.searchXC[i];
                                console.log(item);

                                $('#xq_list').append($('<li class="list-group-item">'+item.data.NAME+'</li>'));

                            }

                            $('#xq_panel').show(100);
                        }
                    },1000);
                }
            }
        },1200);

    }

   eventPoint=event;
    var size = new SuperMap.Size(21,25),
        offset = new SuperMap.Pixel(-(size.w/2), -size.h),
        icon = new SuperMap.Icon('../img/markerflag.png', size, offset);

    marker = new SuperMap.Marker(new SuperMap.LonLat(event.geometry.x,event.geometry.y),null);

    markers.addMarker(marker);

    framedCloud = new SuperMap.Popup.FramedCloud(
        "chicken",
        // [event.geometry.x+200 , event.geometry.y+500],
        marker.getLonLat(),
        null,
        contentHTML,
        null,
        true,
        null,
        true
    );
    infowin = framedCloud;
    map.addPopup(framedCloud);


}

function closeInfoWin(){
    if(infowin){
        try{
            infowin.hide();
            infowin.destroy();
        }
        catch(e){}
    }
}
// -----------------------------------距离量算-----------------------------

function distanceMeasure(){

    // clearFeatures();
    drawLine.activate();
}
//绘完触发事件
function drawLineCompleted(drawGeometryArgs) {
//停止画面控制
    drawLine.deactivate();
//获得图层几何对象
    var geometry = drawGeometryArgs.feature.geometry,
        measureParam = new SuperMap.REST.MeasureParameters(geometry), /* MeasureParameters：量算参数类。 客户端要量算的地物间的距离或某个区域的面积*/
        myMeasuerService = new SuperMap.REST.MeasureService(url); //量算服务类，该类负责将量算参数传递到服务端，并获取服务端返回的量算结果
    myMeasuerService.events.on({ "processCompleted": measureDisCompleted });

//对MeasureService类型进行判断和赋值，当判断出是LineString时设置MeasureMode.DISTANCE，否则是MeasureMode.AREA

    myMeasuerService.measureMode = SuperMap.REST.MeasureMode.DISTANCE;

    myMeasuerService.processAsync(measureParam); //processAsync负责将客户端的量算参数传递到服务端。
}

//测量结束调用事件
function measureDisCompleted(measureEventArgs) {
    var distance = measureEventArgs.result.distance;
    var unit = measureEventArgs.result.unit;
    alert("量算结果:"+distance + "米");
}
//------------------------------------面积量算-------------------
function areaMeasure(){
    // clearFeatures();
    drawPolygon.activate();
}
function drawPolygonCompleted(drawGeometryArgs) {
    //停止画面控制

    drawPolygon.deactivate();
//获得图层几何对象
    var geometry = drawGeometryArgs.feature.geometry,
        measureParam = new SuperMap.REST.MeasureParameters(geometry), /* MeasureParameters：量算参数类。 客户端要量算的地物间的距离或某个区域的面积*/
        myMeasuerService = new SuperMap.REST.MeasureService(url); //量算服务类，该类负责将量算参数传递到服务端，并获取服务端返回的量算结果
    myMeasuerService.events.on({ "processCompleted": measureCompleted });

//对MeasureService类型进行判断和赋值，当判断出是LineString时设置MeasureMode.DISTANCE，否则是MeasureMode.AREA

    myMeasuerService.measureMode = SuperMap.REST.MeasureMode.AREA;

    myMeasuerService.processAsync(measureParam); //processAsync负责将客户端的量算参数传递到服务端。
}
//测量结束调用事件
function measureCompleted(measureEventArgs) {
    var area = measureEventArgs.result.area,
        unit = measureEventArgs.result.unit;
    alert("量算结果:"+ area + "平方米");
}
//-------------------------------------网络分析-----------------------------
function findClose(drawGeometryArgs) {
    var point = drawGeometryArgs.geometry,
        size = new SuperMap.Size(44, 33),
        offset = new SuperMap.Pixel(-(size.w / 2), -size.h),
        icon = new SuperMap.Icon("../theme/images/marker.png", size, offset);
    // markerLayer2.addMarker(new SuperMap.Marker(new SuperMap.LonLat(point.x, point.y), icon));
    eventPoint = point;
    n++;
    if (n >= 1) {
        // drawPoint.deactivate();ffffffff
    }
}
function findClosestFacilities(drawGeometryArgs) {


    road.removeAllFeatures();

    var point = drawGeometryArgs.geometry?drawGeometryArgs.geometry:drawGeometryArgs;
    eventPoint=point;

    if(!eventPoint||facilityPoints.length<1){

        return false;
    }
    var findClosestFacilitiesService, parameter, analystParameter, resultSetting;
    resultSetting = new SuperMap.REST.TransportationAnalystResultSetting({
        returnEdgeFeatures: true,
        returnEdgeGeometry: true,
        returnEdgeIDs: true,
        returnNodeFeatures: true,
        returnNodeGeometry: true,
        returnNodeIDs: true,
        returnPathGuides: true,
        returnRoutes: true
    });
    // var edgeWeightNamesSelect = document.getElementById("edgeWeightNames");
    // var weightFieldName = edgeWeightNamesSelect.options[edgeWeightNamesSelect.selectedIndex].text;

    // var turnWeightFieldSelect = document.getElementById("turnNodeWeightNames");

    // var turnNodeWeightNames = turnWeightFieldSelect.options[turnWeightFieldSelect.selectedIndex].text;

    analystParameter = new SuperMap.REST.TransportationAnalystParameter({
        resultSetting: resultSetting,

        weightFieldName : "SmLength"
    });
    parameter = new SuperMap.REST.FindClosestFacilitiesParameters({
        event: eventPoint,
        expectFacilityCount: 1,
        isAnalyzeById: false,
        facilities: facilityPoints,
        parameter: analystParameter
    });
    findClosestFacilitiesService = new SuperMap.REST.FindClosestFacilitiesService(url2, {
        eventListeners: { "processCompleted": processFindClosestCompleted,"processFailed": processFailed }
    });
    findClosestFacilitiesService.processAsync(parameter);
}
function processFindClosestCompleted(findClosestFacilitiesEventArgs) {

    var result = findClosestFacilitiesEventArgs.result,
        features = [];
    if (result.facilityPathList) {
        for (var i = 0, facilityPathList = result.facilityPathList, len = facilityPathList.length; i < len; i++) {
            var feature = new SuperMap.Feature.Vector();
            feature.geometry = facilityPathList[i].route;
            feature.style = linestyle;
            features.push(feature);
        }
    }
    road.addFeatures(features);
  console.log(features);
}
function clearElements() {
    eventPoint = null;
    n = 0;
   facilityPoints=[];
    // markerLayer2.clearMarkers();
}
/**
 *打印地图，支持ie9及以上，chrome，firefox等.
 *请注意相关css,js文件是否存在.
 *Parameters:
 *id <String> id 为map div的id
 */
function createPrintMap(id){
    var broz = SuperMap.Browser.name;
    if(broz == 'msie' && parseInt(SuperMap.Browser.version) < 9){
        alert("ie9版本以下部分打印功能不支持");
        return;
    }
    var printWindow = window.open("");
    var strInnerHTML = document.getElementById(id).innerHTML;

    var strHeader = "<!DOCTYPE html><html><head><META HTTP-EQUIV='pragma' CONTENT='no-cache'><META HTTP-EQUIV='Cache-Control' CONTENT='no-cache, must-revalidate'><META HTTP-EQUIV='expires' CONTENT='Wed, 26 Feb 1997 08:21:57 GMT'><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' /><meta name='apple-mobile-web-app-capable' content='yes' /><title>地图打印</title>";
    var strCSS = "<link href='../css/sm.css' rel='stylesheet' /><link href='../css/sm-responsive.css' rel='stylesheet' /><link href='../css/style.css' rel='stylesheet'><link href='../css/sm-doc.css' rel='stylesheet' />";
    var strScript = "<script src='../js/jquery-1.9.1.min.js'><\/script><script type = 'text/javascript'>" + "\n" + "function printDiv(){$('.newuiPrint').css({'display':'none'});window.print();$('.newuiPrint').css({'display':'block'});}<\/script>";
    var strBody = "</head><body><div class='print-header'><div class='superD'><h3>地图</h3></div><div id='"+id+"' >" +strInnerHTML + "</div><div id='superft'><div class='printClose'>" + "<button><span class='newuiPrint' onclick = 'printDiv()'>打印 </span></button></div></div></div></body></html>";

    var strHTML = strHeader + strCSS + strScript + strBody;
    printWindow.document.write(strHTML);
    printWindow.document.close();
    function onloadHTML(){
        console.log(printWindow.document.getElementById(id));
        var strDOM = printWindow.document.getElementById(id).children[0].children;
        if(strDOM==null)
        {
            return false;
        }

        for(var i = 0, length = strDOM.length; i < length ; i++){
            var idStr = strDOM[i].id;
            if(idStr.indexOf("SuperMap.Control.ScaleLine") == -1 && idStr.indexOf("SuperMap.Map") == -1){
                strCss = strDOM[i].style.cssText;
                strCss = strCss + "display: none;";
                strDOM[i].style.cssText = strCss;
            }
        }

        var canvasPrint = printWindow.document.getElementsByTagName("canvas");
        var canvasMap = document.getElementsByTagName("canvas");
        for(var i = 0,length = canvasPrint.length;i< length;i++){
            pasteCanvas(canvasMap[i],canvasPrint[i]);
        }
    }
    if (broz == 'firefox') {
        printWindow.onload = onloadHTML;
    } else if (broz == 'safari'||broz == 'chrome'||broz == 'msie') {
        window.setTimeout(onloadHTML,50);
    }
}
//如果涉及到Canvas的图层打印，需要将范例发布出来运行，否则会产生跨域的问题
function pasteCanvas(sCanvas/*source*/,dCanvas/*destination*/){
    var w=sCanvas.width,
        h=sCanvas.height;
    dCanvas.width=w;
    dCanvas.height=h;
    var viewerImageSrc=sCanvas.toDataURL("image/png");
    var viewerImage=new Image();
    viewerImage.src=viewerImageSrc;
    var dContext=dCanvas.getContext("2d");
    dContext.drawImage(viewerImage,0,0,w,h);
}
