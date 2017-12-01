/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    function rankList(){
        this.initData();
        this.initBind();
    }
    rankList.prototype={
        constructor:rankList,
        initData:function(){
            $.ajax({
                url: _ctx+"/system/custtop7ListData",
                method: "get",
                dataType: "json",
                success: function (data) {
                    var tmpHtml = "";
                    tmpHtml+="<tr class='select'><td><input type='text' class='custid'></td><td><input type='text' class='custname'></td><td><input type='text' class='crank'></td><td><input type='text' class='custtype'></td></tr>";
                    for(var i=0;i<data.length;i++){
                        tmpHtml+="<tr><td>"+data[i].custid+"</td><td>"
                               +data[i].custname+"</td><td>"+data[i].crank
                               +"</td><td>"+data[i].custtype+"</td><td>"+data[i].ioccustomerusertop7id
                               +"<td><a href='javascript:void(0);'><i class='del-icon'></i></a></td>";
                    }
                    $("#customer-data table tbody").html("");
                    $("#customer-data table tbody").html(tmpHtml);
                    $("#customer-data table tbody tr:not(:first-child) td:nth-last-child(2)").hide();
                },
                error: function () {

                }
            });
        },
        initBind:function(){
            $("#customer-data table tbody").on("click",".del-icon",function(){
                var ioccustomerusertop7id=$(this).parents("td").siblings("td:nth-child(5)").text();
                window.location.href = _ctx+'/system/rankDetail?ioccustomerusertop7id='+ioccustomerusertop7id;
            });
            $("#customer-data").on("keypress","input",function(event){
                if (event.keyCode == "13") {
                    var selectValue = $(this).val();
                    $(this).parent().siblings("td").find("input").val("");
                    var selectName = $(this)[0].className;
                    var params = {};
                    params[selectName] = selectValue;
                    $.ajax({
                        url: _ctx+"/system/custtop7ListData",
                        method: "get",
                        dataType: "json",
                        data: params,
                        success: function (data) {
                            var tmpHtml = "";
                            for(var i=0;i<data.length;i++){
                                tmpHtml+="<tr><td>"+data[i].custid+"</td><td>"
                                    +data[i].custname+"</td><td>"+data[i].crank
                                    +"</td><td>"+data[i].custtype+"</td><td>"+data[i].ioccustomerusertop7id
                                    +"<td><a href='javascript:void(0);'><i class='del-icon'></i></a></td>";
                            }
                            $("#customer-data table tbody tr:not(:first-child)").html("");
                            $("#customer-data table tbody").append(tmpHtml);
                            $("#customer-data table tbody tr:not(:first-child) td:nth-last-child(2)").hide();
                        },
                        error: function () {

                        }
                    });
                }
            });
        }
    }
    new rankList();
}())