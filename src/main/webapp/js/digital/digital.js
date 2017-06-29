/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#digital-data",
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
            var tmpurl = _ctx+"/digital/vDigital"+urlNum+"Data";
            $.ajax({
                url: tmpurl,
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.tit = data.name;
                    self.digList = data.vDig13List;
                },
                error: function () {

                }
            });
        }
    });
});
