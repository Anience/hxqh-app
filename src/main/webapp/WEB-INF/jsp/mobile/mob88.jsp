<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/mob88.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/vue.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div id="mob88">
	<div class="mob-layout" style="padding-bottom: 120px;">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<h4>Performance</h4>
				<table class="table table-bordered" id="mob88-data">
					<thead>
						<tr>
							<td></td>
							<td>SCR:</td>
							<td>PDP-SR:</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>NAS</td>
							<td>1/18</td>
							<td>1/20</td>
						</tr>
						<tr>
							<td>TREG-1</td>
							<td>1/18</td>
							<td>1/20</td>
						</tr>
						<tr>
							<td>TREG-2</td>
							<td>1/18</td>
							<td>1/20</td>
						</tr>
						<tr>
							<td>TREG-3</td>
							<td>1/18</td>
							<td>1/20</td>
						</tr>
						<tr>
							<td>TREG-4</td>
							<td>1/18</td>
							<td>1/20</td>
						</tr>
						<tr>
							<td>TREG-5</td>
							<td>1/18</td>
							<td>1/20</td>
						</tr>
						<tr>
							<td>TREG-6</td>
							<td>1/18</td>
							<td>1/20</td>
						</tr>
						<tr>
							<td>TREG-7</td>
							<td>1/18</td>
							<td>1/20</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-sm-1"></div>
			<div class="col-sm-7" style="padding-top: 80px;">
				<div id="echart1" class="row" style="height:300px;"></div>
				<div id="echart2" class="row" style="height:300px;"></div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/mobile/mob88.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>