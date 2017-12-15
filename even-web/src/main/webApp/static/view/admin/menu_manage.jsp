<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>hieven后台管理</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="/static/plugin/hplus/favicon.ico">
    <link href="/static/plugin/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/plugin/hplus/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" >
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">
    <link href="/static/css/menu.css" rel="stylesheet">

</head>
<body class="gray-bg"><div class="wrapper wrapper-content  animated fadeInRight">
<div class="row layout">
<div class="col-sm-3" style="padding-right: 0px;">
<div class="layout-left">
    <div class="layout_title">功能目录</div>
    <div id="jstree"></div>
</div>
</div>
<div class="col-sm-9">
<div class="layout-right">
    <div class="layout_title">功能信息</div>
    <div class="table_operate">
        <div class="btn-group">
            <a class="btn btn-white" id="btn_flush"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
            <a class="btn btn-white" id="btn_add"><i class="fa fa-plus"></i>&nbsp;新增</a>
            <a class="btn btn-white" id="btn_edit"><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a>
            <a class="btn btn-white" id="btn_delete"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
        </div>
    </div>
    <div>
        <table id="jqGrid"></table>
        <div id="pager"></div>
    </div>
</div>
</div>
</div>
</div>


<script src="/static/plugin/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/plugin/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/plugin/hplus/js/plugins/layer/layer.min.js"></script>
<script src="/static/plugin/hplus/js/content.min.js?v=1.0.0"></script>
<script src="/static/plugin/hplus/plugins/jstree/dist/jstree.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/toastr/toastr.min.js"></script>
<script src="/static/plugin/hplus/js/plugins/jqgrid/i18n/grid.locale-cnffe4.js?0820"></script>
<script src="/static/plugin/hplus/js/plugins/jqgrid/jquery.jqGrid.minffe4.js?0820"></script>
<script src="/static/js/menu.js"></script>
<script>
    $(function() {
        menu.init();
    });
</script>
</body>
</html>
