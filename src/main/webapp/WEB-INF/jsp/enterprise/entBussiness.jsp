<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/ent.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ent-layout">
	<div class="ent-header">
		<h4>Business</h4>
		<div class="span-layout">
			<span class="lable-span sla">SLA</span>
			<span class="lable-span red">105</span>
			<span class="lable-span yellow">5</span>
			<span class="lable-span green">31</span>
		</div>
	</div>
	<div class="item">
		<div class="left" id="echart1"></div>
		<div class="right" id="echart2"></div>
	</div>
	<div class="item" style="padding-bottom:50px;">
		<div class="left" id="echart3"></div>
		<div class="right" id="echart4"></div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/ent/business.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
</html>