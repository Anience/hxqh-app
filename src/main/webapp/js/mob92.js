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
                initEchart("echart1",data);
            },
            error: function(){

            }
        })
    }
    function initEchart(domId,echartData) {
        var legendData = [];
        var xAxisData = ['周一','周二','周三','周四','周五','周六','周日'];
        var seriesData = [];
        /*for(var i=0,len=echartData.length;i<len;i++){
            legendData = echartData[i].name;
        }*/
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data:['直接访问', '邮件营销','联盟广告','视频广告','搜索引擎'],
                x:'right'
            },
            calculable : true,
            xAxis : [
                {
                    type : 'value',
                    splitLine: {
                        show: false,
                    },
                    axisLabel:{
                        show: true,
                        textStyle: {
                            color: '#fff',   //x轴字体颜色
                        }
                    },
                }
            ],
            yAxis : [
                {
                    type : 'category',
                    splitLine: {
                        show: false,
                    },
                    axisLabel:{
                        show: true,
                        textStyle: {
                            color: '#fff',   //x轴字体颜色
                        }
                    },
                    data : ['周一','周二','周三','周四','周五','周六','周日']
                }
            ],
            series : [
                {
                    name:'直接访问',
                    type:'bar',
                    stack: '总量',
                    itemStyle : { normal: {color: 'red',barBorderRadius: 0,label : {show: true, position: 'insideRight'}}},
                    data:[320, 302, 301, 334, 390, 330, 320]
                },
                {
                    name:'邮件营销',
                    type:'bar',
                    stack: '总量',
                    itemStyle : { normal: {barBorderRadius: 0,label : {show: true, position: 'insideRight'}}},
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'联盟广告',
                    type:'bar',
                    stack: '总量',
                    itemStyle : { normal: {barBorderRadius: 0,label : {show: true, position: 'insideRight'}}},
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'视频广告',
                    type:'bar',
                    stack: '总量',
                    itemStyle : { normal: {barBorderRadius: 0,label : {show: true, position: 'insideRight'}}},
                    data:[150, 212, 201, 154, 190, 330, 410]
                },
                {
                    name:'搜索引擎',
                    type:'bar',
                    stack: '总量',
                    itemStyle : { normal: {barBorderRadius: 0,label : {show: true, position: 'insideRight'}}},
                    data:[820, 832, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart.setOption(option);
    }
    initData();
}());