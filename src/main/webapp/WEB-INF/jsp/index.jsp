<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title></title>
	<link rel="stylesheet" href="${ctx}/css/main.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/tendina.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/AL-index.js"></script>
</head>
<body>
<!--顶部-->
<div class="header">
	<div class="admin">
		<a href="#">
			<i class="icon-down"></i>
			<span>admin</span>
			<img src="" class="admin-img" />
		</a>
		<ul class="admin-down-ul">
			<li><a href="">Settings</a></li>
			<li><a href="">LogOut</a></li>
		</ul>
	</div>
</div>
<!--顶部结束-->
<!--菜单-->
<div class="left-menu">
	<ul id="menu">
		<li class="menu-list">
			<a target="menuFrame" class="firsta" ><i  class="glyph-icon jggl"></i>CENTER MAP<span class="sz"></span></a>
			<ul>
				<li class="menu-list"> <a  href="${ctx}/query/showRegionMap" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>OpenStreetMap<span class="sz"></span></a></li>
			</ul>
		</li>

		<%--<li class="menu-list">--%>
			<%--<a target="menuFrame" class="firsta" ><i  class="glyph-icon jggl"></i>Security<span class="sz"></span></a>--%>
			<%--<ul>--%>
				<%--<li><a href="${ctx}/author/list" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right2"></i>Regular Tasks<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>User Role<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Athorization Mgt<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Menu Configure<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Customer ranking<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Function Button<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Appllication Designer<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Cron Task<span class="sz"></span></a></li>--%>
				<%--<li><a href="${ctx}/organization/list" target="menuFrame" class="firsta" ><i  class="glyph-icon icon-chevron-right2"></i>Sqlmary<span class="sz"></span></a></li>s--%>
			<%--</ul>--%>
		<%--</li>--%>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>IOC WIFI<span class="sz"></span></a>
			<ul>
				<li><a href="${ctx}/wifi/wifi" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Wifi Traffic</a></li>
				<li><a href="${ctx}/wifi/number" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Number of Access Point</a></li>
				<li><a href="${ctx}/wifi/ticket" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Ticket Monitoring</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Daily Ticket Distribution</a></li>
				<li><a href="${ctx}/wifi/distribution" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Distribution Status Report</a></li>
				<li><a href="${ctx}/wifi/mttr" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MTTR Targets<li>
                <li><a href="${ctx}/wifi/monitoring" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Monitoring MTTR Proactive<li>


                <li><a href="" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Wifi Map</a></li>
				<li><a href="" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>WAG & Controller</a></li>
				<li><a href="${ctx}/wifi/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>EVENT BUMN LABUHAN BAJO</a></li>
				<li><a href="${ctx}/wifi/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>WIFI_99</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>IOC DashBoard<span class="sz"></span></a>
			<ul>
				<li><a href="${ctx}/query/list" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>testurl</a></li>
				<li><a href="${ctx}/query/authorStatistic" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>shangchuan</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>IOC ENTERPRISE<span class="sz"></span></a>
			<ul>
				<li><a href="${ctx}/query/list" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-22,23,24-B-1</a></li>
				<li><a href="${ctx}/query/authorStatistic" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-Bussiness</a></li>
				<li><a href="${ctx}/query/webProductStatistic" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-Government</a></li>
				<li><a href="${ctx}/query/showWebAuthorStatistic" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-22,23,24-B-2</a></li>
				<li><a href="${ctx}/query/showAuthorWebStatistic" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-22,23,24-B-4</a></li>
				<li><a href="${ctx}/query/showWebsiteList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-Enterprise</a></li>
				<li><a href="${ctx}/query/surveyList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-26,27,28-G-1</a></li>
				<li><a href="${ctx}/query/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-26,27,28-G-2</a></li>
				<li><a href="${ctx}/query/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-26,27,28-G-4</a></li>
				<li><a href="${ctx}/query/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-30,31,32-E-1</a></li>
				<li><a href="${ctx}/query/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-30,31,32-E-2</a></li>
				<li><a href="${ctx}/query/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENT-30,31,32-E-4</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>IOC CUSTOMER FB<span class="sz"></span></a>
			<ul>
				<li><a href="${ctx}/query/list" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Summary</a></li>
				<li><a href="${ctx}/query/authorStatistic" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Indihome</a></li>
				<li><a href="${ctx}/query/webProductStatistic" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Wifi ID</a></li>
				<li><a href="${ctx}/query/showWebAuthorStatistic" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Telkom Solution</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>IOC MOBILE<span class="sz"></span></a>
			<ul>
				<li><a href="${ctx}/mobile/list" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-85</a></li>
				<li><a href="${ctx}/mobile/mobile87" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-87</a></li>
				<li><a href="${ctx}/mobile/mobile86" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-86</a></li>

				<li><a href="${ctx}/mobile/mobile88" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-88</a></li>
				<li><a href="${ctx}/mobile/mobile91" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-91</a></li>
				<li><a href="${ctx}/mobile/surveyList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-90</a></li>
				<li><a href="${ctx}/mobile/mobile92" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-92</a></li>
				<li><a href="${ctx}/mobile/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>MOB-89</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>IOC DIGITAL<span class="sz"></span></a>
			<ul>
				<li><a href="${ctx}/digital/digital13" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-13</a></li>
				<li><a href="${ctx}/digital/digital14" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-14</a></li>
				<li><a href="" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-15</a></li>

				<li><a href="${ctx}/digital/digital17" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-17</a></li>
				<li><a href="${ctx}/digital/digital18" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-18</a></li>
				<li><a href="${ctx}/digital/showWebsiteList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-19</a></li>
				<li><a href="${ctx}/digital/digital13141718" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-13,14,17,18</a></li>
				<li><a href="${ctx}/digital/getWebsitestatisticList" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-16,20</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>IOC ANO<span class="sz"></span></a>
			<ul>
				<li><a href="${ctx}/ano/ano81" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ANO-81</a></li>
				<li><a href="${ctx}/ano/ano82" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ANO-82</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="glyph-icon zzgl"></i>IOC WHOLESALE INT'L<span class="sz"></span></a>
			<ul>
				<li><a href="${ctx}/query/list" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>WHO-34,35,36-OLO-1</a></li>
			</ul>
		</li>
	</ul>
</div>
<!--菜单右边的iframe页面-->
<div id="right-content" class="right-content">
	<div class="content">
		<div id="page_content">
			<iframe id="menuFrame" name="menuFrame" style="overflow:visible;"
					width="100%" height="100%" src="logins.html"></iframe>
		</div>
	</div>
</div>
</body>
</html>