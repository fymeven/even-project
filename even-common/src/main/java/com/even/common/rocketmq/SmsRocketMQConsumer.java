package com.even.common.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * Created by even on 2017/11/1.
 */
public class SmsRocketMQConsumer {
    private DefaultMQPushConsumer defaultMQPushConsumer;
    private String namesrvAddr;
    private String consumerGroup;
    private String topic="msgTopic";
    private String tag="*"; // 默认查询所有tag
//    private String key;

    public DefaultMQPushConsumer getDefaultMQPushConsumer() {
        return defaultMQPushConsumer;
    }

    public void setDefaultMQPushConsumer(DefaultMQPushConsumer defaultMQPushConsumer) {
        this.defaultMQPushConsumer = defaultMQPushConsumer;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public void init() throws MQClientException {
        //使用producer group参数的构造方法初始化producer
        defaultMQPushConsumer=new DefaultMQPushConsumer(consumerGroup);
        //设置NameServer地址
        defaultMQPushConsumer.setNamesrvAddr(namesrvAddr);
        defaultMQPushConsumer.subscribe(topic,tag);
        //设置consumer的消费策略
        //CONSUME_FROM_LAST_OFFSET 默认策略，从该队列最尾开始消费，即跳过历史消息
        //CONSUME_FROM_FIRST_OFFSET 从队列最开始开始消费，即历史消息（还储存在broker的）全部消费一遍
        //CONSUME_FROM_TIMESTAMP 从某个时间点开始消费，和setConsumeTimestamp()配合使用，默认是半个小时以前
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        defaultMQPushConsumer.registerMessageListener(
                new MessageListenerConcurrently() {
                    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,ConsumeConcurrentlyContext Context) {
                        try {
                            MessageExt msg = list.get(0);
                            String msgString = new String(msg.getBody());
                            System.out.println("msg>\n" + msgString);
                            // 返回消息状态
                            // CONSUME_SUCCESS 消费成功
                            // RECONSUME_LATER 消费失败，需要稍后重新消费
                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                        }catch (Exception ex){
                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        }
                    }
                }
        );
        //启动consumer
        defaultMQPushConsumer.start();
    }

    public void destory(){
        defaultMQPushConsumer.shutdown();
    }

}
