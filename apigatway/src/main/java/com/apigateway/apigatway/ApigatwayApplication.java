package com.apigateway.apigatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatwayApplication.class, args);
	}

}
