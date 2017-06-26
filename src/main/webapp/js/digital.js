/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#digital-Data",
        data: {

        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: "${ctx}/inventory/inventoryData",
                method: "get",
                dataType: "json",
                success: function (data) {

                },
                error: function () {

                }
            });
        }
    });
});
