<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<meta http-equiv="refresh" content="300">
	<link rel="stylesheet" href="${ctx}/css/mob87.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="mob" style="padding-top:60px;">
	<div class="mob-layout">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-2">
				<h3>Nasional</h3>
			</div>
		</div>
		<div class="row" id="mob87">
			<div class="col-sm-1"></div>
			<div class="col-sm-2">
				<ul>
					<li><a href="javascript:void(0);"  style="background: #005E8A;">View:</a></li>
					<li  style="background: #8D93A8;"><a href="javascript:void(0);" v-on:click="navClick('0')">NAS:</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('1')">TREG-1</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('2')">TREG-2</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('3')">TREG-3</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('4')">TREG-4</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('5')">TREG-5</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('6')">TREG-6</a></li>
					<li><a href="javascript:void(0);" v-on:click="navClick('7')">TREG-7</a></li>
				</ul>
			</div>
			<div class="col-sm-6">
				<div id="echart1" style="height: 300px;width: 100%;"></div>
			</div>
			<div class="col-sm-3">
				<table>
					<tr>
						<td>FO Access</td>
						<td class="FOAccess"></td>
					</tr>
					<tr>
						<td>RADIO Access</td>
						<td class="RadioAccess"></td>
					</tr>
					<tr>
						<td>SL_D</td>
						<td class="SL_D"></td>
					</tr>
					<tr>
						<td>OTHERS</td>
						<td class="OTHERS"></td>
					</tr>
				</table>
				<p>*Jumlah Active with Severity(<span class="txt-first">Critical,</span><span class="txt-sec">Major,</span><span class="txt-third">Minor</span>)</p>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/mobile/mob87.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>