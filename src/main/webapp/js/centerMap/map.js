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
                Console.log(data);
               /* var metro = data["metro"];
                var pe = data["pe"];
                var tera = data["tera"];
                var To = data["To"];
                var metroStr = "<tr class=\"Mapttbodyodd\"><td><img src=\"../$resource/com.bjhxqh.module.app.handles.yinni/css/images/centermap/Metro-E.png\" class=\"MapIocnSize\">Metro-E</td>";
                var peStr = "<tr class=\"Mapttbodyeven\"><td><img src=\"../$resource/com.bjhxqh.module.app.handles.yinni/css/images/centermap/PE.png\" class=\"MapIocnSize\">PE&nbsp;&nbsp;&nbsp;&nbsp;</td>";
                var teraStr = "<tr class=\"Mapttbodyodd\"><td><img src=\"../$resource/com.bjhxqh.module.app.handles.yinni/css/images/centermap/Tera.png\" class=\"MapIocnSize\">Tera&nbsp;</td>";
                var ToStr = "<tr class=\"Mapttbodyeven\"><td>Total</td>";
                for(var i=0;i<8;i++){
                    metroStr = metroStr+"<td style='font-size:32px'>"+metro[i]+"</td>";
                    peStr = peStr+"<td style='font-size:32px'>"+pe[i]+"</td>";
                    teraStr = teraStr+"<td style='font-size:32px'>"+tera[i]+"</td>";
                    ToStr = ToStr+"<td style='font-size:32px'>"+To[i]+"</td>";
                }
                metroStr = metroStr+"</tr>";
                peStr = peStr+"</tr>";
                teraStr = teraStr+"</tr>";
                ToStr = ToStr+"</tr>";
                var tablehtml = metroStr+peStr+teraStr+ToStr;
                $("#pointtab").append(tablehtml);

                var arrlist = data["list"];
                var tablebody = "";
                for(var i=0;i<arrlist.length;i++){
                    var columnlist = arrlist[i];
                    if(i%2!=0){
                        var columnStr="<tr class=\"Mapttbodyodd\">";
                    }
                    /!* var columnStr=">"; *!/
                    else{
                        var columnStr="<tr class=\"Mapttbodyeven\">";
                    }
                    for(var j=0;j<columnlist.length;j++){
                        var num=columnlist[j];
                        columnStr=columnStr+"<td>"+num+"</td>";
                    }
                    columnStr=columnStr+"</tr>";
                    tablebody = tablebody+columnStr;
                }
                $("#pointtabs").append(tablebody);*/
            },
            error: function(){

            }
        })
    }
    initMap();
}());