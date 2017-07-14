<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/ent.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/top.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
		var type = "${page}";
	</script>
</head>
<body>
<div class="ent-layout" style="padding-bottom:90px;">
	<div class="top2-layout-left">
		<div class="ent-header">
			<h4>JAK INTER TRADE</h4>
			<div class="span-layout">
				<span class="lable-span sla">SLA</span>
				<span class="lable-span red">105</span>
				<span class="lable-span yellow">5</span>
				<span class="lable-span green">31</span>
			</div>
		</div>
		<div>
			<div class="item1" id="echart11"></div>
			<div class="item2" id="echart12"></div>
			<div class="item2" id="echart13"></div>
			<div class="item1" id="echart14"></div>
			<div class="item2" id="echart15"></div>
			<div class="item2" id="echart16"></div>
			<div class="top1-log">
				<p>Subscribed Service</p>
				<img src="${ctx}/imgs/blue/ASTINET.png" alt="">
				<img src="${ctx}/imgs/blue/IPTRANSIT.png" alt="">
				<img src="${ctx}/imgs/blue/TRANSIT.png" alt="">
				<img src="${ctx}/imgs/blue/VPNIP.png" alt="">
			</div>
			<div class="top1-event">
				<table>
					<thead>
						<tr>
							<td>Event</td>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="top2-layout-right">
		<div class="ent-header">
			<h4>JAK INTER TRADE</h4>
			<div class="span-layout">
				<span class="lable-span sla">SLA</span>
				<span class="lable-span red">105</span>
				<span class="lable-span yellow">5</span>
				<span class="lable-span green">31</span>
			</div>
		</div>
		<div>
			<div class="item1" id="echart21"></div>
			<div class="item2" id="echart22"></div>
			<div class="item2" id="echart23"></div>
			<div class="item1" id="echart24"></div>
			<div class="item2" id="echart25"></div>
			<div class="item2" id="echart26"></div>
			<div class="top1-log">
				<p>Subscribed Service</p>
				<img src="${ctx}/imgs/blue/ASTINET.png" alt="">
				<img src="${ctx}/imgs/blue/IPTRANSIT.png" alt="">
				<img src="${ctx}/imgs/blue/TRANSIT.png" alt="">
				<img src="${ctx}/imgs/blue/VPNIP.png" alt="">
			</div>
			<div class="top1-event">
				<table>
					<thead>
						<tr>
							<td>Event</td>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/ent/top2.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>