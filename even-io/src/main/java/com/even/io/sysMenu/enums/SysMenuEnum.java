package com.even.io.sysMenu.enums;

/**
 * Created by even on 2017/11/1.
 */
public class SysMenuEnum {

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

    public enum parentId{
        PARENT(0l,"一级菜单");// 本系统只有两级菜单，一级菜单都为 0

        private final long longValue;
        private final String desc;


        parentId(long byteValue, String desc) {
            this.longValue = byteValue;
            this.desc = desc;
        }

        public long getLongValue() {
            return longValue;
        }

        public String getDesc() {
            return desc;
        }
    }
}
