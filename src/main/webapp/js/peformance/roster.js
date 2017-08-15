
$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/sla/rosterData",
            method: "get",
            dataType: "json",
            success: function (data) {
                var dataObj = {
                    datin:[],
                    hsi:[],
                    imes:[],
                    surveillance:[],
                    telephony:[],
                    wifi:[],
                }
                dataObj.datin = data.fmap.DATIN;
                dataObj.hsi = data.fmap.HSI;
                dataObj.imes = data.fmap.IMES;
                dataObj.surveillance = data.fmap.SURVEILLANCE;
                dataObj.telephony = data.fmap.TELEPHONY;
                dataObj.wifi = data.fmap.WIFI;
                initDom(dataObj.hsi);
                var i = 0;
                var dataTurn = ['hsi','telephony','imes','datin','surveillance','wifi'];
                setInterval(function(){
                    i++;
                    if(i>=6){
                        i=0;
                    }
                    var dataName = dataTurn[i];
                    initDom(dataObj[dataName]);
                    var domIndex = 'ul li:nth-child('+i+')';
                    $("ul li").css("color","#42435F");
                    $(domIndex).css("color","#fff");
                },10000)
            },
            error: function () {

            }
        });
    }
    function initDom(data){
        var tmpHtml1 = '';
        var tmpHtml2 = '';
        var tmpHtml3 = '';
        var count = Math.ceil(data.length/3);
        for(var i=0;i<count;i++){
            var index1 = 3*i+1
            var index2 = 3*i+2
            var index3 = 3*i+3
            var m = 3*i+1;
            var n = 3*i+2;
            tmpHtml1+="<tr><td>"+index1+"</td>"
                     +"<td>"+data[3*i].rosterId+"</td>"
                     +"<td>"+data[3*i].nama+"</td>"
                     +"<td>"+data[3*i].status+"</td>"
                     +"<td>"+data[3*i].dutyTime+"</td></tr>";
            if(m<data.length){
                tmpHtml2+="<tr><td>"+index2+"</td>"
                    +"<td>"+data[m].rosterId+"</td>"
                    +"<td>"+data[m].nama+"</td>"
                    +"<td>"+data[m].status+"</td>"
                    +"<td>"+data[m].dutyTime+"</td></tr>";
            }
            if(n<data.length){
                tmpHtml3+="<tr><td>"+index3+"</td>"
                    +"<td>"+data[n].rosterId+"</td>"
                    +"<td>"+data[n].nama+"</td>"
                    +"<td>"+data[n].status+"</td>"
                    +"<td>"+data[n].dutyTime+"</td></tr>";
            }
        }
        $('.table1 tbody').html();
        $('.table2 tbody').html();
        $('.table3 tbody').html();
        $('.table1 tbody').html(tmpHtml1);
        $('.table2 tbody').html(tmpHtml2);
        $('.table3 tbody').html(tmpHtml3);
    }
    init();
});
