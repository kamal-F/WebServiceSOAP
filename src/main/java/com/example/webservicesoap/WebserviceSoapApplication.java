package com.example.webservicesoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.example.webservicesoap.repository","com.example.webservicesoap"})

public class WebserviceSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceSoapApplication.class, args);
	}

}
