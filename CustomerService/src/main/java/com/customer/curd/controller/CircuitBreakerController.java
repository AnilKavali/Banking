package com.customer.curd.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {
	
	Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class);
	
	
	@GetMapping("test-api")
	public String testApi() {
		return "test api is called";
	}

	@GetMapping("/sample-api")
	//@Retry(name="sample-api")
	//@Retry(name="sample-api",fallbackMethod = "dummyMethod1")
	@CircuitBreaker(name="default", fallbackMethod = "dummyMethod1")
	public String sampleApi() {
		
		logger.info("Inside sampleApi():::::::::"+new Date());
		
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8154", String.class);
		
		return response.getBody();
	}

	public String dummyMethod1(Exception ex) {
		return "Fallback dummyMethod-1 is called";
	}
	
	public String dummyMethod2(Exception ex) {
		return "Fallback dummyMethod-2 is called";
	}
}
