package com.jay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaAuditing
public class JaySpringRestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaySpringRestProjectApplication.class, args);
	}
}
