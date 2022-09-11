$(function () {
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer
            , form = layui.form;
        $.ajax({
            type: "post",
            headers: {Authorization: $.cookie("token")},
            dataType: "json",
            url: "../value/now",
            success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    $("#storagenow").text(data.data.storageNowID);
                    $("#storageID").val(parseInt(data.data.storageNowID) + 1);
                    $("#colornow").text(data.data.colorNowID);
                    $("#colorID").val(parseInt(data.data.colorNowID) + 1);
                    $("#screennow").text(data.data.screenNowID);
                    $("#screenID").val(parseInt(data.data.screenNowID) + 1);
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
        form.on('submit(storageensure)', function (data) {
            console.log(data.field);
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../value/insert",
                data: {
                    message: "storage",
                    valueID: $("#storageID").val(),
                    value: $("#storageName").val(),
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
        form.on('submit(colorensure)', function (data) {
            console.log(data.field);
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../value/insert",
                data: {
                    message: "color",
                    valueID: $("#colorID").val(),
                    value: $("#colorName").val(),
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
        form.on('submit(screenensure)', function (data) {
            console.log(data.field);
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../value/insert",
                data: {
                    message: "screen",
                    valueID: $("#screenID").val(),
                    value: $("#screenName").val(),
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