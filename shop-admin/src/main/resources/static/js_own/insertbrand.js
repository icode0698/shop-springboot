$(function () {
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer
            , form = layui.form;
        $.ajax({
            type: "post",
            headers: {Authorization: $.cookie("token")},
            dataType: "json",
            url: "../brand/now",
            success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    $("#now").text(data.data);
                    $("#brandID").val(parseInt(data.data) + 1);
                }
                if (data.code == 500) {
                    layer.alert("查询出现错误");
                }
            }, error: function (data) {
                console.log(data);
                layer.alert("服务器异常，请稍后再试");
                return;
            }
        });
        form.on('submit(ensure)', function (data) {
            console.log(data.field);
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../brand/insert",
                data: {
                    brandID: $("#brandID").val(),
                    brandName: $("#brandName").val(),
                }, success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        layer.alert(data.message, {icon: 1}, function () {
                            location.href = "";
                        });
                        return false;
                    }
                    if (data.code == 500) {
                        layer.alert(data.message, {icon: 2});
                        return false;
                    }
                }, error: function (data) {
                    console.log(data);
                    layer.alert("服务器异常，请稍后再试", {icon: 2});
                    return;
                }
            });
            return false;
        });
    });
});