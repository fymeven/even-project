<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title></title>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link rel="shortcut icon" href="/favicon.ico">
    <link href="/static/plugin/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/plugin/hplus/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" >
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">
    <link href="/static/plugin/hplus/plugins/jqTreeGrid/jquery.treegrid.css" rel="stylesheet">
    <link href="/static/plugin/hplus/js/plugins/iosSwitch/lc_switch.css" rel="stylesheet">
    <link href="/static/css/hieven.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="btn-group-toolbar">
            <a class="btn btn-primary" id="btn_flush"><i class="fa fa-refresh"></i>&nbsp;</a>
        <shiro:hasPermission name="auth:add">
            <a class="btn btn-info" id="btn_add"><i class="fa fa-plus"></i>&nbsp;新增</a>
        </shiro:hasPermission>
    </div>
    <div>
        <table id="jqTreeGrid" data-mobile-responsive="true"></table>
    </div>
</div>
<script src="/static/plugin/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/plugin/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/plugin/hplus/js/plugins/layer/layer.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/toastr/toastr.min.js"></script>
<script src="/static/plugin/hplus/plugins/jqTreeGrid/jquery.treegrid.min.js"></script>
<script src="/static/plugin/hplus/plugins/jqTreeGrid/jquery.treegrid.extension.js"></script>
<script src="/static/js/evenPack.js"></script>
<script>
    //权限管理所有权限
    var perms={
        auth_add:false,
        auth_edit:false,
        auth_delete:false
    };
</script>
<shiro:hasPermission name="auth:add">
    <script>
        perms.auth_add=true
    </script>
</shiro:hasPermission>
<shiro:hasPermission name="auth:edit">
    <script>
        perms.auth_edit=true
    </script>
</shiro:hasPermission>
<shiro:hasPermission name="auth:delete">
    <script>
        perms.auth_delete=true
    </script>
</shiro:hasPermission>
<script src="/static/js/admin/auth/page.js"></script>
</body>
</html>
