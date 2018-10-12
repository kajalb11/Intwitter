package com.example.Intwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class IntwitterApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(IntwitterApplication.class, args);
	}
}
