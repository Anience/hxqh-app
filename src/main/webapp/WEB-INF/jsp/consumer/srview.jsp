<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/consumer/wifiId.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="wifiId-layout">
	<div class="mytitle" >
		<h3>SR View</h3>
		<span class="ticket-time"></span>
	</div>
	<div class="left" id="echart1"></div>
	<div class="right">
		<div class="scoll-nav">
			<ul class="first-nav">
				<li>NAS</li>
				<li>TREG1</li>
				<li>TREG2</li>
				<li>TREG3</li>
				<li>TREG4</li>
				<li>TREG5</li>
				<li>TREG6</li>
				<li>TREG7</li>
			</ul>
			<ul class="sec-nav">
				<li><span class="radius"></span></li>
				<li><span class="radius"></span></li>
				<li><span class="radius"></span></li>
				<li><span class="radius"></span></li>
				<li><span class="radius"></span></li>
				<li><span class="radius"></span></li>
				<li><span class="radius"></span></li>
				<li><span class="radius"></span></li>
			</ul>
		</div>
		<div class="item" id="echart2"></div>
		<div class="item" id="echart3"></div>
		<div class="item" id="echart4"></div>
		<span class="ket">Ket:</br>A<=24jam， B=24-48jam， C=48-72jam， D=72jam-7hari， E=7hari-30hari，  F＞30hari</span>
	</div>
	<div class="clearfix"></div>
</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/consumer/wifiId.js"></script>
</html>