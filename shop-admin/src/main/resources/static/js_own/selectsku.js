$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        let originSpu = '';
        let originSku = '';
        $("#spu").bind("input propertychange", function () {
            if (isNaN($("#spu").val())) {
                $("#spu").val(originSpu);
            } else {
                originSpu = $("#spu").val();
            }
        });
        $("#sku").bind("input propertychange", function () {
            if (isNaN($("#sku").val())) {
                $("#sku").val(originSku);
            } else {
                originSku = $("#sku").val();
            }
        });
        getSku();
        $("#getsku").on("click", function () {
            reloadSku($("#category").val(), $("#spu").val(), $("#sku").val());
        });

        function getSku() {
            table.render({
                elem: '#sku-select-table'
                , url: '../sku/select'
                , method: 'post'
                , headers: {Authorization: $.cookie("token")}
                , cellMinWidth: 80
                , id: 'sku-select-table-reload'
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
            });
        }

        function reloadSku(category, spu, sku) {
            table.reload('sku-select-table-reload', {
                where: { //设定异步数据接口的额外参数
                    categoryName: category
                    , spu: spu
                    , sku: sku
                }
                , page: {
                    curr: 1 //重新从第1页开始
                }
            });
        }

        function getSkuOrigin(category, spu, sku) {
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../sku/select",
                data: {
                    message: "selectSku",
                    categoryName: category,
                    spu: spu,
                    sku: sku
                }, success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        $("#trs").empty();
                        for (let i = 0; i < data.data.length; i++) {
                            let content = '<tr><td>' + data.data[i].sku + '</td><td>' + data.data[i].goodsID + '</td><td>' + data.data[i].goodsName + '</td><td>' + data.data[i].categoryName + '</td>'
                                + '<td>' + data.data[i].brandName + '</td><td>' + data.data[i].storage + '</td><td>' + data.data[i].color + '</td><td>' + data.data[i].screen + '</td><td><span>￥</span>' + data.data[i].price.toFixed(2) + '</td><td>' + data.data[i].stock + '</td></tr>';
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