<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/ticket.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ticket-layout">
	<h4>Monitoring MTTR Proactive 2017-06-27</h4>
	<table class="monitoring-table" cellpadding="2">
		<thead>
		<tr>
			<td rowspan="3">TREG</td>
			<td rowspan="2" colspan="4">Bulan lalu Realisasi(Jam)</td>
			<td colspan="12">Bulan Ini</td>
			<td colspan="8">TREG</td>
		</tr>
		<tr>
			<td colspan="4">H-2 Realisasi(Jam)</td>
			<td colspan="4">H-1 Realisasi(Jam)</td>
			<td colspan="4">1 S/d H-1 Realisasi(Jam)</td>
			<td colspan="4">Bulan lalu vs 1 s/d H-1</td>
			<td colspan="4">H-2 vs H-1</td>
		</tr>
		<tr>
			<td>P=12</td>
			<td>G=48</td>
			<td>R=48</td>
			<td>T=48</td>

			<td>P=12</td>
			<td>G=48</td>
			<td>R=48</td>
			<td>T=48</td>

			<td>P=12</td>
			<td>G=48</td>
			<td>R=48</td>
			<td>T=48</td>

			<td>P=12</td>
			<td>G=48</td>
			<td>R=48</td>
			<td>T=48</td>

			<td>P</td>
			<td>G</td>
			<td>R</td>
			<td>T</td>

			<td>P</td>
			<td>G</td>
			<td>R</td>
			<td>T</td>
		</tr>
		</thead>
		<tbody id="moni-data">
			<tr v-for="item of moniList">
				<td>{{item.ioc1}}</td>
				<td>{{item.ioc2}}</td>
				<td>{{item.ioc3}}</td>
				<td>{{item.ioc4}}</td>
				<td>{{item.ioc5}}</td>
				<td>{{item.ioc6}}</td>
				<td>{{item.ioc7}}</td>
				<td>{{item.ioc8}}</td>
				<td>{{item.ioc9}}</td>
				<td>{{item.ioc10}}</td>
				<td>{{item.ioc11}}</td>
				<td>{{item.ioc12}}</td>
				<td>{{item.ioc13}}</td>
				<td>{{item.ioc14}}</td>
				<td>{{item.ioc15}}</td>
				<td>{{item.ioc16}}</td>
				<td>{{item.ioc17}}</td>
				<td>{{item.ioc18}}</td>
				<td>{{item.ioc19}}</td>
				<td>{{item.ioc20}}</td>
				<td>{{item.ioc21}}</td>
				<td>{{item.ioc22}}</td>
				<td>{{item.ioc23}}</td>
				<td>{{item.ioc24}}</td>
				<td>{{item.ioc25}}</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/wifi/monitoring.js"></script>
</html>