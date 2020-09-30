package com.shanjupay.transaction.config;

import com.shanjupay.common.cache.ICache;
import com.shanjupay.transaction.common.util.RedisCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration
public class RedisConfig {

    @Bean
    public ICache cache(StringRedisTemplate stringRedisTemplate) {
        return new RedisCache(stringRedisTemplate);
    }
}
