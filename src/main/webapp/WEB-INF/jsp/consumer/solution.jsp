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
	</script>
</head>
<body>
<div class="new3-layout">
	<h4>Consumer- Voice Traffic</h4>
	<div id="echart1" style="height:500px; "></div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/consumer/solution.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>