package com.leadgen.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = { "com.leadgen.app"})
@EntityScan(basePackages = { "com.leadgen.app"})
@EnableJpaRepositories(basePackages = { "com.leadgen.app" })

public class LeadgenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadgenApplication.class, args);
	}

}
