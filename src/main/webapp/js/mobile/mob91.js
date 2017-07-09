/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#mob91-data",
        data: {
            mobLeft:[],
            mobRight:[]
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/mobile/vMob91Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.mobLeft = data.mob91LeftList;
                    self.mobRight = data.mob9RightList;
                    setInterval(function(){
                        window.location.href=_ctx+"/mobile/mobile91";
                    },300000);
                },
                error: function () {

                }
            });
        }
    });
});
