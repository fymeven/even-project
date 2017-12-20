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

    public enum roleStatus{
        NOMAL(1,"正常"),
        HIDDEN(2,"隐藏");

        private final int intValue;
        private final String desc;


        roleStatus(int intValue, String desc) {
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

    public enum parentId{

        NO_PARENT (0L,"无");// 最高级角色 0
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
