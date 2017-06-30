/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mttr-data",
        data: {
            mttrLeft: [],
            mttrRight: []
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiMttrData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.mttrLeft = data.leftList;
                    self.mttrRight = data.rightList;
                },
                error: function () {

                }
            });
        }
    });
    function initEchart() {
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: jsonstring.charttitle,
                x:jsonstring.charttitlex,
                y:jsonstring.charttitley,
                //padding:'15',
                textStyle: {
                    fontSize: jsonstring.charttitlesize,
                    fontWeight: 'bolder',
                    color: jsonstring.charttitlecolor          // 主标题文字颜色
                }
                //subtext: subtitle
            },
            grid:{
                x:jsonstring.chartgridx,//左角李左边的宽度
                y:jsonstring.chartgridy,//左角李上面的高度
                x2:jsonstring.chartgridx2, //右角李左边的宽度
                y2:jsonstring.chartgridy2, //右角李上面的高度
                borderWidth:jsonstring.chartgridborderwidth,//外围边框线
                borderColor:jsonstring.chartgridbordercolor
            },
            tooltip: {
                trigger: 'axis',
                // backgroundColor: 'rgba(255,255,255,0.7)',
                axisPointer: {
                    type: jsonstring.charttooltipaxispointertype
                },
                formatter: function(params) {
                    var color = '#87cefa';
                    var res = '<div style="color:' + color + '">';
                    res += '<strong>' + params[0].name + '</strong>'
                    for (var i = 0, l = params.length; i < l; i++) {
                        res += '<br/>' + params[i].seriesName + ' : ' + params[i].value
                    }
                    res += '</div>';
                    return res;
                }
            },
            legend: {
                show:jsonstring.chartlegendshow,
                orient:jsonstring.chartlegendorient,//horizontal 水平   vertical 竖直
                x: jsonstring.chartlegendx, //'center' | 'left' | 'right'
                y:jsonstring.chartlegendy,
                textStyle:{    //图例文字的样式
                    color:jsonstring.chartlegendcolor,
                    // fontSize:12
                },
                data:dateJson//['2010','2011','2012','2013']
            },
            calculable: false,
            color:jsonstring["color"],
            xAxis: [
                {
                    type: 'category',
                    boundaryGap : jsonstring.chartxaixboundaryGap,
                    show:true,
                    name:jsonstring.chartxaixsname,
                    axisLabel : {//轴文本
                        show:jsonstring.chartxaixlabelshow,
                        interval:jsonstring.chartxaixlabelinterval,    // {number}刻度的长短，可设为数字
                        rotate: jsonstring.chartxaixlabelrotate,    //旋转度数
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: jsonstring.chartxaixlabelcolor,
                            fontSize:jsonstring.chartxaixlabelsize
                        }
                    },
                    axisLine : {
                        show: false
                    },
                    splitLine : { //网格分隔线
                        show: true,
                        lineStyle: {
                            color: '#666C7F',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    splitArea : {
                        show : false
                    },
                    data:kindJson
                }
            ],
            yAxis: [
                {
                    type: /*'value'*/jsonstring.chartyaixstype,
                    show:jsonstring.chartyaixsshow,
                    name:jsonstring.chartyaixsname,
                    axisLabel : {//轴文本
                        show:jsonstring.chartyaixlabelshow,
                        interval:jsonstring.chartyaixlabelinterval,    // {number}刻度的长短，可设为数字
                        rotate: jsonstring.chartyaixlabelrotate,    //旋转度数
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: jsonstring.chartyaixlabelcolor,
                            fontSize:jsonstring.chartyaixlabelsize
                        }
                    },
                    axisLine : {    // 轴线
                        show: jsonstring.chartyaixlineshow
                    },
                    splitLine : { //网格分隔线
                        show:jsonstring.chartyaixsplitlineshow,
                        lineStyle: {
                            color: '#666C7F',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    splitArea : {
                        show : jsonstring.chartyaixsplitareashow
                    }
                }
            ],
            series: objectJson
        };
        myChart.setOption(option);
    }
});
