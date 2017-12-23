
$(function(){
    function init(){
        var urls = _ctx+"/ano/naruData";
        $.ajax({
            url: urls,
            method: "get",
            dataType: "json",
            success: function (data) {
                var dataIndex = parseInt(pie);
                var tit = [
                    "",
                    "PROGRESS ALPRO KOMSEL",
                    "PROGRESS REHEARSAL NETWORK",
                    "PROGRESS MITIGASI CELAH KEAMANAN",
                    "POSKO NARU"
                ];
                $("h3").text(tit[dataIndex]);
                var totalData = data.listMap[dataIndex];
                var tmpHtml = "";
                for(var i=0;i<totalData.length;i++){
                    if(i==0){
                        tmpHtml+="<tr><td colSpan='2'>"+totalData[i].charttitle+"-"+totalData[i].value+"%</td></tr>";
                    }else{
                        tmpHtml+="<tr><td>"+totalData[i].items+"</td><td>"+totalData[i].value+"%</td></tr>";
                    }
                }
                tmpHtml+="<tr><td colSpan='2'>UIC:PND,DSO,TREG,TSEL</td></tr>";
                $(".p_layout table").html("");
                $(".p_layout table").html(tmpHtml);
                if(pie=="2"||pie=="4"){
                    $(".p_layout table").css("margin-top","15%");
                }
                var tmpValue = Math.round(totalData[0].value);
                initEchart('echart2',tmpValue);
            },
            error: function () {
            }
        });
    }
    init();

    //调用此函数时，参数domId,data,legendData,xData
    function initEchart(idDom,echartData){
        var otherValue = 100-echartData;
        var echartDatas2 = [
            {value:echartData, name:'直接访问'},
            {value:otherValue, name:'邮件营销'},
        ];
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            series : [
                {
                    name:"87Screen",
                    type:'pie',
                    radius : '50%',
                    center: ['50%', '50%'],
                    itemStyle:{
                        normal:{
                            label:{
                                show: true,
                                textStyle: {
                                    fontSize: '18',
                                    fontWeight: 'normal'
                                },
                                formatter: "{d}%"
                            }

                        },
                        labelLine :{
                            show: true
                        }
                    },
                    data:echartDatas2

                }
            ],
            color:['#FF7F50', '#87CEFA','#DA70D6','#32CD32']
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
