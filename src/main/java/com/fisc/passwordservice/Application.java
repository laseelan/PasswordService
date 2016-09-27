package com.fisc.passwordservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Import;

import com.fisc.accountservice.AccountServiceClient;
import com.fisc.accountservice.AccountServiceClientFallback;

@SpringBootApplication
@Import(AccountServiceClientFallback.class)
@EnableFeignClients(clients = AccountServiceClient.class)
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
