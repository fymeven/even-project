package com.even.interceptor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
        printRequestInfo(request);
//		String path = request.getServletPath();
//		if(path.matches(Const.NO_INTERCEPTOR_PATH)){
//			return true;
//		}else{
//			User user = (User)Jurisdiction.getSession().getAttribute(Const.SESSION_USER);
//			if(user!=null){
//				path = path.substring(1, path.length());
//				boolean b = Jurisdiction.hasJurisdiction(path); //访问权限校验
//				if(!b){
//					response.sendRedirect(request.getContextPath() + Const.LOGIN);
//				}
//				return b;
//			}else{
//				//登陆过滤
//				response.sendRedirect(request.getContextPath() + Const.LOGIN);
//				return false;
//			}
//		}
        return true;
	}

    private void printRequestInfo(HttpServletRequest request) {
        Enumeration<String> names = request.getParameterNames();
        StringBuilder sb = new StringBuilder("请求参数为{");
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String values = request.getParameter(name);
            sb.append(name + ":" + values + ", ");
        }
        sb.append("}");
        logger.info("请求地址Start: " + request.getRequestURI() + ", " + sb.toString());
    }
	
}
