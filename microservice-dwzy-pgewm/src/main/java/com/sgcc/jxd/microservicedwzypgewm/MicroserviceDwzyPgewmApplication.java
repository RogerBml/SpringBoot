package com.sgcc.jxd.microservicedwzypgewm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MicroserviceDwzyPgewmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDwzyPgewmApplication.class, args);
    }

}
