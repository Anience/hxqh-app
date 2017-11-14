/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    function init(){
        $.ajax({
            url: _ctx+"/mobile/topoData",
            method: "get",
            dataType: "json",
            success: function (data) {
                window.clearInterval(timer);
                console.log(data.nodeList);
                initEchart("echart1",data.lineList,data.nodeList);
            }
        });
    }

   function initEchart(domId,lineList,nodeList){
       var nodes = nodeList;
       var lines = lineList;
       var myChart = echarts.init(document.getElementById(domId));
       var option = {
           title: {
               text: ''
           },
           animationDurationUpdate: 1500,
           animationEasingUpdate: 'quinticInOut',
           series : [
               {
                   type: 'graph',
                   layout: 'none',
                   symbolSize: 50,
                   roam: true,
                   label: {
                       normal: {
                           show: true
                       }
                   },
                   edgeSymbol: ['circle', 'arrow'],
                   edgeSymbolSize: [4, 10],
                   edgeLabel: {
                       normal: {
                           textStyle: {
                               fontSize: 20
                           }
                       }
                   },
                   data: nodes.slice(1,83),
                   // links: [],
                   links: lines.slice(1,83),
                   lineStyle: {
                       normal: {
                           opacity: 0.9,
                           width: 2,
                           curveness: 0
                       }
                   }
               }
           ]
       };
       myChart.setOption(option);
   }
    init();
    var timer=setInterval(function(){
        init();
    },300000);
});
