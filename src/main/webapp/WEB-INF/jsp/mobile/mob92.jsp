<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<meta http-equiv="refresh" content="300">
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
	<style>
		#mob91{
			width: 100%;
			min-height: 100%;
			background: #03071D;
		}
	</style>
</head>
<body>
	<div id="mob91">
		<div id="echart1" style="width: 100%;height: 80%;padding-top:80px;"></div>
	</div>
</body>
<script type="text/javascript" src="${ctx}/js/mobile/mob92.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>