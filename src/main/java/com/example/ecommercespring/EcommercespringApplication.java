package com.example.ecommercespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing   
public class EcommercespringApplication {

	public static void main(String[] args) {
        
		SpringApplication.run(EcommercespringApplication.class, args);
	}

}
