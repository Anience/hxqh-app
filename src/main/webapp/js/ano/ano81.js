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
           }
        },
        created: function () {
            var self = this;
            self.initData();
            setInterval(self.initData(),3000);
        }
    });
});
