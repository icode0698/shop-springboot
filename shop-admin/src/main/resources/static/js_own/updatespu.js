$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        $.ajax({
            type: "post",
            headers: {Authorization: $.cookie("token")},
            dataType: "json",
            url: "../spu/select",
            data: {
                message: "selectSpu"
            }, success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    $("#trs").empty();
                    for (let i = 0; i < data.data.length; i++) {
                        let content = '<tr><td>' + data.data[i].goodsID + '</td><td>' + data.data[i].goodsName + '</td><td>' + data.data[i].categoryName + '</td><td>' + data.data[i].brandName + '</td><td>' + data.data[i].insertTime + '</td></tr>';
                        $("#trs").append(content);
                    }
                    table.init('spu', {
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
        table.on('edit(spu)', function (obj) {
            var id = obj.data.spu;
            var field = obj.field;
            var value = obj.value //得到修改后的值
            var goodsName = '';
            var categoryName = '';
            var brandName = '';
            if (field == 'name') {
                goodsName = value;
            }
            if (field == 'category') {
                categoryName = value;
            }
            if (field == 'brand') {
                brandName = value;
            }
            $.ajax({
                type: "post",
                headers: {Authorization: $.cookie("token")},
                dataType: "json",
                url: "../spu/update",
                data: {
                    goodsID: id,
                    goodsName: goodsName,
                    categoryName: categoryName,
                    brandName: brandName
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