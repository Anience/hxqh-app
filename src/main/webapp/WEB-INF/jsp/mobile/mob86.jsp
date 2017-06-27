<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/mob86.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="mob86">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<h3 style="color: #03091A;">KPI</h3>
			<div class="row">
				<div class="col-md-2">
					<h4>Packet</h4>
					<table class="table table-bordered">
						<thead>
						<tr><td style="font-size: 30px;color: #03091A;background: #03091A;">NAS</td></tr>
						</thead>
						<tbody>
						<tr><td>NAS</td></tr>
						<tr><td>TREG-1</td></tr>
						<tr><td>TREG-2</td></tr>
						<tr><td>TREG-3</td></tr>
						<tr><td>TREG-4</td></tr>
						<tr><td>TREG-5</td></tr>
						<tr><td>TREG-6</td></tr>
						<tr><td>TREG-7</td></tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-5">
					<h4>Packet Loss</h4>
					<table class="table table-bordered">
						<thead>
						<tr>
							<td width="40%">w-1</td>
							<td width="20%">W</td>
							<td width="40%">Gap</td>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td class="bg-red">94.77</td>
							<td class="bg-red">94.77</td>
							<td class="bg-blue">94.77</td>
						</tr>
						<tr>
							<td class="bg-red">94.77</td>
							<td class="bg-red">94.77</td>
							<td class="bg-blue">94.77</td>
						</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-5">
					<h4>Latency</h4>
					<table class="table table-bordered">
						<thead>
						<tr>
							<td width="40%">w-1</td>
							<td width="20%">W</td>
							<td width="40%">Gap</td>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td class="bg-red">94.77</td>
							<td class="bg-red">94.77</td>
							<td class="bg-blue">94.77</td>
						</tr>
						<tr>
							<td class="bg-red">94.77</td>
							<td class="bg-red">94.77</td>
							<td class="bg-blue">94.77</td>
						</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
</div>
</body>
</html>