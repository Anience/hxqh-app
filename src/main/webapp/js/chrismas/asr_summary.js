
$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/ano/asrsummaryData",
            method: "get",
            dataType: "json",
            success: function (data) {
                //处理数据，数据顺序输出
                initELine('echart1');
            },
            error: function () {
            }
        });
        initELine('echart1');
    }
    init();

    //调用此函数时，参数domId,data,legendData,xData
    function initELine(domId) {
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            backgroundColor: '#0A0F25',
            color:['#4B92D1','#70AD47','#FFC300','#A3A3A3'],

            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['蒸发量','降水量','蒸发量line','降水量line'],
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
                data: ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sept','Oct','Nov','Dec']
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
            series : [
                {
                    name:'蒸发量',
                    type:'bar',
                    data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                },
                {
                    name:'降水量',
                    type:'bar',
                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                },
                {
                    name:'蒸发量line',
                    type:'line',
                    data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                },
                {
                    name:'降水量line',
                    type:'line',
                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                }
            ]
        };
        myChart.setOption(option);
    }
});
