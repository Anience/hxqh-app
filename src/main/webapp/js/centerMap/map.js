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
            .transform(fromProjection, toProjection), 7);
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
                        icon = new OpenLayers.Icon(_ctx+'/imgs/b-64.png', size, offset);
                    }else if(type==="2"){
                        icon = new OpenLayers.Icon(_ctx+'/imgs/g-64.png', size, offset);
                    }else if(type==="3"){
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
                        case "1":
                            var tableData1 = bottomObj[name];
                            for(var i=0;i<tableData1.length;i++){
                                metroStr+="<td>"+tableData1[i]+"</td>"
                            }
                            break;
                        case "2":
                            var tableData2 = bottomObj[name];
                            for(var i=0;i<tableData2.length;i++){
                                peStr+="<td>"+tableData2[i]+"</td>"
                            }
                            break;
                        case "3":
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