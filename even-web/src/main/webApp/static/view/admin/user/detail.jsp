<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>用户详情</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="/static/plugin/hplus/favicon.ico">
    <link href="/static/plugin/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/js/plugins/iosSwitch/lc_switch.css" rel="stylesheet">
    <link href="/static/css/hieven.css" rel="stylesheet">
</head>
<body>
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="feed-element">
        <div class="feed-group">
            <label class="feed"><img alt="image" class="img-circle" src="${detail.userPhoto}"></label>
            <span class="feed"><strong>${detail.realName}</strong></span>
        </div>
        <div class="feed-group">
            <label class="feed">账号：</label><span class="feed">${detail.userName}</span>
        </div>
        <div class="feed-group">
            <label class="feed">邮箱：</label><span class="feed">${detail.email}</span>
        </div>
        <div class="feed-group">
            <label class="feed">性别：</label><span class="feed"><c:choose><c:when test="${detail.sex==1}">男</c:when><c:otherwise>女</c:otherwise></c:choose></span>
        </div>
        <div class="feed-group">
            <label class="feed">电话：</label><span class="feed">${detail.userMobile}</span>
        </div>
        <div class="feed-group">
            <label class="feed">所属部门：</label><span class="feed">${detail.deptName}</span>
        </div>
        <div class="feed-group">
            <label class="feed">状态：</label><span class="feed">${detail.status}</span>
        </div>
        <div class="feed-group">
            <label class="feed">上次登录时间：</label><span class="feed"><fmt:formatDate value="${detail.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
        </div>
        <div class="feed-group">
            <label class="feed">上次登录ip：</label><span class="feed">${detail.lastLoginIp}</span>
        </div>
    </div>
</div>
<script src="/static/plugin/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/plugin/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/plugin/hplus/js/plugins/layer/layer.min.js"></script>
<script src="/static/plugin/hplus/js/content.min.js?v=1.0.0"></script>
<script src="/static/plugin/hplus/js/plugins/toastr/toastr.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/validate/jquery.validate.min.js"></script>
<script src="/static/js/evenPack.js"></script>
</body>
</html>
