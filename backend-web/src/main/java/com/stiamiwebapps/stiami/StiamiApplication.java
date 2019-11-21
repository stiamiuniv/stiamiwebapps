package com.stiamiwebapps.stiami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages={"stiami"})
@EnableAsync
public class StiamiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StiamiApplication.class, args);
	}

}
