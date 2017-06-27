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
</head>
<body>
<div class="ticket-layout">
	<h4>WIFI TICKET MONITORING</h4>
	<table>
		<thead>
		<tr style="height: 50px;">
			<td rowspan="3">TREG</td>
			<td colspan="10">STATUS UP</td>
		</tr>
		<tr style="height: 50px;">
			<td rowspan="2">UP</td>
			<td rowspan="2">AVAILABILITY</td>
			<td colspan="2">DOWN</td>
			<td rowspan="2">UV</td>
			<td rowspan="2">DISMANTLE</td>
			<td rowspan="2">RUSAK</td>
			<td rowspan="2">HILANG</td>
			<td rowspan="2">TEMPORER</td>
			<td rowspan="2" class="dis-td">DISPEND ORDER</td>
		</tr>
		<tr style="height: 50px;">
			<td class="dis-td">REAL DOWN</td>
			<td class="dis-td">DOWN SITE OWNER</td>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td>NAS</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
		</tr>
		<tr>
			<td>TREG-1</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
			<td>12</td>
		</tr>
		</tbody>
	</table>
</div>
</body>
</html>