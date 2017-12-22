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
        <div id="echart1"></div>
        <div class="scoll-nav">
            <ul class="sec-nav">
                <li style="margin-left: 60px;"><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
                <li><span class="radius"></span></li>
            </ul>
            <ul class="first-nav">
                <li style="margin-left: 60px;">BD1S</li>
                <li>JK1S</li>
                <li>JK2S</li>
                <li>SM1S</li>
                <li>MD1S</li>
                <li>MK1S</li>
                <li>BM1S</li>
            </ul>
        </div>
    </div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/chrismas/cbr_bdis.js"></script>
</html>
