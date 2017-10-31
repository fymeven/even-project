package com.even.common.util;


/**
 * 状态码管理
 * 
 * ResponseEnum
 * 创建人:黄世平
 * 时间：2016年11月8日-上午9:36:29 
 * @version 1.0.0
 *
 */
public enum  ResponseEnum {
	
	/*
	 * 系统参数
	 */
	SUCCESS(200, "OK"),
	FAIL_SYS_BAD_REQUEST(201, "错误的请求,参数不完整"),
	FAIL_SYS_API_NOT_FOUND(203, "访问了不存在的API"),
	FAIL_SYS_API_REJECT(204, "访问的API拒绝了对特定用户的请求"),
	FAIL_SYS_EXPIRED_REQUEST(205, "请求时间戳已失效"),
	FAIL_SYS_UNAUTHORIZED(206,  "app试图访问未授权的api"),
	FAIL_SYS_REQUEST_TIMEOUT(251,  "请求超时会话失效"),
	FAIL_SYS_SERVICE_FAULT(252,  "后端服务调用失败"),
	FAIL_SYS_SERVICE_NOT_EXIST(254, "服务器异常,API调用失败!"),
	FAIL_AUTH_NOT(255,  "你没有操作权限"),
	FAIL_SYS_ERROR(500,  "系统异常，系统不支持该请求方式"),
	FAIL_SERVER_ERROR(409,"系统业务异常"),
	
	SMS_MAX_COUNT(101, "用户超出发送次数"),
	SMS_EXISTS(102,  "短信未失效"),
	SMS_FAIL(103,  "短信发送失败"),
	SMS_OK(100,"短信发送成功");
	private final int intValue;
    private final String desc;
    
    ResponseEnum(int intValue, String desc) {
        this.intValue = intValue;
        this.desc = desc;
    }
    
    public int intValue() {
        return intValue;
    }

    public String desc() {
        return desc;
    }

    
    /*
	 * 用户状态
	 */
	public enum UsersResEnum {
		USER_PHONE_NULL(10001, "用户手机号码不能为空"), 
		USER_NOT_EXITS(10002, "用户不存在"), 
		USER_PWD_ERR(10003, "密码错误"), 
		USER_EXITS(10006, "用户已经存在"), 
		USER_SMS_NULL(10007, "短信验证码不能为空"), 
		USER_SMS_ERR(10008, "短信验证码错误"), 
		USER_PWD_NULL(10009, "密码不能为空"),
		USER_PHONE_EXITS(10010, "该手机号码已经注册过，请登录"),
		USER_PHONE_ERR(10011, "手机号码格式错误"),
		USER_REGISTER_ERR(10012,"用户注册失败"),
		USER_REGISTER_SUCCESS(10012,"用户注册成功"),
		USER_LOGIN_ERR(10013,"用户登录失败"),
		USER_LOGIN_SUCCESS(10014,"用户登录成功"),
		USER_SMS_NOT_EXITS(10015,"短信验证码失效"),
		USER_PHONE_NOT_EXITS(10016, "该手机号码未注册"),
		USER_BIDING_ERR(10017,"绑定失败"),
		USER_BIDING_PHONE_EXITS(10018,"该手机号码已经绑定过，请换其他号码"),
		USER_BIDING_SUCCESS(10019,"绑定成功"),
		USER_UPDATE_PASSWORD_ERR(10020,"修改密码失败，请稍后重试"),
		USER_BIDING_EXIST(10021,"该帐号已经绑定过"),
		USER_NOT_PWD(10022,"未设置登录密码"),
		USER_VERIFY_ERR(10023,"验证码错误"),
		USER_FROZEN(10024,"该账号已经冻结");
		
		private final int intValue;
		private final String desc;

		UsersResEnum(int intValue, String desc) {
			this.intValue = intValue;
			this.desc = desc;
		}

		public int intValue() {
			return intValue;
		}

		public String desc() {
			return desc;
		}
	}
}
