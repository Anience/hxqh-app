/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#digital-Data",
        data: {
            tit:"",
            dig13List: [],
            dig14List: [],
            dig17List: [],
            dig18List: [],
            digList: []
        },
        methods: {

        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/digital/vDigital13Data",
                method: "get",
                dataType: "json",
                success: function (data) {
                   console.log(data);

                },
                error: function () {

                }
            });
        }
    });
});
