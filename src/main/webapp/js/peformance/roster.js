
$(function(){
    function init(){
        $.ajax({
            url: _ctx+"/sla/rosterData",
            method: "get",
            dataType: "json",
            success: function (data) {

            },
            error: function () {

            }
        });
    }
    init();
});
