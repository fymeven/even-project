<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>角色管理</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="/static/plugin/hplus/favicon.ico">
    <link href="/static/plugin/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">
    <link href="/static/css/hieven.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <form class="form-horizontal m-t" novalidate="novalidate">
        <div class="form-group">
            <label class="col-sm-2 control-label">角色名称：</label>
            <div class="col-sm-4">
                <input type="text" name="search_roleName" id="search_roleName" placeholder="请输入角色名称" class="form-control">
            </div>
            <a class="btn btn-info" id="btn_search"><i class="fa fa-search"></i>&nbsp;搜索</a>
        </div>
    </form>
    <div class="btn-group-toolbar">
            <a class="btn btn-primary" id="btn_flush" title="刷新"><i class="fa fa-refresh"></i>&nbsp;</a>
        <shiro:hasPermission name="role:add">
            <a class="btn btn-white" id="btn_add" title="添加角色"><i class="fa fa-plus"></i>&nbsp;新增</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="role:delete">
            <a class="btn btn-danger" id="btn_delete" title="删除角色"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
        </shiro:hasPermission>
    </div>
    <div>
        <table id="jqGrid"></table>
        <div id="pager"></div>
    </div>
</div>
<script src="/static/plugin/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/plugin/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/plugin/hplus/js/plugins/layer/layer.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/toastr/toastr.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/jqgrid/i18n/grid.locale-cnffe4.js?0820"></script>
<script src="/static/plugin/hplus/js/plugins/jqgrid/jquery.jqGrid.minffe4.js?0820"></script>
<script src="/static/js/evenPack.js"></script>
<script>
    //角色管理所有权限
    var perms={
        role_auth:false,
        role_edit:false,
        role_delete:false
    };
</script>
<shiro:hasPermission name="role:auth">
    <script>
        perms.role_auth=true
    </script>
</shiro:hasPermission>
<shiro:hasPermission name="role:edit">
    <script>
        perms.role_edit=true
    </script>
</shiro:hasPermission>
<shiro:hasPermission name="role:delete">
    <script>
        perms.role_delete=true
    </script>
</shiro:hasPermission>
<script src="/static/js/admin/role/page.js"></script>
</body>
</html>
