/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#ticket-data",
        data: {
            ticketList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/wifi/vWifiTicketData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.ticketList = data;

                },
                error: function () {

                }
            });
        }
    });
});
