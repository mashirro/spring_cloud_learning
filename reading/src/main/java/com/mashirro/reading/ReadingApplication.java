package com.mashirro.reading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class ReadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
