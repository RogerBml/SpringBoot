package com.sgcc.pms.mricroservicegoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients(basePackages = "com.sgcc.pms.mricroservicegoods.service.servicecalls")
@EnableCaching
@EnableDiscoveryClient
public class MricroserviceGoodsApplication {

    public static void main(String[] args) {

        SpringApplication.run(MricroserviceGoodsApplication.class, args);
    }

}
