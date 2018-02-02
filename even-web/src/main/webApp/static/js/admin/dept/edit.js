var a={
    init:function(){
        this.method.validate();
        this.method.loadSuggest();
    },
    method:{
        validate:function(){
            var i = "<i class='fa fa-times-circle'></i>";
            Ep.validate({
                rules: {
                    deptName:{
                        required: true,
                        minlength:2,
                        maxlength:20
                    }
                },
                messages: {
                    deptName: {
                        required: i + "请输入部门名称",
                        minlength: i + "部门名称至少2个字符",
                        maxlength: i + "部门名称最多20个字符"
                    }
                },
                beforeCommit:function (data) {
                    data.deptManagerId=$('#deptManagerId').attr("data-id");
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
        loadSuggest:function () {
            $("#deptManagerId").bsSuggest({
                url: "/sysUser/getUserforSuggest",
                showBtn: false,
                idField: "id",
                keyField: "realName",
                effectiveFields:['realName','email','userMobile'],
                effectiveFieldsAlias:{realName:"姓名",email:"邮箱",userMobile:"电话"}
            });
        }
    }
}
$(function(){
    a.init();
});