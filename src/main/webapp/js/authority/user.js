/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            userList:[],
            user:[]
        },
        methods:{
            add:function(){
                $(".box").show();
            },
            edit:function(item){
                var self = this;
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
            }
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/system/userListData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.userList = data.list;
                },
                error: function () {

                }
            });
        }
    });
});