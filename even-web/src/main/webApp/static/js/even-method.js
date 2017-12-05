/**
 * Created by even on 2017/11/16.
 */
var system={
    initSysMenu:function(){
        $.ajax({
            url:'/login/initSysMenu',
            type:'get',
            success:function(result){
                console.info(result)
//                <dl id="menu-article">
//                    <dt><i class="Hui-iconfont">&#xe616;</i> 资讯管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
//                    <dd>
//                    <ul>
//                        <li><a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">资讯管理</a></li>
//                    </ul>
//                    </dd>
//                </dl>
                if(result.status){
                    var html=[];
                    $.each(result.data,function(i,o){
                        html.push('<dl>');
                            html.push('<dt><i class="Hui-iconfont">'+ o.menuIcon+'</i>'+ o.menuName+'<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>');
                            html.push('<dd><ul>');
                            if(o.childMenuSet.length>0){
                                $.each(o.childMenuSet,function(ci,co){
                                    html.push('<li><a data-href="'+co.menuUrl+'" data-title="'+co.menuName+'" href="javascript:void(0)">'+co.menuName+'</a></li>');
                                });
                            }else{

                            }
                        html.push('</ul></dd></dl>');
                    });
                }else{
                    layer.msg(result.msg,{icon:2,time:1000});
                }
            }
        });
    }
}
