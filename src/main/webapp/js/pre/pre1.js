$(function(){
	var data1 = [{
			            name: '蒸发量',
			            type: 'bar',
			            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
			        },
			        {
			            name: '降水量',
			            type: 'bar',
			            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
			        }
			    ];
    var legend1 = ['蒸发量', '降水量'];
    var tit1 = "Today’s Status WO on FFM";
    var data3 = [{
			            name: '蒸发量',
			            type: 'bar',
			            data: [0, 0, 0, 0, 0, 0, 0, 0, 32.6, 20.0, 6.4, 3.3]
			        }
			    ];
	var legend3 = ['蒸发量'];
	var tit3 = "Accumulated Closed Order Volume ";
	initELine("echart1",tit1,data1,legend1);
	initELine("echart3",tit3,data3,legend3);
	var tit21 = "RA";
	var legend2=['直接访问','邮件营销'];
	var data2 =[
		             { value: 335, name: '直接访问' },
		             { value: 310, name: '邮件营销' },
		         ];
	var tit22 = "SA";
	initEPie("echart21",tit21,data2,legend2,'false');
	initEPie("echart22",tit22,data2,legend2,'true');
	var tit4 = "Time Achievement ofWO on FFM（weekly） ";
	initE("echart4",tit4);
	function initELine(domId,tit,data,legendData) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			    backgroundColor: '#0A0F25',
			    color: ['#4a476a', '#d46e87'],
			    title: {
			        text: tit,
			        textStyle: {
			            fontSize: 26,
			            fontFamily: 'Arial',
			            color: '#9F9FA1'
			        }
			    },
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
			            show: true,
			            lineStyle: {
			                color: '#212538',
			            }
			        },
			        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
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
    function initEPie(domId,tit,data,legendData,legendShow) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			    backgroundColor: '#0A0F25',
			    color: ['#4a476a', '#d46e87'],
			    title: {
			        text: tit,
			        x: 'center',
			        y: 'top',
			        textStyle: {
			            fontSize: 26,
			            fontFamily: 'Arial',
			            color: '#9F9FA1'
			        }
			    },
			    legend: {
			    	show: legendShow,
			        data: legendData,
			        x: 'right',
			        y: 'top',
			        textStyle: {
			            fontSize: 16,
			            fontFamily: "Arial",
			            color: '#CECECE'
			        }
			    },
			     series: [{
		         type: 'pie',
		         radius: '55%',
		         center: ['50%', '60%'],
		         data: data
		     }]
			};      
        myChart.setOption(option);
    }
    function initE(domId,tit){
    	var myChart = echarts.init(document.getElementById(domId));
    	var dataStyle = {
				    normal: {
				        label: { show: false },
				        labelLine: { show: false }
				    }
				};
		var placeHolderStyle = {
		    normal: {
		        color: 'rgba(0,0,0,0)',
		        label: { show: false },
		        labelLine: { show: false }
		    },
		    emphasis: {
		        color: 'rgba(0,0,0,0)'
		    }
		};
		option = {
		    title: {
		        text: tit,
		        x: 'left',
		        y: 'top',
		        textStyle: {
			            fontSize: 26,
			            fontFamily: 'Arial',
			            color: '#9F9FA1'
			   }
		    },
		    backgroundColor: '#0A0F25',
		    color:['#484969','#f7aa62','#d46e87'],
		    tooltip: {
		        show: true,
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'top',
		        y: 'right',
		        data: ['68%的人表示过的不错', '29%的人表示生活压力很大', '3%的人表示“我姓曾”']
		    },
		    series: [{
		            name: '1',
		            type: 'pie',
		            clockWise: false,
		            radius: [125, 150],
		            itemStyle: dataStyle,
		            data: [{
		                    value: 68,
		                    name: '68%的人表示过的不错'
		                },
		                {
		                    value: 32,
		                    name: 'invisible',
		                    itemStyle: placeHolderStyle
		                }
		            ]
		        },
		        {
		            name: '2',
		            type: 'pie',
		            clockWise: false,
		            radius: [100, 125],
		            itemStyle: dataStyle,
		            data: [{
		                    value: 29,
		                    name: '29%的人表示生活压力很大'
		                },
		                {
		                    value: 71,
		                    name: 'invisible',
		                    itemStyle: placeHolderStyle
		                }
		            ]
		        },
		        {
		            name: '3',
		            type: 'pie',
		            clockWise: false,
		            radius: [75, 100],
		            itemStyle: dataStyle,
		            data: [{
		                    value: 3,
		                    name: '3%的人表示“我姓曾”'
		                },
		                {
		                    value: 97,
		                    name: 'invisible',
		                    itemStyle: placeHolderStyle
		                }
		            ]
		        }
		    ]
		};
		 myChart.setOption(option);
    }
});