/**
 * Created by lenovo on 2017/6/26.
 */
$(function(){
    $("#login").click(function(){
        var username = $("#userName").val().trim();
        var pwd = $("#pwd").val().trim();
        if(username.length==0||pwd.length==0){
            $("#tip").text("用户名或者密码不能为空");
        }else{
            $.ajax({
                url: _ctx+"/system/login",
                method: "post",
                data: {
                    name : username,
                    password  : pwd
                },
                dataType: "json",
                success: function(data){
                    alert(data.message);
                },
                error: function(){

                }
            })
        }
    });

    function checkLogin(){
        if (addForm.user.value == "")
        {
            alert("请填写用户名！");
            return false;
        }
        if (addForm.title.value.length < 5)
        {
            alert("标题不能少于5个字符！");
            return false;
        }
        return true;
    }
});