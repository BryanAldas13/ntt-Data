package com.nttdata.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.nttdata.devops"})
public class DevopsApplication {

	public static void main(String[] args) {

		SpringApplication.run(DevopsApplication.class, args);
	}

}
