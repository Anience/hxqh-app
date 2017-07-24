/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mob86",
        data: {
            mobList:[],
            week1:'',
            week2:''
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
                    self.week1 = data.week1.replace("W","W-");
                    self.week2 = data.week2.replace("W","W-");
                },
                error: function () {

                }
            });
        }
    });
});
