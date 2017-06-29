/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#ano82-data",
        data: {
            anoList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiNumberData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.anoList = data;

                },
                error: function () {

                }
            });
        }
    });
});
