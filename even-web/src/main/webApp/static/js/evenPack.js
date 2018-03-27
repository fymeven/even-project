var Ep={
    /**
     * 进行ajax请求
     * @param options
     */
    ajax:function(options){
        var setting={
            url:'',
            type:'GET',
            data:{},
            beforeSend:function(){},
            errFunc:function(){
                toastr.warning("服务器错误，请联系管理员");
            },
            complete:function(){}
        };
        $.extend(setting,options);
        $.ajax({
            url:setting.url,
            type:setting.type,
            data:setting.data,
            beforeSend:function(xhr){
                setting.beforeSend(xhr);
            },
            success:function(result){
                setting.succFunc(result);
            },
            error:function(result){
                setting.errFunc(result);
            },
            complete:function(xhr,status){
                setting.complete(xhr,status);
            }
        });
    }
    /**
     * 打开一个页面窗口
     * @param options
     */
    ,openDialog:function(options){
        var setting={
            width:800,
            height:600,
            title:'新窗口',
            btn: ['确认', '取消'],
            yes:function(index,layero){
                var children = window[layero.find('iframe')[0]['name']];
                children.$('form').submit();
            }
        };
        $.extend(setting,options);
        layer.open({
            type: 2 //Page层类型
            ,area: [setting.width+'px', setting.height+'px']
            ,title: setting.title
            ,shade: 0.6 //遮罩透明度
            ,anim: 1 //0-6的动画形式，-1不开启
            ,content: setting.url
            ,btn:setting.btn
            ,yes:function(index,layero){
                setting.yes(index,layero);
            }
        });
    }
    /**
     * 关闭窗口
     * @param index 可选
     */
    ,closeDialog:function(index){
        var index = index ? index : parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }
    ,alert:function(options){
        var setting={
            icon:2, //1:success 2:error 3:question 4:lock 5:sadFace 6:smileFace
            time:3000,
            msg:'',
            succFunc:function(){}
        };
        if(typeof options === 'string'){
            setting.msg = options;
        }else{
            $.extend(setting,options);
        }
        layer.msg(setting.msg, {
            icon: setting.icon,
            time: setting.time
        }, function(){
            setting.succFunc();
        });
    }
    ,confirm:function(options){
        var setting={
            title:'提示',
            msg:'',
            btn: ['确认','取消'], //按钮
            succFunc:function(){}
        };
        $.extend(setting,options);
        layer.confirm(setting.msg, {
            title:setting.title,
            btn: setting.btn
        }, function(){
            setting.succFunc();
        });
    }
    /**
     * 消息显示
     */
    ,showMsg:function(options){
        var setting={
            type:'info',//info:常规 success:成功 warning:警告 error:错误
            title:'消息提示',
            closeButton: false,
            progressBar: true,
            positionClass: "toast-top-right",
            onclick: null,
            showDuration: "300",
            hideDuration: "1000",
            timeOut: "3000",
            extendedTimeOut: "1000",
            showEasing: "swing",
            hideEasing: "linear",
            showMethod: "fadeIn",
            hideMethod: "fadeOut"
        };
        toastr.options = {
            closeButton: setting.closeButton,
            progressBar: setting.progressBar,
            positionClass: setting.positionClass,
            onclick: setting.onclick,
            showDuration: setting.showDuration,
            hideDuration: setting.hideDuration,
            timeOut: setting.timeOut,
            extendedTimeOut: setting.extendedTimeOut,
            showEasing: setting.showEasing,
            hideEasing: setting.hideEasing,
            showMethod: setting.showMethod,
            hideMethod: setting.hideMethod
        };
        if(typeof options === 'string'){
            setting.msg = options;
        }else{
            $.extend(setting,options);
        }
        toastr[setting.type](setting.msg,setting.title);
    }
    /**
     * 表单验证
     * @param options
     */
    ,validate:function(options){
        var setting={
            form:$(".form-horizontal"),
            url:$(".form-horizontal").attr("action"),
            beforeCommit:function(data){
                //提交前可进行参数修改
            }
        };
        $.extend(setting,options);
        setting.form.validate({
            rules: setting.rules,
            messages: setting.messages,
            submitHandler:function(form){
                var data={};
                $.each(form.elements,function(i,o){
                    switch (o.type){
                        case 'radio':
                        case 'checkbox':
                            if(o.checked){
                                data[o.name]= o.value;
                            }
                            break;
                        case 'button':
                        case 'submit':
                            break;
                        default :
                            data[o.name]= o.value;
                            break;
                    }
                });
                setting.beforeCommit(data);
                Ep.ajax({
                    url:setting.url,
                    type:'POST',
                    data:data,
                    succFunc:function(result){
                        setting.succFunc(result);
                    }
                });
            }
        })
    }
    ,jqGrid:{
        load:function(options){
            var setting={
                selector:$("#jqGrid"),
                url:'',
                datatype: "json",
                mtype: 'GET',
                autowidth:true,
                height: 'auto',
                rowNum: 10,
                rowList: [10, 20, 30],
                pager: $('#pager'),
                viewrecords: true,
                multiselect: false,//禁用多选框，使用checkbox属性自己实现
                checkboxId:'id',
                checkbox:true,
                sortname: 'update_time',
                sortorder: "desc",
                colModel:[],
                jsonReader: {
                    root: "list",
                    total: "pages",
                    page: "pageNum",
                    records: "total",
                    repeatitems: false
                }
            };
            $.extend(setting,options);

            if(setting.checkbox){
                var checkbox={};
                checkbox.name=setting.checkboxId;
                checkbox.sortable=false;
                checkbox.label='<a id="selectAll" select="false" onclick="Ep.jqGrid.selectAll(this)">全选</a>';
                checkbox.width=30;
                checkbox.align='center';
                checkbox.formatter=function (value, grid, rows, state){
                    var html=[];
                    html.push('<input type="checkbox" name="checkbox" value="'+value+'">');
                    return html.join('');
                }
                setting.colModel.unshift(checkbox);
            };

            $.jgrid.defaults.styleUI = "Bootstrap";
            return setting.selector.jqGrid({
                url: setting.url,
                datatype: setting.datatype,
                mtype: setting.mtype,
                autowidth:setting.autowidth,
                height: setting.height,
                rowNum: setting.rowNum,
                rowList: setting.rowList,
                pager: setting.pager,
                viewrecords: setting.viewrecords,
                multiselect: setting.multiselect,
                sortname: setting.sortname,
                sortorder: setting.sortorder,
                colModel: setting.colModel,
                jsonReader: setting.jsonReader
            });
        },
        selectAll:function(btn){
            if($(btn).attr('select') === 'false'){
                $(btn).attr('select',true);
                $(btn).text('取消');
                $('input[name=checkbox]').prop("checked", true);
            }else{
                $(btn).attr('select',false);
                $(btn).text('全选');
                $('input[name=checkbox]').prop("checked", false);
            }
        },
        getCheckId:function(){
            var idList=[];
            $('input[name=checkbox]:checked').each(function(i,o){
                idList.push(o.value);
            });
            return idList.join(',');
        }

    } 
}