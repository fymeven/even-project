var a={
    init:function(){
        this.validate();
    },
    validate:function(){
        var i = "<i class='fa fa-times-circle'></i>";
        Ep.validate({
            rules: {
                realName:{
                    required: true,
                    maxlength:20
                },
                userName:{
                    required: true,
                    minlength:2,
                    maxlength:20
                },
                userPwd:{
                    minlength:6,
                    maxlength:20
                },
                deptId:{
                    required: true
                },
                email:{
                    email:true,
                    required: true,
                    maxlength:25
                }
            },
            messages: {
                realName: {
                    required: e + "请输入姓名",
                    maxlength: e + "姓名最多20个字符"
                },
                userName: {
                    required: e + "请输入用户账号",
                    minlength: e + "用户账号至少2个字符",
                    maxlength: e + "用户账号最多20个字符"
                },
                userPwd: {
                    minlength: e + "用户密码至少6个字符",
                    maxlength: e + "用户密码最多20个字符"
                },
                deptId: {
                    required: e + "请选择部门"
                },
                email:{
                    email:e + "请输入正确的email格式",
                    required: e + "请输入邮箱地址",
                    maxlength:e + "邮箱地址最多20个字符"
                }
            },
            //beforeCommit:function(data){
            //
            //},
            succFunc:function(result){
                if(result.status){
                    parent.p.method.flush();
                    Ep.closeDialog();
                }else{
                    Ep.alert(result.msg);
                }
            }
        });
    }
}
$(function(){
    a.init();
});