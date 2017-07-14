/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/enterprise/entData",
            method: "get",
            data:{
                type: _type
            },
            dataType: "json",
            success: function(data){
                var pieTop = data.pieProactiveList;
                var pieBottom = data.pieRightnowList;
                var lineTop = data.rightnowTicketM;
                var lineBottom = data.proactiveTicketM;
                var secPage = data.dto6List;
                var thirdPage =  data.dto7List;

                if(pieTop.length==0){
                    pieTop={
                        closenums: undefined,
                        opennums: undefined
                    }
                }else{
                    pieTop = data.pieProactiveList[0];
                }
                if(pieBottom.length==0){
                    pieBottom={
                        closenums: undefined,
                        opennums: undefined
                    }
                }else{
                    pieBottom = data.pieRightnowList[0];
                }

                var i = 1;
                initEchartPie("echart1",pieTop.closenums,pieTop.opennums,"Reactive");
                initEchartLine("echart2",lineTop,"Reactive TKT(30 DAYS)");
                initEchartPie("echart3",pieBottom.closenums,pieBottom.opennums,"Proactive");
                initEchartLine("echart4",lineBottom,"Proactive TKT(30 DAYS)");
                setInterval(function(){
                    i++;
                    if(i>=3){
                        i=0;
                    }
                    switch(i){
                        case 1:
                            $(".first-page").show();
                            $(".sec-page").hide();
                            $(".third-page").hide();
                            break;
                        case 2:
                            $(".first-page").hide();
                            $(".sec-page").show();
                            $(".third-page").hide();
                            initEchartScale("echart5",secPage);
                            break;
                        default:
                            $(".first-page").hide();
                            $(".sec-page").hide();
                            $(".third-page").show();
                            initEchartScale("echart6",thirdPage);
                            break;
                    }


                },2000);
            },
            error: function(){

            }
        })
    }
    function initEchartLine(domId,echartData,tit) {
        var legendData = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
        var seriesData = [];
        var xAxisData =  ['1','2','3','4','5','6','7','8','9','10',
            '11','12','13','14','15','16','17','18','19','20',
            '21','22','23','24','25','26','27','28','29','30'];
        legendData.forEach(function(el){
            var tmpObj = {};
            tmpObj.type = 'line';
            tmpObj.smooth = true;
            tmpObj.name = el;
            tmpObj.data = echartData[el];
            tmpObj.symbol = 'none';
            seriesData.push(tmpObj)
        });
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: tit,
                x:'center',
                y: 'bottom',
                textStyle: {
                    fontSize: '12',
                    fontWeight: 'bold',
                    color: '#BDBEC3'
                }
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                orient:'vertical',
                x:'right',
                y:'top',
                textStyle:{
                    fontSize: 12,
                    color:'#fff'
                },
                data:legendData
            },
            calculable: false,
            grid:{
                borderWidth:0,//外围边框线
                borderColor:'#666c7f'
            },
            xAxis: [
                {
                    type: 'category',
                    name:'Day',
                    boundaryGap : false,
                    axisLine : {    // 轴线
                        show: true
                    },
                    axisLabel : {//轴文本
                        show:false,
                        interval:0,    // {number}刻度的长短，可设为数字
                        rotate: 45,    //旋转度数
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: '#666C7F',
                            fontSize:15
                        }
                    },

                    lineStyle: {
                        color: 'green',
                        type: 'solid',
                        width: 2
                    },
                    splitLine : { //网格分隔线
                        show:false,
                        lineStyle: {
                            color: '#483d8b',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    splitArea : {show : false},//网格区域
                    data:xAxisData
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    axisLabel : {
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: '#fff',
                            fontSize:15
                        }
                    },
                    splitLine : { //分隔线
                        show:true,
                        lineStyle: {
                            color: '#666C7F',
                            type: 'dashed',
                            width: 1
                        }
                    }
                }
            ],
            series:  seriesData
        };
        myChart.setOption(option);
        $("#all",window.parent.document).click(function(){
            myChart.resize();
        });
        $("#small",window.parent.document).click(function(){
            myChart.resize();
        });
    }
    function initEchartPie(idDom,data1,data2,titName){
        var initData;
        var bgcolor = [];
        if(typeof(data1)=="undefined"&&typeof(data2)=="undefined"){
            initData=[
                {
                    value:1,name:'nodata'
                }
            ];
            bgcolor = ['#BDBEC3'];
        }else{
            initData=[
                {value:data1, name:'close'},
                {value:data2, name:'open'}
            ]
            bgcolor = ["#ff7f50", "#87cefa"];
        };
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title : {
                text: titName,
                x:'left',
                y: 'top',
                textStyle: {
                    fontSize: '16',
                    fontWeight: 'bold',
                    color: '#fff'
                }
            },
            color:bgcolor,
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c}"
            },
            legend: {
                show:false,
                data:['close','open']
            },
            calculable : false,
            series : [
                {
                    name:'',
                    type:'pie',
                    radius : ['40%', '70%'],
                    itemStyle : {
                        normal : {
                            //不显示中间的字，而显示成饼图的那种label
                            label : {
                                show: false,
                                position : 'inner',
                                // formatter: '{b} : {c} ({d}%)'
                                formatter: "{d}%"
                                //formatter: '{b} : {c} ({d}%)'
                            },
                            labelLine : {
                                show : false
                            }
                        },
                        emphasis : {
                            label : {
                                show : false,
                                position : 'center',
                                textStyle : {
                                    fontSize : '20',
                                    fontWeight : 'bold'
                                }
                            }
                        }
                    },
                    data:initData
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
    }
    function initEchartScale(idDom,data){
        var myChart = echarts.init(document.getElementById(idDom));
        var serisData = [];
        if(data.length==0){
            serisData = [{
                name:'nodata',
                type:'line',
                smooth:true,
                itemStyle: {normal: {areaStyle: {type: 'default'}}},
                data:[0]
            }];
        }
        option = {
            title : {
                text: '某楼盘销售情况',
                subtext: '纯属虚构'
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['意向','预购','成交']
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : serisData
        };
        myChart.setOption(option);
    }
    initData();
}());