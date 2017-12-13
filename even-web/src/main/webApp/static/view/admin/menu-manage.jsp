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
    <link href="/static/plugin/hplus/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet" >
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/css/menu.css" rel="stylesheet">
</head>
<body class="gray-bg"><div class="wrapper wrapper-content  animated fadeInRight">
<div class="row layout">
<div class="col-sm-3">
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
            <a class="btn btn-white active" id="btn-view"><i class="fa fa-eye"></i>&nbsp;查看</a>
            <a class="btn btn-white" id="btn-add"><i class="fa fa-plus"></i>&nbsp;新增</a>
            <a class="btn btn-white" id="btn-edit"><i class="fa fa-pencil-square-o"></i>&nbsp;编辑</a>
            <a class="btn btn-white" id="btn-delete"><i class="fa fa-trash-o"></i>&nbsp;删除</a>
        </div>
    </div>
    <div>
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
                <form class="form-horizontal m-t" id="signupForm" novalidate="novalidate">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">菜单名称：</label>
                        <div class="col-sm-8">
                            <input id="menuName" name="menuName" class="form-control" type="text" disabled>
                            <%--<span class="help-block m-b-none"><i class="fa fa-info-circle"></i> 这里写点提示的内容</span>--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">图标：</label>
                        <div class="col-sm-8">
                            <div id="menuIcon"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">菜单地址：</label>
                        <div class="col-sm-8">
                            <input id="menuUrl" name="menuUrl" class="form-control" type="text" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">父级菜单：</label>
                        <div class="col-sm-8">
                            <input id="parentMenuName" class="form-control" type="text" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">菜单描述：</label>
                        <div class="col-sm-8">
                            <textarea id="menuDesc" name="menuDesc" class="form-control" disabled></textarea>
                        </div>
                    </div>
                </form>
            </div>
        </div>
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
<script src="/static/plugin/hplus/js/plugins/dataTables/jquery.dataTables.js"></script>
<script>
    var menu={
        jstree:{},//jstree对象
        btn:$('.btn'),
        init:function(){
            this.loadJstree();
            this.operate();
        },
        loadJstree:function(){
            var $menu=this;
            $.ajax({
                url:'/sysMenu/loadSysMenuTree',
                type:'GET',
                success:function(result){
                    if(result.status){
                        $menu.jstree=$('#jstree').jstree({
                            core : {
                                data : result.data
                            }
                        });
                    }else{
                        toastr.warning(result.msg);
                    }
                }
            });
        },
        operate:function(){
            var $menu=this;
            $menu.btn.click(function(){
                var btn_id = $(this).attr("id");
                $(this).siblings().removeClass("active");
                if(btn_id!="btn-delete"){
                    $(this).addClass("active");
                }
                var selected=$menu.jstree.jstree(true).get_selected(true)[0];
                switch (btn_id){
                    case "btn-add":
                        if(selected.parents.length==3){
                            toastr.warning("最多添加三级菜单");
                            return false;
                        }
                        break;
                    case "btn-delete":
                        if(selected.children.length>0){
                            toastr.warning("存在子菜单，不允许删除");
                            return false;
                        }
                        break;
                }
            });
        },
        getSysMenuDetail:function(callBack){
            $.ajax({
                url:'/sysMenu/detail',
                type:'GET',
                data:{
                    id:selected.id
                },
                success:function(result){
                    if(result.status){
                        callBack();
//                        $('#menuName').val(result.data.menuName);
//                        $('#menuIcon').html('<i class="'+result.data.menuIcon+'"></i>');
//                        $('#menuUrl').val(result.data.menuUrl);
//                        $('#parentMenuName').val(result.data.parentMenuName);
//                        $('#menuDesc').val(result.data.menuDesc);

                    }else{
                        toastr.warning(result.msg);
                    }
                }
            });
        }
    }
    $(function() {
        menu.init();
    });
</script>
</body>
</html>
