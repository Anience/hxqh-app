/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initData(){
        $.ajax({
            url: _ctx+"/enterprise/bussinessData",
            method: "get",
            dataType: "json",
            success: function(data){
                initEchart2("echart1",data.vEntBusTopThree);
                initEchart1("echart2");
                initEchart2("echart3",data.vEntBusTopThree);
                initEchart1("echart4");
            },
            error: function(){

            }
        })
    }
    function initEchart1(domId) {
       /* var legendData = ['TREG 1','TREG 2','TREG 3','TREG 4','TREG 5','TREG 6','TREG 7'];
        var seriesData = [];
        var xAxisData = echartName;
        for(var name in echartSData){
            var tmpObj = {};
            tmpObj.type = 'line';
            tmpObj.smooth = true;
            tmpObj.name = name;
            tmpObj.data = echartSData[name];
            seriesData.push(tmpObj)
        }*/
        var xAxisData =  ['周一','周二','周三','周四','周五','周六','周日'];
        var legendData = ['TREG 1','TREG 2','TREG 3','TREG 4','TREG 5','TREG 6','TREG 7'];
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            title: {
                text: "Reactive TKT(30 DAYS)",
                x:30,
                textStyle: {
                    fontSize: 18,
                    fontWeight: 'bolder',
                    color: '#FFF'
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
            series:  [
                {
                    name:'TREG 1',
                    type:'line',
                    data:[120, 132, 101, 134, 90, 230, 210]
                },
                {
                    name:'TREG 2',
                    type:'line',
                    data:[220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name:'TREG 3',
                    type:'line',
                    data:[150, 232, 201, 154, 190, 330, 410]
                },
                {
                    name:'TREG 4',
                    type:'line',
                    data:[320, 332, 301, 334, 390, 330, 320]
                },
                {
                    name:'TREG 5',
                    type:'line',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                },
                {
                    name:'TREG 6',
                    type:'line',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                },
                {
                    name:'TREG 7',
                    type:'line',
                    data:[820, 932, 901, 934, 1290, 1330, 1320]
                }
            ]
        };
        myChart.setOption(option);
    }
    function initEchart2(idDom){
        var lendData = ["close","open"];
        var serisData = [];
       /* for(var i=0,len=echartData.length;i<len;i++){
            var tmpObj = {};
            tmpObj.value = echartData[i].value;
            tmpObj.name = echartData[i].name;
            tmpObj.other = echartData[i].otherfull;
            lendData.push(echartData[i].name);
            serisData.push(tmpObj);
        }
        console.log(serisData);*/
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title :{
                text: 'REACTIVE',
                subtext: '',
                x:'left',
                textStyle:{
                    fontSize: 18,
                    fontWeight: 'bolder',
                    color: '#fff'
                }
            },
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            legend: {
                orient : 'vertical',
                x : 'left',
                y : 50,
                textStyle:{
                    fontSize: 16,
                    fontWeight: 'bolder',
                    color: '#fff'
                },
                data:lendData
            },
            series : [
                {
                    type:'pie',
                    radius : '60%',
                    center: ['60%', '50%'],
                    data:[
                        {value:335, name:'open'},
                        {value:310, name:'close'}
                    ]
                }
            ]
        };
        myChart.setOption(option);
    }
    initData();
}());