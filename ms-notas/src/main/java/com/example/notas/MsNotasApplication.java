package com.example.notas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MsNotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNotasApplication.class, args);
	}
	
	@Bean
	// Ribbon
	@LoadBalanced
	public RestTemplate getClient() {
		return new RestTemplate();
	}

}
