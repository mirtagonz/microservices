package com.py.microservices.kangaroo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class CircuitBreakerKangarooApplication {

    @RequestMapping(value = "/ping")
    public String readingList() {
        return "Kangaroo response";
    }

    public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerKangarooApplication.class, args);
    }
}
