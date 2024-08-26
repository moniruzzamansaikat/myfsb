package com.example.myfsb_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
public class MyfsbProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfsbProjectApplication.class, args);
	}

}
