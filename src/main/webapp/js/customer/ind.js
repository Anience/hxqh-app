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
            },
            error: function () {
                 dealData(impactList);
                 dealData(regularList);
                 dealData(totalList);
                var totalHtml = initDom(totalList);
                var imHtml = initDom(impactList);
                var reHtml = initDom(regularList);
                $("#total-table").html(totalHtml);
                $("#impact-table").html(imHtml);
                $("#re-table").html(reHtml);
            }
        });
    }
    function dealData(data){
        for(var i=0;i<data.length;i++){
            if(data[i].Dev<0){
                data[i].status = 'seri';
            }
            if(data[i].Dev==0){
                data[i].status = 'menany';
            }
            if(data[i].Dev>0){
                data[i].status = 'kalah';
            }
        }
    }
    function initDom(data){
        var tmpHtml = "";
        if(data[i].Dev>0){
            tmpHtml += '<tr><td rowspan="2">'
                +data[i].regional+'</td><td>'
                +data[i].Sh+'</td><td>'
                +data[i].Op+'</td><td>'
                +data[i].Dev+'</td></tr><tr><td>'
                +data[i].Sh1+'</td><td>'
                +data[i].Cl+'</td><td>'
                +data[i].status+'</td></tr>';
        }else{
            tmpHtml += '<tr><td rowspan="2">'
                +data[i].regional+'</td><td>'
                +data[i].Sh+'</td><td>'
                +data[i].Op+'</td><td style="color: red;">'
                +data[i].Dev+'</td></tr><tr><td>'
                +data[i].Sh1+'</td><td>'
                +data[i].Cl+'</td><td style="color: red;">'
                +data[i].status+'</td></tr>';
        }
        return tmpHtml;
    }
    initData();
});
