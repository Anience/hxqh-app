/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/enterprise/top1Data",
            method: "get",
            data:{
                type: type,
                show: '2'
            },
            dataType: "json",
            success: function(data){
                var tool = new entUtil();
                //页面用户名展示
/*                $(".top2-layout-left .ent-header h4").text(data.enterpriseMap["2"].name);*/
                //sla数据展示
                tool.ShowSla(data.enterpriseMap["2"].threeColor,".top2-layout-left");
                //event
                tool.showEvent(data.enterpriseMap["2"].eventList,".top2-layout-left");
                //图标展示
                tool.showLogo(data.enterpriseMap["2"].iconList,".top2-layout-left");
                var leftTop1;
                var leftBottom1;
                //处理后台传回的数据为空的状态
                if(data.enterpriseMap["2"].rightnowList.length==0){
                    leftTop1 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    leftTop1 = data.enterpriseMap["2"].rightnowList[0];
                };
                if(data.enterpriseMap["2"].proactiveList.length==0){
                    leftBottom1 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    leftBottom1 = data.enterpriseMap["2"].proactiveList[0];
                }
                var middleTop1 = data.enterpriseMap["2"].rightnowTicketM;
                var middleTopName1 = data.enterpriseMap["2"].nameList;
                var middleBottom1 = data.enterpriseMap["2"].proactiveTicketM;
                var middleBottomName1 = data.enterpriseMap["2"].nameList;
                var rightTop1 = data.enterpriseMap["2"].enterpriseProductMap;
                var rightTopName1 = data.enterpriseMap["2"].productNameList;
                var rightBottom1 = data.enterpriseMap["2"].enterpriseRegionMap;
                var rightBName1 = data.enterpriseMap["2"].regionNameList;

                //页面用户名展示
                // $(".top2-layout-right .ent-header h4").text(data.enterpriseMap["3"].name);
                //sla数据展示
                tool.ShowSla(data.enterpriseMap["3"].threeColor,".top2-layout-right");
                //event
                tool.showEvent(data.enterpriseMap["3"].eventList,".top2-layout-right");
                //图标展示
                tool.showLogo(data.enterpriseMap["3"].iconList,".top2-layout-right");
                var leftTop2;
                var leftBottom2;
                //处理后台传回的数据为空的状态
                if(data.enterpriseMap["3"].rightnowList.length==0){
                    leftTop2 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    var leftTop2 = data.enterpriseMap["3"].rightnowList[0];
                };
                if(data.enterpriseMap["3"].proactiveList.length==0){
                    leftBottom2 = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    leftBottom2 = data.enterpriseMap["3"].proactiveList[0];
                }
                var middleTop2 = data.enterpriseMap["3"].rightnowTicketM;
                var middleTopName2 = data.enterpriseMap["3"].nameList;
                var middleBottom2 = data.enterpriseMap["3"].proactiveTicketM;
                var middleBottomName2 = data.enterpriseMap["3"].nameList;
                var rightTop2 = data.enterpriseMap["3"].enterpriseProductMap;
                var rightTopName2 = data.enterpriseMap["3"].productNameList;
                var rightBottom2 = data.enterpriseMap["3"].enterpriseRegionMap;
                var rightBName2 = data.enterpriseMap["3"].regionNameList;
                //initEchart1折线图，initEchart2圆形图
                initEchart2("echart11",leftTop1.closenums,leftTop1.opennums,"PERCENTAGE REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart12",middleTop1,middleTopName1,"REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart13",rightTop1,rightTopName1,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                initEchart2("echart14",leftBottom1.closenums,leftBottom1.opennums,"ERCENTAGE PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart15",middleBottom1,middleBottomName1,"PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart16",rightBottom1,rightBName1,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
                //initEchart1折线图，initEchart2圆形图
                //两个用户
                initEchart2("echart21",leftTop2.closenums,leftTop2.opennums,"PERCENTAGE REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart22",middleTop2,middleTopName2,"REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart23",rightTop2,rightTopName2,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                initEchart2("echart24",leftBottom2.closenums,leftBottom2.opennums,"ERCENTAGE PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart25",middleBottom2,middleBottomName2,"PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart26",rightBottom2,rightBName2,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
            },
            error: function(){

            }
        })
    }
    function initEchart1(domId,echartData,xData,tit) {
        var xAxisData =  xData;
        var legendData;
        var seriesData = [];
        if(domId=='echart13'||domId=='echart23'){
            legendData = ['ASTINET','IPTRANSIT','VPNIP'];
        }else{
            legendData = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
        }
        if(echartData.length==0){
            seriesData = [{
                name:'nodata',
                type:'line',
                smooth:true,
                data:[0]
            }];
        }else{
            legendData.forEach(function(el){
                var tmpObj = {};
                tmpObj.type = 'line';
                tmpObj.smooth = true;
                tmpObj.name = el;
                tmpObj.data = echartData[el];
                tmpObj.symbol = 'none';
                seriesData.push(tmpObj)
            });
        }
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
                show:false,
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
                width: '100%',
                height: '60%',
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
    function initEchart2(idDom,data1,data2,titName){
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
                x:'center',
                y: 'bottom',
                textStyle: {
                    fontSize: '12',
                    fontWeight: 'bold',
                    color: '#BDBEC3'
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
    initData();
}());