/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    var impactList = [];
    var regularList = [];
    var totalList = [];
    function initData(){
        $.ajax({
            url: _ctx+"/ano/indiHomeData",
            method: "get",
            dataType: "json",
            success: function (data) {
                impactList = data.homeImpactList;
                regularList = data.homeRegularList;
                totalList = data.homeTotalList;
                dealData(impactList);
                dealData(regularList);
                dealData(totalList);
                $('.ind-time').text(data.clienttime);
                var totalHtml = initDom(totalList);
                var imHtml = initDom(impactList);
                var reHtml = initDom(regularList);
                $("#total-table").html("");
                $("#total-table").append(totalHtml);
                $("#impact-table").html("");
                $("#impact-table").append(imHtml);
                $("#regular-table").html("");
                $("#regular-table").append(reHtml);
            },
            error: function () {

            }
        });
    }
    function dealData(data){
        for(var i=0;i<data.length;i++){
            if(data[i].dev<0){
                data[i].status = 'menang';
            }
            if(data[i].dev==0){
                data[i].status = 'seri';
            }
            if(data[i].dev>0){
                data[i].status = 'kalah';
            }
        }
    }
    function initDom(data){
        if(data[0].dev>0){
            var  tmpHtml = '<tr><td rowspan="2"></td><td>'
                +data[0].sh+'</td><td>'
                +data[0].op+'</td><td>'
                +data[0].dev+'</td></tr><tr><td>'
                +data[0].sh1+'</td><td>'
                +data[0].cl+'</td><td>'
                +data[0].status+'</td></tr>';
        }else{
            var  tmpHtml = '<tr><td rowspan="2"></td><td>'
                +data[0].sh+'</td><td>'
                +data[0].op+'</td><td style="color: red;">'
                +data[0].dev+'</td></tr><tr><td>'
                +data[0].sh1+'</td><td>'
                +data[0].cl+'</td><td style="color: red;">'
                +data[0].status+'</td></tr>';
        }

        for(var i=1;i<data.length;i++){
            if(data[i].dev>0){
                tmpHtml += '<tr><td rowspan="2">'
                    +data[i].regional+'</td><td>'
                    +data[i].sh+'</td><td>'
                    +data[i].op+'</td><td>'
                    +data[i].dev+'</td></tr><tr><td>'
                    +data[i].sh1+'</td><td>'
                    +data[i].cl+'</td><td>'
                    +data[i].status+'</td></tr>';
            }else{
                tmpHtml += '<tr><td rowspan="2">'
                    +data[i].regional+'</td><td>'
                    +data[i].sh+'</td><td>'
                    +data[i].op+'</td><td style="color: red;">'
                    +data[i].dev+'</td></tr><tr><td>'
                    +data[i].sh1+'</td><td>'
                    +data[i].cl+'</td><td style="color: red;">'
                    +data[i].status+'</td></tr>';
            }
        }
        return tmpHtml;
    }
    initData();
    setInterval(function(){
        initData();
    },300000);
});
