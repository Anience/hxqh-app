/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
   /* var digitalData = new Vue({
        el: "#mob88-data",
        data: {
            mobList:[],
            perforList:[]
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
                    self.perforList = data.perforList;
                    var insertHtml = "";
                    for(var i=0;i<data.perforList.length;i++){
                        var tmpData = data.perforList[i];
                        insertHtml+="<tr><td>"+tmpData.treg
                                  +"</td><td>"+tmpData.psr
                                  +"</td><td>"+tmpData.sr
                                  +"</td></tr>";
                    }
                    $("#mob88-data tbody").html(insertHtml);
                },
                error: function () {

                }
            });
        }
    });*/
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
            tit = 'MTTR（MTD）';
            lendData = ['SL_D','OTHERS','FO ACCESS','RADIO ACCESS'];
        }else{
            tit = 'MTTI（MTD）';
            lendData = ['SL-D','OTHER','METRO-E']
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
    function init(){
        $.ajax({
            url: _ctx+"/mobile/vMob88Data",
            method: "get",
            dataType: "json",
            success: function (data) {
                $("#mob88-data tbody").html("");
                var mobList = data;
                initEchart('echart1',data.mob88MttrList);
                initEchart('echart2',data.mob88MttiList);
                self.perforList = data.perforList;
                var insertHtml = "";
                for(var i=0;i<data.perforList.length;i++){
                    var tmpData = data.perforList[i];
                    insertHtml+="<tr><td>"+tmpData.treg;
                        if(parseFloat(tmpData.sr)>0){
                            insertHtml+="</td><td style='color:red;'>"+tmpData.sr;
                        }else{
                            insertHtml+="</td><td>"+tmpData.sr
                        }
                        if(parseFloat(tmpData.psr)>0){
                            insertHtml+="</td><td style='color:red;'>"+tmpData.psr;
                        }else{
                            insertHtml+="</td><td>"+tmpData.psr;
                        }
                        insertHtml+="</td></tr>";
                }
                $("#mob88-data tbody").html(insertHtml);
            },
            error: function () {

            }
        });
    }
    init();
    $("table#mob88-data tbody").on("mouseenter","td",function(e){
        var type = ['','SR','PSR'];
        var typ = type[$(this).index()];
        var trg = $(this).prev().text();
        if(parseFloat($(this).text())>0){
            $.ajax({
                url: _ctx+"/mobile/badmsg",
                method: "get",
                data:{
                    treg: trg,
                    type: typ
                },
                dataType: "json",
                success: function (data) {
                   var eventX = e.pageX - 10;
                   var eventY = e.pageY - 20;
                   var creatDiv = document.createElement("div");
                   var htmlP = "<p>TSEL Region-"+data.tselRegion+"</p>";
                       htmlP +=  "<p>Region Name-"+data.tselRegion+"</p>"
                             +"<p>Node-"+data.node+"</p>"
                             +"<p>PDP_2G value-"+data.tselRegion+"</p>"
                             +"<p>PDP_2G value-"+data.tselRegion+"</p>"
                             +"<p>Date-"+data.dataTimes+"</p>"
                },
                error: function () {

                }
            });
        }
    });
    setInterval(function(){
        init();
    },10000);
});
