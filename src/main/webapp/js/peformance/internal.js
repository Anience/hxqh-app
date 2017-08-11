$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/sla/internalData",
            method: "get",
            dataType: "json",
            success: function (data) {
                $("table.ano81 tbody").html("");
                var tmpHtml  = '';
                for(var i = 0;i<data.length;i++){
                    tmpHtml+='<tr><td>'+data[i].ioc1
                        +'</td><td>'+data[i].ioc2
                        +'</td><td>'+data[i].ioc3
                        +'</td><td>'+data[i].ioc4
                        +'</td><td>'+data[i].ioc5
                        +'</td><td>'+data[i].ioc6
                        +'</td><td>'+data[i].ioc7
                        +'</td><td>'+data[i].downunit
                        +'</td></tr>';
                }
                $("table.ano81 tbody").html(tmpHtml);
            },
            error: function () {

            }
        });
    }
    init();
    setInterval(function(){
        init();
    },300000)
});