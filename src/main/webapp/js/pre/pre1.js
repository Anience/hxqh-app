$(function(){
	init();
	function init(){
		$.ajax({
			url: _ctx+"/ano/realtimeData",
			method: "get",
			dataType: "json",
			success: function (data) {
				var data1 = [];
				var legend1 = [];
				var tit1 = "Today’s Status WO on FFM";
				var xData1 = data.name2List;
				var echartData1 = data.pillartM;
				for(var name in echartData1){
					legend1.push(name);
					var tmpObj = {};
					tmpObj.name = name;
					tmpObj.type = 'bar';
					tmpObj.data = echartData1[name];
					data1.push(tmpObj);
				}
				initELine("echart1",tit1,data1,legend1,xData1);

				var xData3 = data.name3List;
				var data3 = [{
					name: 'Closed Order',
					type: 'bar',
					data: data.value3List
				}
				];
				var legend3 = ['Closed Order'];
				var tit3 = "Accumulated Closed Order Volume ";
				initELine("echart3",tit3,data3,legend3,xData3);
			},
			error: function () {

			}
		});
	}

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
	function initELine(domId,tit,data,legendData,xData) {
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
			    // tooltip: {
			    //     trigger: 'axis'
			    // },
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