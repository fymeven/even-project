var p={
    init:function () {
        this.method.loadJstree();
        this.method.loadJqGrid();
        this.event();
    },
    obj:{
        jstree:{},
        jqGrid:{}
    },
    method:{
        loadJstree:function(){
            p.obj.jstree=$('#jstree').jstree({
                core : {
                    data : {
                        url:'/department/getDeptTree',
                        dataType : "json"
                    }
                }
            });
            p.obj.jstree.on('activate_node.jstree', function(e, data) {
                p.obj.jqGrid.jqGrid('setGridParam', {
                    postData: {
                        deptId: data.node.id
                    }
                }).trigger('reloadGrid');
            });
        },
        loadJqGrid:function(){
            p.obj.jqGrid=Ep.jqGrid.load({
                url: '/sysUser/list',
                checkbox:false,
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
                        { name: 'id', sortable :false,label: '操作', width: 60,align: "center",
                            formatter: function (value, grid, rows, state){
                                var html=[];
                                html.push('&nbsp;<a class="btn btn-white btn-sm btn_edit" title="查看详细信息" alt="查看详细信息" onclick="p.method.detail('+value+');"><i class="fa fa-eye"></i></a>');
                                return html.join('');
                            }
                        }
                ]
            });
        },
        flush:function(){
            p.obj.jstree.jstree(true).refresh();
        },
        detail:function (id) {
            Ep.openDialog({
                title:'用户详情',
                url:'/sysUser/detail/'+id,
                height:600
            });
        },
        add:function(){
            var selected = p.obj.jstree.jstree(true).get_selected(true)[0];
            if(!selected){
                Ep.showMsg({
                    type:'warning',
                    msg:'请先选择需要添加的上级部门'
                });
                return;
            }
            Ep.openDialog({
                title:'添加部门',
                url:'/department/add/'+selected.id,
                height:600
            });
        },
        edit:function(){
            var selected = p.obj.jstree.jstree(true).get_selected(true)[0];
            if(!selected){
                Ep.showMsg({
                    type:'warning',
                    msg:'请先选择需要编辑的部门'
                });
                return;
            }
            if(selected.id==0){
                Ep.showMsg({
                    type:'warning',
                    msg:'此菜单不允许修改，请联系系统管理员'
                });
                return;
            }
            Ep.openDialog({
                title:'编辑部门',
                url:'/department/edit/'+selected.id,
                height:600
            });
        },
        delete:function(){
            var selected = p.obj.jstree.jstree(true).get_selected(true)[0];
            if(!selected){
                Ep.showMsg({
                    type:'warning',
                    msg:'请先勾选要删除的数据'
                });
                return;
            }
            if(selected.children.length>0){
                Ep.showMsg({
                    type:'warning',
                    msg:'存在子部门，不允许删除'
                });
                return;
            }
            Ep.confirm({
                msg:'您确定删除该部门吗？',
                succFunc:function(){
                    Ep.ajax({
                        url:'/department/delete/',
                        data:{
                            id:selected.id
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
                case "btn_edit":
                    p.method.edit();
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
});