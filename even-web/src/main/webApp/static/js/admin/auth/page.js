var p={
    init:function(){
        this.method.loadJqTreeGrid();
        this.event();
    },
    obj:{
        jqTreeGrid:{}
    },
    method:{
        loadJqTreeGrid:function(){
            p.obj.jqTreeGrid=$('#jqTreeGrid').bootstrapTreeTable({
                id : 'id',
                code :'id',
                parentCode : 'parentId',
                type : "GET", // 请求数据的ajax类型
                url : '/sysAuth/selectAllAuth', // 请求数据的ajax的url
//                ajaxParams : {}, // 请求数据的ajax的data属性
                expandColumn : '0',// 在哪一列上面显示展开按钮
                striped : true, // 是否各行渐变色
                bordered : true, // 是否显示边框
                expandAll : false, // 是否全部展开
                // toolbar : '#exampleToolbar',
                columns : [
                    {
                        title : '名称',
                        field : 'authName'
                    },
                    {
                        title : '图标',
                        field : 'icon',
                        align : 'center',
                        valign : 'middle',
                        formatter : function(item, index) {
                            return item.icon == null ? '': '<i class="' + item.icon+ '"></i>';
                        }
                    },
                    {
                        title : '类型',
                        field : 'type',
                        align : 'center',
                        valign : 'middle',
                        formatter : function(item, index) {
                            if (item.type === 1) {
                                return '<span class="label label-primary">目录</span>';
                            }
                            if (item.type === 2) {
                                return '<span class="label label-success">菜单</span>';
                            }
                            if (item.type === 3) {
                                return '<span class="label label-warning">按钮</span>';
                            }
                        }
                    },
                    {
                        title : '地址',
                        field : 'linkUrl'
                    },
                    {
                        title : '权限标识',
                        field : 'perms'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(item, index) {
                            var html=[];
                            if(perms.auth_edit)
                                html.push('&nbsp;<a class="btn btn-white btn-sm btn_edit" title="编辑" onclick="p.method.edit('+item.id+')"><i class="fa fa-edit"></i></a>');
                            if(perms.auth_add && item.type!=3)
                                html.push('&nbsp;<a class="btn btn-white btn-sm btn_add" title="添加下级" onclick="p.method.add('+item.id+')"><i class="fa fa-plus"></i></a>');
                            if(perms.auth_delete)
                                html.push('&nbsp;<a class="btn btn-danger btn-sm btn_delete" title="删除" onclick="p.method.delete('+item.id+')"><i class="fa fa-remove"></i></a>');
                            return html.join('');
                        }
                    }
                ]
            });
        },
        flush:function(){
            p.obj.jqTreeGrid.bootstrapTreeTable('refresh');
        },
        add:function(id){
            Ep.openDialog({
                title:'添加权限',
                url:'/sysAuth/add/'+(id ? id : 0)
            });
        },
        edit:function(id){
            Ep.openDialog({
                title:'编辑权限',
                url:'/sysAuth/edit/'+id
            });
        },
        delete:function(id){
            Ep.confirm({
                msg:'您确定删除该权限吗？',
                succFunc:function(){
                    Ep.ajax({
                        url:'/sysAuth/delete/'+id,
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