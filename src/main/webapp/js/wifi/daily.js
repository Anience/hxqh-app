/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/wifi/wifiDailyData",
            method: "get",
            dataType: "json",
            success: function(data){
                initEchart("echart1",data.list,data.skuIdMap);
            },
            error: function(){

            }
        })
    }
    function initEchart(domId,yData,serisData) {
        var yName = yData;
        var lendName = ["DCS","DES","DGS"];
        var serisDatas = [];
        for(var name in serisData){
            var tmpObj = {};
            tmpObj.name = name;
            tmpObj.type ="line";
            tmpObj.data = serisData[name];
            serisDatas.push(tmpObj);
        }
        console.log(serisDatas);
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: "Daily Ticket Distribution",
                x: "left",
                backgroundColor:'#161C2F',
                textStyle:{
                    fontSize: '16px',
                    fontWeight: 'bold',
                    fontFamily: 'Arial, Verdana, sans-serif'
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
                    color: '#666C7F',
                },
                data:lendName
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    splitLine: {
                        show: false,
                    },
                    axisLabel:{
                        show: true,
                        textStyle: {
                            color: '#666C7F',   //x轴字体颜色
                        }
                    },
                    data : yName
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    splitLine: {
                        show: true,
                        lineStyle: {
                            type: 'dashed',
                        }
                    },
                    axisLabel:{
                        show: true,
                        textStyle: {
                            color: '#666C7F',   //y轴字体颜色
                        }
                    },
                }
            ],
            series :  serisDatas
        };
        myChart.setOption(option);
    }
    initData();
}());