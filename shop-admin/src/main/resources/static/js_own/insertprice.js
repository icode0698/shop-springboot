$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        table.render({
            elem: '#sku-price-table'
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
            , where: { //设定异步数据接口的额外参数
                price: 0
            }
        });
        table.on('edit(price)', function (obj) {
            var sku = obj.data.sku;
            var field = obj.field;
            let price = '';
            let stock = '';
            //得到修改后的值
            if (field == "price") {
                price = obj.value;

            }
            if (field == "stock") {
                stock = obj.value;
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
        function getSkuOrigin(){
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../sku/select",
                data: {
                    message: "selectSkuPrice",
                    price: 0
                }, success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        $("#trs").empty();
                        for (let i = 0; i < data.data.list.length; i++) {
                            let content = '<tr><td>' + data.data.list[i].sku + '</td><td>' + data.data.list[i].goodsID + '</td><td>' + data.data.list[i].goodsName + '</td>'
                                + '<td>' + data.data.list[i].storage + '</td><td>' + data.data.list[i].color + '</td><td>' + data.data.list[i].screen + '</td>'
                                + '<td>' + data.data.list[i].price + '</td><td>' + data.data.list[i].stock + '</td>'
                            $("#trs").append(content);
                        }
                        table.init('price', {
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