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
                var datas = [];
                var nodeLists = ["TREG-1","TREG-2","TREG-3","TREG-4","TREG-5","TREG-6","TREG-7"];
                for(var i=0;i<nodeLists.length;i++){
                    var node = nodeLists[i];
                    var tmpObj = {};
                    tmpObj.name = node;
                    tmpObj.children = [];
                    for(var j=0;j<data.lineList.length;j++){
                        if(tmpObj.name==data.lineList[j].source){
                            var childrenObj1 = {};
                            childrenObj1.name = data.lineList[j].target;
                            tmpObj.children.push(childrenObj1);
                            childrenObj1.children = [];
                            for(var m=0;m<data.lineList.length;m++){
                                if(childrenObj1.name == data.lineList[m].source){
                                    var childrenObj2 = {};
                                    childrenObj2.name = data.lineList[m].target;
                                    childrenObj1.children.push(childrenObj2);
                                    childrenObj2.children = [];
                                    for(var n=0;n<data.lineList.length;n++){
                                        if(childrenObj2.name == data.lineList[n].source){
                                            var childrenObj3 = {};
                                            childrenObj3.name = data.lineList[n].target;
                                            childrenObj2.children.push(childrenObj3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    datas.push(tmpObj);
                    initEchart("echart1",datas[0]);
                    var m = 0;
                    var timer = setInterval(function(){
                        m++;
                        if(m>=8){
                            m=0;
                        }else{
                            var index= m;
                            var liNav = '.first-nav li';
                            var thisLi = '.first-nav li:nth-child('+index+')';
                            $(liNav).css("color","#727386");
                            $(thisLi).css("color","#fff");

                            var liNav2 = '.sec-nav li'+' span';
                            var thisLi2 = '.sec-nav li:nth-child('+index+')'+' span';
                            $(liNav2).css("backgroundColor","#0a0f25");
                            $(thisLi2).css("backgroundColor","#4a476a");
                            initEchart("echart1",datas[m-1]);
                        }
                    },10000);
                }
            }
        });
    }

   function initEchart(domId,datas){
       var myChart = echarts.init(document.getElementById(domId));
       var option = {
           toolbox: {
               show : true,
               feature : {
                   mark : {show: true},
                   dataView : {show: true, readOnly: false},
                   restore : {show: true},
                   saveAsImage : {show: true}
               },
               dataZoom:{
                   orient:"vertical", //水平显示
                   show:true, //显示滚动条
                   start:0, //起始值为20%
                   end:100,  //结束值为60%
               }
           },
           series : [
               {
                   name:'树图',
                   type:'tree',
                   orient: 'horizontal',  // vertical horizontal
                   rootLocation: {x: 100,y: 230}, // 根节点位置  {x: 100, y: 'center'}
                   nodePadding: 8,
                   layerPadding: 200,
                   hoverable: false,
                   roam: true,
                   symbolSize: 6,
                   itemStyle: {
                       normal: {
                           color: '#4883b4',
                           label: {
                               show: true,
                               position: 'right',
                               formatter: "{b}",
                               textStyle: {
                                   color: '#000',
                                   fontSize: 5
                               }
                           },
                           lineStyle: {
                               color: '#ccc',
                               type: 'curve' // 'curve'|'broken'|'solid'|'dotted'|'dashed'

                           }
                       },
                       emphasis: {
                           color: '#4883b4',
                           label: {
                               show: false
                           },
                           borderWidth: 0
                       }
                   },
                   data: [datas]
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
