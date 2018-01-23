var login={
    init:function(){
        var e = "<i class='fa fa-times-circle'></i> ";
        $("#login_form").validate({
            rules: {
                userName: {
                    required: true,
                    minlength: 4
                },
                userPwd: {
                    required: true,
                    minlength: 3,
                    maxlength:20
                }
            },
            messages: {
                userName: {
                    required: e + "请输入您的用户名",
                    minlength: e + "用户名至少4个字符"
                },
                userPwd: {
                    required: e + "请输入您的密码",
                    minlength: e + "密码至少3个字符",
                    maxlength: e + "密码最多20个字符"
                }
            },
            submitHandler:function(form){
                $.ajax({
                    url:'/login/userLogin',
                    type:'POST',
                    data:{
                        userName:$('#userName').val(),
                        userPwd:$('#userPwd').val(),
                        remeberMe:$('#remeberMe').is(":checked")
                    },
                    success:function(result){
                        if(result.status){
                            location.href="/system/main";
                        }else{
                            toastr.warning(result.msg);
                        }
                    }
                });
            }
        })
    }
}