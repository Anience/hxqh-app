$(function(){
	initEchart("echart1",'Node:8');
	var i=0;
	scroll(5);
	function scroll(count){
		setInterval(function(){
           i++;
           if(i>=count){
              i=0;
           }else{
           	  initEchart("echart1",'Node:'+i); 
           }
		},5000);
	}
	function initEchart(domId,tit) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			   backgroundColor:'#0A0F25',
			   color:['#ef8a92','#2c2a4e'],
			   title: {
			        text: tit,
			        x:'right',
			        y:'top',
			        textStyle: {
			            fontSize: 24,
			            fontFamily: 'Arial',
			            color: '#E3E3DF'
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
			             data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
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
			            name: '蒸发量',
			            type: 'line',
			            smooth:true,
			            symbol:'none',
			            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
			        },
			        {
			            name: '降水量',
			            type: 'bar',
			            barWidth:'20',
			            itemStyle:{
			                 normal:{
			                      color: '#4B476A',
			                      barBorderColor: '#4B476A',
			                      barBorderWidth: 6,
			                      barBorderRadius:0
			                 }
			            },
			            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
			        }
			    ]
			};               
        myChart.setOption(option);
    }
});