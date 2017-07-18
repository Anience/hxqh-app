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
            illustruation:{
                FOAccess: '(0,0,0)',
                RadioAccess: '(0,0,0)',
                OTHERS: '(0,0,0)',
                SL_D: '(0,0,0)'
            },
            i: 0
        },
        methods: {
            navClick: function(n){
                var m = parseInt(n);
                $("#mob87 ul").find("li")
                    .css("background","#000");
                $("#mob87 ul").find("li").eq(m+1)
                    .css("background","#8D93A8");
                var thisName = this.nameList[m];
                initIn(this.anoList.map[thisName],this.illustruation);
                initEchart("echart1",this.anoList.map[thisName]);
                this.i = m;
            }
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
                        .css("background","#8D93A8");
                    initEchart("echart1",self.anoList.map['NAS']);
                    initIn(self.anoList.map['NAS'],self.illustruation);
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
                        initIn(self.anoList.map[initName],self.illustruation);
                        $("#mob87 ul").find("li")
                            .css("background","#000");
                        $("#mob87 ul").find("li").eq(self.i+1)
                            .css("background","#8D93A8");
                    },5000);
                },
                error: function () {

                }
            });
        }
    });
    function initIn(data,illustruation){
        illustruation = {
            FOAccess: '(0,0,0)',
            RadioAccess: '(0,0,0)',
            OTHERS: '(0,0,0)',
            SL_D: '(0,0,0)'
        };
        var tmpAdd = data;
        if(tmpAdd.length>0){
            for(var i=0;i<tmpAdd.length;i++){
                var tmpName = tmpAdd[i].name.replace(" ","");
                illustruation[tmpName] = tmpAdd[i].otherfull;
            }
        }
        for(var name in illustruation){
            var tmp = illustruation[name].toString().replace("(","").replace(")","").split(",");
            var htmlStr = "(<span style='color:#F50001;'>"+tmp[0]+",</span>"
                +"<span style='color:#E19713;'>"+tmp[1]+",</span>"
                +"<span style='color:#FFE302;'>"+tmp[2]+"</span>)";
            var domName  = name.replace(" ","");
            $("."+domName).html(htmlStr);
        }
    }
    function initEchart(idDom,echartData){
        var lendData = [];
        var serisData = [];
        var echartDatas;
        var echartLabel ={
            'OTHERS':'',
            'FO ACCESS':'',
            'RADIO ACCESS':'',
            'SL_D':''
        };
        if(echartData){
            echartDatas = echartData;
            for(var i=0,len=echartDatas.length;i<len;i++){
                var tmpObj = {};
                tmpObj.value = echartDatas[i].value;
                tmpObj.name = echartDatas[i].name;
                lendData.push(echartDatas[i].name);
                serisData.push(tmpObj);
                for(var name in echartLabel){
                    if(name==echartDatas[i].name){
                        echartLabel[name] = echartDatas[i].otherfull;
                    }
                }
            }
        }else{
            serisData = [
                {
                    value:1,name:'nodata'
                }
            ];;
        }
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
                                    for(var i=0;i<datas.length;i++){
                                        res+=params.value+"("+echartLabel[params.name]+")";
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
