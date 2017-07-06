/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#digital-data",
        data: {
            tit:"",
            digList: [],
            dig13Dto: [],
            dig14Dto: [],
            dig17Dto: [],
            dig18Dto: [],
            isShow: false
        },
        methods: {
           initEchartData:function(domName,data){
               for(var n=0;n<data.length;n++){
                   var real = data.ioc4;
                   var target = data.ioc3;
                   var data1 = real/target;
                   var data2 = (target-real)/target;
                   initEchart(domName+n,data1,data2);
               }
           }
        },
        compiled:function () {

        },
        created: function () {
            var self = this;
            var tmpurl = _ctx+"/digital/vDigital"+urlNum+"Data";
            $.ajax({
                url: tmpurl,
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.tit = data.name;
                    switch(urlNum){
                        case "13":
                            self.digList = data.vDig13List;
                            break;
                        case "14":
                            self.digList = data.dig14List;
                            break;
                        case "17":
                            self.digList = data.dig17List;
                            break;
                        case "18":
                            self.digList = data.dig18List;
                            break;
                        default:
                            self.dig13Dto = data.dig13Dto;
                            self.dig14Dto = data.dig14Dto;
                            self.dig17Dto = data.dig17Dto;
                            self.dig18Dto = data.dig18Dto;
                            self.isShow = true;
                    }
                    if(self.digList.length>=1){
                        for(var i=0,len=self.digList.length;i<len;i++){
                            self.digList[i].id="dig"+i;
                        }
                    }
                    if(self.dig13Dto.dig13List.length>=1){
                        for(var j=0,lens=self.dig13Dto.dig13List.length;i<lens;j++){
                            self.dig13Dto[j].id="dig13"+j;
                        }
                    }
                    if(self.dig14Dto.dig14List.length>=1){
                        for(var k=0,lenss=self.dig14Dto.dig14List.length;i<lenss;k++){
                            self.dig14Dto.dig14List[k].id="dig14"+k;
                        }
                    }
                    if(self.dig17Dto.dig17List.length>=1){
                        for(var m=0,l=self.dig17Dto.dig17List.length;i<l;m++){
                            self.dig17Dto.dig17List[m].id="dig17"+m;
                        }
                    }
                    if(self.dig18Dto.dig18List.length>=1){
                        for(var i=0,len=self.dig18Dto.dig18List.length;i<len;i++){
                            self.dig18Dto.dig18List[i].id="dig18"+i;
                        }
                    }

                    setTimeout(function(){
                        if(self.digList.length>=1){
                            self.initEchartData("dig",self.digList);
                        }
                        if(self.dig13Dto.dig13List.length>=1){
                            self.initEchartData("dig13",self.dig13Dto.dig13List);
                        }
                        if(self.dig14Dto.dig14List.length>=1){
                            self.initEchartData("dig14",self.dig14Dto.dig14List);
                        }
                        if(self.dig17Dto.dig17List.length>=1){
                            self.initEchartData("dig17",self.dig17Dto.dig17List);
                        }
                        if(self.dig18Dto.dig18List.length>=1){
                            self.initEchartData("dig18",self.dig18Dto.dig18List);
                        }
                    },200);
                },
                error: function () {

                }
            });
        }
    });
    function initEchart(idDom,data1,data2){
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            series : [
                {
                    type:'pie',
                    radius : '70%',
                    center: ['60%', '50%'],
                    itemStyle:{
                        normal:{
                            label:{
                                show: false
                            },
                            labelLine:{
                                show: false
                            }
                        }
                    },
                    data:[
                        {value:123},
                        {value:123}
                    ]
                }
            ]
        };
        myChart.setOption(option);
    }
});
