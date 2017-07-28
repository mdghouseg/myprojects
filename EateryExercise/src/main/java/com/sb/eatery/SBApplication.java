package com.sb.eatery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sb.eatery.service.EateryService;

@SpringBootApplication
public class SBApplication {
	private static final Logger logger = LoggerFactory.getLogger(SBApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SBApplication.class, args);
	}

	@Autowired
	EateryService eateryService;

	@Bean
	public CommandLineRunner run() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				logger.debug("Application Bootstrapped!");
			}
		};
	}
}
