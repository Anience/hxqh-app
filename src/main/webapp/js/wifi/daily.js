/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/wifi/vWifiDailyData",
            method: "get",
            dataType: "json",
            success: function(data){
                initEchart("echart1",data.trafficTopList);
                /*initEchart("echart2",data.trafficBottomList);*/
            },
            error: function(){

            }
        })
    }
    function initEchart(domId,echartData) {
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: "Daily Ticket Distribution",
                x: "left"
            },
            tooltip: {
                trigger: "item",
                formatter: "{a} <br/>{b} : {c}"
            },
            legend: {
                orient:'vertical',
                x:'right',
                y:'top',
                textStyle:{
                    fontSize: 12,
                    color: '#666C7F',
                },
                data: ["2的指数", "3的指数"]
            },
            xAxis: [
                {
                    type: "category",
                    name: "x",
                    splitLine: {show: false},
                    axisLabel:{
                        show: true,
                        textStyle: {
                            color: '#666C7F',   //x轴字体颜色
                        }
                    },
                    data: ["一", "二", "三", "四", "五", "六", "七", "八", "九"]
                }
            ],
            yAxis: [
                {
                    type: "log",
                    splitLine: {
                        show: true,
                        lineStyle: {
                            type: 'dashed',
                        }
                    },
                    axisLabel:{
                        show: true,
                        textStyle: {
                            color: '#666C7F',   //x轴字体颜色
                        }
                    },
                    name: "y"
                }
            ],
            calculable: true,
            series: [
                {
                    name: "3的指数",
                    type: "line",
                    data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669]

                },
                {
                    name: "2的指数",
                    type: "line",
                    data: [1, 2, 4, 8, 16, 32, 64, 128, 256]

                }
            ]
        };
        myChart.setOption(option);
    }
    initData();
}());