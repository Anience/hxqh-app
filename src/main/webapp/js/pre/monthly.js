$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/ano/monthlyData",
            method: "get",
            dataType: "json",
            success: function (data) {
                $("table.monthly tbody").html("");
                var tmpHtml  = '';
                var datas = data.iocProMonthlyList;
                for(var i = 0;i<datas.length;i++){
                    var firstTd = '';
                    if(i>=7){
                        firstTd = 'BIGES';
                    }else{
                        firstTd = "TREG-"+(i+1);
                    }
                    tmpHtml+='<tr><td width="20%">'+firstTd
                        +'</td><td width="20%">'+datas[i].mtt
                        +'</td><td width="20%">'+datas[i].mtti
                        +'</td><td width="20%">'+datas[i].jmlAll
                        +'</td><td width="20%">'+datas[i].tt
                        +'</td></tr>';
                }
                $("table.monthly tbody").html(tmpHtml);
            },
            error: function () {

            }
        });
    }
    init();
});