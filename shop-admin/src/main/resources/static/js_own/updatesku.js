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
                elem: '#sku-update-table'
                , url: '../sku/select'
                , method: 'post'
                , headers: {Authorization: $.cookie("token")}
                , cellMinWidth: 80
                , id: 'sku-update-table-reload'
                , cols: [[
                    {field: 'sku', title: '商品SKU', sort: true}
                    , {field: 'goodsID', title: '所属SPU', sort: true}
                    , {field: 'goodsName', title: '商品名称', sort: true}
                    , {field: 'categoryName', title: '所属分类', sort: true}
                    , {field: 'brandName', title: '所属品牌', sort: true}
                    , {field: 'storage', title: '存储容量'}
                    , {field: 'color', title: '外观颜色'}
                    , {field: 'screen', title: '屏幕尺寸'}
                    , {field: 'price', title: '价格', edit: 'text', sort: true}
                    , {field: 'stock', title: '库存量', edit: 'text', sort: true}
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
            table.reload('sku-update-table-reload', {
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

        table.on('edit(sku-update)', function (obj) {
            var sku = obj.data.sku;
            var field = obj.field;
            var value = obj.value;
            var price = '';
            var stock = '';
            if (field == 'price') {
                price = value;
            }
            if (field == 'stock') {
                stock = value;
            }
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../sku/update",
                data: {
                    sku: sku,
                    price: price,
                    stock: stock
                }, success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        layer.msg(data.message);
                    }
                    if (data.code == 500) {
                        layer.alert(data.message);
                    }
                }, error: function (data) {
                    console.log(data);
                    layer.alert("服务器异常，请稍后再试");
                    return;
                }
            });
        });
    });
});