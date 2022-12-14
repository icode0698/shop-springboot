$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        $.ajax({
            type: "post",
            headers: {Authorization: $.cookie("token")},
            dataType: "json",
            url: "../value/select",
            data: {
                message: "selectValue"
            }, success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    $("#storagetrs").empty();
                    for (let i = 0; i < data.data.storageList.length; i++) {
                        let content = '<tr><td>' + data.data.storageList[i].valueID + '</td><td>' + data.data.storageList[i].value + '</td></tr>';
                        $("#storagetrs").append(content);
                    }
                    table.init('storage', {
                        page: true
                        , limit: 20
                        , cellMinWidth: 40
                    });
                    $("#colortrs").empty();
                    for (let i = 0; i < data.data.colorList.length; i++) {
                        let content = '<tr><td>' + data.data.colorList[i].valueID + '</td><td>' + data.data.colorList[i].value + '</td></tr>';
                        $("#colortrs").append(content);
                    }
                    table.init('color', {
                        page: true
                        , limit: 20
                        , cellMinWidth: 40
                    });
                    $("#screentrs").empty();
                    for (let i = 0; i < data.data.screenList.length; i++) {
                        let content = '<tr><td>' + data.data.screenList[i].valueID + '</td><td>' + data.data.screenList[i].value + '</td></tr>';
                        $("#screentrs").append(content);
                    }
                    table.init('screen', {
                        page: true
                        , limit: 20
                        , cellMinWidth: 40
                    });
                }
                if (data.code == 500) {
                    layer.alert("??????????????????");
                }
            }, error: function (data) {
                console.log(data);
                layer.alert("?????????????????????????????????");
                return;
            }
        });
    });
});