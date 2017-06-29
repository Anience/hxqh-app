/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#digital-data",
        data: {
            tit:"",
            digList: [],
            dig13Dto: [],
            dig14Dto: [],
            dig17Dto: [],
            dig18Dto: [],
            isShow: false
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
                    switch(urlNum){
                        case "13":
                            self.digList = data.vDig13List;
                            break;
                        case "14":
                            self.digList = data.dig14List;
                            break;
                        case "17":
                            self.digList = data.dig17List;
                            break;
                        case "18":
                            self.digList = data.dig18List;
                            break;
                        default:
                            self.dig13Dto = data.dig13Dto;
                            self.dig14Dto = data.dig14Dto;
                            self.dig17Dto = data.dig17Dto;
                            self.dig18Dto = data.dig18Dto;
                            self.isShow = true;
                    }
                },
                error: function () {

                }
            });
        }
    });
});
