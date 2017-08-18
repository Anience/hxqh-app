<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/1
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='utf-8'>
    <title></title>
    <meta name="keywords" content="">
    <link rel="stylesheet" href="${ctx}/css/reset.css">
    <link rel="stylesheet" href="${ctx}/css/rank/rank.css">
    <script src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/script/vue.js"></script>
    <script type="text/javascript" src="${ctx}/js/authority/user.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="rank-layout" id="customer-data">
    <table cellspacing="0">
        <thead>
        <tr>
            <td width="2%">Role Name</td>
            <td width="7%">Module</td>
        </tr>
        </thead>
        <tbody>
            <tr v-for="item in userList">
                <td>{{item.name}}</td>
                <td>{{item.rolename}}</td>
                <td>
                    <button class="btn" @click="add">add</button>
                    <button class="btn" @click="edit(item)">edit</button>
                    <button class="btn" @click="del">del</button>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="mask"></div>
    <div class="box" style="background: #fff;">
        <i class="close" @click="close"></i>
        <h4>Infomation</h4>
        <div class="user-info">
            <p class="item">
                <lable>UserName</lable>
                <input type="text" v-text="userName" v-model="userName">
            </p>
            <p class="item">
                <lable>Password</lable>
                <input type="password" v-text="pwd" v-model="pwd">
            </p>
            <p class="item">
                <lable>E-mail:</lable>
                <input type="text" v-text="email" v-model="email">
            </p>
            <p class="item">
                <lable>Role</lable>
                <select v-model="selected">
                    <option value="item.roleid" v-for="item in roleList">{{item.rolename}}</option>
                </select>
            </p>
            <p class="btn">
                <button @click="save">Save</button>
                <button @click="close">Cancle</button>
            </p>
        </div>
    </div>
</div>

</body>
</html>
