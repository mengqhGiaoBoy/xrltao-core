package com.xrltao.timed;

import com.xrltao.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.connection.RedisStringCommands;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.data.redis.core.types.Expiration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/17 20:16
 * @Description
 */

public class TimedTaskDemo {
//    @Resource
//    RedisTemplate<String, Object> redisTemplate;
//    @Scheduled(cron = "0/5 * * * * * ")
//    public void redisLockTest() throws UnknownHostException {
//        System.out.println(redisLock());
//        System.out.println(redisTemplate.opsForValue().get("asd"));
//    }
//
//    public Boolean redisLock () throws UnknownHostException {
//        DefaultRedisScript script = new DefaultRedisScript();
//        //设置资源位置
//        script.setScriptSource(
//                new ResourceScriptSource(
//                        new ClassPathResource("redisAddLock.lua")
//                )
//        );
//        //设置返回值类型
//        script.setResultType(Boolean.class);
//        List list = new ArrayList();
//        list.add("asd");
//        list.add(InetAddress.getLocalHost().getHostAddress());
//        return  (Boolean) redisTemplate.execute(script, list);
//    }
//
//    public boolean setLock(String key, long expire) {
//        try {
//            Boolean execute = redisTemplate.execute(new RedisCallback<Boolean>() {
//                @Override
//                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
//                    return connection.set("key".getBytes(), "锁定的资源".getBytes(),
//                            Expiration.seconds(expire), RedisStringCommands.SetOption.ifAbsent());
//                }
//            });
//            return execute;
//        } catch (Exception e) {
//        }
//        return false;
//    }
}
