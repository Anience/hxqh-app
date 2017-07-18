<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/ind.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ind-layout" id="ind-data">
	<div class="ind-header">
		<img src="${ctx}/imgs/logo_01.png">
		<span class="ind-time">16-Mar-2017 10:40:28</span>
	</div>
	<div class="table-layout">
		<!--左table-->
		<table class="new-table">
			<thead>
				<tr>
					<td></td>
					<td colspan="3" class="regular">Total Tiket</td>
				</tr>
				<tr>
					<td style="background: #03091B;"></td>
					<td><span>Saldo H</span></td>
					<td><span>Open H</span></td>
					<td><span>Dev</span></td>
				</tr>
				<tr>
					<td width="7%"></td>
					<td width="7%"><span>Saldo H-1</span></td>
					<td width="7%"><span>Close H</span></td>
					<td width="7%"><span>Status</span></td>
				</tr>
			</thead>
			//背景色zero-bg,first-bg,sec-bg,red-bg,green-bg
			<tbody>
				<template v-for="item in totalList">
					<tr>
						<td rowspan="2">{{item.regional}}</td>
						<td>{{item.toSh}}</td>
						<td>{{item.toOp}}</td>
						<td>{{item.toDev}}</td>
					</tr>
					<tr>
						<td>{{item.toSh1}}</td>
						<td>{{item.toCl}}</td>
						<td>kalah</td>
					</tr>
				</template>
			</tbody>
		</table>

		<!--中间table-->
		<table class="new-table" style="margin-right: 50px;margin-left: 50px;">
			<thead>
				<tr>
					<td></td>
					<td colspan="3" class="regular">Regular</td>
				</tr>
				<tr>
					<td style="background: #03091B;"></td>
					<td><span>Saldo H</span></td>
					<td><span>Open H</span></td>
					<td><span>Dev</span></td>
				</tr>
				<tr>
					<td width="7%"></td>
					<td width="7%"><span>Saldo H-1</span></td>
					<td width="7%"><span>Close H</span></td>
					<td width="7%"><span>Status</span></td>
				</tr>
			</thead>
			<tbody>
				<template v-for="item in regularList">
					<tr>
						<td rowspan="2">{{item.regional}}</td>
						<td>{{item.reSh}}</td>
						<td>{{item.reOp}}</td>
						<td>{{item.redev}}</td>
					</tr>
					<tr>
						<td>{{item.reSh1}}</td>
						<td>{{item.reCl}}</td>
						<td>kalah</td>
					</tr>
				</template>
			</tbody>
		</table>

		<!--右table-->
		<table class="new-table">
			<thead>
				<tr>
					<td></td>
					<td colspan="3" class="regular">Impact Gamas</td>
				</tr>
				<tr>
					<td style="background: #03091B;"></td>
					<td><span>Saldo H</span></td>
					<td><span>Open H</span></td>
					<td><span>Dev</span></td>
				</tr>
				<tr>
					<td width="7%"></td>
					<td width="7%"><span>Saldo H-1</span></td>
					<td width="7%"><span>Close H</span></td>
					<td width="7%"><span>Status</span></td>
				</tr>
			</thead>
			<tbody>
					<tr v-for="item in impactList">
						<td rowspan="2">{{item.regional}}</td>
						<td>{{item.imSh}}</td>
						<td>{{item.imOp}}</td>
						<td v-bind:class="{'txt-red':parseFloat(item.imdev<=0)">{{item.imdev}}</td>
					</tr>
					<tr>
						<td>{{item.imSh1}}</td>
						<td>{{item.imCl}}</td>
						<td v-if="parseInt(item.imdev)>0">kalah</td>
						<td v-if="parseInt(item.imdev)==0" style="color: #eb0300;">menany</td>
						<td v-if="parseInt(item.imdev)<0" style="color: #eb0300;">seri</td>
					</tr>
			</tbody>
		</table>
		<div class="clearfix"></div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/customer/ind.js"></script>
</html>