package com.hotelservice.hotelmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelmicroserviceApplication.class, args);
	}

}
