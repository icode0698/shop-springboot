$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        let originSpu = '';
        let originSku = '';
        $("#spu").bind("input propertychange", function () {
            if (isNaN($("#spu").val())) {
                $("#spu").val(originSpu);
            }
            else {
                originSpu = $("#spu").val();
            }
        });
        $("#sku").bind("input propertychange", function () {
            if (isNaN($("#sku").val())) {
                $("#sku").val(originSku);
            }
            else {
                originSku = $("#sku").val();
            }
        });
        getSku($("#category").val(), $("#spu").val(), $("#sku").val());
        $("#getsku").on("click", function () {
            getSku($("#category").val(), $("#spu").val(), $("#sku").val());
        });
        function getSku(category, spu, sku) {
            $.ajax({
                type: "post",
                dataType: "json",
                url: "../sku/select",
                data: {
                    message: "selectSku",
                    category: category,
                    spu: spu,
                    sku: sku
                }, success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        $("#trs").empty();
                        for (let i = 0; i < data.data.length; i++) {
                            let content = '<tr><td>' + data.data[i].sku + '</td><td>' + data.data[i].goodsID + '</td><td>' + data.data[i].goodsName + '</td><td>' + data.data[i].categoryName + '</td>'
                                + '<td>' + data.data[i].brandName + '</td><td>' + data.data[i].storage + '</td><td>' + data.data[i].color + '</td><td>' + data.data[i].screen + '</td><td>' + data.data[i].price.toFixed(2) + '</td><td>' + data.data[i].stock + '</td></tr>';
                            $("#trs").append(content);
                        }
                        table.init('sku', {
                            page: true
                            , limit: 20
                            , cellMinWidth: 40
                        });
                        table.on('edit(sku)', function (obj) {
                            var sku = obj.data.sku;
                            var field = obj.field;
                            var value = obj.value;
                            var price = '';
                            var stock = '';
                            if(field == 'price'){
                                price = value;
                            }
                            if(field == 'stock'){
                                stock = value;
                            }
                            $.ajax({
                                type: "post",
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
                                    if (data.status == 500) {
                                        layer.alert(data.message);
                                    }
                                }, error: function (data) {
                                    console.log(data);
                                    layer.alert("服务器异常，请稍后再试");
                                    return;
                                }
                            });
                        });
                    }
                    if (data.status == 500) {
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