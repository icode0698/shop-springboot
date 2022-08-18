$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        $.ajax({
            type: "post",
            dataType: "json",
            url: "../sku/select",
            data: {
                message: "selectSkuPrice",
                price: 0
            }, success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    $("#trs").empty();
                    for (let i = 0; i < data.data.length; i++) {
                        let content = '<tr><td>'+data.data[i].sku+'</td><td>'+data.data[i].goodsID+'</td><td>'+data.data[i].goodsName+'</td>'
                            +'<td>'+data.data[i].storage+'</td><td>'+data.data[i].color+'</td><td>'+data.data[i].screen+'</td>'
                            +'<td>'+data.data[i].price+'</td><td>'+data.data[i].stock+'</td>'
                        $("#trs").append(content);
                    }
                    table.init('price', {
                        page: true
                        , limit: 20
                        , cellMinWidth: 40
                    }); 
                    table.on('edit(price)', function(obj){
                        var sku = obj.data.sku;
                        var field = obj.field;
                        let price = '';
                        let stock = '';
                        //得到修改后的值
                        if(field=="price"){
                            price = obj.value;
                            
                        }
                        if(field=="stock"){
                            stock = obj.value;
                        }
                        $.ajax({
                            type: "post",
                            dataType: "json",
                            url: "../sku/update",
                            data: {
                                sku: sku,
                                price: price,
                                stock: stock
                            },success: function (data) {
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
    });
});