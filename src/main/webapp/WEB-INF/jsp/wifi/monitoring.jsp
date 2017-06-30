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
			<td colspan="4" width="7%">Bulan lalu vs 1 s/d H-1</td>
			<td colspan="4" width="7%">H-2 vs H-1</td>
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
				<td v-bind:class="{'text-red':parseInt(item.ioc2)>12,'text-blue':parseInt(item.ioc2)>0&&parseInt(item.ioc2)<12}">{{item.ioc2}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc3)>48,'text-blue':parseInt(item.ioc3)>0&&parseInt(item.ioc3)<48}">{{item.ioc3}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc4)>48,'text-blue':parseInt(item.ioc4)>0&&parseInt(item.ioc4)<48}">{{item.ioc4}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc5)>48,'text-blue':parseInt(item.ioc5)>0&&parseInt(item.ioc5)<48}">{{item.ioc5}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc6)>12,'text-blue':parseInt(item.ioc6)>0&&parseInt(item.ioc6)<12}">{{item.ioc6}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc7)>48,'text-blue':parseInt(item.ioc7)>0&&parseInt(item.ioc7)<48}">{{item.ioc7}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc8)>48,'text-blue':parseInt(item.ioc8)>0&&parseInt(item.ioc8)<48}">{{item.ioc8}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc9)>48,'text-blue':parseInt(item.ioc9)>0&&parseInt(item.ioc9)<48}">{{item.ioc9}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc10)>12,'text-blue':parseInt(item.ioc10)>0&&parseInt(item.ioc10)<12}">{{item.ioc10}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc11)>48,'text-blue':parseInt(item.ioc11)>0&&parseInt(item.ioc11)<48}">{{item.ioc11}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc12)>48,'text-blue':parseInt(item.ioc12)>0&&parseInt(item.ioc12)<48}">{{item.ioc12}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc13)>48,'text-blue':parseInt(item.ioc13)>0&&parseInt(item.ioc13)<48}">{{item.ioc13}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc14)>12,'text-blue':parseInt(item.ioc14)>0&&parseInt(item.ioc14)<12}">{{item.ioc14}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc15)>48,'text-blue':parseInt(item.ioc15)>0&&parseInt(item.ioc15)<48}">{{item.ioc15}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc16)>48,'text-blue':parseInt(item.ioc16)>0&&parseInt(item.ioc16)<48}">{{item.ioc16}}</td>
				<td v-bind:class="{'text-red':parseInt(item.ioc17)>48,'text-blue':parseInt(item.ioc17)>0&&parseInt(item.ioc17)<48}">{{item.ioc17}}</td>
				<td v-bind:class="{'red-radius' : parseFloat(item.ioc18)<0.75,'yellow-radius' : parseFloat(item.ioc18)>=0.75&&parseFloat(item.ioc18)<0.9,'green-radius' : parseFloat(item.ioc18)>=0.9}"></td>
				<td v-bind:class="{'red-radius' : parseFloat(item.ioc19)<0.75,'yellow-radius' : parseFloat(item.ioc19)>=0.75&&parseFloat(item.ioc19)<0.9,'green-radius' : parseFloat(item.ioc19)>=0.9}"></td>
				<td v-bind:class="{'red-radius' : parseFloat(item.ioc20)<0.75,'yellow-radius' : parseFloat(item.ioc20)>=0.75&&parseFloat(item.ioc20)<0.9,'green-radius' : parseFloat(item.ioc20)>=0.9}"></td>
				<td v-bind:class="{'red-radius' : parseFloat(item.ioc21)<0.75,'yellow-radius' : parseFloat(item.ioc21)>=0.75&&parseFloat(item.ioc21)<0.9,'green-radius' : parseFloat(item.ioc21)>=0.9}"></td>
				<td v-bind:class="{'red-radius' : parseFloat(item.ioc22)<0.75,'yellow-radius' : parseFloat(item.ioc22)>=0.75&&parseFloat(item.ioc22)<0.9,'green-radius' : parseFloat(item.ioc22)>=0.9}"></td>
				<td v-bind:class="{'red-radius' : parseFloat(item.ioc23)<0.75,'yellow-radius' : parseFloat(item.ioc23)>=0.75&&parseFloat(item.ioc23)<0.9,'green-radius' : parseFloat(item.ioc23)>=0.9}"></td>
				<td v-bind:class="{'red-radius' : parseFloat(item.ioc24)<0.75,'yellow-radius' : parseFloat(item.ioc24)>=0.75&&parseFloat(item.ioc24)<0.9,'green-radius' : parseFloat(item.ioc24)>=0.9}"></td>
				<td v-bind:class="{'red-radius' : parseFloat(item.ioc25)<0.75,'yellow-radius' : parseFloat(item.ioc25)>=0.75&&parseFloat(item.ioc25)<0.9,'green-radius' : parseFloat(item.ioc25)>=0.9}"></td>

			</tr>
		</tbody>
	</table>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/wifi/monitoring.js"></script>
</html>