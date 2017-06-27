<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/mob88.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="mob88">
	<div class="mob-layout">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-3">
				<h4>Performance</h4>
				<table class="table table-bordered">
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
			<div class="col-sm-7">
				<div class="row echart1" style="background: red;"></div>
				<div class="row echart2" style="background: #000;"></div>
			</div>
		</div>
	</div>
</div>
</body>
</html>