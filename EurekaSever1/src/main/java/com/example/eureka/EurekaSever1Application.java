package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSever1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaSever1Application.class, args);
	}

}
