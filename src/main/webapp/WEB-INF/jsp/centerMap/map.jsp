<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsp/commons/meta.jsp" %>
<!Doctype html>
<html xmlns=http://www.w3.org/1999/xhtml>
<head>
	<meta http-equiv=Content-Type content="text/html;charset=utf-8">
	<meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
	<meta content=always name=referrer>
	<title>OpenLayers 3地图示例</title>
	<script src="${ctx}/script/jquery-3.2.1.min.js"></script>
	<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
</head>
<body>
<div id="Map" style="height: 3200px;"></div>
<div id="toolbar"></div>
<script>
	$(function(){
		var zoom = 9;
		var fromProjection = new OpenLayers.Projection("EPSG:4326");
		var toProjection = new OpenLayers.Projection("EPSG:900913");
		map = new OpenLayers.Map("Map");
		var mapnik = new OpenLayers.Layer.OSM();
		map.addLayer(mapnik);
		map.setCenter(new OpenLayers.LonLat(106.827183, -6.1753942)
				.transform(fromProjection, toProjection), 8);
		initPoints(map, fromProjection, toProjection);

		window.setInterval(function() {
			initPoints(map, fromProjection, toProjection);
		}, 604800000);
		function initPoints(map, fromProjection, toProjection) {
			var size = new OpenLayers.Size(21, 25);
			var offset = new OpenLayers.Pixel(-(size.w / 2), -size.h);
			var lineLayers = map.getLayersByName(new RegExp("Markers", ""));
			for ( var t = 0; t < lineLayers.length; t++) {
				map.removeLayer(lineLayers[t]);
			}
			var markers = new OpenLayers.Layer.Markers("Markers");
			$.ajax({
				url: ${ctx}+"/ano/openMapPoints",
				method: "get",
				dataType: "json",
				success: function(data){
					alert(data);
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
				}
			})
			/*$.ajax({
				        url : ${ctx} + "http://localhost:8080/ano/openMapPoints",
				        method : "get",
						dataType : "json",
						success : function(data) {
							var points = data["data"];
							for ( var i = 0; i < points.length; i++) {
								var point = points[i];
								var type = point["type"];
								var name = point["name"];
								var x = point["x"];
								var y = point["y"];
								var icon = new OpenLayers.Icon(${ctx}+'/imgs/WIFIAP.png', size, offset);
								if(type==="1"){
									icon = new OpenLayers.Icon(${ctx}+'/imgs/Metro-E.png', size, offset);
								}else if(type==="2"){
									icon = new OpenLayers.Icon(${ctx}+'/imgs/PE.png', size, offset);
								}else if(type==="3"){
									icon = new OpenLayers.Icon(${ctx}+'/imgs/Tera.png', size, offset);
								}
								//console.log(name);
								eval("var position"
										+ i
										+ " = new OpenLayers.LonLat("
										+ x
										+ ", "
										+ y
										+ ").transform(fromProjection, toProjection);");
								eval("var marker = new OpenLayers.Marker(position"
										+ i + ",icon);");
								eval("marker.events.register('mouseover', marker, function (evt) {popup"
										+ i
										+ " = new OpenLayers.Popup('"
										+ name
										+ "', position"
										+ i
										+ ", new OpenLayers.Size(200, 50), '"
										+ name
										+ "', false);map.addPopup(popup"
										+ i
										+ ");});");
								eval("marker.events.register('mouseout', marker, function (evt) {popup"
										+ i + ".hide();}); ");
								eval("markers.addMarker(marker);");
							}
							initLines(map, markers, fromProjection, toProjection);
							//map.addLayer(markers);
						},
						error:function(){

						}

					});*/
		}

		function initLines(map, markers, fromProjection, toProjection) {
			$.ajax({
						method : "get",
						url : ${ctx} + "http://localhost:8080//ano/openMapLines",
						dataType : "json",
						success : function(data) {
							var lines = data["data"];
							var colors = data["color"];
							var layerobj = {};
							for ( var i = 0; i < colors.length; i++) {
								layerobj[colors[i]] = "";
							}
							for ( var j = 0; j < lines.length; j++) {
								var line = lines[j];
								var color = typeof (line["color"]) == "undefined"
								|| line["color"] === "" ? "#9c83a5"
										: line["color"];
								var from_x = line["from_x"];
								var from_y = line["from_y"];
								var to_x = line["to_x"];
								var to_y = line["to_y"];
								var from_point = new OpenLayers.LonLat(from_x,
										from_y).transform(fromProjection,
										toProjection);
								var to_point = new OpenLayers.LonLat(to_x, to_y)
										.transform(fromProjection, toProjection);
								var lineStr = layerobj[color];
								if (typeof (lineStr) != "undefined"
										&& lineStr.length > 0) {
									lineStr = lineStr + ",";
								}
								lineStr = lineStr + from_point["lon"] + " "
										+ from_point["lat"] + "," + to_point["lon"]
										+ " " + to_point["lat"];
								layerobj[color] = lineStr;
							}
							var lineLayers = map.getLayersByName(new RegExp(
									"line$", ""));
							for ( var t = 0; t < lineLayers.length; t++) {
								map.removeLayer(lineLayers[t]);
							}
							for ( var h = 0; h < colors.length; h++) {
								var color = colors[h];
								var newLayer = new OpenLayers.Layer.Vector(color
										+ "line", {
									styleMap : new OpenLayers.StyleMap({
										strokeWidth : 2,
										strokeColor : color
									}),
									isBasicLayer : true,
									renderers : [ "Canvas" ],
									rendererOptions : {
										hitDetection : true
									}
								});
								if (layerobj[color].length > 0) {
									//eval("var Layer"+h+" = new OpenLayers.Layer.Vector('"+h+"line', {styleMap : new OpenLayers.StyleMap({strokeWidth : 2,strokeColor : '"+color+"'}), isBasicLayer : true, renderers : ['Canvas'], rendererOptions : {hitDetection : true} });");
									var features = [ new OpenLayers.Feature.Vector(
											OpenLayers.Geometry
													.fromWKT("LineString("
															+ layerobj[color] + ")")) ];
									//eval("var features"+h+" = [new OpenLayers.Feature.Vector(OpenLayers.Geometry.fromWKT(\"LineString(" + layerobj[color] + ")\"))];");
									newLayer.addFeatures(features);
									//eval("Layer"+h+".addFeatures(features"+h+");");
									map.addLayer(newLayer);
									//eval("map.addLayer(Layer"+h+");");
								}
							}
							map.addLayer(markers);
							initTable();
						},
				       error:function(){

					   }
					});
		}
		function initTable() {
			$("#pointtab").empty();
			$("#pointtabs").empty();
			//jQuery("#pointtab").append("<tr><td>Metro</td><td>2</td><td>3</td><td>1</td><td>2</td><td>3</td><td>1</td><td>2</td></tr>");
			$.ajax({
				method : "get",
				url : ${ctx} + "/ano/openMapTable",
				dataType : "json",
				success : function(data) {
					var metro = data["metro"];
					var pe = data["pe"];
					var tera = data["tera"];
					var metroStr = "<tr class='Mapttbodyod'><td><img src='../$resource/com.bjhxqh.module.app.handles.yinni/css/images/centermap/Metro-E.png' class='MapIocnSize'>Metro-E</td>";
					var peStr = "<tr class='Mapttbodyeven'><td><img src='../$resource/com.bjhxqh.module.app.handles.yinni/css/images/centermap/PE.png' class='MapIocnSize'>PE&nbsp;&nbsp;&nbsp;&nbsp;</td>";
					var teraStr = "<tr class='Mapttbodyodd'><td><img src='../$resource/com.bjhxqh.module.app.handles.yinni/css/images/centermap/Tera.png' class='MapIocnSize'>Tera&nbsp;</td>";
					for(var i=0;i<7;i++){
						metroStr = metroStr+"<td style='font-size:36px'>"+metro[i]+"</td>";
						peStr = peStr+"<td style='font-size:36px'>"+pe[i]+"</td>";
						teraStr = teraStr+"<td style='font-size:36px'>"+tera[i]+"</td>";
					}
					metroStr = metroStr+"</tr>";
					peStr = peStr+"</tr>";
					teraStr = teraStr+"</tr>";
					var tablehtml = metroStr+peStr+teraStr;
					$("#pointtab").append(tablehtml);

					var arrlist = data["list"];
					var tablebody = "";
					for(var i=0;i<arrlist.length;i++){
						var columnlist = arrlist[i];
						if(i%2!=0){
							var columnStr="<tr class='Mapttbodyodd'>";
						}else{
							var columnStr="<tr class='Mapttbodyeven'>";
						}
						for(var j=0;j<columnlist.length;j++){
							var num=columnlist[j];
							columnStr=columnStr+"<td>"+num+"</td>";
						}
						columnStr=columnStr+"</tr>";
						tablebody = tablebody+columnStr;
					}
					$("#pointtabs").append(tablebody);
				}
			});
		}
	});
</script>
</body>
</html>