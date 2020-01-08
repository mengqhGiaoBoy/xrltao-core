package com.xrltao.controller;

import com.xrltao.jms.consumer.PayConsumer;
import com.xrltao.jms.producer.PayProducer;
import com.xrltao.po.User;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/15 0:05
 * @Description
 */
@RestController
public class UserController {

//    @Autowired
//    private DefaultMQProducer defaultMQProducer;
//    @Autowired
//    private PayProducer payProducer;
//    @Autowired
//    private PayConsumer payConsumer;
//
//    @RequestMapping("/setSession")
//    public Object setSessionId(HttpServletRequest request, HttpServletResponse response){
//        HttpSession session = request.getSession();
//        //与sesstion redis  整合之后  只要设置session就会自动保存进redis
//        session.setAttribute("testSession",session.getId());
//        return session.getId();
//    }
//    @RequestMapping("rocketMQ")
//    public Object setRocekt() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
//        Message message = new Message("TopicTest","bodya","阿达".getBytes());
////        SendResult send = defaultMQProducer.send(message);
//        return payProducer.send(message);
//    }

}
