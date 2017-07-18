/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#ind-data",
        data: {
            impactList: [],
            regularList: [],
            totalList: []
        },
        methods: {
           initData:function(){
               var self = this;
               $.ajax({
                   url: _ctx+"/ano/indiHomeData",
                   method: "get",
                   dataType: "json",
                   success: function (data) {
                       self.impactList = data.homeImpactList;
                       self.regularList = data.homeRegularList;
                       self.totalList = data.homeTotalList;
                   },
                   error: function () {

                   }
               });
           }
        },
        created: function () {
            var self = this;
            self.initData();
           /* setInterval(function(){
                window.location.href=_ctx+"/ano/indiHomeData";
            },300000);*/
        }
    });
});
