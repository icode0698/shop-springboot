$(function () {
    let filePath = '';
    layui.use(['layer',  'form', 'upload'], function () {
        var layer = layui.layer
            , form = layui.form
            , upload = layui.upload;
        $.ajax({
            type: "post",
            dataType: "json",
            url: "../spu/now",
            success: function (data) {
                if (data.code == 200) {
                    $("#now").text(data.data.spuNow);
                    $("#spu").val(parseInt(data.data.spuNow)+1);
                    for(let i=0;i<data.data.brandList.length;i++){
                        $("#brandlist").append('<option value="'+data.data.brandList[i].brandID+'">'+data.data.brandList[i].brandName+'</option>');
                    }
                    for(let i=0;i<data.data.categoryList.length;i++){
                        $("#categorylist").append('<option value="'+data.data.categoryList[i].categoryID+'">'+data.data.categoryList[i].categoryName+'</option>');
                    }
                    form.render('select');
                    for(let i=0;i<data.data.storageList.length;i++){
                        $("#storagediv").append('<input type="checkbox" lay-filter="storage" value="'+data.data.storageList[i].valueID+'" name="storage" lay-skin="primary" title="'+data.data.storageList[i].value+'">');
                    }
                    for(let i=0;i<data.data.colorList.length;i++){
                        $("#colordiv").append('<input type="checkbox" lay-filter="color" value="'+data.data.colorList[i].valueID+'" name="color" lay-skin="primary" title="'+data.data.colorList[i].value+'">');
                    }
                    for(let i=0;i<data.data.screenList.length;i++){
                        $("#screendiv").append('<input type="checkbox" lay-filter="screen" value="'+data.data.screenList[i].valueID+'" name="screen" lay-skin="primary" title="'+data.data.screenList[i].value+'">');
                    }
                    form.render('checkbox');
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
        $("#pic").focus(function(){
            $.ajax({
                type: "post",
                dataType: "json",
                url: "../spu/now/img",
                success: function (data) {
                    console.log(data);
                    if (data.code == 200) {
                        console.log(data);
                        $("#pictipdiv").css("display","");
                        $("#picidtip").text(data.data);
                        $("#pic").val(parseInt(data.data)+1);
                    }
                }, error: function (data) {
                    console.log(data);
                    layer.alert("服务器异常，请稍后再试", {icon:2});
                    return;
                }
            });
        });
        upload.render({
            elem: '#choose'
            ,url: '../upload/goods'
            ,data: {
                id: function(){
                    return $("#pic").val();
                }
                ,spu: function(){
                    return $("#spu").val();
                }
            }
            ,auto: true
            , choose: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $("#pictip").text(file.name);
                    $('#demo').attr('src', result); //图片链接（base64）
                    console.log(file);
                });
            }
            , done: function (data) {
                if(data.code==200){
                    console.log('上传成功');
                    filePath = data.data.filePath;
                }
                if (data.code == 500) {
                    console.log('上传失败，请稍候再试');
                }
            }
            , error: function () {
                console.log('上传失败，请稍候再试');
            }
        });
        form.on('submit(ensure)', function (res) {
            // console.log(res.field);
            layer.load();
            let storageList = [];
            let colorList = [];
            let screenList = [];
            $.each($("input:checkbox[name='storage']:checked"), function () {
                storageList.push($(this).attr("value"));
            });
            $.each($("input:checkbox[name='color']:checked"), function () {
                colorList.push($(this).attr("value"));
            });
            $.each($("input:checkbox[name='screen']:checked"), function () {
                screenList.push($(this).attr("value"));
            });
            console.log(storageList);
            console.log(colorList);
            console.log(screenList);
            $.ajax({
                type: "post",
                dataType: "json",
                url: "../spu/insert",
                data: {
                    goodsID: $("#spu").val(),
                    goodsName: $("#name").val(),
                    brandID: ""+res.field.brand,
                    categoryID: ""+res.field.category,
                    imgID: ""+res.field.pic,
                    storageList: JSON.stringify(storageList),
                    colorList: JSON.stringify(colorList),
                    screenList: JSON.stringify(screenList),
                    imgSrc: filePath
                }, success: function (data) {
                    console.log(data);
                    layer.closeAll('loading');
                    if (data.code == 200) {
                        layer.alert(data.message, {icon:1}, function () { location.href="";});
                        return false;
                    }
                    if (data.code == 500) {
                        layer.alert(data.message, {icon:2});
                        return false;
                    }
                }, error: function (data) {
                    console.log(data);
                    layer.alert("服务器异常，请稍后再试", {icon:2});
                    return;
                }
            });
            return false;
        });
    });
});