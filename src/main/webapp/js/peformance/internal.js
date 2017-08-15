$(function(){
    var digitalData = new Vue({
        el: "#internal-data",
        data: {
             dataList: []
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/sla/internalData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.dataList = data.listMap;
                },
                error: function () {

                }
            });
        }
    });
});