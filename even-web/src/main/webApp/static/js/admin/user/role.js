var r={
    init:function () {
        this.method.loadDoubleBox();
    },
    method:{
        loadDoubleBox:function () {
            var nonSelectedList=[],selectedList=[];
            Ep.ajax({
                url:'/sysRole/list',
                succFunc:function (result) {
                    if (result.status){
                        nonSelectedList=result.data;
                        Ep.ajax({
                            url:'/sysRole/getRolesByUserId/'+userId,
                            succFunc:function (result) {
                                if (result.status){
                                    selectedList=result.data;
                                    $(document).ready(function(){
                                        $('#roleList').doublebox({
                                            nonSelectedListLabel: '角色列表',
                                            selectedListLabel: '已授权角色',
                                            preserveSelectionOnMove: 'moved',
                                            moveOnSelect: false,
                                            nonSelectedList:nonSelectedList,
                                            selectedList:selectedList,
                                            optionValue:"id",
                                            optionText:"roleName",
                                            doubleMove:true,
                                        });
                                    });
                                }
                            }
                        });
                    }
                }
            });
        },
        setRole:function () {
            if(!$('#roleList').val()){
                Ep.alert({icon:4,msg:'请选择需要授权的角色'});
                return;
            }
            Ep.ajax({
                url:'/sysUser/setRole',
                type:'POST',
                data:{
                    userId:userId,
                    roleList:$('#roleList').val().join(',')
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
                        },1500);
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
    r.init();
});