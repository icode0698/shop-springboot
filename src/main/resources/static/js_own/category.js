$(function () {
    //ajax获取商品参数信息
    $.ajax({
        type: "post",
        url: "content/categoryAndBrand",
        dataType: "json",
        data: {
            type: "ajax_Category",
        },
        success: function (data) {
            // 初始化分类
            for (var i = 0; i < data.data.categoryList.length; i++) {
                var content = '<label id="label_category' + i + '" for="radio_category' + i + '" class="btn btn-default btn_margin">' + data.data.categoryList[i].categoryName + '</label>' +
                    '<input type="radio" class="radio_display" name="category" id="radio_category' + i + '" value="' + data.data.categoryList[i].categoryID + '" />';
                $("#category").append(content);
            }
            // 初始化组件完成后为每个radio设置click事件
            $("#label_category").on("click", function () {
                for (var j = 0; j < data.data.categoryList.length; j++) {
                    $("#label_category" + j).removeClass("btn-primary");
                }
                $(this).addClass("btn-primary");
            });
            for (var i = 0; i < data.data.categoryList.length; i++) {
                $("#label_category" + i).on("click", function () {
                    $("#label_category").removeClass("btn-primary");
                    $("#label_category").addClass("btn-default");
                    for (var j = 0; j < data.data.categoryList.length; j++) {
                        $("#label_category" + j).removeClass("btn-primary");
                    }
                    $(this).addClass("btn-primary");
                });
            }
            // 初始化品牌
            for (var i = 0; i < data.data.brandList.length; i++) {
                var content = '<label id="label_brand' + i + '" for="radio_brand' + i + '" class="btn btn-default btn_margin">' + data.data.brandList[i].brandName + '</label>' +
                    '<input type="radio" class="radio_display" name="brand" id="radio_brand' + i + '" value="' + data.data.brandList[i].brandID + '" />';
                $("#brand").append(content);
            }
            // 初始化组件完成后为每个radio设置click事件
            $("#label_brand").on("click", function () {
                for (var j = 0; j < data.data.brandList.length; j++) {
                    $("#label_brand" + j).removeClass("btn-primary");
                }
                $(this).addClass("btn-primary");
            });
            for (var i = 0; i < data.data.brandList.length; i++) {
                $("#label_brand" + i).on("click", function () {
                    $("#label_brand").removeClass("btn-primary");
                    $("#label_brand").addClass("btn-default");
                    for (var j = 0; j < data.data.brandList.length; j++) {
                        $("#label_brand" + j).removeClass("btn-primary");
                    }
                    $(this).addClass("btn-primary");
                });
            }
            //确定组件加载完成后动态显示Price
            init();
            update();
        },
        error: function (data) {
            console.log("data_status:" + data.message);
        }
    });
    function init() {
        list();
    }
    function update() {
        $("input:radio[name='category']").change(function () {
            $("#tip").empty();
            $("#goods").empty();
            list();
        });
        $("input:radio[name='brand']").change(function () {
            $("#tip").empty();
            $("#goods").empty();
            list();
        });
    }
    function list() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "content/list",
            data: {
                categoryID: $("input:radio[name='category']:checked").val(),
                brandID: $("input:radio[name='brand']:checked").val(),
            }, success: function (data) {
                console.log(data);
                if (data.code == 200) {
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
});