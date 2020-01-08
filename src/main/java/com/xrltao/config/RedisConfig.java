package com.xrltao.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/14 23:18
 * @Description Redis配置类
 */
//@Configuration
//@EnableCaching
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 50)
public class RedisConfig {
    /*
     * @author mengqh
     * @date 2019/12/14 22:39
     * @param [redisFactory]
     * @return RedisTemplate<Object,Object>
     * @description 手动注册RedisTemplate
     */
//    @Bean
//    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisFactory){
//        RedisTemplate<Object,Object> redisTemplate = new RedisTemplate();
//        //设置默认序列化器
//        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//        redisTemplate.setConnectionFactory(redisFactory);
//        return redisTemplate;
//    }
    /*
     * @author mengqh
     * @date 2019/12/15 12:10
     * @param [redisTemplate]
     * @return org.springframework.data.redis.cache.RedisCacheManager
     * @description 配置redis Cache
     */
//    @Bean
//    public CacheManager redisCacheManager(RedisTemplate redisTemplate) {
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                //设置序列化器为redisTemplate中序列化器
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getDefaultSerializer()));
//        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration,this.getRedisCacheConfigurationMap());
//    }

    /*
     * @author mengqh
     * @date 2019/12/15 12:34
     * @param []
     * @return org.springframework.cache.interceptor.KeyGenerator
     * @description redis中 key的生成策略
     */
    @Bean
    public KeyGenerator simpleKeyGenerator(){
        return (target,method,objects) -> {
            StringBuilder keyStr = new StringBuilder();
            keyStr.append(target.getClass().getSimpleName());
            keyStr.append(".");
            keyStr.append(method.getName());
            keyStr.append("[");
            for (Object obj : objects) {
                keyStr.append(obj.toString());
            }
            keyStr.append("]");
            return keyStr.toString();
        };
    }

    /*
     * @author mengqh
     * @date 2019/12/15 14:44
     * @param []
     * @return java.util.Map<java.lang.String,org.springframework.data.redis.cache.RedisCacheConfiguration>
     * @description 不同的key设置不同的序列化时间
     */
//    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
//        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
//        redisCacheConfigurationMap.put("UserInfoList", this.getRedisCacheConfigurationWithTtl(100));
//        redisCacheConfigurationMap.put("UserInfoListAnother", this.getRedisCacheConfigurationWithTtl(18000));
//        return redisCacheConfigurationMap;
//    }
    /*
     * @author mengqh
     * @date 2019/12/15 14:43
     * @param [seconds]
     * @return org.springframework.data.redis.cache.RedisCacheConfiguration
     * @description 定制 Jackson 配置key时间
     */
//    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
//        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
//                RedisSerializationContext
//                        .SerializationPair
//                        .fromSerializer(jackson2JsonRedisSerializer)
//        ).entryTtl(Duration.ofSeconds(seconds));
//
//        return redisCacheConfiguration;
//    }

}
