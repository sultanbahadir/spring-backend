package com.menu.starter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.menu"})
@SpringBootApplication(scanBasePackages = "com.menu")
@EnableJpaRepositories(basePackages = "com.menu")
public class MenuManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuManagementSystemApplication.class, args);
	}

}
