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
                // window.clearInterval(timer);
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
                                    for(var l=0;l<data.colorList.length;l++){
                                        if(childrenObj2.name == data.colorList[l].title){
                                            childrenObj2.itemStyle={normal:{color:'#DC143C'},label:{show:true},emphasis:{color:'#DC143C'}};
                                            childrenObj2.value = data.colorList[l].msg;
                                        }
                                    }
                                    childrenObj2.children = [];
                                    for(var n=0;n<data.lineList.length;n++){
                                        if(childrenObj2.name == data.lineList[n].source){
                                            var childrenObj3 = {};
                                            childrenObj3.name = data.lineList[n].target;
                                            childrenObj2.children.push(childrenObj3);
                                            for(var k=0;k<data.colorList.length;k++){
                                                if(childrenObj3.name == data.colorList[k].title){
                                                    childrenObj3.itemStyle={normal:{color:'#DC143C'},label:{show:true},emphasis:{color:'#DC143C'}};
                                                    childrenObj3.value = data.colorList[k].msg;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    datas.push(tmpObj);
                    initEchart("echart1",datas[0]);
                }
                var p = 0;
                var timer = setInterval(function(){
                    p++;
                    if(p>=8){
                        p=0;
                    }else{
                        var index= p;
                        var liNav = '.first-nav li';
                        var thisLi = '.first-nav li:nth-child('+index+')';
                        $(liNav).css("color","#727386");
                        $(thisLi).css("color","#fff");

                        var liNav2 = '.sec-nav li'+' span';
                        var thisLi2 = '.sec-nav li:nth-child('+index+')'+' span';
                        $(liNav2).css("backgroundColor","#0a0f25");
                        $(thisLi2).css("backgroundColor","#4a476a");
                        initEchart("echart1",datas[p-1]);
                    }
                },10000);
            }
        });
    }

   function initEchart(domId,datas){
       var myChart = echarts.init(document.getElementById(domId));
       var option = {
           backgroundColor:'#0A0F25',
           tooltip : {
               trigger: 'item',
               formatter: function(params){
                   if(typeof params.value =='string'){
                       return params.value.replace(/\\n/g, "<br />");
                   }else{
                       return "";
                   }
               }
           },
           series : [
               {
                   type:'tree',
                   orient: 'horizontal',  // vertical horizontal
                   rootLocation: {x: 220,y: 230}, // 根节点位置  {x: 100, y: 'center'}
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
                                   color: '#fff',
                                   fontSize: 5
                               }
                           },
                           lineStyle: {
                               color: '#8B8682',
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
    // var timer=setInterval(function(){
    //     init();
    // },300000);
});
