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
        map.setCenter(new OpenLayers.LonLat(106.827183, -6.1753942)
            .transform(fromProjection, toProjection), 8);
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
                    if(type==="1"){
                        icon = new OpenLayers.Icon(_ctx+'/imgs/Metro-E.png', size, offset);
                    }else if(type==="2"){
                        icon = new OpenLayers.Icon(_ctx+'/imgs/PE.png', size, offset);
                    }else if(type==="3"){
                        icon = new OpenLayers.Icon(_ctx+'/imgs/Tera.png', size, offset);
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
            },
            error: function(){

            }
        })
    }
    function initTable(){
        $("#pointtab").empty();
        $("#pointtabs").empty();
        $.ajax({
            url: _ctx+"/ano/openMapTable",
            method: "get",
            dataType: "json",
            success: function(data){
                var arrlist = data["mapOpenmaptableRighttableList"];
                for(var i=0;i<arrlist.length;i++){
                    var index = i+1;
                    var tmpHtml = '<tr style="height : 60px"><td>'+index
                        +'</td><td>'+arrlist[i].dates
                        +'</td><td>'+arrlist[i].ruas
                        +'</td><td>'+arrlist[i].nodeId
                        +'</td><td>'+arrlist[i].interface_
                        +'<tr>';
                    $("#top-table").append(tmpHtml);
                }

            },
            error: function(){

            }
        })
    }
    initMap();
}());