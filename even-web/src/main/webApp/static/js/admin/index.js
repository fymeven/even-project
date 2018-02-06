var index={
    init:function () {
        this.event();
    },
    method:{
        loginOut:function () {
            Ep.confirm({
                msg:'您确定退出吗？',
                succFunc:function(){
                    location.href="/login/loginOut";
                }
            });
        }
    },
    event:function () {
        $('.btn').click(function(){
            switch ($(this).attr("id")){
                case "btn_loginOut":
                    index.method.loginOut();
                    break;
            }
        });
    }
}
$(function(){
    index.init();
    webSocket.init();
})