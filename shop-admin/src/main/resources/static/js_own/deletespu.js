$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        let origin = '';
        $("#spu").bind("input propertychange", function () {
            if (isNaN($("#spu").val())) {
                $("#spu").val(origin);
            }
            else {
                origin = $("#spu").val();
            }
        });
        $("#order").on("click",function(){
            if($("#spu").val()==''){
                layer.alert("请先输入信息", { icon: 3 });
            }
            else{
                getSkuInfo();
            }
        });
        $("#ensure").on("click",function(){
            layer.confirm("确定要删除这件商品吗？", {
                icon: 3,
                btn: ["确定删除", "再看看"]
            }, function () {
                $.ajax({
                    type: "post",
                    dataType: "json",
                    url: "../spu/delete",
                    data: {
                        message: "deleteSpu",
                        spu: $("#spu").val()
                    }, success: function (data) {
                        console.log(data);
                        if (data.code == 200) {
                            getSkuInfo();
                            layer.alert(data.message, { icon: 1 });
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
            }, function () {});
        });
        function getSkuInfo(){
            $.ajax({
                type: "post",
                dataType: "json",
                url: "../sku/select",
                data: {
                    message: "skuBelong",
                    spu: $("#spu").val()
                }, success: function (data) {
                    $("#deleteinfo").css("display","");
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