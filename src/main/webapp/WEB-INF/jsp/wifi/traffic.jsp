<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
	<style>
		.traffic-layout{
			width: 100%;
			height: 100%;
			background: #03071D;
			padding-top: 5%;
			padding-bottom: 5%;
		}
	</style>
</head>
<body>
	<div class="traffic-layout">
		<div class="row" style="height: 50%;width:100%;" id="echart1"></div>
		<div class="row" style="height: 50%;width:100%;" id="echart2"></div>
	</div>
</body>
<script type="text/javascript" src="${ctx}/js/traffic.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
</html>