
$(function(){
	var data = [{
			            name: '蒸发量',
			            type: 'bar',
			            barWidth:'40',
			            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7]
			        },
			        {
			            name: '降水量',
			            type: 'line',
			            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7]
			        }
			    ];
    var legend = ['蒸发量', '降水量'];
    var tit = "Today’s Status WO on FFM";
initELine('echart1',data,legend);
function initELine(domId,data,legendData) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			    backgroundColor: '#0A0F25',
			    color:['#4a476a','#6b6082','#9f5b72','#ef7d58','#e8b46f','#787388'],
			    color: ['#4a476a', '#d46e87'],
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data: legendData,
			        x: 'right',
			        y: 'top',
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
			        data: ['1月', '2月', '3月', '4月', '5月', '6月']
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
			    series: data
			};      
        myChart.setOption(option);
    }
});
