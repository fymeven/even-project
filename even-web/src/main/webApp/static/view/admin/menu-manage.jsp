<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>H+ 后台主题UI框架 - 主页</title>

    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="/static/plugin/hplus/favicon.ico">
    <link href="/static/plugin/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg"><div class="wrapper wrapper-content  animated fadeInRight">
<div class="row">
<div class="col-sm-4">
    <div class="ibox ">
        <div id="jstree"></div>
    </div>
</div>
<div class="col-sm-8">
<div class="ibox">
<div class="ibox-content"></div>
</div>
</div>
</div>
</div>


<script src="/static/plugin/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="/static/plugin/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="/static/plugin/hplus/js/plugins/layer/layer.min.js"></script>
<script src="/static/plugin/hplus/js/content.min.js?v=1.0.0"></script>
<script src="/static/plugin/hplus/js/plugins/jsTree/jstree.min.js"></script>
<script>
    $(function() {
        $('#container').jstree({
            "plugins" : ["checkbox"],
            'core' : {
                'data' : {
                    "url" : "/sysMenu/",
                    "dataType" : "json" // needed only if you do not supply JSON headers
                }
            }
        });
    });
</script>
</body>
</html>
