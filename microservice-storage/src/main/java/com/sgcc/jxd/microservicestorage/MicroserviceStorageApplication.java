package com.sgcc.jxd.microservicestorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceStorageApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(MicroserviceStorageApplication.class, args);
    }

}
