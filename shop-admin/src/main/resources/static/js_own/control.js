$(function () {
    layui.use(['layer', 'form', 'table'], function () {
        var layer = layui.layer
            , form = layui.form
            , table = layui.table;
        getData("user", $("#usertime").val());
        getMessage("message", $("#messagetime").val());
        $("#usertime").on("change", function () {
            console.log($("#usertime").val());
            getData("user", $("#usertime").val());
        });
        $("#messagetime").on("change", function () {
            console.log($("#messagetime").val());
            getMessage("message", $("#messagetime").val());
        });
        $("#test").on("click", function () {
            console.log("+++++++++++");
        });
        $.ajax({
            type: "post",
            url: "../admin/boinfo",
            dataType: "json",
            success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    $("#infotrs").empty();
                    if (data.data.length == 0) {
                        $("#infotrs").append("没有找到相关数据");
                    }
                    else {
                        for (let i = 0; i < data.data.length; i++) {
                            let content = '';
                            if (i == 1) {
                                content = '<tr><td>' + data.data[i].type + '</td><td>' + data.data[i].info + ' <a href="https://layuion.com/" target="_blank" style="padding-left:15px;">官网</a></td></tr>';
                            }
                            else {
                                content = '<tr><td>' + data.data[i].type + '</td><td>' + data.data[i].info + '</td></tr>';
                            }
                            $("#infotrs").append(content);
                        }
                    }
                }
                else {
                    layer.alert("查询出错");
                }
            },
            error: function (XMLResponse) {
                layer.alert("服务器异常，请稍后再试");
                console.log("error_status:" + XMLResponse.status);
                return;
            }
        });
        function getMessage(type, value) {
            $.ajax({
                type: "post",
                url: "../admin/control",
                dataType: "json",
                data: {
                    type: type,
                    value: value
                },
                success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        if (data.data.length == 0) {
                            table.init('message', {
                                page: true
                                , limit: 10
                                , cellMinWidth: 40
                            });
                        }
                        else {
                            for (let i = 0; i < data.data.length; i++) {
                                let content = '<tr><td>' + data.data[i].user + '</td><td>' + data.data[i].nickName + '</td><td>' + data.data[i].message + '</td>'
                                    + '<td>' + data.data[i].createTime + '</td><td>' + data.data[i].lastTime + '</td><td>' + data.data[i].online + '</td></tr>';
                                $("#messagetrs").append(content);
                            }
                            table.init('message', {
                                page: true
                                , limit: 10
                                , cellMinWidth: 40
                            });
                            $("#messagetrs").empty();
                        }
                    }
                    else {
                        layer.alert("查询出错");
                    }
                },
                error: function (XMLResponse) {
                    layer.alert("服务器异常，请稍后再试");
                    console.log("error_status:" + XMLResponse.status);
                    return;
                }
            });
        }

        function getData(type, value) {
            $.ajax({
                type: "post",
                url: "../admin/control",
                dataType: "json",
                data: {
                    type: type,
                    value: value,
                },
                success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        if (data.data.length == 0) {
                            table.init('user', {
                                page: true
                                , limit: 10
                                , cellMinWidth: 40
                            });
                        }
                        else {
                            for (let i = 0; i < data.data.length; i++) {
                                let online = '';
                                if (data.data[i].online == true) {
                                    online = '<span>在线  </span><span id="' + data.data[i].user + '" style="color:#01AAED;cursor: pointer;">下线</span>';
                                }
                                if (data.data[i].online == false) {
                                    online = '离线';
                                }
                                let content = '<tr><td>' + data.data[i].user + '</td><td>' + data.data[i].nickName + '</td><td>' + data.data[i].regTime + '</td>'
                                    + '<td>' + data.data[i].lastTime + '</td><td>' + online + '</td><td>' + data.data[i].viewCount + '</td></tr>';
                                $("#usertrs").append(content);
                            }
                            table.init('user', {
                                page: true
                                , limit: 10
                                , cellMinWidth: 40
                            });
                            $("#usertrs").empty();
                            for (let i = 0; i < data.data.length; i++) {
                                console.log(i);
                                $("#" + data.data[i].user).on("click", function () {
                                    console.log("+++++++++++");
                                    $.ajax({
                                        type: "post",
                                        url: "../admin/offline",
                                        dataType: "json",
                                        data: {
                                            user: data.data[i].user
                                        },
                                        success: function (data) {
                                            console.log(data);
                                            if (data.code == 200) {
                                                $("#usertrs").empty();
                                                getData("user", $("#usertime").val());
                                                layer.alert(data.message);
                                            }
                                            else {
                                                layer.alert(data.message);
                                            }
                                        },
                                        error: function (XMLResponse) {
                                            layer.alert("服务器异常，请稍后再试");
                                            console.log("error_status:" + XMLResponse.status);
                                            return;
                                        }
                                    });
                                });
                            }
                        }
                    }
                    else {
                        layer.alert("查询出错");
                    }
                },
                error: function (XMLResponse) {
                    $("#error_hide").removeClass("hidden");
                    $("#error_tip").text("抱歉，服务器异常。\nXMLResponse_Status:" + XMLResponse.status);
                    console.log("error_status:" + XMLResponse.status);
                    return;
                }
            });
        }
    });
});