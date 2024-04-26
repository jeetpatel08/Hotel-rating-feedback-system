package com.servicereregistry.servicereregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServicereregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicereregistryApplication.class, args);
	}

}
