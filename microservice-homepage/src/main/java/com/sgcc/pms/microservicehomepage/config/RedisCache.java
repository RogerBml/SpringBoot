package com.sgcc.pms.microservicehomepage.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisCache extends CachingConfigurerSupport {


    @Override
    public KeyGenerator keyGenerator() {
        return (taget, method, param) -> {
            String tagetName = taget.getClass().getName();
            String methodName = method.getName();
            return tagetName + "_" + methodName ;

        };

    }
}
