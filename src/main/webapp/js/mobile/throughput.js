$(function(){
    var totalData;
    var nameList;
    var dataOder = ["JAKARTA","MAKASAR","PEKANBARU","SURABAYA"];
    $.ajax({
        url: _ctx+"/mobile/throughtputData",
        method: "get",
        dataType: "json",
        success: function (data) {
            totalData = data.agteMap;
            nameList = data.namelist;
            initEchart('echart1',nameList,totalData["JAKARTA"].in,totalData["JAKARTA"].out,totalData["JAKARTA"].opers,totalData["JAKARTA"].wrong,'JAKARTA');
        },
        error: function () {

        }
    });
    var i = 0;
    scroll(5,'first-nav','sec-nav');
    function scroll(count,domName1,domName2){
        setInterval(function(){
            i++;
            if(i>=count){
                i=0;
            }else{
                var index= i;
                var liNav = '.'+domName1+' li';
                var thisLi = '.'+domName1+' li:nth-child('+index+')';
                $(liNav).css("color","#727386");
                $(thisLi).css("color","#fff");

                var liNav2 = '.'+domName2+' li'+' span';
                var thisLi2 = '.'+domName2+' li:nth-child('+index+')'+' span';
                $(liNav2).css("backgroundColor","#0a0f25");
                $(thisLi2).css("backgroundColor","#4a476a");
                var objectName = dataOder[i];
                initEchart('echart1',nameList,totalData[objectName].in,totalData[objectName].out,totalData[objectName].opers,totalData[objectName].wrong,objectName);
            }
        },5000);
    }
    function initEchart(domId,xData,lineData1,lineData2,barData1,barData2,tit) {
        var legendData=["GbitsPerSecondOut","GbitsPerSecondIn"]
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            backgroundColor:'#0A0F25',
            color:['#ef8a92','#2c2a4e'],
            title: {
                text: tit,
                x:'center',
                y:'top',
                textStyle: {
                    fontSize: 24,
                    fontFamily: 'Arial',
                    color: '#E3E3DF'
                }
            },
            legend: {
                data: legendData,
                x: 'center',
                y: 'bottom',
                textStyle: {
                    fontSize: 16,
                    fontFamily: "Arial",
                    color: '#CECECE'
                }
            },
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            calculable : true,
            grid:{
                borderWidth: 1,
                color:'#494868'
            },
            xAxis : [
                {
                    type : 'category',
                    data: xData,
                    axisLabel:{
                        show: true,
                        textStyle:{
                            color:'#9FA0A1',
                        }
                    },
                    axisLine : {    // 轴线
                        show: true,
                        lineStyle: {
                            color: '#494868',
                            type: 'solid',
                            width: 2
                        },
                    },
                    splitLine : { //网格分隔线
                        show:true,
                        lineStyle: {
                            color: '#23283B',
                            type: 'solid',
                            width: 1
                        }
                    },
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    axisLabel:{
                        show: true,
                        textStyle:{
                            color:'#9FA0A1',
                        }
                    },
                    axisLine : {    // 轴线
                        show: true,
                        lineStyle: {
                            color: '#494868',
                            type: 'solid',
                            width: 2
                        },
                    },
                    splitLine : { //网格分隔线
                        show:true,
                        lineStyle: {
                            color: '#494868',
                            type: 'solid',
                            width: 1
                        }
                    },
                    splitArea:{
                        show: false
                    }
                }
            ],
            series :[{
                name: 'GbitsPerSecondIn',
                type: 'line',
                smooth:true,
                symbol:'none',
                data: lineData1
                },
                {
                    name: 'GbitsPerSecondOut',
                    type: 'line',
                    smooth:true,
                    symbol:'none',
                    data: lineData2
                },
                {
                    type: 'bar',
                    barWidth:'2',
                    itemStyle:{
                        normal:{
                            color: '#4B476A',
                            barBorderColor: '#4B476A',
                            barBorderWidth: 1,
                            barBorderRadius:0
                        }
                    },
                    data: barData1
                },
                {
                    type: 'bar',
                    barWidth:'2',
                    itemStyle:{
                        normal:{
                            color: '#4B476A',
                            barBorderColor: '#4B476A',
                            barBorderWidth: 1,
                            barBorderRadius:0
                        }
                    },
                    data: barData2
                }
            ]
        };
        myChart.setOption(option);
    }
});