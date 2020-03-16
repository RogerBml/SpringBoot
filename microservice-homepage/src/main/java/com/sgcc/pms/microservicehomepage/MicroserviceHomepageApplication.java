package com.sgcc.pms.microservicehomepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.sgcc.pms.microservicehomepage.service")
//@EnableCircuitBreaker
@EnableCaching
public class MicroserviceHomepageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceHomepageApplication.class, args);
    }

}
