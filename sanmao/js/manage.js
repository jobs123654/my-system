/*
   所有的居民区，学校 基本的查询
 *
 *
 *
 *
 * */

//------------------------------------------------------------------------------


//----------------------------------------初始化百度地图-----------------------------------------------------------------
// D:\SuperMapiServer8C\iClient\forJavaScript\examples\images
var tileLayer,layer,vector, drawLine, map ,drawCircle,drawPolygon, markers,infowin=null,eventPoint,facilityPoints =[], n = 0,style = {
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




    //
    markers = new SuperMap.Layer.Markers("Markers");







    layer = new SuperMap.Layer.TiledDynamicRESTLayer("World", url, {transparent: true, cacheEnabled: true},{maxResolution:"auto"});



    vector=new SuperMap.Layer.Vector("vector");

    //几何查询
    drawCircle = new SuperMap.Control.DrawFeature(vector, SuperMap.Handler.RegularPolygon,{handlerOptions:{sides:50}});
    drawCircle.events.on({"featureadded": drawCompleted});


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

    var  selectFeature = new SuperMap.Control.SelectFeature([vector],{onSelect:mouseClickHandler,onUnselect:onUnFeatureSelect});




    map.addControl(selectFeature);
    // map.addControl(drawLine);
    selectFeature.activate();
    map.addControl(drawLine);
    map.addControl(drawCircle);
    map.addControl(drawPolygon);


}

function onUnFeatureSelect() {
    closeInfoWin();
    markers.clearMarkers();
}
function addLayer(){

    map.addLayers([layer,vector,markers]);
//显示地图范围
    map.setCenter(new SuperMap.LonLat( 118.21 , 39.86 ), 0);
}

//----------------------------------------id查询
function getFeaturesByIDs() {
    vector.removeAllFeatures();

    var getFeaturesByIDsParameters, getFeaturesByIDsService;
    getFeaturesByIDsParameters = new SuperMap.REST.GetFeaturesByIDsParameters({
        returnContent: true,
        // datasetNames: ["World:Countries"],//数据集
        datasetNames:["yang:xiaoqu"],    //xiaoqu  school  学校 科研教育__point
        fromIndex: 0,
        toIndex:-1,
        IDs: [1,3,5,6,7,8,10]
    });

    getFeaturesByIDsService = new SuperMap.REST.GetFeaturesByIDsService(url1, {
        eventListeners: {"processCompleted": processCompleted, "processFailed": processFailed}});
    getFeaturesByIDsService.processAsync(getFeaturesByIDsParameters);
}



/*sql查询*/
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

//缓冲区查询
function drawCompleted(f) {
var d=localStorage.getItem("range")?localStorage.getItem("range"):'0.5';

    var feature = new SuperMap.Feature.Vector();
    feature.geometry = f.geometry?f.geometry:f.feature.geometry;
    feature.style = style;
    vector.addFeatures(feature);

    var getFeatureParameter, getFeatureService;
    getFeatureParameter = new SuperMap.REST.GetFeaturesByBufferParameters({
        bufferDistance: d,
//attributeFilter: "SMID > 0",
        datasetNames: ["yang:xiaoqu"],
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
                facilityPoints.push(new SuperMap.Geometry.Point(feature.geometry.x, feature.geometry.y));
            }

            vector.addFeatures(feature);
            console.log(feature.geometry.x+"    "+feature.geometry.y);

        }
    }
    console.log(s);
    drawCircle.deactivate();
}



function processFailed(e) {
    alert("失败:"+e.error.errorMsg);
}
function clearFeatures() {
//先清除上次的显示结果
    vector.removeAllFeatures();
    vector.refresh();
    console.clear();
    $('#search').val("")
    closeInfoWin();
    markers.clearMarkers();

}

//-------------------------------------注册点击函数-----------------------------------------
function mouseClickHandler(event){
    if(event.data.SMID==null)
    {
        return false;
    }
    closeInfoWin();


    var contentHTML = "<div style='width:120px; font-size:12px;font-weight:bold ; opacity: 0.8'>";
    contentHTML += "位置: "+event.data.NAME+"<br>"+event.data.INFO;
    contentHTML += "</div>";

//初始化FramedCloud类



//添加覆盖物到标记图层
//      markers.addMarker(marker);
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

    if(event.data.FID_科研教)
    {
        clearElements();
        setTimeout(function () {
            if(confirm("是否显示周围的学区房？")){
                drawCompleted(event);
                if(localStorage.getItem('near')!="no")
                {

                    setTimeout(function () {
                        findClosestFacilities(event);
                    },100);
                }
            }
        },1200);

    }



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



    var point = drawGeometryArgs.geometry;
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
    vector.addFeatures(features);
  console.log(features);
}
function clearElements() {
    eventPoint = null;
    n = 0;
   facilityPoints=[];
    // markerLayer2.clearMarkers();

}