$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        getOrder($("#orderid").val(),$("#user").val());
        let origin = '';
        $("#orderid").bind("input propertychange",function(){
            console.log("orderidout"+origin);
            if(isNaN($("#orderid").val())){
                $("#orderid").val(origin);
            }
            else{
                origin = $("#orderid").val();
                console.log("orderid"+origin);
            }
        });
        $("#order").on("click",function(){
            getOrder($("#orderid").val(),$("#user").val());
        });
        function getOrder(value,user){
            $.ajax({
                type: "post",
                dataType: "json",
                url: "../order/select",
                data: {
                    message: "selectOrder",
                    id: value,
                    user: user
                }, success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        $("#trs").empty();
                        for (let i = 0; i < data.data.length; i++) {
                            var pay;
                            var paymentTime;
                            if(data.data[i].isPay==true){
                                pay="已支付";
                                paymentTime=data.data[i].paymentTime;
                            }
                            else{
                                pay="未支付" ;
                                paymentTime="暂无";
                            }
                            let content = '<tr><td>'+data.data[i].id+'</td><td>'+data.data[i].user+'</td><td>'+data.data[i].goodsName+'</td><td>'+data.data[i].sku+'</td>'
                                +'<td>'+data.data[i].categoryName+'</td><td>'+data.data[i].brandName+'</td><td>'+data.data[i].storage+'</td><td>'+data.data[i].color+'</td><td>'+data.data[i].screen+'</td>'
                                +'<td><span>￥</span>'+data.data[i].unitPrice.toFixed(2)+'</td><td>'+data.data[i].num+'</td><td><span>￥</span>'+data.data[i].totalPrice.toFixed(2)+'</td>'
                                +'<td>'+pay+'</td><td>'+data.data[i].createTime+'</td><td>'+paymentTime+'</td></tr>';
                            $("#trs").append(content);
                        }
                        table.init('order', {
                            page: true
                            , limit: 20
                            , cellMinWidth: 40
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