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
    <script type="text/javascript" src="${ctx}/js/authority/role.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="rank-layout" id="customer-data">
    <table cellspacing="0">
        <thead>
            <tr>
                <td width="7%">Role Name</td>
                <td width="7%">Description</td>
                <td width="7%">Operation</td>
            </tr>
        </thead>
        <tbody>
            <tr v-for="item in roleList">
                <td>{{item.rolename}}</td>
                <td>{{item.roledesc}}</td>
                <td>
                    <button class="btn" @click="add">add</button>
                    <button class="btn" @click="edit(item)">edit</button>
                    <button class="btn" @click="del">del</button>
                    <button class="btn" @click="authorization(item)" style="width: 120px;">authorization</button>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="mask"></div>
    <div class="box" style="background: #fff;height: 260px;">
        <i class="close" @click="close"></i>
        <h4>Infomation</h4>
        <div class="user-info">
            <p class="item">
                <lable style="width: 70px;">Name</lable>
                <input type="text" style="width: 190px;" v-text="roleName" v-model="roleName">
            </p>
            <p class="item">
                <lable style="width: 70px;">Description</lable>
                <input type="text" style="width: 190px;"  v-text="roleDesc" v-model="roleDesc">
            </p>
            <p>
                <button>Save</button>
                <button>Cancle</button>
            </p>
        </div>
    </div>
    <div class="auth-box" style="background: #fff;">
        <i class="close" @click="close"></i>
        <h4>Infomation</h4>
        <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
        <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
        <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
        <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
        <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
        <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
        <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
        <label><input name="Fruit" type="checkbox" value="" />苹果 </label>
        <p style="width: 300px; margin: 0 auto;">
            <button>Save</button>
            <button>Cancle</button>
        </p>
    </div>
</div>
</body>
</html>
