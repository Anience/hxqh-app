/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mttr-data",
        data: {
            mttrLeft: [],
            mttrRight: []
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiMttrData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.mttrLeft = data.leftList;
                    self.mttrRight = data.rightList;
                    initEchart("echart1",data.vWifiMttrList);
                    var pageW = $("table.mttr").width()*2+40;
                    $("#mttr-data").width(pageW);
                    $("#mttr-data").css("paddingBottom","20");
                    $("#mttr-data  h4").width(pageW);
                },
                error: function () {

                }
            });
        }
    });
    function initEchart(domId,echartData) {
        var myChart = echarts.init(document.getElementById(domId));
        var xData = ["NAS","TREG-1","TREG-2","TREG-3","TREG-4","TREG-5","TREG-6","TREG-7"];
        var seriesData = [];
        option = {
            backgroundColor: '#0c0e26',//背景色
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'none'
                },
                formatter: function(params) {
                    var color = '#87cefa';
                    var res = '<div style="color:' + color + '">';
                    res += '<strong>' + params[0].name + '</strong>'
                    for (var i = 0, l = params.length; i < l; i++) {
                        res += '<br/>' + params[i].seriesName + ' : ' + params[i].value
                    }
                    res += '</div>';
                    return res;
                }
            },
            color:['#009900','#FFFF00','#FF0000'],
            calculable: false,
            xAxis: [
                {
                    type: 'category',
                    name:'Region',
                    axisTick:{
                        interval:0
                    },
                    lineStyle: {
                        color: '#FFFFFF',
                        type: 'solid',
                        width: 2
                    },
                    axisLabel : {//轴数据风格
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        //rotate: 30,
                        margin:5,
                        splitNumber: 100,
                        textStyle:{
                            color: '#FFFFFF'
                        }
                    },
                    splitLine : {
                        show:false,
                        lineStyle: {
                            color: '#FFFFFF',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    data:xData
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name:'value',
                    axisLabel : {//轴数据风格
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        //rotate: 30,
                        margin:5,
                        splitNumber: 100,
                        textStyle:{
                            color: '#FFFFFF'
                        }
                    },
                    splitLine : { //分隔线
                        show:true,
                        lineStyle: {
                            color: '#FFFFFF',
                            type: 'dashed',
                            width: 1
                        }
                    }
                }
            ],
            series : [
                {
                    name:'>=90:',
                    type:'bar',
                    data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2,],
                },
                {
                    name:'75~90:',
                    type:'bar',
                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2]
                },
                {
                    name:'<75:',
                    type:'bar',
                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2]
                }
            ]
        };
        myChart.setOption(option);
    }
});
