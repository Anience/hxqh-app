/**
 * Created by lenovo on 2017/6/26.
 */
// $(function () {
//     function init(){
//         $.ajax({
//             url: _ctx+"/mobile/topoData",
//             method: "get",
//             dataType: "json",
//             success: function (data) {
//                 // window.clearInterval(timer);
//                 var datas = [];
//                 var nodeLists = ["TREG-1","TREG-2","TREG-3","TREG-4","TREG-5","TREG-6","TREG-7"];
//                 for(var i=0;i<nodeLists.length;i++){
//                     var node = nodeLists[i];
//                     var tmpObj = {};
//                     tmpObj.name = node;
//                     tmpObj.children = [];
//                     for(var j=0;j<data.lineList.length;j++){
//                         if(tmpObj.name==data.lineList[j].source){
//                             var childrenObj1 = {};
//                             childrenObj1.name = data.lineList[j].target;
//                             tmpObj.children.push(childrenObj1);
//                             childrenObj1.children = [];
//                             for(var m=0;m<data.lineList.length;m++){
//                                 if(childrenObj1.name == data.lineList[m].source){
//                                     var childrenObj2 = {};
//                                     childrenObj2.name = data.lineList[m].target;
//                                     childrenObj1.children.push(childrenObj2);
//                                     for(var l=0;l<data.colorList.length;l++){
//                                         if(childrenObj2.name == data.colorList[l].title){
//                                             childrenObj2.itemStyle={normal:{color:'#DC143C'},label:{show:true},emphasis:{color:'#DC143C'}};
//                                             childrenObj2.value = data.colorList[l].msg;
//                                         }
//                                     }
//                                     childrenObj2.children = [];
//                                     for(var n=0;n<data.lineList.length;n++){
//                                         if(childrenObj2.name == data.lineList[n].source){
//                                             var childrenObj3 = {};
//                                             childrenObj3.name = data.lineList[n].target;
//                                             childrenObj2.children.push(childrenObj3);
//                                             for(var k=0;k<data.colorList.length;k++){
//                                                 if(childrenObj3.name == data.colorList[k].title){
//                                                     childrenObj3.itemStyle={normal:{color:'#DC143C'},label:{show:true},emphasis:{color:'#DC143C'}};
//                                                     childrenObj3.value = data.colorList[k].msg;
//                                                 }
//                                             }
//                                         }
//                                     }
//                                 }
//                             }
//                         }
//                     }
//                     datas.push(tmpObj);
//                     initEchart("echart1",datas[0]);
//                 }
//                 var p = 0;
//                 var timer = setInterval(function(){
//                     p++;
//                     if(p>=8){
//                         p=0;
//                     }else{
//                         var index= p;
//                         var liNav = '.first-nav li';
//                         var thisLi = '.first-nav li:nth-child('+index+')';
//                         $(liNav).css("color","#727386");
//                         $(thisLi).css("color","#fff");
//
//                         var liNav2 = '.sec-nav li'+' span';
//                         var thisLi2 = '.sec-nav li:nth-child('+index+')'+' span';
//                         $(liNav2).css("backgroundColor","#0a0f25");
//                         $(thisLi2).css("backgroundColor","#4a476a");
//                         initEchart("echart1",datas[p-1]);
//                     }
//                 },10000);
//             }
//         });
//     }
//    function initEchart(domId,datas){
//        var myChart = echarts.init(document.getElementById(domId));
//        console.log(datas);
//        var option = {
//            backgroundColor:'#0A0F25',
//            tooltip : {
//                trigger: 'item',
//                formatter: function(params){
//                    if(typeof params.value =='string'){
//                        return params.value.replace(/\\n/g, "<br />");
//                    }else{
//                        return "";
//                    }
//                }
//            },
//            series : [
//                {
//                    type:'tree',
//                    orient: 'horizontal',  // vertical horizontal
//                    rootLocation: {x: 220,y: 230}, // 根节点位置  {x: 100, y: 'center'}
//                    nodePadding: 8,
//                    layerPadding: 200,
//                    hoverable: false,
//                    roam: true,
//                    symbolSize: 6,
//                    itemStyle: {
//                        normal: {
//                            color: '#4883b4',
//                            label: {
//                                show: true,
//                                position: 'right',
//                                formatter: "{b}",
//                                textStyle: {
//                                    color: '#fff',
//                                    fontSize: 9
//                                }
//                            },
//                            lineStyle: {
//                                color: '#8B8682',
//                                type: 'curve' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
//
//                            }
//                        },
//                        emphasis: {
//                            color: '#4883b4',
//                            label: {
//                                show: false
//                            },
//                            borderWidth: 0
//                        }
//                    },
//                    data: [datas]
//                }
//            ]
//        };
//        myChart.setOption(option);
//    }
//     init();
//     // var timer=setInterval(function(){
//     //     init();
//     // },300000);
// });


