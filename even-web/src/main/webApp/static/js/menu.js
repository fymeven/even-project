var menu={
    currentNode:{},//当前树节点对象
    jstree:{},//jstree对象
    jqGrid:{},//jqGrid对象
    init:function(){
        this.loadJstree();
        this.loadJqGrid(0);
        this.event();
    },
    loadJstree:function(){
        menu.jstree=$('#jstree').jstree({
            core : {
                data : {
                    url:'/sysMenu/loadSysMenuTree',
                    dataType : "json"
                }
            }
        });
        menu.jstree.on('activate_node.jstree', function(e, data) {
            menu.jqGrid.jqGrid('setGridParam', {
                url: "/sysMenu/selectChildrenMenus",
                postData: {
                    parentId: data.node.id
                }
            }).trigger('reloadGrid');
        });
    },
    loadJqGrid:function(parentId){
        $.jgrid.defaults.styleUI = "Bootstrap";
        this.jqGrid=$("#jqGrid").jqGrid({
            url: '/sysMenu/selectChildrenMenus',
            postData:{
                parentId:parentId
            },
            datatype: "json",
            mtype: 'GET',
            autowidth:true,
            height: 'auto',
            rowNum: 10,
            rowList: [10, 20, 30],
            pager: $('#pager'),
            viewrecords: true,
            sortname: 'update_time',
            sortorder: "desc",
            colModel: [
                { name: 'id', hidden:true ,key:true },
                { name: 'menuName', index: 'menu_name',label:'菜单名称', width: 100, align: "center" },
                { name: 'menuIcon', sortable :false,label:'图标', width: 100, align: "center",
                    formatter: function (value, grid, rows, state){
                        return '<i class="'+value+'"></i>';
                    }
                },
                { name: 'parentMenuName',sortable :false ,label:'上级菜单', width: 100, align: "center" },
                { name: 'menuDesc', sortable :false,label:'菜单描述', width: 150, align: "center" },
                { name: 'menuStatus', sortable :false,label:'菜单状态', width: 80, align: "center",
                    formatter: function (value, grid, rows, state){
                        var html=[];
                        switch (value){
                            case 1:
                                html.push('<input type="checkbox" name="menuStatus" data-rowId='+rows.id+' checked autocomplete="off" />');
                                break;
                            case 2:
                                html.push('<input type="checkbox" name="menuStatus" data-rowId='+rows.id+' autocomplete="off" />');
                                break;
                        }
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
            loadComplete: function(){
                $('input[name=menuStatus]').lc_switch();
                $('body').delegate('input[name=menuStatus]', 'lcs-statuschange', function() {
                    var status = $(this).is(':checked') ? 1 : 2;
                    $.ajax({
                        url:'/sysMenu/updateMenuStatus',
                        type:'POST',
                        data:{
                            id:$(this).attr('data-rowId'),
                            menuStatus:status
                        },
                        success:function(result){
                            if(!result.status){
                                toastr.warning(result.msg);
                            }
                        }
                    });
                });
            }
        });
    },
    event:function(){
        $('.btn').click(function(){
            menu.currentNode=menu.jstree.jstree(true).get_selected(true)[0];
            var btn_id = $(this).attr("id");
            switch (btn_id){
                case "btn_flush":
                    menu.jstree.jstree(true).refresh();
                    menu.jqGrid.trigger('reloadGrid');
                    break;
                case "btn_add":
                    menu.method.btnAdd();
                    break;
                case "btn_edit":
                    menu.method.btnEdit();
                    break;
                case "btn_delete":
                    menu.method.btnDelete();
                    break;
            }
        });
    },
    method:{
        btnAdd:function(){
            if(menu.currentNode.parents.length>3){
                toastr.warning("最多添加三级菜单");
                return false;
            }
            layer.open({
                type: 2 //Page层类型
                ,area: ['800px', '500px']
                ,title: '添加菜单'
                ,shade: 0.6 //遮罩透明度
                ,anim: 1 //0-6的动画形式，-1不开启
                ,content: '/sysMenu/page/add'
                ,btn: ['确认', '关闭']
                ,yes: function(index, layero){
                    var childrenFrame = window[layero.find('iframe')[0]['name']]; //得到子iframe页的窗口对象
                    childrenFrame.$('#form_menu_add').submit();
                },
                success: function(layero, index){
                    var childrenFrame = window[layero.find('iframe')[0]['name']];
                    childrenFrame.$('#parentId').val(menu.currentNode.id);
                    childrenFrame.$('#parentMenuName').val(menu.currentNode.text);
                    childrenFrame.menu.method.initValidate({
                        form:'form_menu_add',
                        url:'/sysMenu/save'
                    });
                }
            });
        },
        btnEdit:function(){
            if(menu.currentNode.id==0){
                toastr.warning("此菜单不允许修改");
                return false;
            }
            layer.open({
                type: 2 //Page层类型
                ,area: ['800px', '500px']
                ,title: '编辑菜单'
                ,shade: 0.6 //遮罩透明度
                ,anim: 1 //0-6的动画形式，-1不开启
                ,content: '/sysMenu/page/update'
                ,btn: ['确认', '关闭']
                ,yes: function(index, layero){
                    var childrenFrame = window[layero.find('iframe')[0]['name']]; //得到子iframe页的窗口对象
                    childrenFrame.$('#form_menu_update').submit();
                },
                success: function(layero, index){
                    var childrenFrame = window[layero.find('iframe')[0]['name']];
                    $.ajax({
                        url:'/sysMenu/detail',
                        type:'GET',
                        data:{
                            id:menu.currentNode.id
                        },
                        success:function(result){
                            if(result.status){
                                childrenFrame.$('#id').val(result.data.id);
                                childrenFrame.$('#menuName').val(result.data.menuName);
//                                childrenFrame.$('#menuIcon').html('<i class="'+result.data.menuIcon+'"></i>');
                                childrenFrame.$('#menuIcon').val(result.data.menuIcon);
                                childrenFrame.$('#menuUrl').val(result.data.menuUrl);
                                childrenFrame.$('#parentMenuName').val(result.data.parentMenuName);
                                childrenFrame.$('#menuDesc').val(result.data.menuDesc);
                            }else{
                                toastr.warning(result.msg);
                            }
                        }
                    });
                    childrenFrame.menu.method.initValidate({
                        form:'form_menu_update',
                        url:'/sysMenu/update'
                    });
                }
            });
        },
        btnDelete:function(){
            if(menu.currentNode.children.length>0){
                toastr.warning("存在子菜单，不允许删除");
                return false;
            }
            layer.confirm('您确定删除该菜单吗？', {
                btn: ['确认','取消'] //按钮
            }, function(index){
                layer.close(index);
                $.ajax({
                    url:'/sysMenu/delete',
                    type:'POST',
                    data:{
                        id:menu.currentNode.id
                    },
                    success:function(result){
                        if(result.status){
                            menu.jstree.jstree(true).refresh();
                            menu.jqGrid.trigger('reloadGrid');
                        }else{
                            toastr.warning(result.msg);
                        }
                    }
                });
            });
        },
        initValidate:function(options){
            var e = "<i class='fa fa-times-circle'></i> ";
            $('#'+options.form).validate({
                rules: {
                    menuName:{
                        required: true,
                        minlength:2,
                        maxlength:10
                    },
                    menuUrl:{
                        required: true,
                        maxlength:500
                    },
                    menuDesc:{
                        maxlength:500
                    }
                },
                messages: {
                    menuName: {
                        required: e + "请输入菜单名称",
                        minlength: e + "菜单名称至少2个字符",
                        maxlength: e + "菜单名称最多10个字符"
                    },
                    menuUrl: {
                        required: e + "请输入菜单地址",
                        maxlength: e + "菜单地址最多500个字符"
                    },
                    menuDesc: {
                        maxlength: e + "菜单描述最多500个字符"
                    }
                },
                submitHandler:function(form){
                    $.ajax({
                        url:options.url,
                        type:'POST',
                        data:{
                            id:$('#id').val(),
                            menuName:$('#menuName').val(),
                            menuIcon:$('#menuIcon').val(),
                            menuUrl:$('#menuUrl').val(),
                            parentId:$('#parentId').val(),
                            menuDesc:$('#menuDesc').val()
                        },
                        success:function(result){
                            if(result.status){
                                parent.menu.jstree.jstree(true).refresh();
                                parent.menu.jqGrid.trigger('reloadGrid');
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                            }else{
                                toastr.warning(result.msg);
                            }
                        }
                    });
                }
            })
        }
    }
}
