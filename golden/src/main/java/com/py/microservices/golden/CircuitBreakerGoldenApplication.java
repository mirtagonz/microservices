package com.py.microservices.golden;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class CircuitBreakerGoldenApplication {

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerGoldenApplication.class, args);
	}

}
