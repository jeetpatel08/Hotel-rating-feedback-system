package com.ratingservice.ratingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingmicroserviceApplication.class, args);
	}

}
