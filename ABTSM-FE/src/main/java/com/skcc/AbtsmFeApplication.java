package com.skcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//@EnableHystrix
public class AbtsmFeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbtsmFeApplication.class, args);
	}
}
