<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>HiEven 后台管理 - 登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link href="/static/plugin/hplus/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/login.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ HiEven ]</h1>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
                <form id="login_form" method="post">
                    <input type="text" id="userName" name="userName" class="form-control uname m-b" placeholder="用户名" />
                    <input type="password" id="userPwd" name="userPwd" class="form-control pword m-b" placeholder="密码" />
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" class="checkbox" id="remeberMe">记住密码？
                        </label>
                    </div>
                    <input type="submit" id="login_btn" class="btn btn-success btn-block" value="loginNow!"/>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; even
            </div>
        </div>
    </div>
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/plugin/hplus/js/plugins/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/plugin/hplus/js/plugins/toastr/toastr.min.js"></script>
<script>
    $(function(){
    var login={
        init:function(){
            var e = "<i class='fa fa-times-circle'></i> ";
            $("#login_form").validate({
                rules: {
                    userName: {
                        required: true,
                        minlength: 4
                    },
                    userPwd: {
                        required: true,
                        minlength: 3,
                        maxlength:20
                    }
                },
                messages: {
                    userName: {
                        required: e + "请输入您的用户名",
                        minlength: e + "用户名至少4个字符"
                    },
                    userPwd: {
                        required: e + "请输入您的密码",
                        minlength: e + "密码至少3个字符",
                        maxlength: e + "密码最多20个字符"
                    }
                },
                submitHandler:function(form){
                    $.ajax({
                        url:'/login/userLogin',
                        type:'POST',
                        data:{
                            userName:$('#userName').val(),
                            userPwd:$('#userPwd').val(),
                            remeberMe:$('#remeberMe').is(":checked")
                        },
                        success:function(result){
                            if(result.status){
                                location.href="/page/main";
                            }else{
                                toastr.warning(result.msg);
                            }
                        }
                    });
                }
            })
        }
    }
    login.init();
    });
</script>
</body>
</html>