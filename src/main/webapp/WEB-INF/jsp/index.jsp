<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<html>
<head>
	<title>TelKom Dashboard</title>
	<link rel="stylesheet" href="${ctx}/css/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/main.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${ctx}/css/index.css" type="text/css" media="screen" />
	<script type="text/javascript" src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${ctx}/script/tendina.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/AL-index.js"></script>
</head>
<body>
<!--顶部-->
<span id="small" style=""></span>
<div class="header">
	<div class="admin">
		<a href="#">
			<i class="icon-down"></i>
			<span>admin</span>
			<img src="${ctx}/imgs/none_user.gif" class="admin-img" />
		</a>
		<ul class="admin-down-ul" style="display: none;">
			<li>
				<a href="">
				    <i class="icon-set icon-user"></i>
					Settings
				</a>
			</li>
			<div class="line"></div>
			<li>
				<a href="${ctx}/system/logout">
					<i class="icon-logout icon-user"></i>
					LogOut
				</a>
			</li>
		</ul>
	</div>
</div>
<!--顶部结束-->
<!--菜单-->
<div class="left-menu">
	<ul id="menu">
		<li class="menu-list">
			<a style="border-top: none;" target="menuFrame" class="firsta" ><i  class="first-a-icon"></i>Network Surveillance<i class="first-a-down"></i></a>
			<ul>
				<li class="menu-list"> <a  href="${ctx}/ano/map" target="menuFrame" class="firsta"><i  class="glyph-icon icon-chevron-right3"></i>Center Map<span class="sz"></span></a></li>
				<li><a id="list81" href="${ctx}/ano/ano81" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. AWAS</a></li>
				<li><a id="list82" href="${ctx}/ano/ano82" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. Gamas</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC WIFI<i class="first-a-down"></i></a>
			<ul>
				<li><a id ="list103" href="${ctx}/wifi/ticket" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Wifi Ticket Monitoring</a></li>
				<li><a id ="list102" href="${ctx}/wifi/number" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. Number of Access Point</a></li>
				<li><a href="https://dashboard.telkom.co.id/idwifi/prabagen/index/page/390" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>3. Akses Point DES </a></li>
				<li><a id ="ioc95" href="${ctx}/wifi/wifi" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>4. Wifi Traffic</a></li>
				<li><a id="list96" href="${ctx}/wifi/mttr" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>5. MTTR Targets</a></li>
				<li><a id="list98" href="${ctx}/wifi/distribution" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>6. Distribution Status Report</a></li>
				<li><a id="list100" href="${ctx}/wifi/monitoring" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>8. Monitoring MTTR Proactive</a></li>
				<li><a id ="ioc104" href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>9. Daily Ticket Distribution</a></li>
				<li><a href="http://10.37.4.240/cacti" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>10. Cacti WAC/WAG</a></li>
				<li><a href="http://10.37.41.240/cacti/graph_view.php?action=tree&tree_id=2&leaf_id=8" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>11. Traffic WAG</a></li>
				<li><a href="http://10.37.41.240/cacti/graph_view.php?action=tree&tree_id=3&leaf_id=36" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>12. Traffic WAC</a></li>
				<li><a href="http://180.252.2.198/cacti/plugins/monitor/monitor.php?username=noc&password=moklet13254" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>13. AWG & Controller</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC DashBoard<i class="first-a-down"></i></a>
			<ul>
				<li><a id="list13" href="${ctx}/digital/13" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-13</a></li>
				<li><a id="list14" href="${ctx}/digital/14" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-14</a></li>
				<li><a href="https://rafi.upoint.co.id/login" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>testurl</a></li>
				<li><a id="list17" href="${ctx}/digital/17" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-17</a></li>
				<li><a id="lsit18" href="${ctx}/digital/18" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>DIG-18</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>shangchuan</a></li>
				<li><a href="https://dashboard.telkom.co.id/idwifi" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Wifi Map</a></li>
				<li><a href="http://180.252.2.198/cacti/plugins/monitor/monitor.php?username=noc&password=moklet13254" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>WAG & Controller</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>EVENT BUMN LABUHAN BAJO</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC ENTERPRISE<i class="first-a-down"></i></a>
			<ul>
				<li><a href="${ctx}/enterprise/ebg?type=DBS" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Business</a></li>
				<li><a href="${ctx}/enterprise/top?type=DBS&show=1" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. DBS TOP1</a></li>
				<li><a href="${ctx}/enterprise/top?type=DBS&show=2" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>3. DBS_TOP2&TOP3</a></li>
				<li><a href="${ctx}/enterprise/top?type=DBS&show=4" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>4. DBS TOP4-7</a></li>
				<li><a href="${ctx}/enterprise/ebg?type=DGS" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>5. Government</a></li>
				<li><a href="${ctx}/enterprise/top?type=DGS&show=1" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>6. DGS TOP1</a></li>
				<li><a href="${ctx}/enterprise/top?type=DGS&show=2" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>7. DGS TOP2&TOP3</a></li>
				<li><a href="${ctx}/enterprise/top?type=DGS&show=4" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>8. DGS TOP4-7</a></li>
				<li><a href="${ctx}/enterprise/ebg?type=DES" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>9. Enterprise</a></li>
				<li><a href="${ctx}/enterprise/top?type=DES&show=1" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>10. DES TOP1</a></li>
				<li><a href="${ctx}/enterprise/top?type=DES&show=2" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>11. DES TOP2&TOP3</a></li>
				<li><a href="${ctx}/enterprise/top?type=DES&show=4" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>12. DES TOP4-7</a></li>
				<li><a href="http://10.40.9.78/noc/dash_bges.php" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>ENTERPRISE-business</a></li>
				<li><a href="http://10.40.9.78/noc/monita/view/dashboard/dashboard.php" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Enterprise-government</a></li>
				<li><a href="${ctx}/enterprise/url.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Enterprise-enterprise</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC CUSTOMER FB<i class="first-a-down"></i></a>
			<ul>
				<li><a href="https://app.brandfibres.com/dashboards/59192e5fd3b0408e1a5a6f55" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Summary</a></li>
				<li><a href="https://app.brandfibres.com/dashboards/59192ea188c9ffdd1fd3a676" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. Indihome</a></li>
				<li><a href="https://app.brandfibres.com/dashboards/591965d788c9ffdd1fd3a6a3" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>3. Wifi ID</a></li>
				<li><a href="https://app.brandfibres.com/dashboards/591a6e383dde83723869e4cf" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>4. Telkom Solution</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC MOBILE<i class="first-a-down"></i></a>
			<ul>
				<li><a id="85" href="${ctx}/mobile/topological" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Backhaul TTC Tsel National</a></li>
				<li><a id="list86" href="${ctx}/mobile/mobile86" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. IPPM KPI</a></li>
				<li><a id="list87" href="${ctx}/mobile/mobile87" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>3. Ticket</a></li>
				<li><a id="list88" href="${ctx}/mobile/mobile88" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>4. MTTR & MTTI</a></li>
				<li><a id="list" href="http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=55a496385e87d5ad301e" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>5. Backbone Tsel</a></li>
				<li><a id="list90" href="${ctx}/mobile/throughtput" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>6. Throughtput IP Transit</a></li>
				<li><a id="list91" href="${ctx}/mobile/mobile91" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>7. SQUAT</a></li>
				<li><a id="list92" href="${ctx}/mobile/mobile92" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>8. Quality CNOP</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC DIGITAL<i class="first-a-down"></i></a>
			<ul>
				<li><a  href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>0. ImageUpload</a></li>
				<li><a id="list13,14,17,18" href="${ctx}/digital/13141718" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>1. Digital Operational</a></li>
				<li><a id="DIG-15" href="https://rafi.upoint.co.id/overview" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>2. Upoint Rafi</a></li>
				<li><a id="DIG-19" href="https://rafi.upoint.co.id/?username=cfuds&password=cfuds" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>3.Upoint Rafi User</a></li>
				<li><a id="DIG-16,20" href="http://dashboard.melon.co.id/home" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>4. Melon</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC WHOLESALE<i class="first-a-down"></i></a>
			<ul>
				<li><a href="${ctx}/enterprise/ebg?type=DWS" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>wholesale</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=2" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_1</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=4" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_2</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=6" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_3</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=8" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_4</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=10" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_5</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=12" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_6</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=14" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_7</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=18" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_8-4</a></li>
				<li><a href="${ctx}/enterprise/top?type=DWS&show=20" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>top20_9</a></li>
				<li><a href="https://wholesale.telkom.co.id/" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>wholesale.telkom</a></li>
				<li><a href="http://10.60.175.91:5056/auth/login" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Topology</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>Customer<i class="first-a-down"></i></a>
			<ul>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Telkom Summary</a></li>
				<li><a href="${ctx}/ano/indiHome" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Indihome</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>WIFIID</a></li>
				<li><a href="${ctx}/wifi/daily" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Telkom Solution</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>IOC CRA<i class="first-a-down"></i></a>
			<ul>
				<li><a href="https://cra.telkom.co.id/tioc" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>CRA event</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>Consumer<i class="first-a-down"></i></a>
			<ul>

				<li><a href="${ctx}/ano/indiHome" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>indHome</a></li>
				<li><a href="${ctx}/ano/voice" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>summary</a></li>
				<li><a href="${ctx}/ano/solution?type=4" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Voice(1-4)</a></li>
				<li><a href="${ctx}/ano/solution?type=8" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Voice(5-8)</a></li>
				<li><a href="${ctx}/ano/wifiInd" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>wifiInd</a></li>
				<li><a href="http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=8c6693afbca73e29a252" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Internet Traffic - 107</a></li>
				<li><a href="http://backbone.telkom.co.id/plugins/weathermap/weathermap-cacti-plugin.php?action=viewmap&id=75853fd93fd314f0043c" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Internet Traffic - 111</a></li>
				<li><a href="http://118.97.167.60:21180/aos-web/res/aos-common/login.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Iqas - 116</a></li>
				<li><a href="http://10.194.194.119/wallboard_dc/app/wallboard.php?lay=147&slide=2" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Reserved for Huawei</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>Prevision<i class="first-a-down"></i></a>
			<ul>
				<li><a href="${ctx}/ano/realtime" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>realtime</a></li>
				<li><a href="${ctx}/ano/per7x" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>per7x</a></li>
				<li><a href="${ctx}/ano/monthly" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>monthly</a></li>
				<li><a href="${ctx}/ano/complaint" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>complaint</a></li>
			</ul>
		</li>
		<li class="menu-list">
			<a  target="menuFrame" class="firsta"><i  class="first-a-icon"></i>ITOC<i class="first-a-down"></i></a>
			<ul>
				<li><a href="http://10.62.13.18:9090" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Manage Engine</a></li>
				<li><a href="http://me-admin.telkom.co.id:9090/MyPage.do?method=viewDashBoard" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Application Manager</a></li>
				<li><a href="http://10.64.1.196/Orion/SummaryView.aspx?viewid=34" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>Solarwinds</a></li>
			</ul>
		</li>
	</ul>
</div>
<!--菜单右边的iframe页面-->
<div id="right-content" class="right-content">
	<div class="content">
		<div class="right-header">
			<a href="#"><i class="home-icon"></i>My portal</a>
			<span class="header-router"></span>
			<span id="all" style=""></span>
		</div>
		<div class="router">
			<span class="router-txt">My portal</span>
		</div>
		<div id="page_content">
			<iframe id="menuFrame" name="menuFrame" style="overflow:visible;"
					width="100%" height="100%"  src="${ctx}/ano/map" onresize="alert('You have changed the size of the window')"></iframe>
		</div>
	</div>
</div>
</body>
<script>
	$(function(){
		var contentH = document.body.clientHeight-$(".header").height();
		var iframeH = document.body.clientHeight-$(".header").height()-$(".right-header").height()-$(".router").height();
		$(".right-content").height(contentH);
		$(".content").height(contentH);
        $("#page_content").height(iframeH);
        $(".left-menu").height(contentH);
	});
</script>
</html>