package com.even.io.sysRole.enums;

/**
 * Created by even on 2017/11/1.
 */
public class SysRoleEnum {

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
}
