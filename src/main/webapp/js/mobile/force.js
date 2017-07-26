/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
   $.ajax({
        url: _ctx+"/mobile/topologicalData",
        method: "get",
        dataType: "json",
        success: function (data) {
            var linkMap = data.linkMap;
            var nodeMap = data.nodeMap;
            var totalData = {
                'TREG-1': {
                    links: [],
                    nodes: []
                },
                'TREG-2': {
                    links: [],
                    nodes: []
                },
                'TREG-3': {
                    links: [],
                    nodes: []
                },
                'TREG-4': {
                    links: [],
                    nodes: []
                },
                'TREG-5': {
                    links: [],
                    nodes: []
                },
                'TREG-6': {
                    links: [],
                    nodes: []
                },
                'TREG-7': {
                    links: [],
                    nodes: []
                }
            };
            var mainDom = document.getElementById('echart1');
            var constMaxDepth = 4;
            var categoryData = ['TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
            categoryData.forEach(function(el){
                for(var i = 0;i<linkMap[el].length;i++){
                    var x = mainDom.clientWidth / 2 + (.5 - Math.random()) * 200;
                    var y = (mainDom.clientHeight - 20) * nodeMap[el][i].deptdepth / (constMaxDepth + 1) + 20;
                    var tmpLink = {};
                    var tmpNode = {};
                    tmpLink.source = linkMap[el][i].ttcId.toString();
                    tmpLink.target = linkMap[el][i].parentId.toString();
                    tmpLink.weight = 1;
                    tmpNode.category  = nodeMap[el][i].catagory;
                    tmpNode.depth = nodeMap[el][i].deptdepth;
                    tmpNode.name = nodeMap[el][i].ttcId;
                    tmpNode.id = nodeMap[el][i].ttcId;
                    tmpNode.initial = [x,y];
                    tmpNode.fixY = true;
                    totalData[el].links.push(tmpLink);
                    totalData[el].nodes.push(tmpNode);
                }
            });
            initEchart("echart1",totalData["TREG-1"].nodes,totalData["TREG-1"].links,"Backhaul TTC Tsel TREG1");
            var i = 0;
            scroll(8,'first-nav','sec-nav');
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
                        var tit = "Backhaul TTC Tsel TREG"+i;
                        var objectName = "TREG-"+i;
                        initEchart("echart1",totalData[objectName].nodes,totalData[objectName].links,tit);
                    }
                },5000);
            }
        },
        error: function () {

        }
    });
   function initEchart(domId,nodes,links){
       var constMaxRadius = 10;
       var constMinRadius = 2;
       console.log(links);
       var myChart = echarts.init(document.getElementById(domId));
       option = {
           backgroundColor:'#0A0F25',
           title : {
               text: 'Force',
               subtext: 'Force-directed tree',
               x:'right',
               y:'bottom'
           },
           tooltip : {
               trigger: 'item',
               formatter: '{a} : {b}'
           },
           legend: {
               x: 'left',
               data:['叶子节点','非叶子节点', '根节点'],
               textStyle: {
                   fontSize: 16,
                   fontFamily: "Arial",
                   color: '#CECECE'
               }
           },
           series : [
               {
                   type:'force',
                   name : "Force tree",
                   ribbonType: false,
                   categories : [
                       {
                           name: '叶子节点',
                           itemStyle: {
                               normal: {
                                   color : '#ff7f50'
                               }
                           }
                       },
                       {
                           name: '非叶子节点',
                           itemStyle: {
                               normal: {
                                   color : '#6f57bc'
                               }
                           }
                       },
                       {
                           name: '根节点',
                           itemStyle: {
                               normal: {
                                   color : '#af0000'
                               }
                           }
                       }
                   ],
                   itemStyle: {
                       normal: {
                           label: {
                               show: false
                           },
                           nodeStyle : {
                               brushType : 'both',
                               strokeColor : 'rgba(255,215,0,0.6)',
                               lineWidth : 1
                           }
                       }
                   },
                   minRadius : constMinRadius,
                   maxRadius : constMaxRadius,
                   nodes : nodes,
                   links : links
               }
           ]
       };
       myChart.setOption(option);
   }

/*
    var nodes = [];
    var links = [];
    var constMaxDepth = 4;
    var constMaxChildren = 3;
    var constMinChildren = 2;
    var constMaxRadius = 10;
    var constMinRadius = 2;
    var mainDom = document.getElementById('echart1');

    function rangeRandom(min, max) {
        return Math.random() * (max - min) + min;
    }

    function createRandomNode(depth) {
        var x = mainDom.clientWidth / 2 + (.5 - Math.random()) * 200;
        var y = (mainDom.clientHeight - 20) * depth / (constMaxDepth + 1) + 20;
        var node = {
            name : 'NODE_' + nodes.length,
            value : rangeRandom(constMinRadius, constMaxRadius),
            // Custom properties
            id : nodes.length,
            depth : depth,
            initial : [x, y],
            fixY : true,
            category : depth === constMaxDepth ? 0 : 1
        }
        nodes.push(node);

        return node;
    }

    function forceMockThreeData() {
        var depth = 0;

        var rootNode = createRandomNode(0);
        rootNode.name = 'ROOT';
        rootNode.category = 2;

        function mock(parentNode, depth) {
            var nChildren = Math.round(rangeRandom(constMinChildren, constMaxChildren));

            for (var i = 0; i < nChildren; i++) {
                var childNode = createRandomNode(depth);
                links.push({
                    source : parentNode.id,
                    target : childNode.id,
                    weight : 1
                });
                if (depth < constMaxDepth) {
                    mock(childNode, depth + 1);
                }
            }
        }

        mock(rootNode, 1);
    }

    forceMockThreeData();
    var myChart = echarts.init(document.getElementById("echart1"));
    console.log(nodes);
    console.log(links);
    option = {
        title : {
            text: 'Force',
            subtext: 'Force-directed tree',
            x:'right',
            y:'bottom'
        },
        tooltip : {
            trigger: 'item',
            formatter: '{a} : {b}'
        },
        toolbox: {
            show : true,
            feature : {
                restore : {show: true},
                magicType: {show: true, type: ['force', 'chord']},
                saveAsImage : {show: true}
            }
        },
        legend: {
            x: 'left',
            data:['叶子节点','非叶子节点', '根节点']
        },
        series : [
            {
                type:'force',
                name : "Force tree",
                ribbonType: false,
                categories : [
                    {
                        name: '叶子节点',
                        itemStyle: {
                            normal: {
                                color : '#ff7f50'
                            }
                        }
                    },
                    {
                        name: '非叶子节点',
                        itemStyle: {
                            normal: {
                                color : '#6f57bc'
                            }
                        }
                    },
                    {
                        name: '根节点',
                        itemStyle: {
                            normal: {
                                color : '#af0000'
                            }
                        }
                    }
                ],
                itemStyle: {
                    normal: {
                        label: {
                            show: false
                        },
                        nodeStyle : {
                            brushType : 'both',
                            strokeColor : 'rgba(255,215,0,0.6)',
                            lineWidth : 1
                        }
                    }
                },
                minRadius : constMinRadius,
                maxRadius : constMaxRadius,
                nodes : nodes,
                links : links
            }
        ]
    };

    myChart.setOption(option);*/
});
