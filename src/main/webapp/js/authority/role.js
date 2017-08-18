$(function () {
    var system = new Vue({
        el: "#customer-data",
        data: {
            roleList:[],
            roleName:"",
            roleDesc: "",
            modelNoList:[],
            modelHaveList:[]
        },
        methods:{
            add:function(){
                self.roleName = "";
                self.roleDesc = "";
                $(".mask").show();
                $(".box").show();
            },
            edit:function(item){
                var self = this;
                self.isNew = false;
                $(".mask").show();
                $(".box").show();
                self.roleName = item.rolename;
                self.roleDesc = item.roledesc;
                self.roleId = item.roleid;
            },
            del:function(item){
                $.ajax({
                    url: _ctx+"/system/delrole",
                    method: "get",
                    dataType: "json",
                    data:{
                        id: item.roleid
                    },
                    success: function (data) {
                        alert(data.message);
                        window.location.href = _ctx+"/system/roleList";
                    },
                    error: function () {

                    }
                });
            },
            authorization:function(item){
                var self = this;
                $(".mask").show();
                $(".auth-box").show();
                $.ajax({
                    url: _ctx+"/system/modelRoleData",
                    method: "get",
                    dataType: "json",
                    data:{
                        roleid: item.roleid
                    },
                    success: function (data) {
                        self.modelNoList  = data.modelNoList;
                        self.modelHaveList = data.modelHaveList;
                    },
                    error: function () {

                    }
                });
            },
            close:function(){
                $(".box").hide();
                $(".mask").hide();
                $(".auth-box").hide();
            },
            save:function(){
                var self = this;
                var tmpUrl = '';
                var data = {};
                if(self.isNew){
                    tmpUrl = _ctx+"/system/addRole";
                    datas = {
                        rolename: self.roleId,
                        roledesc: self.roleDesc
                    }
                }else{
                    tmpUrl = _ctx+"/system/editRole";
                    datas = {
                        id: self.roleId,
                        rolename: self.roleId,
                        roledesc: self.roleDesc
                    }
                }
                $.ajax({
                    url: tmpUrl,
                    method: "get",
                    dataType: "json",
                    data: datas,
                    success: function (data) {
                        alert(data.message);
                        window.location.href = _ctx+"/system/RoleList";
                    },
                    error: function () {

                    }
                });
            },
        },
        created: function () {
            var self = this;
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
        }
    });
});