$(function(){
    let val = $("#searchvalue").val();
    if(val!=''){
        init(val);
    }
    else{
        searchAll();
    }
    $("#search").on("click",function(){
        let value = $("#searchvalue").val();
        console.log(value);
        console.log(isNaN(value));
        if(value!=''){
            init(value);
        }
        else{
            searchAll();
        }
    });

    function searchAll(){
        $.ajax({
            type: "post",
            dataType: "json",
            url: "content/search",
            success: function (data) {
                console.log(data);
                if (data.code == 200) {
                    $("#tip").empty();
                    $("#goods").empty();
                    if(data.data.goodsList.length==0){
                        $("#tip").append("没有找到相关产品");
                    }
                    else{
                        $("#tip").append('<span style="margin-top:10px;margin-bottom:10px">为你找到<span style="font-size:18px;color:#01AAED;">'+data.data.goodsList.length+'件</span>符合的商品</span>');
                        for (var i = 0; i < data.data.goodsList.length; i++) {
                            var content = '<div class="col-sm-6 col-md-4 wow slideInUp">'
                                + '<div class="thumbnail">'
                                + '<img src="' + data.data.goodsList[i].imgList[0] + '" alt="">'
                                + '<div class="caption">'
                                + '<h3>' + data.data.goodsList[i].goodsName + '</h3>'
                                + '<p><a href="details.html?spu=' + data.data.goodsList[i].goodsID + '&goods=' + data.data.goodsList[i].goodsName + '" class="btn btn-primary" role="button" target="_blank">立即购买</a>'
                                + '</div>'
                                + '</div>';
                            $("#goods").append(content);
                        }
                    }
                }
                
            }, error: function () {
                $("#tip").append("服务器异常");
                console.log("服务器异常\n");
            }
        });
    }

    function init(value){
        if(isNaN(value)){
            $.ajax({
                type: "post",
                dataType: "json",
                url: "content/search",
                data: {
                    value: value
                }, success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        $("#tip").empty();
                        $("#goods").empty();
                        if(data.data.goodsList.length==0){
                            $("#tip").append("没有找到相关产品");
                        }
                        else{
                            $("#tip").append('<span style="margin-top:10px;margin-bottom:10px">为你找到<span style="font-size:18px;color:#01AAED;">'+data.data.goodsList.length+'件</span>符合的商品</span>');
                            for (var i = 0; i < data.data.goodsList.length; i++) {
                                var content = '<div class="col-sm-6 col-md-4 wow slideInUp">'
                                    + '<div class="thumbnail">'
                                    + '<img src="' + data.data.goodsList[i].imgList[0] + '" alt="">'
                                    + '<div class="caption">'
                                    + '<h3>' + data.data.goodsList[i].goodsName + '</h3>'
                                    + '<p><a href="details.html?spu=' + data.data.goodsList[i].goodsID + '&goods=' + data.data.goodsList[i].goodsName + '" class="btn btn-primary" role="button" target="_blank">立即购买</a>'
                                    + '</div>'
                                    + '</div>';
                                $("#goods").append(content);
                            }
                        }
                    }
                    
                }, error: function (data) {
                    $("#tip").append("服务器异常");
                    console.log("服务器异常\n" + data.code);
                }
            });
        }
        else{
            $.ajax({
                type: "post",
                dataType: "json",
                url: "content/search",
                data: {
                    id: value
                }, success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        $("#tip").empty();
                        $("#goods").empty();
                        if(data.data.goodsList.length==0){
                            $("#tip").append("没有找到相关产品");
                        }
                        else{
                            $("#tip").append('<span style="margin-top:10px;margin-bottom:10px">为你找到<span style="color:#01AAED;">'+data.data.goodsList.length+'件</span>符合的商品</span>');
                            for (var i = 0; i < data.data.goodsList.length; i++) {
                                var content = '<div class="col-sm-6 col-md-4 wow slideInUp">'
                                    + '<div class="thumbnail">'
                                    + '<img src="' + data.data.goodsList[i].imgList[0] + '" alt="">'
                                    + '<div class="caption">'
                                    + '<h3>' + data.data.goodsList[i].goodsName + '</h3>'
                                    + '<p><a href="details.html?spu=' + data.data.goodsList[i].goodsID + '&goods=' + data.data.goodsList[i].goodsName + '" class="btn btn-primary" role="button" target="_blank">立即购买</a>'
                                    + '</div>'
                                    + '</div>';
                                $("#goods").append(content);
                            }
                        }
                    }
                    
                }, error: function () {
                    $("#tip").append("服务器异常");
                    console.log("服务器异常\n");
                }
            });
        }
    }
});