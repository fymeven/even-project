package com.even.io.sysRole.enums;

/**
 * Created by even on 2017/11/1.
 */
public class SysRoleEnum {

    public enum isDel{
        NOMAL(1,"正常"),
        DELED(2,"已删除");

        private final int intValue;
        private final String desc;


        isDel(int intValue, String desc) {
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
