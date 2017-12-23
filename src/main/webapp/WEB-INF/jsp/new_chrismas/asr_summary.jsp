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
<div class="layout">
    <div class="box">
        <h4 class="tit"></h4>
        <table class="perservice" style="display: none;">
            <thead></thead>
            <tbody></tbody>
        </table>
        <div class="showcontent">
            <span></span>
            <span></span>
        </div>
        <div id="echart1"></div>
    </div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/chrismas/asr_summary.js"></script>
</html>
