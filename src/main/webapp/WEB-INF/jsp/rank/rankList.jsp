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
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="rank-layout" id="customer-data">
    <table cellspacing="0">
        <thead>
            <tr>
                <td width="7%">Customer Num</td>
                <td width="7%">Customer Name</td>
                <td width="7%">Rank</td>
                <td width="7%" class="custtype">Type</td>
                <td width="7%" style="display: none;">ioccustomerusertop7id</td>
                <td width="7%">Operation</td>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
<script src="${ctx}/js/rank/rankList.js"></script>
</body>
</html>
