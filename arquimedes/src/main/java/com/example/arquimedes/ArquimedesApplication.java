package com.example.arquimedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ArquimedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquimedesApplication.class, args);
	}

}
