var a={
    init:function(){
        this.method.validate();
        this.method.loadDept();
    },
    method:{
        validate:function(){
            var i = "<i class='fa fa-times-circle'></i>";
            $.validator.addMethod("notselect",function(value,element,params){
                return value !=0;
            },"请选择部门");
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
                        notselect:true
                    },
                    email:{
                        email:true,
                        required: true,
                        maxlength:25
                    }
                },
                messages: {
                    realName: {
                        required: i + "请输入姓名",
                        maxlength: i + "姓名最多20个字符"
                    },
                    userName: {
                        required: i + "请输入用户账号",
                        minlength: i + "用户账号至少2个字符",
                        maxlength: i + "用户账号最多20个字符"
                    },
                    userPwd: {
                        minlength: i + "用户密码至少6个字符",
                        maxlength: i + "用户密码最多20个字符"
                    },
                    deptId: {
                        // required: i + "请选择部门"
                        notselect:i + "请选择部门"
                    },
                    email:{
                        email:i + "请输入正确的email格式",
                        required: i + "请输入邮箱地址",
                        maxlength:i + "邮箱地址最多20个字符"
                    }
                },
                beforeCommit:function(data){
                    if(!data.userPwd){
                        data.userPwd=defaultPwd;
                    }
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
        },
        loadDept:function () {
            Ep.ajax({
                url:'/department/list',
                succFunc:function (result) {
                    if(result.status){
                        $.each(result.data,function (i,o) {
                            document.getElementById('deptId').options[i+1]=new Option(o.deptName,o.id);
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