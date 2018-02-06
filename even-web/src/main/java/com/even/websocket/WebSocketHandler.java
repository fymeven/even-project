package com.even.websocket;

import com.alibaba.fastjson.JSONObject;
import com.even.bean.SysMessage;
import com.even.bean.SysUser;
import com.even.common.util.BeanCopyUtil;
import com.even.dao.SysMessageMapper;
import com.even.io.sysMessage.enums.SysMessageEnums;
import com.even.io.sysMessage.response.SysMessageResponse;
import com.even.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WebSocketHandler implements org.springframework.web.socket.WebSocketHandler {

    private static Logger logger = LoggerFactory.getLogger(HandshakeInterceptor.class);

    @Resource
    private SysMessageMapper sysMessageMapper;
    @Resource
    private ISysUserService sysUserService;

    public static final Map<Long, WebSocketSession> userSocketSessionMap=new HashMap<>();

    public static int onlineCount ;//在线人数

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        Long userId = (Long) webSocketSession.getHandshakeAttributes().get("CURRENT_USER_ID");
        if (userSocketSessionMap.get(userId) == null) {
            userSocketSessionMap.put(userId, webSocketSession);
            onlineCount ++;
        }
        logger.info("id:{},加入webSocket连接,当前{}在线", userId,onlineCount);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        SysMessageResponse sysMessageResponse= JSONObject.parseObject(webSocketMessage.getPayload().toString(),SysMessageResponse.class);
        //同步消息至数据库
        SysUser sysUser = sysUserService.detail(sysMessageResponse.getToId());
        sysMessageResponse.setToName(sysUser.getRealName());
        sysMessageResponse.setSendTime(new Date());
        sysMessageResponse.setIsRead(SysMessageEnums.isRead.NO.getByteValue());
        SysMessage sysMessage = new SysMessage();
        BeanCopyUtil.copyProperties(sysMessage,sysMessageResponse);
        sysMessageMapper.insert(sysMessage);
        //发送消息
        sendMessageToUser(sysMessageResponse.getToId(),new TextMessage(JSONObject.toJSONString(sysMessageResponse)));
        logger.info("id:{}向id:{}发送了webSocket消息", sysMessage.getFromId(),sysMessage.getToId());
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }
        Long userId = (Long) webSocketSession.getHandshakeAttributes().get("CURRENT_USER_ID");
        for (Long key : userSocketSessionMap.keySet()) {
            if(key == userId){
                userSocketSessionMap.remove(key);
                onlineCount --;
            }
        }
        logger.info("id:{},已退出webSocket连接,当前{}在线", userId,onlineCount);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        if(webSocketSession.isOpen()){
            webSocketSession.close();
        }
        Long userId = (Long) webSocketSession.getHandshakeAttributes().get("CURRENT_USER_ID");
        for (Long key : userSocketSessionMap.keySet()) {
            if(key == userId){
                userSocketSessionMap.remove(key);
                onlineCount --;
            }
        }
        logger.info("id:{},已退出webSocket连接,当前{}在线", userId,onlineCount);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 发送消息给指定的用户
     */
    public void sendMessageToUser(Long userId,TextMessage message) throws IOException {
        WebSocketSession webSocketSession = userSocketSessionMap.get(userId);
        if(webSocketSession !=null && webSocketSession.isOpen()){
            webSocketSession.sendMessage(message);
        }
    }

}
