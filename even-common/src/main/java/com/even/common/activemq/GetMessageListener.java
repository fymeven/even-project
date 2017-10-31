package com.even.common.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by fymeven on 2017/7/18.
 */
public class GetMessageListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
           if (message!=null) {
               TextMessage textMessage = (TextMessage) message;
               try {
                   System.out.println("收到消息:"+textMessage.getText());
               } catch (JMSException e) {
                   e.printStackTrace();
               }
           }
    }
}
