package com.example.Intweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class IntweetApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntweetApplication.class, args);
	}
}
