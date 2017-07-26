/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var digitalData = new Vue({
        el: "#ano81-data",
        data: {
            anoList:[]
        },
        methods: {
           initData:function(){
               var self = this;
               $.ajax({
                   url: _ctx+"/ano/ano81Data",
                   method: "get",
                   dataType: "json",
                   success: function (data) {
                       self.anoList = data;
                   },
                   error: function () {

                   }
               });
           },
            changeData: function(){
                var self = this;
                $.ajax({
                    url: _ctx+"/ano/ano81Data",
                    method: "get",
                    dataType: "json",
                    success: function (data) {
                        self.anoList.splice(data.length);
                    },
                    error: function () {

                    }
                });
            }
        },
        created: function () {
            var self = this;
            self.initData();
        }
    });
});
