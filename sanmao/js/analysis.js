(function () {
var school=function (id,name,x,y,num) {
    this.id=id;
    this.name=name;
    this.x=x;
    this.y=y;
    this.num=num;
    this.con=[];
    this.init();
}

    school.prototype={
        constructor:school,
        init:function () {
            if(this.con.length==0)
            {
                for(var i=0;i<3;i++)
                {
                    this.con.push(Math.ceil(Math.random()*200+200));
                }

            }

        }

    };
    var xq=function (id,name,x,y,num) {
        this.id=id;
        this.name=name;
        this.x=x;
        this.y=y;
        this.js=[];
        this.hs=[];
        this.num=num;

    }
    xq.prototype={
        constructor:xq,
       setSid:function (sid) {
           this.sid=sid;
       },
        drawRect:function (vector) {
            var x=this.x,y=this.y;
            /*var point=[
             new SuperMap.Geometry.Point(x-15,y-10),
             new SuperMap.Geometry.Point(x+15,y-10),
             new SuperMap.Geometry.Point(x-15,y+10),
             new SuperMap.Geometry.Point(x+15,y+10)
            ];
           for(var i in point)
           {
               var item=point[i];
               var pointVector = new SuperMap.Feature.Vector(item);
               pointVector.style=style1;
               range.addFeatures([pointVector]);
           }*/
            var rectTangle = new SuperMap.Geometry.Rectangle(x-15, y+10, 10, 5);
            var pointVector = new SuperMap.Feature.Vector(rectTangle);
            pointVector.style={
                strokeColor: "#304DBE",
                strokeWidth: 1,
                pointerEvents: "visiblePainted",
                fillColor: "#304DBE",
                fillOpacity: 0.5
            };
            vector.addFeatures([pointVector]);

        }
    };
    var System=function () {
        
    }
    System.sc=[];
    System.xc=[];
    System.searchSC=[];
    System.searchXC=[];
   System.infoContain=[
   ' 本校是唐山市校园环境、教学设施相对较好的学校，' +
    '也是唯一的以寄宿制为特色的中学，是一所现代化、规范化、 园林式的省级标准化寄宿制学校。',
       '校园占地面积200余亩，建筑面积20000多平方米，校舍典雅别致，时代气息浓郁。校园绿荫掩映，' +
       '空气清新，环境宜人，校园绿化率达51.6%。学校教学、实验、文体活动、生活设施齐备,所有实验设施均按国家I类标准配备，拥有国家一类标准塑胶运动场。',
       '学校实行全封闭式寄宿制管理，建立了严格的学生寄宿管理制度。校内学生生活设施完善，学生公寓内每个楼层设有淋浴间，学生尽可感受家庭般的温馨。',
       '一直以来以“一切为了学生的健康成长”为办学出发点和落脚点，用“人文引领、个性发展、创新实践、承担责任”的教育哲学指导学校办学实践，用“砺志励学、立德立人” 八字校训勉励全体师生，大力推进新课程改革。',
  '学校以“立人”这个总纲规划学校文化建设大局。“以德育人，真心护人”的教风和“厚积、有恒、善思、乐学”的学风蔚为气象，潜移默化；风云阁、求索轩、渡夫亭、文化石、学子铭等人文景观，使学生浸润其中，耳濡目染，学会做人，学会认知，学会合作，学会创造。',
       '本校以九年义务教育、高中教育为主体，并辅以幼儿教育的全日寄宿与走读双轨并行、“全优化”管理形式的学校。2007年曾与北京师大附属中学合作创办优质教育。'

   ];
    System.getRealDistance=function ( long1,  lat1,  long2,  lat2) {
        var rad=function (d) {
            return d*Math.PI/180;
        }
        var  a, b, d, sa2, sb2;
        lat1 = rad(lat1);
        lat2 = rad(lat2);
        a = lat1 - lat2;
        b = rad(long1 - long2);

        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2   * 6378137.0
            * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
                * Math.cos(lat2) * sb2 * sb2));
        return d;

    }
    System.school={
        name:'',
        info:''
    };

    System.init=function () {
        // /*---start-*/
        var i = 0;
        while (i < System.xc.length) {
            var j = 0, dis = 10000;
            while (j < System.sc.length) {
                var a = System.xc[i], b = System.sc[j];
                var distance = Math.abs(Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)));
                if (distance < dis) {
                    dis = distance;
                    a.setSid(b.id);
                }
                j++;
            }
            i++;
        }
    }
        System.getNearSchool=function (k) {


            var i=0,dis=5000,s=[];
            var b=System.getElement(k);
            b.js=[];
            b.hs=[];
            while (i<System.sc.length)
            {
                var a=System.sc[i];

                    var distance=System.getRealDistance(a.x,a.y,b.x,b.y);

                    if(distance<dis)
                    {
                        dis=distance;

                        if(a.name.indexOf("小学")>=0)
                        {
                            b.js.push(a);
                        }
                        if(a.name.indexOf("中")>=0)
                        {
                            b.hs.push(a);
                        }
                    }

                    i++;


            }
       console.log(b);
            return b;
        }


        System.getNearHeightSchool=function () {
            var i=0;
            while(i<System.xc.length)
            {
                var j=0,dis=10000;
                while(j<System.sc.length)
                {
                    var a=System.xc[i],b=System.sc[j];
                    var distance=Math.abs(Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)));
                    if(distance<dis)
                    {
                        dis=distance;
                        a.setSid(b.id);
                    }
                    j++;
                }
                i++;
        }
        for(var s in System.xc) {

             localStorage.setItem(System.xc[s].name, System.xc[s].sid);
            // console.log("正在加载"+"xq_"+System.xc[s].name+"   "+System.xc[s].sid);
        }
        console.log("加载完毕！");
    }
    System.getInfo=function (key,a) {
        for(var x in System.xc)
        {
            if(System.xc[x].name.indexOf(key)>=0)
            {
                return System.xc[x].name;
            }
        }
        return "";
    }
    System.getElement=function (k) {
        for(var x in System.xc)
        {
            if(System.xc[x].name.indexOf(k)>=0)
            {
                console.log("OK-----------------------------------");
                return System.xc[x];
            }
        }
        return null;
    }
    System.getSchoolElement=function (k) {
        for(var x in System.sc)
        {
            if(System.sc[x].name.indexOf(k)>=0)
            {
                console.log("OK-----------------------------------");
                return System.sc[x];
            }
        }
        return null;
    }
    window.school=school;
    window.xq=xq;
    window.system=System;
})();

setTimeout(function () {
    system.init();
},2500);