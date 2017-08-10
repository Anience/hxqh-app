/**
 * Created by lenovo on 2017/6/26.
 */
$(function () {
    var system = new Vue({
        el: "#detail-data",
        data: {
            custname: '',
            custid:'',
            custtype:'',
            custrank:''
        },
        methods: {
        },
        created: function () {
            var self = this;
            $.ajax({
                url: _ctx+"/system/getrankDetail",
                method: "get",
                dataType: "json",
                data:{
                    ioccustomerusertop7id:custid
                },
                success: function (data) {
                    self.custname = data.custname;
                    self.custid = data.custid;
                    self.custtype = data.custtype;
                    self.custrank = data.custrank;
                },
                error: function () {

                }
            });
        }
    });
    $('.search-name').click(function(){
        var custName = $("input#custName").val();
        var type = $("input#type").val();
        $.ajax({
            url: _ctx+"/system/customeruserListData",
            method: "get",
            dataType: "json",
            data:{
                name:custName,
                div:type
            },
            success: function (data) {
                $('.box').show();
            },
            error: function () {

            }
        });
    });
    $('.box table tbody').on('tr','click',function(){
        console.log($(this));
    });
    $('.close').click(function(){
        $('.box').hide();
    });
});