$(function(){
	function init(){
		$.ajax({
			url: _ctx+"/sla/variousunitData",
			method: "get",
			dataType: "json",
			success: function (data) {
				var leftTop  = data.fmap.DBS.lefttop;
				var rightTop = data.fmap.DBS.righttopList;
				//初始化左上的数据
				$('.t_standard').text(leftTop.tStandard);
				$('.t_closeYear').text(leftTop.closeYears);
				$('.t_num').text(leftTop.ticketNums);
				$('.r_mtt').text(leftTop.rMtt);
				$('.class_name').text('DBS');
				initEchart('echart1',true,true);
				initEchart('echart2',false,false);
				initEchart('echart3',false,false);
				initEchart('echart4',false,false);
				initPie('echart',leftTop.openMttrLeft,leftTop.colseMttrLeft);
			},
			error: function () {

			}
		});
	}
	init();
	function initPie(domId,data1,data2){
		var myChart = echarts.init(document.getElementById(domId));
		option = {
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			series : [
				{
					name:'mttr',
					type:'pie',
					radius : ['50%', '70%'],
					itemStyle : {
						normal : {
							label : {
								show : false
							},
							labelLine : {
								show : false
							}
						},
						emphasis : {
							label : {
								show : true,
								position : 'center',
								textStyle : {
									fontSize : '12',
									fontWeight : 'bold'
								}
							}
						}
					},
					data:[
						{value:data1, name:'open'},
						{value:data2, name:'close'}
					]
				}
			]
		};
		myChart.setOption(option);
	}
	function initEchart(domId,isTit,isLabel) {
		var myChart = echarts.init(document.getElementById(domId));
		option = {
			backgroundColor:'#0a0f25',
			title : {
				show:isTit,
				text: 'closed',
				x:'center',
				y:'bottom',
				textStyle : {
					fontSize : '30',
					fontWeight : 'bold',
					color: '#cecece'
				}
			},
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			series : [
				{
					name:'访问来源',
					type:'pie',
					itemStyle:{
						normal:{
							label:{
								show: isLabel,
								position:'inner'
							},
							labelLine:{
								show:false
							}
						}
					},
					radius : '40%',
					center: ['50%', '40%'],
					data:[
						{value:335, name:'直接访问'},
						{value:310, name:'邮件营销'},
						{value:234, name:'联盟广告'}
					]
				}
			]
		};
		myChart.setOption(option);
	}

});