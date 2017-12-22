package com.even.io.sysUser.enums;

/**
 * Created by even on 2017/11/1.
 */
public class SysUserEnum {
    public enum LoginEnum {

        ACCOUNT_ERROR(10002,"用户名/密码错误"),
        ACCOUNT_LOCK(10003,"用户账号已锁定"),
        ACCOUNT_PASS(10004,"身份已过期");

        private final int intValue;
        private final String desc;

        LoginEnum(int intValue, String desc) {
            this.intValue = intValue;
            this.desc = desc;
        }

        public int getIntValue(){
            return intValue;
        }

        public String getDesc(){
            return desc;
        }

    }

    public enum isDel{
        NOMAL((byte)1,"正常"),
        DELED((byte)2,"已删除");

        private final byte byteValue;
        private final String desc;


        isDel(byte byteValue, String desc) {
            this.byteValue = byteValue;
            this.desc = desc;
        }

        public byte getByteValue() {
            return byteValue;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum userStatus{
        NOMAL(1,"正常"),
        LOCK(2,"已锁定");


        private final int intValue;
        private final String desc;


        userStatus(int intValue, String desc) {
            this.intValue = intValue;
            this.desc = desc;
        }

        public int getIntValue() {
            return intValue;
        }

        public String getDesc() {
            return desc;
        }
    }
}
