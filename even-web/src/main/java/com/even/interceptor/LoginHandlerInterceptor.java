package com.even.interceptor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 
* 类名称：
* 类描述： 登录过滤，权限验证
* @author even
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{
    private static final Logger logger = LogManager.getLogger(LoginHandlerInterceptor.class.getName());
    @Value("${loginUrl}")
    private String loginUrl;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        printRequestInfo(request);
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated() || subject.isRemembered()){
			return true;
		}else{
            response.sendRedirect(loginUrl);
            return false;
		}
	}

    private void printRequestInfo(HttpServletRequest request) {
        Enumeration<String> names = request.getParameterNames();
        StringBuilder sb = new StringBuilder("请求参数为{");
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String values = request.getParameter(name);
            sb.append(name + ":" + values + ", ");
        }
        sb.append("}");
        logger.info("请求地址Start: " + request.getRequestURI() + ", " + sb.toString());
    }
	
}
