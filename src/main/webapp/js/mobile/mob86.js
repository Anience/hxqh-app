/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mob86",
        data: {
            mobList:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/mobile/vMob86Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.mobList = data.vMob86List;
                },
                error: function () {

                }
            });
        }
    });
});
