/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/mobile/vMob92Data",
            method: "get",
            data:{
                type: type,
                show: '1'
            },
            dataType: "json",
            success: function(data){
                //initEchart1折线图，initEchart2圆形图
                //一个用户
                initEchart2("echart11");
                initEchart1("echart12");
                initEchart1("echart13");
                initEchart2("echart14");
                initEchart1("echart15");
                initEchart1("echart16");
                //两个用户
                initEchart2("echart21");
                initEchart1("echart22");
                initEchart1("echart23");
                initEchart2("echart24");
                initEchart1("echart25");
                initEchart1("echart26");

                initEchart2("echart31");
                initEchart1("echart32");
                initEchart1("echart33");
                initEchart2("echart34");
                initEchart1("echart35");
                initEchart1("echart36");

                initEchart2("echart41");
                initEchart1("echart42");
                initEchart1("echart43");
                initEchart2("echart44");
                initEchart1("echart45");
                initEchart1("echart46");

            },
            error: function(){

            }
        })
    }
    function initEchart1(domId) {
        var xAxisData =  ['周一','周二','周三','周四','周五','周六','周日'];
        var legendData = ['TREG 1','TREG 2','TREG 3','TREG 4','TREG 5','TREG 6','TREG 7'];
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: "Reactive TKT(30 DAYS)",
                x:'center',
                y: 'bottom',
                textStyle: {
                    fontSize: 18,
                    fontWeight: 'bolder',
                    color: '#FFF'
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
            series:  [
                {
                    name:'TREG 1',
                    type:'line',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'TREG 2',
                    type:'line',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'TREG 3',
                    type:'line',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'TREG 4',
                    type:'line',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'TREG 5',
                    type:'line',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                },
                {
                    name:'TREG 6',
                    type:'line',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                },
                {
                    name:'TREG 7',
                    type:'line',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart.setOption(option);
    }
    function initEchart2(idDom){
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title : {
                text: 'Reactive',
                x:'center',
                y: 'bottom',
                textStyle: {
                    fontSize: '18',
                    fontWeight: 'bolder',
                    color: '#fff'
                }
            },
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            legend: {
                show:false,
                data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
            },
            calculable : false,
            series : [
                {
                    name:'访问来源',
                    type:'pie',
                    radius : ['40%', '70%'],
                    itemStyle : {
                        normal : {
                            //不显示中间的字，而显示成饼图的那种label
                            label : {
                                show: true,
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
                    data:[
                        {value:335, name:'直接访问'},
                        {value:310, name:'邮件营销'},
                        {value:234, name:'联盟广告'},
                        {value:135, name:'视频广告'},
                        {value:1548, name:'搜索引擎'}
                    ]
                }
            ]
        };
        myChart.setOption(option);
    }
    initData();
}());