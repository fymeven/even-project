package com.even.common.util;

/**
 * 返回结果
 */
public class ResponseResult {

    private static boolean status = true; //返回状态

	private static String version = "1.0.0";    //版本
	
	private static String msg;  // 描述

	private Object data;//返回数据

    public static ResponseResult SUCCESS=new ResponseResult(true, version,  "操作成功", null);//成功

    public static ResponseResult ERROR=new ResponseResult(false, version, "操作失败", null);//失败

	public ResponseResult(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public String getVersion() {
		return version;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setVersion(String version) {
		this.version = version;
	}

    public ResponseResult() {
        super();
    }

    public ResponseResult(boolean status, String version, String msg, Object data) {
        this.status = status;
        this.version = version;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult setResult(boolean status,String msg){
        return new ResponseResult(status, version, msg, null);
    }

    public static ResponseResult setResult(boolean status,String msg,Object data){
        return new ResponseResult(status, version, msg, data);
    }

    public static ResponseResult SUCCESS(Object data){
        return new ResponseResult(status, version, msg, data);
    }

    public static ResponseResult SUCCESS(Object data,String msg){
        return new ResponseResult(status, version, msg, data);
    }

    public static ResponseResult ERROR(String msg){
        return new ResponseResult(false, version, msg, null);
    }

    public static ResponseResult ERROR(Object data,String msg){
        return new ResponseResult(false, version, msg, null);
    }

}
