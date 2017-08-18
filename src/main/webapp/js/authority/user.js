/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            userList:[],
            userName:'',
            roleName:'',
            selected:'',
            roleList:[],
            email:'',
            isNew: true
        },
        methods:{
            add:function(){
                this.initBox();
                $(".userName").text();
                $(".email").text();
                self.userName = "";
                self.selected = "";
                self.email = "";
                $(".mask").show();
                $(".box").show();
            },
            edit:function(item){
                var self = this;
                self.isNew = false;
                $(".mask").show();
                $(".box").show();
                self.userName = item.name;
                self.selected = item.roleName;
                $.ajax({
                    url: _ctx+"/system/userDetailData",
                    method: "get",
                    dataType: "json",
                    data:{
                        id: item.id
                    },
                    success: function (data) {
                        self.roleList = data.roleList;
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
            },
            save:function(){
                var url = '';
                var data = {};
                if(isNew){
                    url = _ctx+"/system/addUser";
                    data = {

                    }
                }else{
                    url = _ctx+"/system/editUser";
                }
                $.ajax({
                    url: _ctx+"/system/editUser",
                    method: "get",
                    dataType: "json",
                    data:{
                        id: item.id
                    },
                    success: function (data) {
                        self.userName = item.name;
                        self.selected = item.roleName;
                        self.roleList = data.roleList;
                        self.pwd = "";
                    },
                    error: function () {

                    }
                });
            },
            initBox: function(){
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