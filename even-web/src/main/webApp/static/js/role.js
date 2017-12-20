var role={
    jqGrid:{},//jqGrid对象
    init:function(){
        this.loadJqGrid();
        this.event();
    },
    loadJqGrid:function(){
        $.jgrid.defaults.styleUI = "Bootstrap";
        this.jqGrid=$("#jqGrid").jqGrid({
            url: '/sysRole/list',
            datatype: "json",
            mtype: 'GET',
            autowidth:true,
            height: 'auto',
            rowNum: 10,
            rowList: [10, 20, 30],
            pager: $('#pager'),
            viewrecords: true,
            multiselect: true,
            sortname: 'update_time',
            sortorder: "desc",
            colModel: [
                { name: 'id', hidden:true ,key:true},
                { name: 'roleName', index: 'role_name',label:'角色名称', width: 100, align: "center" },
                { name: 'parentId', hidden:true},
                { name: 'parentRoleName',sortable :false ,label:'上级角色', width: 100, align: "center",
                    cellattr: function(rowId, val, rawObject, cm, rdata){
                        if(val=='无'){
                            return "style='color:red;'";
                        }
                    }
                },
                { name: 'roleDesc', sortable :false,label:'角色描述', width: 150, align: "center" },
                { name: 'roleStatus', sortable :false,label:'角色状态', width: 80, align: "center",
                    formatter: function (value, grid, rows, state){
                        var html=[];
                        switch (value){
                            case 1:
                                html.push('正常');
                                break;
                            case 2:
                                html.push('隐藏');
                                break;
                        }
                        return html.join('');
                    }
                },
                { name: 'id', sortable :false,label: '操作', width: 60,align: "center",
                    formatter: function (value, grid, rows, state){
                        var html=[];
                        html.push('<a class="btn" title="授权" alt="授权" onclick="role.method.btnAuth('+value+');"><i class="fa fa-key"></i></a>');
                        html.push('<a class="btn" title="编辑" alt="编辑" onclick="role.method.btnEdit('+value+');"><i class="fa fa-pencil"></i></a>');
                        html.push('<a class="btn" title="删除" alt="删除" onclick="role.method.btnDelete('+value+');"><i class="glyphicon glyphicon-trash"></i></a>');
                        return html.join('');
                    }
                }
            ],
            jsonReader: {
                root: "list",
                total: "pages",
                page: "pageNum",
                records: "total",
                repeatitems: false
            },
            beforeSelectRow: function (rowid, e) {
                var $myGrid = $(this),
                    i = $.jgrid.getCellIndex($(e.target).closest('td')[0]),
                    cm = $myGrid.jqGrid('getGridParam', 'colModel');
                return (cm[i].name === 'cb');
            }
        });
    },
    event:function(){
        $('.btn').click(function(){
            var btn_id = $(this).attr("id");
//            role.selectRow = role.jqGrid.jqGrid('getRowData',selectRowId);
            switch (btn_id){
                case "btn_flush":
                    role.jqGrid.trigger('reloadGrid');
                    break;
                case "btn_add":
                    role.method.btnAdd();
                    break;
                case "btn_delete":
                    role.method.btnDelete();
                    break;
            }
        });
    },
    method:{
        btnAdd:function(){
            layer.open({
                type: 2 //Page层类型
                ,area: ['800px', '500px']
                ,title: '添加角色'
                ,shade: 0.6 //遮罩透明度
                ,anim: 1 //0-6的动画形式，-1不开启
                ,content: '/sysRole/page/add'
                ,btn: ['确认', '关闭']
                ,yes: function(index, layero){
                    var childrenFrame = window[layero.find('iframe')[0]['name']]; //得到子iframe页的窗口对象
                    childrenFrame.$('#form_role_add').submit();
                },
                success: function(layero, index){
                    var childrenFrame = window[layero.find('iframe')[0]['name']];
                    childrenFrame.$('input[name=roleStatus]').lc_switch();
                    $.ajax({
                        url:'/sysRole/list',
                        type:'GET',
                        success:function(result){
                            if(result.status){
                                $.each(result.data,function(i,o){
                                    childrenFrame.document.getElementById('parentId').options[i+1]=new Option(o.roleName, o.id);
                                });
                                childrenFrame.$("#parentId").chosen();
                            }else{
                                toastr.warning(result.msg);
                            }
                        }
                    });
                    childrenFrame.role.method.initValidate({
                        form:'form_role_add',
                        url:'/sysRole/save'
                    });
                }
            });
        },
        btnEdit:function(roleId){
            if(!roleId) {
                toastr.warning("请选择操作角色");
                return false;
            }
            layer.open({
                type: 2 //Page层类型
                ,area: ['800px', '500px']
                ,title: '编辑角色'
                ,shade: 0.6 //遮罩透明度
                ,anim: 1 //0-6的动画形式，-1不开启
                ,content: '/sysRole/page/update'
                ,btn: ['确认', '关闭']
                ,yes: function(index, layero){
                    var childrenFrame = window[layero.find('iframe')[0]['name']]; //得到子iframe页的窗口对象
                    childrenFrame.$('#form_role_update').submit();
                },
                success: function(layero, index){
                    var childrenFrame = window[layero.find('iframe')[0]['name']];
                    childrenFrame.$('input[name=roleStatus]').lc_switch();
                    $.ajax({
                        url:'/sysRole/list',
                        type:'GET',
                        success:function(result){
                            if(result.status){
                                $.each(result.data,function(i,o){
                                    childrenFrame.document.getElementById('parentId').options[i+1]=new Option(o.roleName, o.id);
                                });
                                childrenFrame.$("#parentId").chosen();
                                role.method.getRoleDetail(roleId,function(result){
                                    childrenFrame.$('#id').val(result.data.id);
                                    childrenFrame.$('#roleName').val(result.data.roleName);
                                    childrenFrame.$('#parentId').val(result.data.parentId);
                                    childrenFrame.$('#parentId').trigger("chosen:updated");
                                    result.data.roleStatus ==1 ? childrenFrame.$('#roleStatus').lcs_on() : childrenFrame.$('#roleStatus').lcs_off();
                                    childrenFrame.$('#roleDesc').val(result.data.roleDesc);
                                })
                            }else{
                                toastr.warning(result.msg);
                            }
                        }
                    });
                    childrenFrame.role.method.initValidate({
                        form:'form_role_update',
                        url:'/sysRole/update'
                    });
                }
            });
        },
        btnDelete:function(roleId){
            if(!roleId) {
                var idArray=role.jqGrid.jqGrid('getGridParam','selarrrow');
                roleId=idArray.join();
                if(!roleId){
                    toastr.warning("请勾选需要删除的角色");
                    return false;
                }
            }
            layer.confirm('您确定删除该角色吗？', {
                btn: ['确认','取消'] //按钮
            }, function(index){
                layer.close(index);
                $.ajax({
                    url:'/sysRole/delete',
                    type:'POST',
                    data:{
                        idList:roleId
                    },
                    success:function(result){
                        if(result.status){
                            role.jqGrid.trigger('reloadGrid');
                        }else{
                            toastr.warning(result.msg);
                        }
                    }
                });
            });
        },
        btnAuth:function(roleId){
            if(!roleId) {
                toastr.warning("请选择操作角色");
                return false;
            }
            layer.open({
                type: 2 //Page层类型
                ,area: ['800px', '500px']
                ,title: '角色授权'
                ,shade: 0.6 //遮罩透明度
                ,anim: 1 //0-6的动画形式，-1不开启
                ,content: '/sysRole/page/auth'
                ,btn: ['确认', '关闭']
                ,yes: function(index, layero){
                    var childrenFrame = window[layero.find('iframe')[0]['name']]; //得到子iframe页的窗口对象
                    childrenFrame.$('#form_role_auth').submit();
                },
                success: function(layero, index){
                    var childrenFrame = window[layero.find('iframe')[0]['name']];

                    childrenFrame.role.method.initValidate({
                        form:'form_role_auth',
                        url:'/sysRole/setAuth'
                    });
                }
            });
        },
        initValidate:function(options){
            var e = "<i class='fa fa-times-circle'></i> ";
            $('#'+options.form).validate({
                rules: {
                    roleName:{
                        required: true,
                        minlength:2,
                        maxlength:10
                    },
                    parentId:{
                        required: true
                    },
                    roleDesc:{
                        maxlength:500
                    }
                },
                messages: {
                    roleName: {
                        required: e + "请输入角色名称",
                        minlength: e + "角色名称至少2个字符",
                        maxlength: e + "角色名称最多10个字符"
                    },
                    parentId: {
                        required: e + "请选择上级角色"
                    },
                    roleDesc: {
                        maxlength: e + "角色描述最多500个字符"
                    }
                },
                submitHandler:function(form){
                    $.ajax({
                        url:options.url,
                        type:'POST',
                        data:{
                            id:$('#id').val(),
                            roleName:$('#roleName').val(),
                            parentId:$('#parentId').val(),
                            roleStatus:$('#roleStatus').is(':checked') ? 1 : 2,
                            roleDesc:$('#roleDesc').val()
                        },
                        success:function(result){
                            if(result.status){
                                parent.role.jqGrid.trigger('reloadGrid');
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                            }else{
                                toastr.warning(result.msg);
                            }
                        }
                    });
                }
            })
        },
        getRoleDetail:function(roleId,callback){
            $.ajax({
                url:'/sysRole/detail',
                type:'GET',
                data:{
                    id:roleId
                },
                success:function(result){
                    if(result.status){
                        callback(result);
                    }else{
                        toastr.warning(result.msg);
                    }
                }
            });
        }
    }
}
