$(function () {
    $("#out").on("click", function () {
        $.ajax({
            type: "post",
            headers: {Authorization: $.cookie("token")},
            url: "admin/logout",
            dataType: "json",
            success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    location.href = 'login.html';
                } else {
                    layer.alert(data.message, {icon: 2}, function () {
                        location.href = 'login.html';
                        return;
                    });
                }
            },
            error: function (XMLResponse) {
                layer.alert("抱歉，服务器异常。", {icon: 2}, function () {
                });
                return;
            }
        });
    });
});