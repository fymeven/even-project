<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>添加菜单</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="/favicon.ico">
    <link href="/static/plugin/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
    <link href="/static/css/hieven.css" rel="stylesheet">

</head>
<body>
<div class="wrapper wrapper-content  animated fadeInRight">
<form class="form-horizontal m-t" novalidate="novalidate" action="/sysAuth/add">
<div class="form-group">
<label class="col-sm-3 control-label">权限名称：</label>
<div class="col-sm-8">
<input id="authName" name="authName" class="form-control" type="text" autocomplete="off">
</div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label">上级权限：</label>
    <div class="col-sm-8">
        <input id="parentId" name="parentId" type="hidden" value="${parent.id}">
        <input id="parentName" name="parentName" class="form-control" type="text" autocomplete="off" disabled value="${parent.authName}">
    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label">权限标识：</label>
    <div class="col-sm-8">
        <input id="perms" name="perms" class="form-control" type="text" autocomplete="off">
    </div>
</div>
<div class="form-group">
<label class="col-sm-3 control-label">图标：</label>
<div class="col-sm-8">
    <input id="icon" name="icon" class="form-control" type="text" autocomplete="off">
    <i class="input-button selectmoduleicon" title="选取图标">...</i>
</div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label">类型：</label>
    <div class="col-sm-8">
        <div class="radio radio-success radio-inline">
            <input type="radio" id="type1" value="1" name="type" <c:if test="${ empty parent.type || parent.type == 1}">checked</c:if><c:if test="${parent.type == 2}">disabled</c:if>>
            <label for="type1"> 目录 </label>
        </div>
        <div class="radio radio-primary radio-inline">
            <input type="radio" id="type2" value="2" name="type" <c:if test="${ parent.type == 2}">checked</c:if>>
            <label for="type2"> 菜单 </label>
        </div>
        <div class="radio radio-warning radio-inline">
            <input type="radio" id="type3" value="3" name="type" <c:if test="${ empty parent.type || parent.type == 1}">disabled</c:if>>
            <label for="type3"> 按钮 </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label">菜单地址：</label>
    <div class="col-sm-8">
        <input id="linkUrl" name="linkUrl" class="form-control" type="text" autocomplete="off" disabled>
    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label">状态：</label>
    <div class="col-sm-8">
        <div class="switch">
            <div class="onoffswitch">
                <input type="checkbox" checked class="onoffswitch-checkbox" id="status" name="status">
                <label class="onoffswitch-label" for="status">
                    <span class="onoffswitch-inner"></span>
                    <span class="onoffswitch-switch"></span>
                </label>
            </div>
        </div>
    </div>
</div>
<div class="form-group">
<label class="col-sm-3 control-label">描述：</label>
<div class="col-sm-8">
<textarea id="authDesc" name="authDesc" class="form-control" autocomplete="off"></textarea>
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
<script src="/static/js/admin/auth/add.js"></script>
</body>
</html>
