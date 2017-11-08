package com.even.common.util;

/**
 * 返回结果
 */
public class ResponseResult {

    private boolean status = true; //返回状态

	private  String version = "1.0.0";    //版本

	private  String msg="";  // 提示

	private Object data;    //返回数据

    public static ResponseResult SUCCESS=new ResponseResult(true, "操作成功");//成功

    public static ResponseResult ERROR=new ResponseResult(false,  "操作失败");//失败

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseResult() {
        super();
    }

    public ResponseResult(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseResult(boolean status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(boolean status, String version, String msg, Object data) {
        this.status = status;
        this.version = version;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult SUCCESS(String msg){
        return new ResponseResult(true, msg,null);
    }

    public static ResponseResult SUCCESS(Object data){
        return new ResponseResult(true, "操作成功",data);
    }

    public static ResponseResult SUCCESS(String msg,Object data){
        return new ResponseResult(true, msg,data);
    }

    public static ResponseResult ERROR(String msg){
        return new ResponseResult(false, msg,null);
    }

    public static ResponseResult ERROR(Object data){
        return new ResponseResult(false, "操作失败",data);
    }

    public static ResponseResult ERROR(String msg,Object data){
        return new ResponseResult(false, msg,data);
    }
}
