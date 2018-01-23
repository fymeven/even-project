<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>编辑角色</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="/static/plugin/hplus/favicon.ico">
    <link href="/static/plugin/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/css/hieven.css" rel="stylesheet">
</head>
<body>
<div class="wrapper wrapper-content  animated fadeInRight">
<form class="form-horizontal m-t" novalidate="novalidate" action="/sysRole/edit">
<input type="hidden" id="id" name="id" value="${detail.id}">
<div class="form-group">
<label class="col-sm-3 control-label">角色名称：</label>
<div class="col-sm-8">
<input id="roleName" name="roleName" class="form-control" type="text" autocomplete="off" value="${detail.roleName}">
</div>
</div>
<div class="form-group">
<label class="col-sm-3 control-label">角色状态：</label>
<div class="col-sm-8">
    <div class="switch">
        <div class="onoffswitch">
            <input type="checkbox" class="onoffswitch-checkbox" id="status" name="status" <c:if test="${detail.status == 1}">checked</c:if>>
            <label class="onoffswitch-label" for="status">
                <span class="onoffswitch-inner"></span>
                <span class="onoffswitch-switch"></span>
            </label>
        </div>
    </div>
</div>
</div>
<div class="form-group">
<label class="col-sm-3 control-label">角色描述：</label>
<div class="col-sm-8">
<textarea id="roleDesc" name="roleDesc" class="form-control" autocomplete="off">${detail.roleDesc}</textarea>
</div>
</div>
</form>
</div>
<script src="/static/plugin/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/plugin/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/plugin/hplus/js/plugins/layer/layer.min.js"></script>
<script src="/static/plugin/hplus/js/content.min.js?v=1.0.0"></script>
<script src="/static/plugin/hplus/js/plugins/toastr/toastr.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/validate/jquery.validate.min.js"></script>
<script src="/static/js/evenPack.js"></script>
<script src="/static/js/admin/role/edit.js"></script>
</body>
</html>
