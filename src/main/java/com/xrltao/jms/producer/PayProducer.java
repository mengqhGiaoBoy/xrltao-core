package com.xrltao.jms.producer;

import com.xrltao.config.JmsConfig;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/22 19:06
 * @Description
 */
//@Component
public class PayProducer {

    private DefaultMQProducer producer;
    private String producerGroup = "pay_producer_group";

    public PayProducer() {
        producer = new DefaultMQProducer();
        //设置组
        producer.setProducerGroup(producerGroup);
        //地址
        producer.setNamesrvAddr(JmsConfig.NAME_ADDR);
        start();
    }

    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown(){
        this.producer.shutdown();
    }

    public SendResult send(Message message) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        SendResult send = producer.send(message);
        return send;
    }
}
