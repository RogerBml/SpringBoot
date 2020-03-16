package com.sgcc.jxd.microservicelogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceLoginApplication.class, args);
    }

}
