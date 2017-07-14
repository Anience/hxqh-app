/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/enterprise/top1Data",
            method: "get",
            data:{
                type: type,
                show: '1'
            },
            dataType: "json",
            success: function(data){
                //页面用户名展示
                $(".ent-header h4").text(data.enterpriseMap["1"].name);
                //sla数据展示
                var colorData = data.enterpriseMap["1"].threeColor;
                var cust = colorData.cust ==null?'':colorData.cust;
                var eq = colorData.eq ==null?'0':colorData.eq;
                var gt = colorData.gt ==null?'0':colorData.gt;
                var lt = colorData.lt ==null?'0':colorData.lt;
                $(".span-layout .sla").text(cust);
                $(".span-layout .red").text(eq);
                $(".span-layout .yellow").text(gt);
                $(".span-layout .green").text(lt);
                //event
                var events = data.enterpriseMap["1"].eventList;
                var trHtml ="";
                for(var i =0,len=events.length;i<len;i++){
                    var event = events[i].affevent;
                    var time = event.split(" ")[0];
                    var other = event.split("/")[3];
                    trHtml+="<tr><td>"+time+"/"+other+"</td></tr>";
                    $(".top1-event table").show();
                }
                $(".top1-event table tbody").html(trHtml);
                //图标展示
                var logoList = data.enterpriseMap["1"].iconList;
                for(var i=0,len=logoList.length;i<len;i++){
                    var className = '.'+logoList[i].lay;
                    var imgUrl = '';
                    if(logoList[i].status=='0'){
                        imgUrl = _ctx+'/imgs/red/'+logoList[i].lay+'.png';
                    }else{
                        imgUrl = _ctx+'/imgs/blue/'+logoList[i].lay+'.png';
                    }
                    $(className).show();
                    $(className).attr('src',imgUrl);
                }

                var leftTop;
                var leftBottom;
                //处理后台传回的数据为空的状态
                if(data.enterpriseMap["1"].rightnowList.length==0){
                    leftTop = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                     leftTop = data.enterpriseMap["1"].rightnowList[0];
                };
                if(data.enterpriseMap["1"].proactiveList.length==0){
                    leftBottom = {
                        closenums: undefined,
                        opennums: undefined
                    };
                }else{
                    leftBottom = data.enterpriseMap["1"].proactiveList[0];
                }
                var middleTop = data.enterpriseMap["1"].rightnowTicketM;
                var middleTopName = data.enterpriseMap["1"].rightnowNameList;
                var middleBottom = data.enterpriseMap["1"].proactiveTicketM;
                var middleBottomName = data.enterpriseMap["1"].proactiveNameList;
                //initEchart1折线图，initEchart2圆形图
                initEchart2("echart1",leftTop.closenums,leftTop.opennums,"PERCENTAGE REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart2",middleTop,middleTopName,"REACTIVE TICKETS(30 DAYS)");
                initEchart1("echart3",middleTop,middleTopName,"TRAFFIC BY REGION(2 DAYS PER 30 MINS)");
                initEchart2("echart4",leftBottom.closenums,leftBottom.opennums,"ERCENTAGE PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart5",middleBottom,middleBottomName,"PROACTIVE TICKETS(30 DAYS)");
                initEchart1("echart6",middleBottom,middleBottomName,"TRAFFIC BY PRODUCT(2 DAYS PER 6 HOURS)");
            },
            error: function(){

            }
        })
    }
    function initEchart1(domId,echartData,xData,tit) {
        var xAxisData =  xData;
        var legendData = ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'];
        var seriesData = [];
        legendData.forEach(function(el){
            var tmpObj = {};
            tmpObj.type = 'line';
            tmpObj.smooth = true;
            tmpObj.name = el;
            tmpObj.data = echartData[el];
            tmpObj.symbol = 'none';
            seriesData.push(tmpObj)
        });
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: tit,
                x:'center',
                y: 'bottom',
                textStyle: {
                    fontSize: '12',
                    fontWeight: 'bold',
                    color: '#BDBEC3'
                }
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                orient:'vertical',
                x:'right',
                y:'top',
                textStyle:{
                    fontSize: 12,
                    color:'#fff'
                },
                data:legendData
            },
            calculable: false,
            grid:{
                borderWidth:0,//外围边框线
                borderColor:'#666c7f'
            },
            xAxis: [
                {
                    type: 'category',
                    name:'Day',
                    boundaryGap : false,
                    axisLine : {    // 轴线
                        show: true
                    },
                    axisLabel : {//轴文本
                        show:false,
                        interval:0,    // {number}刻度的长短，可设为数字
                        rotate: 45,    //旋转度数
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: '#666C7F',
                            fontSize:15
                        }
                    },

                    lineStyle: {
                        color: 'green',
                        type: 'solid',
                        width: 2
                    },
                    splitLine : { //网格分隔线
                        show:false,
                        lineStyle: {
                            color: '#483d8b',
                            type: 'dashed',
                            width: 1
                        }
                    },
                    splitArea : {show : false},//网格区域
                    data:xAxisData
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    axisLabel : {
                        show:true,
                        interval:0,    // {number}刻度的长短，可设为数字 间隔
                        margin:5,
                        splitNumber: 18,
                        textStyle:{
                            color: '#fff',
                            fontSize:15
                        }
                    },
                    splitLine : { //分隔线
                        show:true,
                        lineStyle: {
                            color: '#666C7F',
                            type: 'dashed',
                            width: 1
                        }
                    }
                }
            ],
            series:  seriesData
        };
        myChart.setOption(option);
        $("#all",window.parent.document).click(function(){
            myChart.resize();
        });
        $("#small",window.parent.document).click(function(){
            myChart.resize();
        });
    }
    function initEchart2(idDom,data1,data2,titName){
        var initData;
        var bgcolor = [];
        if(typeof(data1)=="undefined"&&typeof(data2)=="undefined"){
            initData=[
                {
                    value:1,name:'nodata'
                }
            ];
            bgcolor = ['#BDBEC3'];
        }else{
            initData=[
                {value:data1, name:'close'},
                {value:data2, name:'open'}
            ]
            bgcolor = ["#ff7f50", "#87cefa"];
        };
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title : {
                text: titName,
                x:'center',
                y: 'bottom',
                textStyle: {
                    fontSize: '12',
                    fontWeight: 'bold',
                    color: '#BDBEC3'
                }
            },
            color:bgcolor,
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c}"
            },
            legend: {
                show:false,
                data:['close','open']
            },
            calculable : false,
            series : [
                {
                    name:'',
                    type:'pie',
                    radius : ['40%', '70%'],
                    itemStyle : {
                        normal : {
                            //不显示中间的字，而显示成饼图的那种label
                            label : {
                                show: false,
                                position : 'inner',
                                // formatter: '{b} : {c} ({d}%)'
                                formatter: "{d}%"
                                //formatter: '{b} : {c} ({d}%)'
                            },
                            labelLine : {
                                show : false
                            }
                        },
                        emphasis : {
                            label : {
                                show : false,
                                position : 'center',
                                textStyle : {
                                    fontSize : '20',
                                    fontWeight : 'bold'
                                }
                            }
                        }
                    },
                    data:initData
                }
            ]
        };
        myChart.setOption(option);
        $("#all",window.parent.document).click(function(){
            myChart.resize();
        });
        $("#small",window.parent.document).click(function(){
            myChart.resize();
        });
    }
    initData();
}());