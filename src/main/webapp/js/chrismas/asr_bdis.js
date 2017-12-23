$(function(){
    var legendData = ["w1Attempt","w2Attempt","w1Answer","w2Answer"];
    var xData1 = [];
    var xData2 = [];
    var xData = [];
    var totalData = [];
    var totalData1 = [];
    var totalData2 = [];
    var tit1 = "";
    var tit2 = "";
    var dataTurn = ["BD1S","PG1S","JK1S","JK2S","SM1S","MD1S","MK1S","BM1S"];
    function init(){
        $.ajax({
            url: _ctx+"/ano/asrbdisData",
            method: "get",
            dataType: "json",
            success: function (data) {
                //处理数据，数据顺序输出
                totalData1 =  data.group;
                totalData =  data.group;
                xData1 = totalData.BD1S.weekday;
                xData = totalData.BD1S.weekday;
                var tit1 = "Call Answer Ratio (% ASR) For BD1S on Week 1 & Week 2           as of 15 Dec 2017\n";
                $(".tit").text(tit1);
                // 每组数据
                dealData(totalData.BD1S,"BD1S","weeks");
                getData();
                //轮播图
                var j = 0;
                setInterval(function(){
                    j++;
                    if(j>=17){
                        j=0;
                    }else{
                        var index= j%8;
                        var showContent = "weeks";
                        var liNav = '.first-nav li';
                        var thisLi = '.first-nav li:nth-child('+index+')';
                        $(liNav).css("color","#727386");
                        $(thisLi).css("color","#fff");
j
                        if(j>=9){
                            xData = xData2;
                            totalData = totalData2;
                            showContent = "years";
                            $(".tit").text(tit2);
                        }else{
                            xData = xData1;
                            totalData = totalData1;
                            showContent = "weeks";
                            $(".tit").text(tit1);
                        }
                        var liNav2 = '.sec-nav li'+' span';
                        var thisLi2 = '.sec-nav li:nth-child('+index+')'+' span';
                        $(liNav2).css("backgroundColor","#0a0f25");
                        $(thisLi2).css("backgroundColor","#4a476a");
                        dealData(totalData[dataTurn[index]],dataTurn[index],showContent);
                    }
                },5000);
            },
            error: function () {
            }
        });
    }
    init();

    function getData(){
        var urls = _ctx+"/ano/cbrbdisData";
        $.ajax({
            url: urls,
            method: "get",
            dataType: "json",
            success: function (data) {
                totalData2 =  data.group;
                xData2 = data.group.BD1S.weekday;
                tit2 = "Call Answer Ratio (% ASR) For BD1S on Years 2016 & 2017         as of 15 Dec 2017";
            },
            error: function () {
            }
        });
    }

    function dealData(datas,objName,showContent){
        var data = [];
        for(var i=0;i<legendData.length;i++){
            var tmpObj = {};
            tmpObj.name=legendData[i];
            if(legendData[i]=="w1Attempt"||legendData[i]=="w2Attempt"){
                tmpObj.type="bar";
            }else{
                tmpObj.type="line";
            }
            tmpObj.data=datas[legendData[i]];
            data.push(tmpObj);
        }
        if(showContent=="years"){
            $(".showcontent span:nth-child(1)").text(datas.w1Block);
            $(".showcontent span:nth-child(2)").text(datas.w2Block);
            $(".showcontent").show();
            $("table.perservice").hide();
        }else{
            var tmpHtml1 = "<tr><td width='3%'>Previous</td>";
            var tmpHtml2 = "<tr><td width='3%'>current</td>";
            var tmpHtml3 = "<tr><td width='3%'></td>";
            var w1Aser = datas.w1Block||[];
            var w2Aser = datas.w2Block||[];
            for(var m=0;m<w1Aser.length;m++){
                tmpHtml1+="<td>"+w1Aser[m]+"</td>";
                tmpHtml2+="<td>"+w2Aser[m]+"</td>";
                tmpHtml3+="<td>"+xData[m]+"</td>";
            }
            tmpHtml1 += "</tr>";
            tmpHtml2 += "</tr>";
            $("table.perservice thead").html(tmpHtml3);
            $("table.perservice tbody").html("");
            $("table.perservice tbody").html(tmpHtml1+tmpHtml2);
            $("table.perservice").show();
            $(".showcontent").hide();
        }
        initELine('echart1',data,legendData,xData);
    }
    //调用此函数时，参数domId,data,legendData,xData
    function initELine(domId,data,legendData,xData) {
        var myChart = echarts.init(document.getElementById(domId));
        option = {
            backgroundColor: '#0A0F25',
            color:['#4B92D1','#70AD47','#FFC300','#A3A3A3'],

            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: legendData,
                x: 'center',
                y: 'bottom',
                textStyle: {
                    fontSize: 16,
                    fontFamily: "Arial",
                    color: '#CECECE'
                }
            },
            calculable: true,
            grid: {
                show: false,
                borderWidth: 1,
                borderColor: '#212538'
            },
            xAxis: [{
                show: true,
                type: 'category',
                axisLabel: {
                    show: true,
                    textStyle: {
                        fontSize: 12,
                        fontFamily: "Arial",
                        color: '#9F9FA1'
                    }
                },
                splitArea: {
                    show: false
                },
                splitLine: {
                    show: false,
                    lineStyle: {
                        color: '#212538',
                    }
                },
                data: xData
            }],
            yAxis: [{
                type: 'value',
                axisLabel: {
                    show: true,
                    textStyle: {
                        fontSize: 12,
                        fontFamily: "Arial",
                        color: '#9F9FA1'
                    }
                },
                splitArea: {
                    show: false
                },
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#212538',
                    }
                },
            }],
            series : data
        };
        myChart.setOption(option);
    }
});
