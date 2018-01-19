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
                url: '/sysRole/list',
                colModel: [
                    { name: 'id', hidden:true ,key:true},
                    { name: 'roleName', index: 'role_name',label:'角色名称', width: 100, align: "center" },
                    { name: 'roleDesc', sortable :false,label:'角色描述', width: 150, align: "center" },
                    { name: 'status', sortable :false,label:'角色状态', width: 80, align: "center",
                        formatter: function (value, grid, rows, state){
                            var html=[];
                            switch (value){
                                case 1:
                                    html.push('正常');
                                    break;
                                case 2:
                                    html.push('不可用');
                                    break;
                            }
                            return html.join('');
                        }
                    },
                    { name: 'id', sortable :false,label: '操作', width: 60,align: "center",
                        formatter: function (value, grid, rows, state){
                            var html=[];
                            if(perms.role_edit)
                                html.push('&nbsp;<a class="btn btn-primary btn-sm btn_edit" title="编辑" alt="编辑" onclick="p.method.edit('+value+');"><i class="fa fa-edit"></i></a>');
                            if(perms.role_auth)
                                html.push('&nbsp;<a class="btn btn-primary btn-sm btn_auth" title="授权" alt="授权" onclick="p.method.auth('+value+');"><i class="fa fa-key"></i></a>');
                            if(perms.role_delete)
                                html.push('&nbsp;<a class="btn btn-warning btn-sm btn_delete" title="删除" alt="删除" onclick="p.method.delete('+value+');"><i class="fa fa-remove"></i></a>');
                            return html.join('');
                        }
                    }
                ]
            });
        },
        flush:function(){
            p.obj.jqGrid.trigger('reloadGrid');
        },
        add:function(){
            Ep.openDialog({
                title:'添加角色',
                url:'/sysRole/add',
                height:400
            });
        },
        edit:function(id){
            Ep.openDialog({
                title:'编辑角色',
                url:'/sysRole/edit/'+id,
                height:400
            });
        },
        auth:function(id){
            Ep.openDialog({
                title:'角色授权',
                url:'/sysRole/auth/'+id,
                yes:function(index,layero){
                    var children = window[layero.find('iframe')[0]['name']];
                    children.a.method.setAuth();
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
                msg:'您确定删除该角色吗？',
                succFunc:function(){
                    Ep.ajax({
                        url:'/sysRole/delete/',
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
            }
        });
    }
}
$(function(){
    p.init();
})