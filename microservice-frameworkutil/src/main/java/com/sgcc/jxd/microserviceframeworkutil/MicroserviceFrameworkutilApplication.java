package com.sgcc.jxd.microserviceframeworkutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceFrameworkutilApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceFrameworkutilApplication.class, args);
    }

}
