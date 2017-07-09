/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#distribution-data",
        data: {
            disList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiDistributionData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.disList = data;
                    setInterval(function(){
                        window.location.href=_ctx+"/wifi/distribution";
                    },300000);
                },
                error: function () {

                }
            });
        }
    });
});
