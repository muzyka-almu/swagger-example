package com.example.swaggerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.example.swaggerexample" })
public class SwaggerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerExampleApplication.class, args);
	}
}
