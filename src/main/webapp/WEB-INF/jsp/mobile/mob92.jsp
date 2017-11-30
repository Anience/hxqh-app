<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script>
		var _ctx = "${ctx}";
	</script>
	<style>
		body{
			padding-bottom:100px;
			background: #03071D;
		}
		#mob91{
			width: 100%;
			min-height: 100%;
			background: #03071D;
		}
		#mob91 h3{
			font-size: 26px;
			font-weight: bolder;
			color: #fff;
			margin: 0px;
			padding-top: 60px;
			padding-left: 30px;
			float: left;
			text-align: left;
		}
		#mob91 .ticket-time{
			color: #fff;
			font-size: 26px;
			height:46px;
			width: 40%;
			line-height:46px;
			display: block;
			float: right;
		}
		#mob91 p{
			color: #fff;
			font-size: 20px;
			text-align: right;
			padding-right: 30px;
		}
		.noData-content{
			width: 100%;
			height: 500px;
			overflow: auto;
			background: #03071D;
			margin-bottom: 20px;
		}
		::-webkit-scrollbar{
			width: 5px;
			background-color: #F5F5F5;
		}
		::-webkit-scrollbar-thumb{
			border-radius: 10px;
			background-image: -webkit-gradient(linear, left bottom, left top, color-stop(0.44, #327979), color-stop(0.72, #26c1c1), color-stop(0.86, #3b7373));
		}
		::-webkit-scrollbar-track {
			-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
			background-color: #F5F5F5;
			border-radius: 10px;
		}
		.noData-content table{
			width: 90%;
			margin: 0 auto;
			border: 1px solid #fff;
		}
		.noData-content table thead tr td{
			text-align: center;
		}
		.noData-content table tr td{
			height:35px;
			line-height:35px;
			width: 50%;
			color: #fff;
			border: 1px solid #fff;
			padding-left:5px;
			padding-right: 5px;
			text-align: center;
			font-size: 18px;
		}
		.noData-content table tbody tr td{
			border-left:none;
			border-bottom: none;
			border-top:none;
		}
	</style>
</head>
<body>
	<div id="mob91">
		<div style=" width: 100%; height: 50px;"><h3>Quality CNOP</h3><span class="ticket-time"></span></div>

		<div id="echart1" style="width: 100%;height: 80%;padding-top:80px;padding-left: 30px;padding-right: 30px;"></div>
		<p>BAD >= 5ms > GOOD</p>
	</div>
    <div class="noData-content" style="display: none;">
		<table>
			<thead>
				<tr>
					<td>No Data</td>
					<td>BAD</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</body>
<script src="${ctx}/script/echarts-all.js"></script>
<script type="text/javascript" src="${ctx}/js/mobile/mob92.js"></script>
</html>