package com.sgcc.jxd.microservicestorage.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Bean
    public Queue queueStorage(){
        return new Queue("Storage_queue",true);
    }
}
