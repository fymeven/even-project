var e={
    init:function(){
        this.method.validate();
        this.event();
    },
    method:{
        validate:function(){
            var i = "<i class='fa fa-times-circle'></i>";
            Ep.validate({
                rules: {
                    authName:{
                        required: true,
                        minlength:2,
                        maxlength:20
                    },
                    perms:{
                        required: true,
                        maxlength:200
                    },
                    icon:{
                        maxlength:200
                    },
                    linkUrl:{
                        maxlength:500
                    },
                    type:{
                        required: true
                    },
                    authDesc:{
                        maxlength:500
                    }
                },
                messages: {
                    authName: {
                        required: i + "请输入权限名称",
                        minlength: i + "权限名称至少2个字符",
                        maxlength: i + "权限名称最多20个字符"
                    },
                    perms: {
                        required: i + "请输入权限标识",
                        maxlength: i + "权限标识最多200个字符"
                    },
                    icon: {
                        maxlength: i + "图标最多200个字符"
                    },
                    linkUrl:{
                        maxlength: i + "链接地址最多500个字符"
                    },
                    type:{
                        required: i + "请选择类型"
                    },
                    authDesc:{
                        maxlength: i + "描述最多500个字符"
                    }
                },
                beforeCommit:function(data){
                    data.status = data.status === 'on' ? 1 : 2;
                },
                succFunc:function(result){
                    if(result.status){
                        Ep.alert({
                            icon:1,
                            msg:result.msg
                        });
                        setTimeout(function () {
                            parent.p.method.flush();
                            Ep.closeDialog();
                        },2000);
                    }else{
                        Ep.alert({
                            icon:2,
                            msg:result.msg
                        });
                    }
                }
            });
        }
    },
    event:function(){
        $('input[name=type]').change(function(){
            if($(this).val() == '2'){
                $('#linkUrl').removeAttr("disabled");
            }else{
                $('#linkUrl').val('');
                $('#linkUrl').attr('disabled',true);
            }
            if($(this).val() == '3'){
                $('#icon').val('');
                $('#icon').attr('disabled',true);
            }else{
                $('#icon').removeAttr("disabled");
            }
        });
    }
}
$(function(){
    e.init();
});