$(function(){
    var nodes = [];
    var links = [];
    var colorList = [];
    var EchartData = {
        TREG1: {
            nodesList:[],
            links:[]
        },
        TREG2: {
            nodesList:[],
            links:[]
        },
        TREG3: {
            nodesList:[],
            links:[]
        },
        TREG4: {
            nodesList:[],
            links:[]
        },
        TREG5: {
            nodesList:[],
            links:[]
        },
        TREG6: {
            nodesList:[],
            links:[]
        },
        TREG7: {
            nodesList:[],
            links:[]
        }
    };
    var nodeLists = ["TREG1","TREG2","TREG3","TREG4","TREG5","TREG6","TREG7"];


    function init(){
        $.ajax({
            url: _ctx+"/mobile/topoData",
            method: "get",
            dataType: "json",
            success: function (datas) {

                nodes = datas.nodeList;
                links = datas.lineList;
                colorList = datas.colorList;

                oneDeal(nodeLists[0]);
                initEchart(EchartData[nodeLists[0]].nodesList,EchartData[nodeLists[0]].links);

                var p = 0;
                var timer = setInterval(function(){
                    p++;
                    if(p>=7){
                        p=0;
                    }
                    var index = p+1;
                    var liNav = '.first-nav li';
                    var thisLi = '.first-nav li:nth-child('+index+')';
                    $(liNav).css("color","#727386");
                    $(thisLi).css("color","#fff");

                    var liNav2 = '.sec-nav li'+' span';
                    var thisLi2 = '.sec-nav li:nth-child('+index+')'+' span';
                    $(liNav2).css("backgroundColor","#0a0f25");
                    $(thisLi2).css("backgroundColor","#4a476a");
                    var dataName = nodeLists[p];
                    var data = EchartData[dataName];
                    if(data.nodesList.length==0){
                        oneDeal(nodeLists[p]);
                    }
                    initEchart(data.nodesList,data.links);
                },10000);

            }
        });
    }

    function oneDeal(tregName){
        var tregNames = "";
        switch(tregName){
            case "TREG1":
                tregNames = "TREG-1";
                break;
            case "TREG2":
                tregNames = "TREG-2";
                break;
            case "TREG3":
                tregNames = "TREG-3";
                break;
            case "TREG4":
                tregNames = "TREG-4";
                break;
            case "TREG5":
                tregNames = "TREG-5";
                break;
            case "TREG6":
                tregNames = "TREG-6";
                break;
            default:
                tregNames = "TREG-7";
                break;
        }
        var firstNode = "";
        var secondNode = "";
        var thirdNode = "";
        var fourNode = "";

        var nodesList = [];
        var treg1 = {
            links:[],
            nodes:[]
        };

        for(var i=0,len=links.length;i<len;i++){
            var link = links[i];
            if(link.source == tregNames){
                treg1.links.push(link)
                treg1.nodes.push(link.source);
                treg1.nodes.push(link.target);
                firstNode = link.target;
            }
            if(link.source == firstNode){
                treg1.links.push(link);
                treg1.nodes.push(link.target);
                secondNode = link.target;
            }
            if(link.source == secondNode){
                treg1.links.push(link);
                treg1.nodes.push(link.target);
                thirdNode = link.target;
            }
        }

        var nodesSet = Array.from(new Set(treg1.nodes));
        for(var k=0,len=nodesSet.length;k<len;k++){
            var newNode = findNode(nodesSet[k])
            nodesList.push(newNode);
        }
        nodesList = changeXY(nodesList);
        EchartData[tregName].nodesList = [].concat(JSON.parse(JSON.stringify(nodesList)));
        EchartData[tregName].links = [].concat(JSON.parse(JSON.stringify(treg1.links)));
    }

    function changeXY(nodesList){
        var x0 = 0;
        var newNodeList = [];
        var y0 = nodesList[0].y;
        var y1 = nodesList[1].y;
        var y2 = nodesList[2].y;
        var y3 = nodesList[3].y;

        var newxi0 = nodesList[0].x*Math.cos(90) - nodesList[0].y*Math.sin(90);
        // var newxi1 = nodesList[1].x*Math.cos(90) - nodesList[1].y*Math.sin(90);
        // var newxi2 = nodesList[2].x*Math.cos(90) - nodesList[2].y*Math.sin(90);
        // var newxi3 = nodesList[3].x*Math.cos(90) - nodesList[3].y*Math.sin(90);


        var newxi1 = newxi0+100;
        var newxi2 = newxi0+150;
        var newxi3 = newxi0+200;

        //统计每组的数量
        var i=0,j=0,k=0,l=0;
        //增加距离的间隔
        var a=0,b=0,c=0,d=0;

        //点的分组
        for (var m = 0; m < nodesList.length; m++) {
            x0 = nodesList[m].x;
            switch (nodesList[m].y) {
                case y1:
                    i++;
                    break;
                case y2:
                    j++;
                    break;
                case y3:
                    k++;
                    break;
                case y0:
                    // default:
                    l++;
                    break;
                default:
                    for(var d=nodes.length-1;d>=0;d--){
                        if(nodes[d].name==nodesList[m].name){
                            if(nodes[d].y==y1||nodes[d].y==y2||nodes[d].y==y3){
                                switch(nodes[d].y){
                                    case y1:
                                        i++;
                                        break;
                                    case y2:
                                        j++;
                                        break;
                                    case y3:
                                        k++;
                                        break;
                                }
                            }
                        }
                    }

            }
        }

        i=100/i;
        j=100/j;
        k=100/k;
        l=100/l;


        for (var n = 0; n < nodesList.length; n++) {
            x0 = nodesList[n].x;
            switch (nodesList[n].y) {
                case y1:
                    nodesList[n].x = newxi1;
                    nodesList[n].y = 10+i*a;
                    a++;
                    break;
                case y2:
                    nodesList[n].x = newxi2;
                    nodesList[n].y = 10+j*b;
                    b++;
                    break;
                case y3:
                    nodesList[n].x = newxi3;
                    nodesList[n].y = 10+k*c;
                    c++;
                    break;
                case y0:

                    // default:
                    nodesList[n].x = newxi0;
                    nodesList[n].y = 50;
                    d++;
                    break;
                default:
                    for(var z=nodes.length-1;z>=0;z--){
                        if(nodes[z].name==nodesList[n].name){
                            if(nodes[z].y==y1||nodes[z].y==y2||nodes[z].y==y3){
                                switch(nodes[z].y){
                                    case y1:
                                        nodesList[n].x = newxi1;
                                        nodesList[n].y = 10+i*a;
                                        a++;
                                        break;
                                    case y2:
                                        nodesList[n].x = newxi2;
                                        nodesList[n].y = 10+j*b;
                                        b++;
                                        break;
                                    case y3:
                                        nodesList[n].x = newxi3;
                                        nodesList[n].y = 10+k*c;
                                        c++;
                                        break;
                                }
                            }
                        }
                    }

            }
            newNodeList.push(nodesList[n]);
        }
        return newNodeList;
    }

    function findNode(nodeName){
        for(var j=nodes.length-1;j>=0;j--){
            if(nodes[j].name==nodeName){
                for(var l=0;l<colorList.length;l++){
                    if(nodeName == colorList[l].title){
                        nodes[j].itemStyle={normal:{color:'#DC143C'},label:{show:true},emphasis:{color:'#DC143C'}};
                        nodes[j].value = colorList[l].msg;
                    }
                }
                return nodes[j];
            }
        }
    }

    function initEchart(nodesList,links){
        var myChart = echarts.init(document.getElementById("echart1"));
        var option = {
            backgroundColor:'#0A0F25',
            tooltip: {},
            animationDurationUpdate: 1500,
            animationEasingUpdate: 'quinticInOut',
            series : [
                {
                    type: 'graph',
                    // orient: 'horizontal',
                    // layout: 'none',
                    roam:true,
                    itemStyle: {
                        normal: {
                            color: '#4883b4',
                            label: {
                                show: true,
                                position: 'right',
                                formatter: "{b}",
                                textStyle: {
                                    color: '#fff',
                                    fontSize: 9
                                }
                            },
                            lineStyle: {
                                color: '#8B8682',
                                type: 'solid' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
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
                    symbolSize: 10,
                    label: {
                        normal: {
                            show: true,
                            position: 'right',
                        }
                    },
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
                    edgeSymbol: ['circle'],
                    edgeSymbolSize: [4, 10],
                    edgeLabel: {
                        normal: {
                            textStyle: {
                                fontSize: 20
                            }
                        }
                    },
                    data: nodesList,
                    links: links,
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
});