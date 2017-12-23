
$(function(){
    function init(){
        var urls = _ctx+"/ano/naruData";
        $.ajax({
            url: urls,
            method: "get",
            dataType: "json",
            success: function (data) {
                initELine('echart2');
            },
            error: function () {
            }
        });
    }
    init();

    //调用此函数时，参数domId,data,legendData,xData
    function initEchart(idDom,echartData){
        var echartDatas2 = [
            {value:335, name:'直接访问'},
            {value:310, name:'邮件营销'},
            {value:234, name:'联盟广告'},
            {value:135, name:'视频广告'},
            {value:1548, name:'搜索引擎'}
        ];
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            series : [
                {
                    name:"87Screen",
                    type:'pie',
                    radius : '80%',
                    center: ['60%', '50%'],
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
