
$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/ano/asrbdisData",
            method: "get",
            dataType: "json",
            success: function (data) {
                //处理数据，数据顺序输出
                var totalData =  data.group;;
                var legendData = ["w1Attempt","w2Attempt","w1Answer","w2Answer"];
                var xData = totalData.BD1S.weekday;
                var data = [];
                for(var i=0;i<legendData.length;i++){
                    var tmpObj = {};
                    tmpObj.name=legendData[i];
                    if(legendData[i]=="w1Attempt"||legendData[i]=="w2Attempt"){
                        tmpObj.type="bar";
                    }else{
                        tmpObj.type="line";
                    }
                    tmpObj.data=totalData.BD1S[legendData[i]];
                    data.push(tmpObj);
                }
                initELine('echart1',data,legendData,xData);

                //轮播图
                var j = 0;
                setInterval(function(){
                    j++;
                    if(j>=8){
                        j=0;
                    }else{
                        var index= j;
                        var liNav = '.first-nav li';
                        var thisLi = '.first-nav li:nth-child('+index+')';
                        $(liNav).css("color","#727386");
                        $(thisLi).css("color","#fff");

                        var liNav2 = '.sec-nav li'+' span';
                        var thisLi2 = '.sec-nav li:nth-child('+index+')'+' span';
                        $(liNav2).css("backgroundColor","#0a0f25");
                        $(thisLi2).css("backgroundColor","#4a476a");

                        var objName = 'TREG-'+j;
                        initELine('echart1');
                    }
                },5000);
            },
            error: function () {
            }
        });
    }
    init();

    //调用此函数时，参数domId,data,legendData,xData
    function initELine(domId,data,legendData,xData) {
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            backgroundColor: '#0A0F25',
            color:['#4B92D1','#70AD47','#FFC300','#A3A3A3'],

            tooltip: {
                trigger: 'axis'
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
            calculable: true,
            grid: {
                show: false,
                borderWidth: 1,
                borderColor: '#212538'
            },
            xAxis: [{
                show: true,
                type: 'category',
                axisLabel: {
                    show: true,
                    textStyle: {
                        fontSize: 12,
                        fontFamily: "Arial",
                        color: '#9F9FA1'
                    }
                },
                splitArea: {
                    show: false
                },
                splitLine: {
                    show: false,
                    lineStyle: {
                        color: '#212538',
                    }
                },
                data: xData
            }],
            yAxis: [{
                type: 'value',
                axisLabel: {
                    show: true,
                    textStyle: {
                        fontSize: 12,
                        fontFamily: "Arial",
                        color: '#9F9FA1'
                    }
                },
                splitArea: {
                    show: false
                },
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#212538',
                    }
                },
            }],
            series : data
        };
        myChart.setOption(option);
    }
});
