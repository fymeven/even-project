﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/static/plugin/H-uiAdmin/lib/html5.js"></script>
    <script type="text/javascript" src="/static/plugin/H-uiAdmin/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="/static/plugin/H-uiAdmin/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="/static/plugin/H-uiAdmin/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="/static/plugin/H-uiAdmin/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="/static/plugin/H-uiAdmin/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="/static/plugin/H-uiAdmin/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->

    <title>角色管理</title>
    <meta name="keywords" content="H-ui.admin v3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="H-ui.admin v3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<!--top header-->
<jsp:include page="header.jsp"/>
<!--left menu-->
<jsp:include page="menu.jsp"/>
<!--right content -->
<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页<span class="c-gray en">&gt;</span>管理员管理<span class="c-gray en">&gt;</span>角色管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <div class="cl pd-5 bg-1 bk-gray mt-20">
                <span class="l"> <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="_add('添加管理员','/static/view/jsp/admin-add.jsp','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加角色</a> </span>
            </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-bg table-hover table-sort"></table>
            </div>
        </article>
    </div>
</section>
<script type="text/javascript" src="/static/plugin/H-uiAdmin/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/static/plugin/H-uiAdmin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/plugin/H-uiAdmin/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="/static/plugin/H-uiAdmin/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<script type="text/javascript" src="/static/plugin/H-uiAdmin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/static/plugin/H-uiAdmin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/static/plugin/H-uiAdmin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="/static/js/config.js"></script>
<script type="text/javascript">
    /*
     参数解释：
     title	标题
     url		请求的url
     id		需要操作的数据id
     w		弹出层宽度（缺省调默认值）
     h		弹出层高度（缺省调默认值）
     */
    /*管理员-增加*/
    function _add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*管理员-删除*/
    function _del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                url:'/sysUser/delete',
                data:{
                    "idList":id
                },
                success:function(result){
                    if(result.status){
                        layer.msg(result.msg,{icon:1,time:1000});
                        dataTable.ajax.reload();
                    }else{
                        layer.msg(result.msg,{icon:2,time:1000});
                    }
                }
            });
        });
    }
    /*管理员-编辑*/
    function _edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*管理员-停用*/
    function _stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            //此处请求后台程序，下方是成功后的前台处理……

            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }

    /*管理员-启用*/
    function _start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            //此处请求后台程序，下方是成功后的前台处理……

            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6,time:1000});
        });
    }

    var dataTable=$('.table-sort').DataTable({
        "aaSorting": [[ 1, "asc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "serverSide": true,//打开后台分页
        "bPaginate" : true, //是否显示（应用）分页器
        "bLengthChange":true, //改变每页显示数据数量
        "bSort": true, //排序功能
        "bInfo" : true, //是否显示页脚信息，DataTables插件左下角显示记录数
        "bFilter" : true, //是否启动过滤、搜索功能
        "bAutoWidth": true,//自动宽度
        "ajax":"/sysRole/page",
        "columns":[
            {
                "title":'<input type="checkbox" name="" value="">',
                "sClass": "text-c",
                "render": function (data, type, full, meta) {
                    return '<input type="checkbox"  class="checkchild"  value="' + data + '" />';
                },
                "width":"5%",
                "orderable": false
            },
            { "title":"ID","data": "id","defaultContent":'',"width":"5%","className": "text-c" },
            { "title":"角色名称","data": "roleName","defaultContent":'',"width":"15%","className": "text-c" },
            { "title":"描述","data": "roleDesc","defaultContent":'',"width":"50%","className": "text-c" },
            { "title":"状态","data": "roleStatus","defaultContent":'',"orderable": false,"width":"10%","className": "text-c",
                "render": function (data, type, full, meta) {
                    return sysConfig.enum.sysRole.roleStatus(data);
                }
            },
            { "title":"操作","data": "id","defaultContent":'',"orderable": false,"className": "text-c",
                "render":function(data, type, full, meta){
                    var html=[];
                    html.push('<a style="text-decoration:none" onClick="article_shenhe(this,\''+data+'\')" href="javascript:;" title="审核">审核</a>');
                    html.push('<a style="text-decoration:none" class="ml-5" onClick="article_edit(\'资讯编辑\',\'article-add.html\',\''+data+'\')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>');
                    html.push('<a style="text-decoration:none" class="ml-5" onClick="_del(this,\''+data+'\')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>');
                    return html.join('');
                }
            }
        ]
    });

    //columns.type:数据类型（ string, numeric, date ， html ）
</script>
</body>
</html>