package com.even.io.sysMessage.enums;

public class SysMessageEnums {
    public enum isRead{
        NO((byte) 1,"未读"),
        YES((byte) 2,"已读");
        private byte byteValue;
        private String desc;

        isRead(byte byteValue, String desc) {
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
