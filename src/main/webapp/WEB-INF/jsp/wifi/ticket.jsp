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
	<script src="${ctx}/script/vue.js"></script>
	<script src="${ctx}/js/wifi/ticket.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ticket-layout" style="padding-bottom: 120px;">
	<h4>WIFI TICKET MONITORING</h4>
	<table class="ticket">
		<thead>
		<tr>
			<td rowspan="3">TREG</td>
			<td colspan="6">Gangguan H-1</td>
			<td colspan="7">Gangguan HI</td>
		</tr>
		<tr>
			<td colspan="2">OPEN</td>
			<td colspan="2">CLOSE</td>
			<td colspan="2">OPEN H-1</td>
			<td colspan="2">CREATED</td>
			<td colspan="2">CLOSE</td>
			<td colspan="2">OPEN</td>
			<td rowspan="2">STATUS</td>
		</tr>
		<tr>
			<td>Tiket</td>
			<td>AP</td>
			<td>Tiket</td>
			<td>AP</td>
			<td>Tiket</td>
			<td>AP</td>
			<td>Tiket</td>
			<td>AP</td>
			<td>Tiket</td>
			<td>AP</td>
			<td>Tiket</td>
			<td>AP</td>
		</tr>
		</thead>
		<tbody id="ticket-data">
			<tr v-for="item of ticketList">
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
				<td v-if="item.ioc12" style="color: #eb0300;">kalah</td>
				<td v-if="!item.ioc12"><span class="bule-star"></span></td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>