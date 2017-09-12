$(function(){
	init();
	function init(){
		$.ajax({
			url: _ctx+"/ano/realtimeData",
			method: "get",
			dataType: "json",
			success: function (data) {
                var d = new Date();
                var years = d.getFullYear();
                var month = add_zero(d.getMonth()+1);
                var days = add_zero(d.getDate());
                var hours = add_zero(d.getHours());
                var minutes = add_zero(d.getMinutes());
                var second=add_zero(d.getSeconds());
                var nowTime = years+"-"+month+"-"+days+" "+hours+":"+minutes+":"+second;
                function add_zero(temp) {
                    if(temp<10) return "0"+temp;
                    else return temp;
                }
                var time ='Last Update:'+ nowTime;
                $('.ticket-time').text(time);
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

				var pieMap = data.pieMap.PIE;
				var tit21 = "RA";
				var legend2=['Open','Close'];
				var data21 =[
					{ value: 0, name: 'Close' },
					{ value: 0, name: 'Open' },
				];
				var data22 =[
					{ value: 0, name: 'Close' },
					{ value: 0, name: 'Open' },
				];
				data21[0].value = pieMap[0].jumlah;
				data21[1].value = pieMap[2].jumlah;
				data22[0].value = pieMap[1].jumlah;
				data22[1].value = pieMap[3].jumlah;
				var tit22 = "SA";
				initEPie("echart21",tit21,data21,legend2,true);
				initEPie("echart22",tit22,data22,legend2,true);

				var tit4 = "Time Achievement of WO on FFM（weekly）";
				var echartData4 = data.arcList;
				initE("echart4",tit4,echartData4[0].jumlah,echartData4[1].jumlah,echartData4[2].jumlah)
			},
			error: function () {

			}
		});
	}
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
				 itemStyle:{
		         	normal:{
		         		label:{
		         			show:true,
							position:'inner',
							formatter:"{b} : {d}%  {c}",
							textStyle:{
								color:'#fff',
								fontSize:14
							}
						},
						labelLine:{
							show:false
						}
					}
					 },
		         data: data
		     }]
			};      
        myChart.setOption(option);
    }
    function initE(domId,tit,data1,data2,data3){
    	var myChart = echarts.init(document.getElementById(domId));
    	var dataStyle1 = {
				    normal: {
				    	color:'green',
				        label: { show: true,data:data1,formatter: "{b}:\n{c}({d}%)" },
				        labelLine: { show: true,length:30 }
				    }
				};
		var dataStyle2 = {
			normal: {
				color:'yellow',
				label: { show: true ,data:data2,formatter: "{b}:\n{c}({d}%)"},
				labelLine: { show: true,length:50 }
			}
		};
		var dataStyle3 = {
			normal: {
				color:'red',
				label: { show: true,data:data3,formatter: "{b}:\n{c}({d}%)" },
				labelLine: { show: true ,length:70}
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
			color:['green','yellow','red'],
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
		    tooltip: {
		        show: true,
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		    	show: true,
		        orient: 'vertical',
                x: 'left',
                y: '50px',
                textStyle: {
                    color:'#9F9FA1'
                },
		        data: ['Less 12 hours', '12 hours<yellow<24 hours', 'Red>24 hours']
		    },
		    series: [{
		            name: '1',
		            type: 'pie',
		            clockWise: false,
		            radius: [125, 150],
		            itemStyle: dataStyle1,
		            data: [{
		                    value: data1,
		                    name: 'Less 12 hours'
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
		            itemStyle: dataStyle2,
		            data: [{
		                    value: data2,
		                    name: '12 hours<yellow<24 hours'
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
		            itemStyle: dataStyle3,
		            data: [{
		                    value: data3,
		                    name: 'Red>24 hours'
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