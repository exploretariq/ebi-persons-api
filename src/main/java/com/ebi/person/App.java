package com.ebi.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

/**
 * Main class for loading the spring boot application.
 */
@Slf4j
@SpringBootApplication
@ComponentScan("com.ebi.person")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		log.info("Application started");
	}
}
