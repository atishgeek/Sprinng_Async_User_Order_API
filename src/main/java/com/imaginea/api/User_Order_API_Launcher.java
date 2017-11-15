package com.imaginea.api;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class User_Order_API_Launcher {

	
	/**
	 * This method will initialize our spring boot application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(User_Order_API_Launcher.class, args);
	}

	
	@Bean
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(4);
		executor.setMaxPoolSize(4);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("Api Caller-");
		executor.initialize();
		
		return executor;
	}
	
	
	
}
