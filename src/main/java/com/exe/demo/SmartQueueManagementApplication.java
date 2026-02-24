package com.exe.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exe.demo.repository.CustomerRepository;

@SpringBootApplication
public class SmartQueueManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartQueueManagementApplication.class, args);
	}
	@Bean
    public CommandLineRunner testDB(CustomerRepository repo) {
        return args -> {
            System.out.println("Database Connected Successfully!");
        };
    }

}
