/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mob87",
        data: {
            anoList:[],
            isShow: 0,
            nameList: ['NAS','TREG-1','TREG-2','TREG-3','TREG-4','TREG-5','TREG-6','TREG-7'],
            i: 1
        },
        methods: {
            updataEchart:function(){
                self.i = 0;
            },
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/mobile/vMob87Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.anoList = data;
                    $("#mob87 ul").find("li").eq(1)
                        .css("background","#f5f5f5");
                    initEchart("echart1",self.anoList.map['NAS']);
                    setInterval(function(){
                        var initName = "";
                        self.i++;
                        if(self.i<=7){
                            initName = self.nameList[self.i];
                        }else{
                            self.i = 0;
                            initName = self.nameList[self.i];
                        }
                        initEchart("echart1",self.anoList.map[initName]);
                        $("#mob87 ul").find("li")
                            .css("background","#000");
                        $("#mob87 ul").find("li").eq(self.i+1)
                            .css("background","#f5f5f5");
                    },3000);
                },
                error: function () {

                }
            });
        }
    });
    function initEchart(idDom,echartData){
        var lendData = [];
        var serisData = [];
        for(var i=0,len=echartData.length;i<len;i++){
            var tmpObj = {};
            tmpObj.value = echartData[i].value;
            tmpObj.name = echartData[i].name;
            tmpObj.other = echartData[i].otherfull;
            lendData.push(echartData[i].name);
            serisData.push(tmpObj);
        }
        console.log(serisData);
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title :{
                text: 'TICKET',
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
                    name:"87Screen",
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
                                        res+=params.value+"("+params.name+")";
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
