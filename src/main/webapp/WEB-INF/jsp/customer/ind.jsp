<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="ind-layout">
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
			<tr class="zero-bg">
				<td rowspan="2"></td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="zero-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R6</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td rowspan="2">R7</td>
				<td>123</td>
				<td>123</td>
				<td class="red-bg">123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td class="green-bg">123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R3</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="sec-bg">
				<td rowspan="2">R1</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R4</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="sec-bg">
				<td rowspan="2">R5</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R2</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
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
			<tr class="zero-bg">
				<td rowspan="2"></td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="zero-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R6</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td rowspan="2">R7</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R3</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="sec-bg">
				<td rowspan="2">R1</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R4</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="sec-bg">
				<td rowspan="2">R5</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R2</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			</tbody>
		</table>

		<!--右table-->
		<table class="new-table">
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
			<tr class="zero-bg">
				<td rowspan="2"></td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="zero-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R6</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td rowspan="2">R7</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R3</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="sec-bg">
				<td rowspan="2">R1</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R4</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="sec-bg">
				<td rowspan="2">R5</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="sec-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>

			<tr class="first-bg">
				<td rowspan="2">R2</td>
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			<tr class="first-bg">
				<td>123</td>
				<td>123</td>
				<td>123</td>
			</tr>
			</tbody>
		</table>
		<div class="clearfix"></div>
	</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/wifi/daily.js"></script>
<script src="${ctx}/script/echarts-all.js"></script>
</html>