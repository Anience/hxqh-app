$(function(){
	initEPie("echart1");
	initEPie("echart2");
	initEPie("echart3");
	initEPie("echart4");
	scroll('5','treg14');
	scroll('4','treg57');
	function scroll(count,domName){
		var i = 0;
		setInterval(function(){
           i++;
           if(i>=count){
              i=0;
           }else{
           	  var index= i+1; 
           	  var liNav = '.'+domName+' li';
           	  var thisLi = '.'+domName+' li:nth-child('+index+')';
              $(liNav).css("color","#727386");
			  $(thisLi).css("color","#fff");
           }
		},5000);
	}
	function initEPie(domId) {
        var myChart = echarts.init(document.getElementById(domId));
			option = {
				background:'#21233c',
			    color:['#35314e','#d46e87'],
			    series : [{
			            type:'pie',
			            radius : '55%',
			            center: ['50%', '50%'],
			            itemStyle:{
			             normal:{
			                label:{
			                    show: true,
			                    position:'inner'
			                },
			               labelLine:{
			                  show:false
			               }
			              }
			            },
			            data:[
			                {value:335, name:'直接访问'},
			                {value:310, name:'邮件营销'}
			            ]
			        }
			    ]
			};
        myChart.setOption(option);
    }
});