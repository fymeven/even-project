<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>添加角色</title>

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
<form class="form-horizontal m-t" novalidate="novalidate" action="/department/edit">
<input type="hidden" id="id" name="id" value="${detail.id}">
<div class="form-group">
<label class="col-sm-3 control-label">部门名称：</label>
<div class="col-sm-8">
<input id="deptName" name="deptName" class="form-control" type="text" autocomplete="off" value="${detail.deptName}">
</div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label">上级部门：</label>
    <div class="col-sm-8">
        <input id="parentId" name="parentId" type="hidden" value="${detail.parentId}">
        <input id="parentName" name="parentName" class="form-control" type="text" autocomplete="off" disabled value="${detail.parentName}">
    </div>
</div>
<div class="form-group">
    <label class="col-sm-3 control-label">部门负责人：</label>
    <div class="col-sm-8">
        <div class="input-group">
            <input type="text" class="form-control" id="deptManagerId" name="deptManagerId" autocomplete="off" data-id="${detail.deptManagerId}" value="${detail.deptManagerName}">
            <div class="input-group-btn">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="">
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
            </div>
        </div>
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
<script src="/static/plugin/hplus/js/plugins/suggest/bootstrap-suggest.min.js"></script>
<script src="/static/js/evenPack.js"></script>
<script src="/static/js/admin/dept/edit.js"></script>
</body>
</html>
