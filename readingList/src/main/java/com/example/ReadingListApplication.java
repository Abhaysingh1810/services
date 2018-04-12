package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ReadingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}
}
