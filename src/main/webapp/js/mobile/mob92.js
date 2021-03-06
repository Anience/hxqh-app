/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/mobile/vMob92Data",
            method: "get",
            dataType: "json",
            success: function(data){
                window.clearInterval(timer);
                // initEchart("echart1",data.dtoMap.LATENCY_KPI,'Roundtrip Latency');
                $('.ticket-time').text("Last Update: "+data.timeList[0] );
                initEchart("echart1",data.dtoMap.JITTER_KPI,'Jitter');
                var i = 0;
                var timer = setInterval(function(){
                    i++;
                    if(i>=4){
                        i=0;
                    }
                    switch(i){
                        case 0:
                            initEchart("echart1",data.dtoMap.LATENCY_KPI,'Roundtrip Latency');
                            $("p").text("BAD >= 20ms > GOOD");
                            $(".noData-content").hide();
                            break;
                        case 1:
                            initEchart("echart1",data.dtoMap.LOSS_KPI,'Packet Loss');
                            $("p").text("BAD >= 0.1% > GOOD");
                            $(".noData-content").hide();
                            break;
                        case 2:
                            initEchart("echart1",data.dtoMap.MOS_KPI,'MOS');
                            $("p").text("BAD < 3.5 <= GOOD");
                            $(".noData-content").hide();
                            break;
                        default:
                            initEchart("echart1",data.dtoMap.JITTER_KPI,'Jitter');
                            $("p").text("BAD >= 5ms > GOOD");
                            $(".noData-content").hide();
                            break;
                    }
                },15000);
            },
            error: function(){

            }
        })
    }
    function initEchart(domId,echartData,tit){
        var legendData = ["No Data","Bad","Good"];
        var xAxisData = ["TREG7","TREG6","TREG5","TREG4","TREG3","TREG2","TREG1"];
        var colorData = ["#707B8E","#ECD201","#5ACF05"];
        // var ecConfig = require('../../script/echarts-config');
        var ecConfig = echarts.config;
        var greenData = echartData.green;
        var redData = echartData.red;
        var orangeData = echartData.orange;
        var greenPercent = echartData.greenPercent.toString().trim().split(',');
        var redPercent = echartData.redPercent.toString().trim().split(',');
        var orangePercent = echartData.orangePercent.toString().trim().split(',');
        var myChart = echarts.init(document.getElementById(domId));
        myChart.on(ecConfig.EVENT.CLICK, eConsole)
        option = {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            title: {
                text: tit,
                x:'center',
                textStyle: {
                    fontSize: 26,
                    fontWeight: 'bolder',
                    color: '#FFFFFF'          // 主标题文字颜色
                },
            },
            legend: {
                x:'right',
                data:legendData,
                color:'#FFFFFF',
                textStyle:{    //图例文字的样式
                    color:'#FFFFFF',
                    fontSize: 20,
                }
            },
            xAxis : [
                {
                    type : 'value',
                    axisLine:{show:false},
                    axisLabel : {//轴数据风格
                        show:false,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        //rotate: 30,
                        margin:5,
                        splitNumber: 100,
                        textStyle:{
                            color: '#FFFFFF'
                        }
                    },
                    splitLine : { //网格分隔线
                        show:false,

                        lineStyle: {
                            fontSize: 26,
                            color: '#FFFFFF',
                            type: 'dashed',
                            width: 1
                        }
                    }
                }
            ],
            yAxis : [
                {
                    type : 'category',
                    data : xAxisData,
                    axisLine:{show:false},
                    splitLine : { //网格分隔线
                        show:false,

                        lineStyle: {
                            fontSize: 26,
                            color: 'RGB( 255, 255, 255)',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    axisLabel : {//轴数据风格
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        margin:5,
                        splitNumber: 100,
                        textStyle:{
                            fontSize: 20,
                            color: '#FFFFFF'
                        }
                    }
                }
            ],
            color:colorData,
            grid:{
                borderWidth:0,//外围边框线
                borderColor:'#e3b'
            },
            series : [
                {
                    name:'No Data',
                    type:'bar',
                    stack: 'percentage',
                    itemStyle : {
                        fontSize: 26,
                        normal: {
                            label : {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'normal'
                                },
                                formatter:function(obj){
                                    var c="";
                                    var xaixsData=xAxisData;
                                    var redDatas=redData;
                                    for(var i=0;i<7;i++){
                                        if(obj.name==xaixsData[i]){
                                            c+=redDatas[i];
                                        }
                                    }
                                    return c;
                                },
                                position: 'inside'
                            }
                        }
                    },
                    data:redPercent
                },
                {
                    name:'Bad',
                    type:'bar',
                    stack: 'percentage',
                    itemStyle : {
                        fontSize: 26,
                        normal: {
                            label : {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'normal'
                                },
                                formatter:function(obj){
                                    var c="";
                                    var xaixsData=xAxisData;
                                    var orangeDatas=orangeData;
                                    for(var i=0;i<7;i++){
                                        if(obj.name==xaixsData[i]){
                                            c+=orangeDatas[i];
                                        }
                                    }
                                    return c;
                                },
                                position: 'inside'
                            }
                        }
                    },
                    data:orangePercent
                },
                {
                    name:'Good',
                    type:'bar',
                    stack: 'percentage',
                    itemStyle : {
                        fontSize: 26,
                        normal: {
                            label : {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'normal'
                                },
                                formatter:function(obj){
                                    var c="";
                                    var xaixsData=xAxisData;
                                    var greenDatas=greenData;
                                    for(var i=0;i<7;i++){
                                        if(obj.name==xaixsData[i]){
                                            c+=greenDatas[i];
                                        }
                                    }
                                   return c;
                                },
                                position: 'inside'
                            }
                        }
                    },
                    data:greenPercent
                }
            ]
        };
        myChart.setOption(option);
        $("#all",window.parent.document).click(function(){
            myChart.resize();
        });
        $("#small",window.parent.document).click(function(){
            myChart.resize();
        });
        function eConsole(param){
            if (typeof param.seriesIndex == 'undefined') {
                return;
            }
            var data1 = [];
            var data2 = [];
            if (param.type == 'click') {
                var _treg = "TREG-"+param.name.charAt(param.name.length-1);
                var _kpitype = (tit.split(" ")[1]||tit.split(" ")[0]).toLocaleUpperCase()+"_KPI";
                $.ajax({
                    url: _ctx+"/mobile/cnopNoBad",
                    method: "get",
                    data: {
                        kpitype : _kpitype,
                        treg  : _treg,
                    },
                    dataType: "json",
                    success: function(data){
                                data1 = data.NoData||[];
                                data2 = data.Bad||[];
                                var tmpHtml = "";
                                var data1Len = data1.length||0;
                                var data2Len = data2.length||0;
                                //如果数据长度相等
                                if(data1Len==data2Len){
                                    for(var i=0;i<data1.length;i++){
                                        tmpHtml += "<tr><td>"+data1[i].msg+"</td><td>"+data2[i].msg+"</td></tr>";
                                    }
                                }
                                //如果数据长度不一样
                                if(data1Len<data2Len){
                                    for(var i=0;i<data1.length;i++){
                                        tmpHtml += "<tr><td>"+data1[i].msg+"</td><td>"+data2[i].msg+"</td></tr>";
                                    }
                                    for(var j=i;j<data2.length;j++){
                                        tmpHtml += "<tr><td></td><td>"+data2[j].msg+"</td></tr>";
                                    }
                                }
                                if(data1Len>data2Len){
                                    for(var i=0;i<data2.length;i++){
                                        tmpHtml += "<tr><td>"+data1[i].msg+"</td><td>"+data2[i].msg+"</td></tr>";
                                    }
                                    for(var j=i;j<data1.length;j++){
                                        tmpHtml += "<tr><td>"+data1[j].msg+"</td><td></td></tr>";
                                    }
                                }

                                $(".noData-content table tbody").html(tmpHtml);
                                $(".noData-content").show();

                        // $.ajax({
                        //     url: _ctx+"/mobile/cnopNoBad",
                        //     method: "get",
                        //     data: {
                        //         kpitype : _kpitype,
                        //         treg  : _treg,
                        //         sourceType: 'Bad'
                        //     },
                        //     dataType: "json",
                        //     success: function(data){
                        //         data2 = data;
                        //         var tmpHtml = "";
                        //         var data1Len = data1.length;
                        //         var data2Len = data2.length;
                        //         //如果数据长度相等
                        //         if(data1Len==data2Len){
                        //             for(var i=0;i<data1.length;i++){
                        //                 tmpHtml += "<tr><td>"+data1[i].msg+"</td><td>"+data2[i].msg+"</td></tr>";
                        //             }
                        //         }
                        //         //如果数据长度不一样
                        //         if(data1Len<data2Len){
                        //             for(var i=0;i<data1.length;i++){
                        //                 tmpHtml += "<tr><td>"+data1[i].msg+"</td><td>"+data2[i].msg+"</td></tr>";
                        //             }
                        //             for(var j=i;j<data2.length;j++){
                        //                 tmpHtml += "<tr><td></td><td>"+data2[j].msg+"</td></tr>";
                        //             }
                        //         }
                        //         if(data1Len>data2Len){
                        //             for(var i=0;i<data2.length;i++){
                        //                 tmpHtml += "<tr><td>"+data1[i].msg+"</td><td>"+data2[i].msg+"</td></tr>";
                        //             }
                        //             for(var j=i;j<data1.length;j++){
                        //                 tmpHtml += "<tr><td>"+data1[j].msg+"</td><td></td></tr>";
                        //             }
                        //         }
                        //
                        //         $(".noData-content table tbody").html(tmpHtml);
                        //         $(".noData-content").show();
                        //     },
                        //     error: function(){
                        //
                        //     }
                        // })
                    },
                    error: function(){

                    }
                })
            }
        }
    }
    initData();
    setInterval(function(){
        initData();
    },300000);
}());