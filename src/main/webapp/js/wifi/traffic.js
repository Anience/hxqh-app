/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/wifi/vWifiTrafficData",
            method: "get",
            dataType: "json",
            success: function(data){
                initEchart("echart1",data.strTop,data.nameList);
                initEchart("echart2",data.strBottom,data.nameBottomList);
            },
            error: function(){

            }
        })
    }
    function initEchart(domId,echartSData,echartName) {
        var legendData = [];
        var seriesData = [];
        var xAxisData = echartName;
        if(domId=="echart1"){
            legendData = ['TREG 1','TREG 2','TREG 3','TREG 4','TREG 5','TREG 6','TREG 7'];
        }else{
            legendData = ['CONS','DWS','EBIS'];
        }
        for(var i=0,len=echartSData.length;i<len;i++){
            var tmpObj = {};
            tmpObj.type = 'line';
            tmpObj.stack = '总量';
            tmpObj.name = echartSData[i].da;
            tmpObj.data = echartSData[i].str.split(",");
            seriesData.push(tmpObj)
        }
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: "Daily Traffic Distribution By Regions-Jun 2017",
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
                data:legendData
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
                    data : xAxisData
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
            series :  seriesData
        };
        myChart.setOption(option);
    }
    initData();
}());