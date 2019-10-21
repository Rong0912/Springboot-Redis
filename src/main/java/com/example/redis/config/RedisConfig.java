package com.example.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @author EDZ
 * @date 2019/10/16
 */

public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }
}
