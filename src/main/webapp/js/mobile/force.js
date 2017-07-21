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
            var categoryData = ['TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
            categoryData.forEach(function(el){
                for(var i = 0;i<linkMap[el].length;i++){
                    var tmpLink = {};
                    var tmpNode = {};
                    tmpLink.source = linkMap[el][i].ttcId;
                    tmpLink.target = linkMap[el][i].parentId;
                    tmpLink.weight = 1;
                    tmpNode.category  = nodeMap[el][i].catagory;
                    tmpNode.depth = nodeMap[el][i].deptdepth;
                    tmpNode.name = nodeMap[el][i].title;
                    tmpNode.id = nodeMap[el][i].ttcId;
                    totalData[el].links.push(tmpLink);
                    totalData[el].nodes.push(tmpNode);
                }
            });
            initEchart("echart1",totalData["TREG-1"].nodes,totalData["TREG-1"].links);
        },
        error: function () {

        }
    });
   function initEchart(domId,nodes,links){
       var constMaxRadius = 10;
       var constMinRadius = 2;
       var myChart = echarts.init(document.getElementById(domId));
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
       myChart.setOption(option);
   }

});
