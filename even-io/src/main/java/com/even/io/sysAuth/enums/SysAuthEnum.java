package com.even.io.sysAuth.enums;

/**
 * Created by even on 2017/11/1.
 */
public class SysAuthEnum {

    public static Long ROOT_ID = 0L;  //根节点id
    public static String ROOT_NAME = "本系统"; //根节点名称

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

    public enum status{
        SHOW(1,"显示"),
        HIDDEN(2,"隐藏");

        private final int intValue;
        private final String desc;


        status(int intValue, String desc) {
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

    public enum type{

        DIRECTORY(1,"目录"),// 目录
        MENU(2,"菜单"),//菜单
        BUTTON(3,"按钮");//按钮

        private final int intValue;
        private final String desc;


        type(int byteValue, String desc) {
            this.intValue = byteValue;
            this.desc = desc;
        }

        public long getIntValue() {
            return intValue;
        }

        public String getDesc() {
            return desc;
        }
    }
}
