package com.ty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookManagementSystemApplication.class, args);
	}
		// Bean used for making external REST API calls (e.g., to Google Books API)
		@Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
		   
	}

}
