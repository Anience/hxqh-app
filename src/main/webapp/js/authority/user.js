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
            pwd:'000000',
            email:'',
            isNew: ture
        },
        methods:{
            add:function(){
                this.initBox();
                $(".box").show();
            },
            edit:function(item){
                var self = this;
                self.isNew = false;
                self.pwd = "000000";
                $(".box").show();
                $.ajax({
                    url: _ctx+"/system/userDetailData",
                    method: "get",
                    dataType: "json",
                    data:{
                        id: item.id
                    },
                    success: function (data) {
                        self.userName = item.name;
                        self.selected = item.roleName;
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
                self.userName = "";
                self.selected = "";
                self.roleList = [];
                self.email = "";
                self.pwd = "";
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