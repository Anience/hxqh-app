$(function(){
	$.ajax({
		url: _ctx+"/ano/wifiIndData",
		method: "get",
		dataType: "json",
		success: function (data) {

		},
		error: function () {

		}
	});
	initEchart("echart1");
	initEScale("echart2",'PLATINUM');
	initEScale("echart3",'TITANNIUM&GOLD');
	initEScale("echart4",'SILVER');
	var i = 0;
	scroll(9,'first-nav','sec-nav');
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
           }
		},5000);
	}
	function initEchart(domId) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			  backgroundColor:'#0A0F25',
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    legend: {
			        data:['邮件营销','联盟广告','视频广告'],
			        x: 'right',
			        y: 'top',
			        textStyle:{
			           fontSize: 12,
			           color: '#B4B3B3'
			       }
			    },
			    calculable : true,
			    grid:{
			        borderWidth: 0
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data : ['周一','周二','周三','周四','周五','周六','周日'],
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
			    series : [
			        {
			            name:'邮件营销',
			            type:'bar',
			            barWidth:'30',
			            itemStyle:{
			                 normal:{
			                      color: '#4B476A',
			                      barBorderColor: '#4B476A',
			                      barBorderWidth: 6,
			                      barBorderRadius:0,
			                      label:{
			                            show: true,
			                            position:'inside',
			                            textStyle:{
			                                color: '#fff',
			                                align: 'center',
			                                fontSize: 12,
			                            }
			                      }
			                 }
			            },
			            stack: '广告',
			            data:[120, 132, 101, 134, 90, 230, 210]
			        },
			        {
			            name:'联盟广告',
			            type:'bar',
			            stack: '广告',
			            itemStyle:{
			                 normal:{
			                      color: '#D46E86',
			                      barBorderColor: '#D46E86',
			                      barBorderWidth: 6,
			                      barBorderRadius:0,
			                      label:{
			                            show: true,
			                            position:'inside',
			                            textStyle:{
			                                color: '#fff',
			                                align: 'center',
			                                fontSize: 12,
			                            }
			                      }
			                 }
			            },
			            data:[220, 182, 191, 234, 290, 330, 310]
			        },
			        {
			            name:'视频广告',
			            type:'bar',
			            stack: '广告',
			            itemStyle:{
			                 normal:{
			                      color: '#F7AA62',
			                      barBorderColor: '#F7AA62',
			                      barBorderWidth: 6,
			                      barBorderRadius:0,
			                      label:{
			                            show: true,
			                            position:'inside',
			                            textStyle:{
			                                color: '#fff',
			                                align: 'center',
			                                fontSize: 12,
			                            }
			                      }
			                 }
			            },
			            data:[150, 232, 201, 154, 190, 330, 410]
			        },
			     ]
			};               
        myChart.setOption(option);
    }
    function initEScale(domId,tit){
        var myChart = echarts.init(document.getElementById(domId));
			option = {
			  backgroundColor:'#0A0F25',
			   title: {
			        text: tit,
			        backgroundColor:'#2a2b48',
			        textStyle: {
			            fontSize: 12,
			            fontFamily: 'Arial',
			            color: '#9F9FA1'
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
			        borderWidth: 0,
			        x:'40',
			        y:'40',
			        width: '90%',
			        height: '40%'
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data : ['周一','周二','周三','周四','周五','周六','周日'],
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
			    series : [
			        {
			            name:'成交',
			            type:'line',
			            smooth:true,
			            symbol:'none',
			            itemStyle: {
			            	normal: {
			            		areaStyle: {
			            			type: 'default',
			            			color:'#2a2b48'
			            		},
			            		lineStyle: {
                                    color:'#2a2b48'
			            		}
			            	}
			            },
			            data:[10, 12, 21, 54, 260, 830, 710]
			        }
			     ]
			};               
        myChart.setOption(option);
    }
});