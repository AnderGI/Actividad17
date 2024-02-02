package com.example.notas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MsNotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNotasApplication.class, args);
	}
	
	@Bean
	public RestTemplate getClient() {
		return new RestTemplate();
	}

}
