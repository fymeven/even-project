/**
 * Created by fymeven on 2017/11/4.
 */
var sysConfig={
    enum:{
        sysUser:{
            userStatus:function(status){
                var desc;
                switch (status){
                    case 1:
                        desc= "正常";
                        break;
                    case 2:
                        desc= "已锁定";
                        break;
                }
                return desc;
            }
        }
    }
}