$(function () {
    layui.use(['layer', 'table'], function () {
        var layer = layui.layer
            , table = layui.table;
        getOrder();
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
            reloadOrder($("#orderid").val(),$("#user").val());
        });
        function getOrder(){
            table.render({
                elem: '#order-select-table'
                ,url:'../order/select'
                ,method: 'post'
                ,cellMinWidth: 80 
                ,id: 'order-select-table-reload'
                ,cols: [[
                  {field:'id', title: '订单编号', width: 150, sort: true}
                  ,{field:'user', title: '所属用户', sort: true} 
                  ,{field:'goodsName', title: '所购商品', sort: true}
                  ,{field:'sku', title: '商品SKU', sort: true}
                  ,{field:'categoryName', title: '商品分类'}
                  ,{field:'brandName', title: '品牌名称', width: 120}
                  ,{field:'storage', title: '存储容量'} 
                  ,{field:'color', title: '外观颜色'}
                  ,{field:'screen', title: '屏幕尺寸'}
                  ,{field:'unitPrice', title: '价格', sort: true}
                  ,{field:'num', title: '数量', width:80, sort: true}
                  ,{field:'totalPrice', title: '总计', sort: true}
                  ,{field:'pay', title: '支付', sort: true}
                  ,{field:'createTime', title: '创建时间', width: 160, sort: true}
                  ,{field:'paymentTime', title: '支付时间', width: 160, sort: true}
                ]]
                ,parseData: function(res){
                    for (let i = 0; i < res.data.list.length; i++) {
                        if(res.data.list[i].isPay == true){
                            res.data.list[i].pay = '已支付';
                        }
                        else{
                            res.data.list[i].pay = '未支付';
                        }
                    }
                    return {
                        "code": res.code, //解析接口状态
                        "msg": res.message, //解析提示文本
                        "count": res.data.count, //解析数据长度
                        "data": res.data.list //解析数据列表
                    };
                }
                ,page: {
                    limit: 20,
                    limits: [10,20,30,40,50]
                }
                ,response:{
                    statusCode: 200
                }
            });
        }
        function reloadOrder(id, user){
            table.reload('sku-select-table-reload',{
                where: { //设定异步数据接口的额外参数
                    id: id
                    ,user: user
                  }
                  ,page: {
                    curr: 1 //重新从第1页开始
                  }
            });
        }
        function getOrderOrigin(value,user){
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