package com.xrltao.jms.consumer;

import com.xrltao.config.JmsConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/22 19:06
 * @Description
 */
//@Component
public class PayConsumer {

    private DefaultMQPushConsumer consumer;
    private String consumerGroup = "pay_consumer_group";

    public PayConsumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer();
        //组
        consumer.setConsumerGroup(consumerGroup);
        //地址
        consumer.setNamesrvAddr(JmsConfig.NAME_ADDR);
        //消费偏移量
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        //主题，* 订阅所有
        consumer.subscribe("TopicTest","*");
//        consumer.subscribe("TopicTest", MessageSelector.bySql(" sql > 4"));
        //注册消息监听器
        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
            MessageExt messageExt = msgs.get(0);
            //通过messageExt.get 你就可以为所欲为了 哈哈哈
            System.out.println(messageExt.getBodyCRC());
            return ConsumeOrderlyStatus.SUCCESS;
        });
        startListener();
    }
    public void  startListener() throws MQClientException {
        consumer.start();
        System.out.println("开始监听");
    }
}
