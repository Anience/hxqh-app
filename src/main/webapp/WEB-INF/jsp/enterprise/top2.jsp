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
			<div class="item1" id="echart1-1"></div>
			<div class="item2" id="echart1-2"></div>
			<div class="item2" id="echart1-3"></div>
			<div class="item1" id="echart1-4"></div>
			<div class="item2" id="echart1-5"></div>
			<div class="item2" id="echart1-6"></div>
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
						<td width="30%"></td>
						<td width="70%">Event</td>
					</tr>
					<tbody>
					<tr>
						<td class="bg-red"></td>
						<td>Event</td>
					</tr>
					<tr>
						<td class="bg-yellow"></td>
						<td>Event</td>
					</tr>
					<tr>
						<td class="bg-green"></td>
						<td>Event</td>
					</tr>
					</tbody>
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
			<div class="item1" id="echart2-1"></div>
			<div class="item2" id="echart2-2"></div>
			<div class="item2" id="echart2-3"></div>
			<div class="item1" id="echart2-4"></div>
			<div class="item2" id="echart2-5"></div>
			<div class="item2" id="echart2-6"></div>
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
						<td width="30%"></td>
						<td width="70%">Event</td>
					</tr>
					<tbody>
					<tr>
						<td class="bg-red"></td>
						<td>Event</td>
					</tr>
					<tr>
						<td class="bg-yellow"></td>
						<td>Event</td>
					</tr>
					<tr>
						<td class="bg-green"></td>
						<td>Event</td>
					</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/ent/top2.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>