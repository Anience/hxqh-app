/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mttr-data",
        data: {
            mttrList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiMttrData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.mttrList = data;
                },
                error: function () {

                }
            });
        }
    });
});
