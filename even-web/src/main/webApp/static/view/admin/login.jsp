<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <title>系统登录</title>
    <link href="/static/plugin/superui-master/content/ui/css/layout.css" rel="stylesheet" />
    <link href="/static/plugin/superui-master/content/ui/css/login.css" rel="stylesheet"/>
    <style>
        .ibar {
            display: none;
        }
    </style>
</head>

<body class="login-bg">
    <div class="main ">
        <!--登录-->
        <div class="login-dom login-max">
            <div class="logo text-center">
                <a href="#">
                    <img src="/static/plugin/superui-master/content/ui/img/logo.png" width="180px" height="180px" />
                </a>
            </div>
            <div class="login container " id="login">
                <p class="text-big text-center logo-color">
                    同一个账号，连接一切
                </p>

                <p class="text-center margin-small-top logo-color text-small">
                  SuperUI框架
                </p>
                <form id="login_form" class="login-form" method="post" autocomplete="off">
                    <div class="login-box border text-small" id="box">
                        <div class="name border-bottom">
                            <input type="text" placeholder="账号" id="userName" name="userName" datatype="*" nullmsg="请填写帐号信息" />
                        </div>
                        <div class="pwd">
                            <input type="password" placeholder="密码" datatype="*" id="userPwd" name="userPwd" nullmsg="请填写帐号密码" />
                        </div>
                    </div>
                    <input type="submit" class="btn text-center login-btn" value="立即登录" />
                </form>
                <div class="forget">
                   
                </div>
            </div>
        </div>
        <div class="footer text-center text-small ie">
            Copyright 2013-2016 版权所有 ©tzhsweet 2015-2018      <a href="#" target="_blank">粤ICP备16024545号-1</a>
            <span class="margin-left margin-right">|</span>
            <script src="#" language="JavaScript"></script>
        </div>
        <div class="popupDom">
            <div class="popup text-default">
            </div>
        </div>
    </div>
</body>

<script src="/static/plugin/superui-master/content/ui/global/jQuery/jquery.min.js"></script>
<script type="text/javascript">
    $('#login_form').ajaxSubmit({
        url:'/system/userLogin',
        type:'post',
        success:function(result){
            if(result.stauts){
                location.href="/static/view/admin/login.jsp";
            }else{
                alert(result.msg)
            }
        }
    });
</script>
</html>