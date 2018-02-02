var p={
    init:function(){
        this.method.loadJqGrid();
        this.event();
    },
    obj:{
        jqGrid:{}
    },
    method:{
        loadJqGrid:function(){
            p.obj.jqGrid=Ep.jqGrid.load({
                url: '/sysUser/list',
                colModel: [
                    { name: 'id', hidden:true ,key:true},
                    { name: 'realName', sortable :false,label:'姓名', width: 100, align: "center" },
                    { name: 'userName', sortable :false,label:'用户账号', width: 100, align: "center" },
                    { name: 'email', sortable :false,label:'邮箱', width: 100, align: "center" },
                    { name: 'status', sortable :false,label:'用户状态', width: 80, align: "center",
                        formatter: function (value, grid, rows, state){
                            var html=[];
                            switch (value){
                                case 1:
                                    html.push('正常');
                                    break;
                                case 2:
                                    html.push('已锁定');
                                    break;
                            }
                            return html.join('');
                        }
                    },
                    { name: 'id', sortable :false,label: '操作', width: 100,align: "center",
                        formatter: function (value, grid, rows, state){
                            var html=[];
                            html.push('&nbsp;<a class="btn btn-white btn-sm btn_edit" title="查看详细信息" alt="查看详细信息" onclick="p.method.detail('+value+');"><i class="fa fa-eye"></i></a>');
                            if(perms.user_role)
                                html.push('&nbsp;<a class="btn btn-white btn-sm btn_role" title="设置角色" alt="设置角色" onclick="p.method.setRole('+value+');"><i class="fa fa-street-view"></i></a>');
                            if(perms.user_edit)
                                html.push('&nbsp;<a class="btn btn-white btn-sm btn_edit" title="编辑" alt="编辑" onclick="p.method.edit('+value+');"><i class="fa fa-edit"></i></a>');
                            if(perms.user_delete)
                            html.push('&nbsp;<a class="btn btn-danger btn-sm btn_delete" title="删除" alt="删除" onclick="p.method.delete('+value+');"><i class="fa fa-remove"></i></a>');
                            return html.join('');
                        }
                    }
                ]
            });
        },
        flush:function(){
            p.obj.jqGrid.trigger('reloadGrid');
        },
        detail:function (id) {
            Ep.openDialog({
                title:'用户详情',
                url:'/sysUser/detail/'+id,
                height:600
            });
        },
        search:function () {
            p.obj.jqGrid.jqGrid('setGridParam', {
                postData: {
                    realName: $('#search_realName').val(),
                    userName: $('#search_userName').val(),
                    email: $('#search_email').val(),
                }
            }).trigger('reloadGrid');
        },
        add:function(){
            Ep.openDialog({
                title:'添加用户',
                url:'/sysUser/add'
            });
        },
        edit:function(id){
            Ep.openDialog({
                title:'编辑用户',
                url:'/sysUser/edit/'+id
            });
        },
        setRole:function(id){
            Ep.openDialog({
                title:'角色授权',
                url:'/sysUser/role/'+id,
                yes:function(index,layero){
                    var children = window[layero.find('iframe')[0]['name']];
                    children.r.method.setRole();
                }
            });
        },
        delete:function(id){
            if(!id){
                id = Ep.jqGrid.getCheckId();
                if(!id){
                    Ep.showMsg({
                        type:'warning',
                        msg:'请先勾选要删除的数据'
                    });
                    return;
                }
            }
            Ep.confirm({
                msg:'您确定删除该用户吗？',
                succFunc:function(){
                    Ep.ajax({
                        url:'/sysUser/delete/',
                        data:{
                            idList:id
                        },
                        type:'POST',
                        succFunc:function(result){
                            if(result.status){
                                p.method.flush();
                                Ep.alert({
                                    icon:1,
                                    msg:result.msg
                                });
                            }else{
                                Ep.alert({
                                    icon:2,
                                    msg:result.msg
                                });
                            }
                        }
                    });
                }
            });
        }
    },
    event:function(){
        $('.btn').click(function(){
            switch ($(this).attr("id")){
                case "btn_flush":
                    var $btn=$(this);
                    $btn.find('i').addClass("fa-spin");
                    p.method.flush();
                    setTimeout(function(){
                        $btn.find('i').removeClass("fa-spin");
                    },2000);
                    break;
                case "btn_add":
                    p.method.add();
                    break;
                case "btn_delete":
                    p.method.delete();
                    break;
                case "btn_search":
                    p.method.search();
                    break;
            }
        });
    }
}
$(function(){
    p.init();
})