$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        $.ajax({
            type: "post",
            dataType: "json",
            url: "../brand/select",
            data: {
                message: "selectBrand"
            }, success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    $("#trs").empty();
                    for (let i = 0; i < data.data.length; i++) {
                        let content = '<tr><td>' + data.data[i].brandID + '</td><td>' + data.data[i].brandName + '</td><td>' + data.data[i].insertTime + '</td></tr>';
                        $("#trs").append(content);
                    }
                    table.init('brand', {
                        page: true
                        , limit: 20
                        , cellMinWidth: 40
                    });
                    table.on('edit(brand)', function (obj) {
                        console.log("++++++++++");
                        var id = obj.data.id;
                        var brandName = obj.value //得到修改后的值
                        $.ajax({
                            type: "post",
                            dataType: "json",
                            url: "../brand/update",
                            data: {
                                brandID: id,
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
                }
                if (data.code == 500) {
                    layer.alert("查询出现错误");
                }
            }, error: function () {
                layer.alert("服务器异常，请稍后再试");
                return;
            }
        });
    });
});