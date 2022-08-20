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
                    for (let i = 0; i < data.data.list.length; i++) {
                        let content = '<tr><td>'+data.data.list[i].sku+'</td><td>'+data.data.list[i].goodsID+'</td><td>'+data.data.list[i].goodsName+'</td>'
                            +'<td>'+data.data.list[i].storage+'</td><td>'+data.data.list[i].color+'</td><td>'+data.data.list[i].screen+'</td>'
                            +'<td>'+data.data.list[i].price+'</td><td>'+data.data.list[i].stock+'</td>'
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
    });
});