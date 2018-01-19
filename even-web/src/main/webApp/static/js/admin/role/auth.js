var a={
    init:function(){
        this.method.loadJstree();
    },
    obj:{
        jstree:{}
    },
    method:{
        loadJstree:function(){
            a.obj.jstree=$('#jstree').jstree({
                core : {
                    data : {
                        url:'/sysRole/getAuthTree/'+roleId,
                        dataType : "json"
                    }
                },
                plugins : ["checkbox"],
                checkbox: {
                    "keep_selected_style": false,//是否默认选中
                    "three_state": true,//父子级别级联选择
                    "tie_selection": false
                }
            });
            a.obj.jstree.jstree(true).get_all_checked = function(full) {
                var tmp=new Array;
                for(var i in this._model.data){
                    if(this.is_undetermined(i)||this.is_checked(i)){
                        if(i!='#' && i!='0'){tmp.push(full?this._model.data[i]:i);}//排除根节点 0
                    }
                }
                return tmp;
            };

            //a.obj.jstree.on('activate_node.jstree', function(e, data) {
            //
            //});
        },
        setAuth:function(){
            var authList = a.obj.jstree.jstree(true).get_all_checked();
            if(authList.length===0){
                Ep.alert({icon:4,msg:'请选择需要授权的权限'});
                return;
            }
            Ep.ajax({
                url:'/sysRole/setAuth',
                type:'POST',
                data:{
                    roleId:roleId,
                    authList:authList.join(',')
                },
                succFunc:function(result){
                    if(result.status){
                        Ep.closeDialog();
                    }else{
                        Ep.alert(result.msg);
                    }
                }
            });
        }
    }
}
$(function(){
    a.init();
});