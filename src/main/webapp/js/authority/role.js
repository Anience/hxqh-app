$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            roleList:[]
        },
        methods: {
            add:function(){
                $(".mask").show();
                $(".box").show();
            },
            edit:function(item){
                var self = this;
                $(".mask").show();
                $(".box").show();
                $.ajax({
                    url: _ctx+"/system/userDetail",
                    method: "get",
                    dataType: "json",
                    data:{
                        id: item.id
                    },
                    success: function (data) {
                        self.user = data;
                    },
                    error: function () {

                    }
                });
            },
            del:function(){

            },
            close:function(){
                $(".box").hide();
                $(".mask").hide();
            }
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/system/roleListData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.roleList = data.roleList;
                },
                error: function () {

                }
            });
        }
    });
});