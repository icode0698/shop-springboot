$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        let origin = '';
        $("#spu").bind("input propertychange", function () {
            if (isNaN($("#spu").val())) {
                $("#spu").val(origin);
            } else {
                origin = $("#spu").val();
            }
        });
        $("#order").on("click", function () {
            if ($("#spu").val() == '') {
                layer.alert("请先输入信息", {icon: 3});
            } else {
                getSkuInfo();
            }
        });
        $("#ensure").on("click", function () {
            layer.confirm("确定要删除这件商品吗？", {
                icon: 3,
                btn: ["确定删除", "再看看"]
            }, function () {
                $.ajax({
                    type: "post",
                    headers: {Authorization: $.cookie("token")},
                    dataType: "json",
                    url: "../spu/delete",
                    data: {
                        message: "deleteSpu",
                        spu: $("#spu").val()
                    }, success: function (data) {
                        console.log(data);
                        if (data.code == 200) {
                            reloadSkuInfo();
                            layer.alert(data.message, {icon: 1});
                        }
                        if (data.code == 500) {
                            layer.alert(data.message,);
                        }
                    }, error: function (data) {
                        console.log(data);
                        layer.alert("服务器异常，请稍后再试");
                        return;
                    }
                });
            }, function () {
            });
        });

        function getSkuInfo() {
            table.render({
                elem: '#sku-delete-table'
                , url: '../sku/select'
                , method: 'post'
                , headers: {Authorization: $.cookie("token")}
                , cellMinWidth: 80
                , id: 'sku-delete-table-reload'
                , cols: [[
                    {field: 'sku', title: '商品SKU', sort: true}
                    , {field: 'goodsID', title: '所属SPU', sort: true}
                    , {field: 'goodsName', title: '商品名称', sort: true}
                    , {field: 'categoryName', title: '所属分类', sort: true}
                    , {field: 'brandName', title: '所属品牌', sort: true}
                    , {field: 'storage', title: '存储容量'}
                    , {field: 'color', title: '外观颜色'}
                    , {field: 'screen', title: '屏幕尺寸'}
                    , {field: 'price', title: '价格', sort: true}
                    , {field: 'stock', title: '库存量', sort: true}
                ]]
                , where: { //设定异步数据接口的额外参数
                    spu: $("#spu").val()
                }
                , parseData: function (res) {
                    return {
                        "code": res.code, //解析接口状态
                        "msg": res.message, //解析提示文本
                        "count": res.data.count, //解析数据长度
                        "data": res.data.list //解析数据列表
                    };
                }
                , page: {
                    limit: 20,
                    limits: [10, 20, 30, 40, 50]
                }
                , response: {
                    statusCode: 200
                }
                , done: function (res) {
                    if (res.count != undefined && res.count > 0) {
                        $("#ensure").css("display", "");
                    } else {
                        $("#ensure").css("display", "none");
                    }
                }
            });
        }

        function reloadSkuInfo() {
            table.reload('sku-select-table-reload', {
                where: { //设定异步数据接口的额外参数
                    spu: $("#spu").val()
                }
                , page: {
                    curr: 1 //重新从第1页开始
                }
                , done: function (res) {
                    if (res.count != undefined && res.count > 0) {
                        $("#ensure").css("display", "");
                    } else {
                        $("#ensure").css("display", "none");
                    }
                }
            });
        }

        function getSkuInfoOrigin() {
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../sku/select",
                data: {
                    message: "skuBelong",
                    spu: $("#spu").val()
                }, success: function (data) {
                    $("#deleteinfo").css("display", "");
                    console.log(data);
                    if (data.code == 200) {
                        $("#trs").empty();
                        for (let i = 0; i < data.data.list.length; i++) {
                            let content = '<tr><td>' + data.data.list[i].sku + '</td><td>' + data.data.list[i].goodsID + '</td><td>' + data.data.list[i].goodsName + '</td><td>' + data.data.list[i].categoryName + '</td>'
                                + '<td>' + data.data.list[i].brandName + '</td><td>' + data.data.list[i].storage + '</td><td>' + data.data.list[i].color + '</td><td>' + data.data.list[i].screen + '</td><td><span>￥</span>' + data.data.list[i].price.toFixed(2) + '</td><td>' + data.data.list[i].stock + '</td></tr>';
                            $("#trs").append(content);
                        }
                        table.init('sku', {
                            page: true
                            , limit: 20
                            , cellMinWidth: 40
                        });
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
        }
    });
});