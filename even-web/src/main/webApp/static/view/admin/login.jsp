<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>HiEven 后台管理 - 登录</title>
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

<body class="signin" onload="login.init()">
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
                    <input type="text" id="userName" name="userName" class="form-control uname m-b" placeholder="用户名" autocomplete="off" value="admin" />
                    <input type="password" id="userPwd" name="userPwd" class="form-control pword m-b" placeholder="密码" autocomplete="off" value="123"/>
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
<script src="/static/js/jquery.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/validate/jquery.validate.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/toastr/toastr.min.js"></script>
<script src="/static/js/login.js"></script>
</body>
</html>