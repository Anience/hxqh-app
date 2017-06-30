/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mob87",
        data: {
            anoList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/mobile/vMob87Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.anoList = data;
                    initEchart("echart1");
                },
                error: function () {

                }
            });
        }
    });
    function initEchart(idDom){
        var myChart = echarts.init(document.getElementById(idDom));
        option = {
            title :{
                text: '某站点用户访问来源',
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
                data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
            },
            calculable : false,
            series : [
                {
                    name:'访问来源',
                    type:'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        {value:335, name:'直接访问'},
                        {value:310, name:'邮件营销'},
                        {value:234, name:'联盟广告'},
                        {value:135, name:'视频广告'},
                        {value:1548, name:'搜索引擎'}
                    ]
                }
            ]
        };
        myChart.setOption(option);
    }
});
