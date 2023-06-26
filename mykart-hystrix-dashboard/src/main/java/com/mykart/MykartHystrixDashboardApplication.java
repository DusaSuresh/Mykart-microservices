package com.mykart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class MykartHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MykartHystrixDashboardApplication.class, args);
	}

}
