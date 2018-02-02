var a={
    init:function(){
        this.method.validate();
    },
    method:{
        validate:function(){
            var i = "<i class='fa fa-times-circle'></i>";
            Ep.validate({
                rules: {
                    roleName:{
                        required: true,
                        minlength:2,
                        maxlength:20
                    },
                    roleDesc:{
                        maxlength:500
                    }
                },
                messages: {
                    roleName: {
                        required: i + "请输入角色名称",
                        minlength: i + "角色名称至少2个字符",
                        maxlength: i + "角色名称最多20个字符"
                    },
                    roleDesc:{
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
    }
}
$(function(){
    a.init();
});