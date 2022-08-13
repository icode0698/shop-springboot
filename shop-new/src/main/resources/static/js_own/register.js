$(function () {
    let filePath = '';
    layui.use(['layer', 'form', 'upload'], function () {
        var layer = layui.layer
            , form = layui.form
            , upload = layui.upload;
        form.verify({
            username: function (value) {
                if (/^\s+/.test(value)) {
                    return '不能有连续的空格';
                }
            }
            , nickname: function (value) {
                if (/^\s+/.test(value)) {
                    return '不能有连续的空格';
                }
            }
            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            , pass: [
                /^[\S]{6,20}$/
                , '6到20位字符，不能有空格'
            ]
            , same: function () {
                if ($("#repass").val() != $("#pass").val()) {
                    return "两次密码输入不一致";
                }
            }
        });
        upload.render({
            elem: '#choose'
            , url: 'upload/user'
            , data: {
                user: user
                , id: $("#pic").val()
                , spu: $("#spu").val()
            }
            , auto: true
            , choose: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $("#pictip").text(file.name);
                    $('#demo').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (data) {
                if (data.code == 200) {
                    filePath = data.data.filePath;
                    console.log('上传成功');
                }
                if (data.code == 500) {
                    console.log('上传失败，请稍候再试');
                }
            }
            , error: function () {
                console.log('上传失败，请稍候再试');
            }
        });
        form.on('submit(ensure)', function (data) {
            console.log(filePath);
            $.ajax({
                type: "post",
                dataType: "json",
                url: "user/register",
                data: {
                    user: data.field.user,
                    nickName: data.field.nickname,
                    password: data.field.pass,
                    headPic: filePath
                }, success: function (data) {
                    if (data.code == 200) {
                        layer.confirm(data.message, {
                            icon: 1,
                            btn: ["前往登录", "浏览首页"]
                        }, function () {
                            location.href = 'login.html';
                        }, function () {
                            location.href = 'index.html';
                        });
                    } else {
                        layer.alert(data.message, {icon: 2});
                    }
                }, error: function () {
                    console.log("服务器异常\n");
                    return;
                }
            });
            return false;
        });
    });
});