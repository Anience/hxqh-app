/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mob88-data",
        data: {
            mobList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/mobile/vMob88Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.mobList = data;
                    initEchart('echart1',data.mob88MttrList);
                    initEchart('echart2',data.mob88MttiList);
                    setInterval(function(){
                        window.location.href=_ctx+"/mobile/mobile88";
                    },300000);
                },
                error: function () {

                }
            });
        }
    });
    function initEchart(idDom,echartData){
        var lendData = [];
        var serisData = [];
        var tit;
        for(var i=0,len=echartData.length;i<len;i++){
            var tmpObj = {};
            tmpObj.value = echartData[i].value;
            tmpObj.name = echartData[i].name;
            lendData.push(echartData[i].name);
            serisData.push(tmpObj);
        }
        if(idDom=="echart1"){
            tit = 'MTTR';
        }else{
            tit = 'MTTI';
        }
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title :{
                text: tit,
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
                y : 150,
                textStyle:{
                    fontSize: 16,
                    fontWeight: 'bolder',
                    color: '#fff'
                },
                data:lendData
            },
            series : [
                {
                    name:"881Screen",
                    type:'pie',
                    radius : '70%',
                    center: ['60%', '50%'],
                    itemStyle:{
                        normal:{
                            label:{
                                show: true,
                                textStyle: {
                                    fontSize: '18',
                                    fontWeight: 'normal'
                                },
                                formatter: function(params) {
                                    var res="";
                                    var datas = params.series.data;
                                    var text= ['1','2']
                                    for(var i=0;i<datas.length;i++){
                                        res+=params.value;
                                        break;
                                    }
                                    return res;
                                }
                            }

                        },
                        labelLine :{
                            show: true
                        }
                    },
                    data:serisData
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
});
