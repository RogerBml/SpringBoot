package com.sgcc.jxd.microserviceorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.sgcc.jxd.microserviceorders.service.goodsService")
@EnableCaching
public class MicroserviceOrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceOrdersApplication.class, args);
    }

}
