/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            parentList:[],
            sonList:[]
        },
        methods:{
            add:function(){
                $(".box").show();
            },
            edit:function(item){

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
                url: _ctx+"/system/modelListData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    self.parentList = data.listMap[0];
                    self.sonList = data.listMap[1];

                },
                error: function () {

                }
            });
        }
    });
});