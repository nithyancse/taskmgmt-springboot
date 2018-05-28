package com.taskmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.taskmgmt.domain"})  // scan JPA entities
public class TaskmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmgmtApplication.class, args);
	}
}
