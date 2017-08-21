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
            isNew: true,
            userid:''
        },
        methods:{
            add:function(){
                var self = this;
                self.userName = "";
                self.selected = "";
                self.email = "";
                self.userid =  "";
                $.ajax({
                    url: _ctx+"/system/roleListData",
                    method: "get",
                    dataType: "json",
                    success: function (data) {
                        self.roleList = data;
                    },
                    error: function () {

                    }
                });
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
                self.userid = item.id;
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
            del:function(item){
                var msgs = 'Are you sure to delete the user?';
                Showbo.Msg.confirm(msgs,function(f){
                    if(f=='yes'){
                        $.ajax({
                            url: _ctx+"/system/delUser",
                            method: "get",
                            dataType: "json",
                            data:{
                                id: item.id
                            },
                            success: function (data) {
                                window.location.href = _ctx+"/system/userList";
                            },
                            error: function () {

                            }
                        });
                    }else{
                        return false;
                    }
                });
            },
            close:function(){
                $(".box").hide();
                $(".mask").hide();
            },
            save:function(){
                var self = this;
                var tmpUrl = '';
                var data = {};
                if(self.isNew){
                    tmpUrl = _ctx+"/system/addUser";
                    datas = {
                        username: self.userName,
                        email: self.email,
                        roleid: self.selected
                    }
                }else{
                    tmpUrl = _ctx+"/system/editUser";
                    datas = {
                        username: self.userName,
                        email: self.email,
                        id: self.userid,
                        roleid: self.selected
                    }
                }
                $.ajax({
                    url: tmpUrl,
                    method: "get",
                    dataType: "json",
                    data: datas,
                    success: function (data) {
                       alert(data.message);
                       window.location.href = _ctx+"/system/userList";
                    },
                    error: function () {

                    }
                });
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