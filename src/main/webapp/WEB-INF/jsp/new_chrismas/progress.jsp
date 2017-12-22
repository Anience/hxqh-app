<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/12/22
  Time: 03:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${ctx}/css/chrismas/chrismas.css" type="text/css" media="screen" />
    <script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
    <script>
        var _ctx = "${ctx}";
    </script>
</head>
<body>
<div class="p_layout">
    <div id="echart2"></div>
    <table border="2" bordercolor="black" cellspacing="0" cellpadding="5">
        <tr>
            <td>TOTAL</td>
            <td>93.5%</td>
        </tr>
        <tr>
            <td>IP RAN</td>
            <td>93.5%</td>
        </tr>
        <tr>
            <td>IP Core</td>
            <td>93.5%</td>
        </tr>
        <tr>
            <td colSpan="2">UIC:PND,DSO,TREG,TSEL</td>
        </tr>
    </table>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/chrismas/progess.js"></script>
</html>
