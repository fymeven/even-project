package com.even.controller;

import com.even.common.rocketmq.SmsRocketMQProducer;
import com.even.common.util.ResponseResult;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by even on 2017/11/1.
 */
@Controller
@RequestMapping("/message")
public class MsgController {
    @Resource
    private SmsRocketMQProducer producer;
    @ResponseBody
    @RequestMapping("/send")
    public ResponseResult send(@RequestParam("msgContent") String msgContent){
        Message message=new Message("msgTopic","tag1",msgContent.getBytes());
        try {
            producer.getDefaultMQProducer().send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResponseResult.SUCCESS("消息发送成功");
    }

    @RequestMapping("websocket")
    public String websocket(){
        return "websocket";
    }
}
