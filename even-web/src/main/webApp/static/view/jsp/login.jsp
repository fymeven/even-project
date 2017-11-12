<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <title>后台登录</title>
    <link href="/static/plugin/superui-master/content/ui/css/layout.css" rel="stylesheet" />
    <link href="/static/plugin/superui-master/content/ui/css/login.css" rel="stylesheet"/>
</head>

<body class="login-bg">
<div class="main ">
    <!--登录-->
    <div class="login-dom login-max">
        <div class="logo text-center">
            <a href="javascript:void(0);">
                <img src="/static/plugin/superui-master/content/ui/img/logo.png" width="180px" height="180px" />
            </a>
        </div>
        <div class="login container ">
            <p class="text-big text-center logo-color">
                同一个账号，连接一切
            </p>

            <p class="text-center margin-small-top logo-color text-small">
               even 后台管理
            </p>
            <form id="login_form" class="login-form"  method="post" autocomplete="off">
                <div class="login-box border text-small" id="box">
                    <div class="name border-bottom">
                        <input type="text" placeholder="登录账号" id="userName" name="userName" datatype="*" nullmsg="请填写登录账号" />
                    </div>
                    <div class="pwd">
                        <input type="password" placeholder="登录密码" datatype="*" id="userPwd" name="userPwd" nullmsg="请填写登录密码" />
                    </div>
                </div>
                <input type="button" id="login_btn" class="btn text-center login-btn" value="立即登录" />
            </form>
            <div class="forget">
                <%--<a href="#" class="forget-pwd text-small fl"> 忘记登录密码？</a><a href="#" class="forget-new text-small fr" id="forget-new">注册账号</a>--%>
            </div>
        </div>
    </div>
    <div class="footer text-center text-small ie">
        Copyright 2013-2016 版权所有 ©tzhsweet 2015-2018      <a href="#" target="_blank">粤ICP备16024545号-1</a>
        <span class="margin-left margin-right">|</span>
    </div>
    <div class="popupDom">
        <div class="popup text-default">
        </div>
    </div>
</div>
</body>

<script src="/static/plugin/superui-master/content/ui/global/jQuery/jquery.min.js"></script>
<script src="/static/plugin/superui-master/content/ui/global/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/plugin/superui-master/content/min/js/supershopui.common.js"></script>
<script type="text/javascript">
    $(function(){
        $('#login_btn').click(function(){
            $('#login_form').ajaxSubmit({
                url:'/system/login',
                success:function(result){
                    console.info(result);
                }
            });
        });
    });
</script>
</html>