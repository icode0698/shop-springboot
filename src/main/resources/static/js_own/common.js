$(function () {
    $("#top_btn_login").click(function () {
        location.href = "login.html";
    });
    $("#top_btn_reg").click(function () {
        location.href = "register.html";
    });
    // 顶部动态显示登录状态(session)
    $.ajax({
        type: "post",
        dataType: "json",
        url: "user/status",
        data: {
            type: "ajax_whether",
            message: "getStatus"
        }, success: function (data) {
            console.log(data);
            if (data.code == 200) {
                $("#login_no").addClass("hidden");
                $("#login_yes").removeClass("hidden");
                $("#span_user").text(data.data.nickName);
                $("#headPic").attr("src", data.data.headPic);
            }
        }, error: function () {
            console.log("服务器异常\n");
            return;
        }
    });
    // 处理退出登录
    $("#btn_out").click(function () {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "user/logout",
            data: {
                type: "ajax_whether",
                message: "logout"
            }, success: function () {
                location.href = "index.html";
            }, error: function () {
                console.log("服务器异常\n");
                return;
            }
        });
    });
});
