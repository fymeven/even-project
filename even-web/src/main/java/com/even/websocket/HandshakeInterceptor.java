package com.even.websocket;

import com.even.bean.SysUser;
import com.even.common.util.ShiroUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;

import java.util.Map;

public class HandshakeInterceptor implements org.springframework.web.socket.server.HandshakeInterceptor {
    private static Logger logger = LoggerFactory.getLogger(HandshakeInterceptor.class);
    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
            //使用userName区分WebSocketHandler，以便定向发送消息
            SysUser loginUser= ShiroUtil.getUser();
            if (loginUser != null){
                map.put("CURRENT_USER_ID", loginUser.getId());
                logger.info("当前webSocket用户为:{}", loginUser.getUserName());
            }else {
                logger.info("为获取到登录用户");
            }
        }

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {

    }
}
