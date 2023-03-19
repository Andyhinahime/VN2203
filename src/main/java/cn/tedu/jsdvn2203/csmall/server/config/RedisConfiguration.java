package cn.tedu.jsdvn2203.csmall.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.Serializable;

@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String , Serializable> redisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ){
        RedisTemplate<String , Serializable> redisTemplate = new RedisTemplate<>();
        //1.連接redis
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //2.配置序列化器 - 對象序列化才能在網路傳輸
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.json()); //Value 通過json傳輸

        return redisTemplate;

    }

}
