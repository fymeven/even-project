package com.even.listener.shiro;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * Created by fymeven on 2017/10/29.
 */
public class ShiroSessionListener implements SessionListener {
    private static final Logger logger= LogManager.getLogger(ShiroSessionListener.class.getName());
    @Override
    public void onStart(Session session) {
        logger.info("创建会话:"+session.getId());
    }

    @Override
    public void onStop(Session session) {
        logger.info("会话停止:"+session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        logger.info("会话过期:"+session.getId());
    }
}
