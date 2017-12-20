<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="/static/plugin/hplus/js/plugins/iosSwitch/lc_switch.css" rel="stylesheet">
    <link href="/static/css/hieven.css" rel="stylesheet">
</head>
<body class="gray-bg" onload="role.init()">
<div class="wrapper wrapper-content  animated fadeInRight">
    <div class="btn-group-toolbar">
            <a class="btn btn-primary" id="btn_flush"><i class="fa fa-refresh"></i>&nbsp;</a>
            <a class="btn btn-info" id="btn_add"><i class="fa fa-plus"></i>&nbsp;新增</a>
            <a class="btn btn-danger" id="btn_delete"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
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
<script src="/static/plugin/hplus/js/plugins/iosSwitch/js/lc_switch.min.js"></script>
<script src="/static/js/role.js"></script>
</body>
</html>
