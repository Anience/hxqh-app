<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/consumer/solution.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
		var _type = "${page}";
	</script>
	<style>
		.ticket-time{
			color: #fff;
			font-size: 29px;
			height:46px;
			width: 30%;
			line-height:46px;
			display: block;
			float: right;
		}
	</style>
</head>
<body>
<div class="new3-layout">
	<div style=" width: 100%; height: 50px;"><h4>Consumer- Voice Traffic</h4><span class="ticket-time"></span></div>

	<div id="echart1" style="height:80%; "></div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/consumer/solution.js"></script>
</html>