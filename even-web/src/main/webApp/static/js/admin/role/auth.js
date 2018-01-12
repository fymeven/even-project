var a={
    init:function(){
        this.loadJstree();
    },
    obj:{
        jsTree:{}
    },
    loadJstree:function(){
        this.obj.jstree=$('#jstree').jstree({
            core : {
                data : {
                    url:'/sysRole/getAuthTree/'+roleId,
                    dataType : "json"
                }
            },
            plugins : ["checkbox"]
        });
        this.obj.jstree.on('activate_node.jstree', function(e, data) {

        });
    }
}
$(function(){
    a.init();
});