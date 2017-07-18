/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function initMap(){
        var zoom = 9;
        var fromProjection = new OpenLayers.Projection("EPSG:4326");
        var toProjection = new OpenLayers.Projection("EPSG:900913");
        map = new OpenLayers.Map("Map");
        var mapnik = new OpenLayers.Layer.OSM();
        map.addLayer(mapnik);
        map.setCenter(new OpenLayers.LonLat(115.269, -0.286)
            .transform(fromProjection, toProjection), 6.5);
        initPoints(map, fromProjection, toProjection);
    }
    function initPoints(map, fromProjection, toProjection){
        var size = new OpenLayers.Size(21, 25);

        var offset = new OpenLayers.Pixel(-(size.w / 2), -size.h);
        var lineLayers = map.getLayersByName(new RegExp("Markers", ""));
        for ( var t = 0; t < lineLayers.length; t++) {
            map.removeLayer(lineLayers[t]);
        }
        var markers = new OpenLayers.Layer.Markers("Markers");
        $.ajax({
            url: _ctx+"/ano/openMapPoints",
            method: "get",
            dataType: "json",
            success: function(data){
                var points = data;
                for ( var i = 0; i < points.length; i++) {
                    var point = points[i];
                    var type = point["type"];
                    var name = point["name"];
                    var x = point["x"];
                    var y = point["y"];
                    var icon = new OpenLayers.Icon(_ctx+'/imgs/WIFIAP.png', size, offset);
                    if(type==="METRO"){
                        icon = new OpenLayers.Icon(_ctx+'/imgs/b-64.png', size, offset);
                    }else if(type==="PE"){
                        icon = new OpenLayers.Icon(_ctx+'/imgs/g-64.png', size, offset);
                    }else if(type==="TERA"){
                        icon = new OpenLayers.Icon(_ctx+'/imgs/y-64.png', size, offset);
                    }
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
                map.addLayer(markers);
                initTable();
                initLines(map, markers, fromProjection, toProjection);
            },
            error: function(){

            }
        })
    }
    function initLines(map, markers, fromProjection, toProjection) {
        $.ajax({
            url: _ctx+"/ano/openMapLines",
            method: "get",
            dataType: "json",
            success: function(data){
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
            },
            error: function(){

            }
        })
    }
    function initTable(){
        $("#top-table").empty();
        $("#bottom-table").empty();
        $.ajax({
            url: _ctx+"/ano/openMapTable",
            method: "get",
            dataType: "json",
            success: function(data){
                //初始化top-table
                var arrlist = data["mapOpenmaptableRighttableList"];
                for(var i=0;i<arrlist.length;i++){
                    var index = i+1;
                    var tmpHtml = '<tr style="height: 60px"><td>'+index
                        +'</td><td>'+arrlist[i].dates
                        +'</td><td>'+arrlist[i].ruas
                        +'</td><td>'+arrlist[i].nodeId
                        +'</td><td>'+arrlist[i].interface_
                        +'</tr>';
                    $("#top-table").append(tmpHtml);
                }
                //初始化bottom-table
                var bottomObj = data["mttrM"];
                var metroStr = "<tr><td><img src="+_ctx+"/imgs/b-64.png>Metro-E</td>";
                var peStr = "<tr><td><img src="+_ctx+"/imgs/g-64.png>PE</td>";
                var teraStr = "<tr><td><img src="+_ctx+"/imgs/y-64.png>Tera</td>";
                var ToStr = "<tr><td>Total</td>";
                for(var name in bottomObj){
                    switch(name){
                        case "METRO":
                            var tableData1 = bottomObj[name];
                            for(var i=0;i<tableData1.length;i++){
                                metroStr+="<td>"+tableData1[i]+"</td>"
                            }
                            break;
                        case "PE":
                            var tableData2 = bottomObj[name];
                            for(var i=0;i<tableData2.length;i++){
                                peStr+="<td>"+tableData2[i]+"</td>"
                            }
                            break;
                        case "TERA":
                            var tableData3 = bottomObj[name];
                            for(var i=0;i<tableData3.length;i++){
                                teraStr+="<td>"+tableData3[i]+"</td>"
                            }
                            break;
                        default:
                            var tableData4 = bottomObj[name];
                            for(var i=0;i<tableData4.length;i++){
                                ToStr+="<td>"+tableData4[i]+"</td>"
                            }
                    }
                }
                metroStr+="</tr>";
                peStr+="</tr>";
                teraStr+="</tr>";
                ToStr+="</tr>";
                var allHtml = metroStr+peStr+teraStr+ToStr;
                $("#bottom-table").append(allHtml);
            },
            error: function(){

            }
        })
    }
    initMap();
   /* setInterval(function(){
        window.location.href=_ctx+"/ano/map";
    },300000);*/
}());