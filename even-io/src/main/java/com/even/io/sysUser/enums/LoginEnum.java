package com.even.io.sysUser.enums;

/**
 * Created by fymeven on 2017/10/29.
 */
public enum LoginEnum {

    ACCOUNT_ERROR(10002,"用户名/密码错误"),
    ACCOUNT_LOCK(10003,"用户账号已锁定"),
    ACCOUNT_PASS(1004,"身份已过期");

    private final int result;
    private final String desc;

    LoginEnum(int result, String desc) {
        this.result = result;
        this.desc = desc;
    }


}
