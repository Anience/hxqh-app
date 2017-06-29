<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<meta charset='utf-8'>
	<title>登录页面</title>
	<meta name="keywords" content="">
	<link rel="stylesheet" href="${ctx}/css/reset.css">
	<link rel="stylesheet" href="${ctx}/css/digital.css">
	<script src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script src="${ctx}/script/vue.js"></script>
	<script src="${ctx}/js/digital/digital.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
</head>
<body>
<div class="digital">
	<div class="dig-layout">
		<table class="dig-13" id="digital-data">
			<thead>
				<tr>
					<td rowspan="3">OPERATIONAL</td>
					<td rowspan="3">UNIT</td>
					<td colspan="5">MAR-17</td>
					<td rowspan="3">MOM</td>
					<td colspan="5">YtD MAR-17</td>
					<td rowspan="3">YOY</td>
				</tr>
				<tr>
					<td rowspan="2">TARGET</td>
					<td colspan="2">MtD</td>
					<td colspan="2">OUTLOOK</td>
					<td rowspan="2">TARGET</td>
					<td rowspan="2">REAL</td>
					<td rowspan="2">ACH</td>
					<td colspan="2">OUTLOOK</td>
				</tr>
				<tr>
					<td>REAL</td>
					<td>ACH</td>
					<td>AMOUNT</td>
					<td>ACH</td>
					<td>REAL</td>
					<td>ACH</td>
				</tr>
				<tr>
					<td colspan="14">{{tit}}</td>
				</tr>
			</thead>
			<tbody>
				<tr v-for="item of digList">
					<td>{{item.ioc1}}</td>
					<td style="font-family: Brush Script MT;">{{item.ioc2}}</td>
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
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>
