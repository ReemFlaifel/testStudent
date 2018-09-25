package com.erabia.applicationstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.erabia")

public class ApplicationStarter {
	public static void main(String args[]) throws Exception {
		SpringApplication.run(ApplicationStarter.class, args);
	}
}
