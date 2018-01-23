package com.even.common.util;

import com.even.bean.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by even on 2017/12/26.
 */
public class ShiroUtil {
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static SysUser getUser() {
        return (SysUser)getSubject().getPrincipal();
    }

    public static Long getUserId() {
        return getUser().getId();
    }

    public static void logout() {
        getSubject().logout();
    }

    public static void setSession(Object key,Object value){
        getSubject().getSession().setAttribute(key,value);
    }

    public static void getSession(Object key){
        getSubject().getSession().getAttribute(key);
    }

}
