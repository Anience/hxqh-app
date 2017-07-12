/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#ticket-data",
        data: {
            ticketList:[],
            test: 0,
            time: "",
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
                    self.ticketList = data.vWifiTickets;
                    self.time = data.nowTime;
                    setInterval(function(){
                        window.location.href=_ctx+"/wifi/ticket";
                    },300000);
                },
                error: function () {

                }
            });
        }
    });
});
