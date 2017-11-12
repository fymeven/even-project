﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <meta charset="utf-8" />
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/plugin/superui-master/content/ui/global/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link href="/static/plugin/superui-master/content/ui/global/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/plugin/superui-master/content/adminlte/dist/css/AdminLTE.css">
    <link rel="stylesheet" href="/static/plugin/superui-master/content/adminlte/dist/css/skins/_all-skins.min.css">
    <link href="/static/plugin/superui-master/content/min/css/supershopui.common.min.css" rel="stylesheet" />
    <link href="/static/plugin/superui-master/content/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet" />
    <!--全局通用框架样式 end-->
</head>
<body>
<section class="content-header">
    <h1>
        管理表格
        <small>bootstrap-table管理表格</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Simple</li>
    </ol>
</section>
<!-- Main content -->
<section class="content">

    <div class="row">
        <!-- BEGIN SAMPLE TABLE PORTLET-->
        <div class="col-md-12">
            <!-- BEGIN SAMPLE TABLE PORTLET-->
            <div class="box-body" style="padding-bottom:0px;">
                <div class="panel panel-default">
                    <div class="panel-heading">查询条件</div>
                    <div class="panel-body">
                        <form id="formSearch" class="form-horizontal">
                            <div class="form-group" style="margin-top:15px">
                                <label class="control-label col-sm-1" for="txt_search_departmentname">姓</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="txt_search_departmentname">
                                </div>
                                <label class="control-label col-sm-1" for="txt_search_statu">用户名</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="txt_search_statu">
                                </div>
                                <div class="col-sm-4" style="text-align:left;">
                                    <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div id="toolbar" class="btn-group">
                    <button id="btn_add" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                    </button>
                    <button id="btn_edit" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
                    </button>
                    <button id="btn_delete" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                    </button>
                </div>
                <div class="table-scrollable">
                    <table class="table-striped table-hover" id="table"
                           data-toggle="table"
                           data-pagination="true"
                           data-side-pagination="server"
                           data-search="true"
                           data-advanced-search="true"
                           data-id-table="advancedTable"
                           data-url="json/user_server_page.json" data-toolbar="#toolbar" data-row-style="rowStyle">
                        <thead>
                        <tr>
                            <th data-checkbox="true"></th>
                            <th data-field="id" data-sortable="true">Id</th>
                            <th data-field="lastname" data-sortable="true">姓</th>
                            <th data-field="username" data-sortable="true" data-formatter="nameFormatter">用户名</th>
                            <th data-field="state" data-sortable="true" data-formatter="stateFormatter">状态</th>
                            <th data-formatter="actionFormatter">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
            <!-- END SAMPLE TABLE PORTLET-->

            <div id="modal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Id</label>
                                <input type="number" class="form-control" name="id" placeholder="id">
                            </div>
                            <div class="form-group">
                                <label>Stars</label>
                                <input type="text" class="form-control" name="name" placeholder="Name">
                            </div>
                            <div class="form-group">
                                <label>用户名</label>
                                <input type="number" class="form-control" name="forks_count" placeholder="用户名">
                            </div>
                            <div class="form-group">
                                <label>状态</label>
                                <input type="text" class="form-control" name="状态" placeholder="状态">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary submit">保存</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        </div>


    </div>

</section>
<script src="/static/plugin/superui-master/content/ui/global/jQuery/jquery.min.js"></script>
<!-- Bootstrap 3.3.6 -->

<script src="/static/plugin/superui-master/content/ui/global/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/plugin/superui-master/content/min/js/supershopui.common.js"></script>
<script src="/static/plugin/superui-master/content/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="/static/plugin/superui-master/content/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
</body>
<script>

    var API_URL = 'http://' + location.host + ':3001/list/';

    var
            $modal = $('#modal').modal({ show: false }),
            $alert = $('.alert').hide();
    $(function () {
        // create event
        $('.create').click(function () {
            showModal($(this).text());
        });

        $modal.find('.submit').click(function () {
            var row = {};

            $modal.find('input[name]').each(function () {
                row[$(this).attr('name')] = $(this).val();
            });

        });
    });
    function nameFormatter(value, row) {
        var icon = row.id % 2 === 0 ? 'glyphicon-star' : 'glyphicon-star-empty'

        return '<i class="glyphicon ' + icon + '"></i> ' + value;
    }
    function actionFormatter(value) {
        return [
                    ' <a href="javascript:;" class="btn btn-icon-only purple"><i class="fa fa-edit"></i></a>'+
                    '<a href="javascript:;" class="btn btn-icon-only red"> <i class="fa fa-times"></i></a>',
        ].join('');
    }
    function stateFormatter(value, row) {

        if (row.state === "1") {
            return ' <span class="label label-sm label-success"> 在职 </span>';
        }
        else if (row.state == "2") {
            return ' <span class="label label-sm label-warning"> 实习 </span>';
        }
        else {
            return '<span class="label label-sm label-danger"> 离职 </span>';
        }

    }
    function rowStyle(row, index) {
        var classes = ['active', 'success', 'info', 'warning', 'danger'];

        if (index % 2 === 0 && index / 2 < classes.length) {
            return {
                classes: classes[index / 2]
            };
        }
        return {};
    }
    // update and delete events
    window.actionEvents = {
        'click .update': function (e, value, row) {
            showModal($(this).attr('title'), row);
        },
        'click .remove': function (e, value, row) {
            if (confirm('Are you sure to delete this item?')) {
                $.ajax({
                    url: API_URL + row.id,
                    type: 'delete',
                    success: function () {
                        $table.bootstrapTable('refresh');
                        showAlert('Delete item successful!', 'success');
                    },
                    error: function () {
                        showAlert('Delete item error!', 'danger');
                    }
                })
            }
        }
    };

    function showModal(title, row) {
        row = row || {
            id: '',
            name: '',
            stargazers_count: 0,
            forks_count: 0,
            description: ''
        }; // default row value

        $modal.data('id', row.id);
        $modal.find('.modal-title').text(title);
        for (var name in row) {
            $modal.find('input[name="' + name + '"]').val(row[name]);
        }
        $modal.modal('show');
    }

    function showAlert(title, type) {
        $alert.attr('class', 'alert alert-' + type || 'success')
                .html('<i class="glyphicon glyphicon-check"></i> ' + title).show();
        setTimeout(function () {
            $alert.hide();
        }, 3000);
    }
</script>
</html>