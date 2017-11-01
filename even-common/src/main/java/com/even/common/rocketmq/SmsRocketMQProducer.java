package com.even.common.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * Created by even on 2017/11/1.
 */
public class SmsRocketMQProducer {
    private DefaultMQProducer defaultMQProducer;
    private String producerGroup;
    private String namesrvAddr;

    public DefaultMQProducer getDefaultMQProducer() {
        return defaultMQProducer;
    }

    public void setDefaultMQProducer(DefaultMQProducer defaultMQProducer) {
        this.defaultMQProducer = defaultMQProducer;
    }

    public String getProducerGroup() {
        return producerGroup;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public void init() throws MQClientException {
        //用带producer group参数的构造方法初始化producer
        defaultMQProducer=new DefaultMQProducer(producerGroup);
        //设置rocketMq的nameserver服务，多个地址用分号 （；）分隔
        defaultMQProducer.setNamesrvAddr(namesrvAddr);
        //启动producer
        defaultMQProducer.start();
    }

    public void destory(){
        defaultMQProducer.shutdown();
    }
}
