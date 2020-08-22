package com.example.golden;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@RestController
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class CircuitBreakerGoldenApplication {
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@RequestMapping(value = "/alo")
	public String helloWorld() {
		return "Hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerGoldenApplication.class, args);
	}

}
