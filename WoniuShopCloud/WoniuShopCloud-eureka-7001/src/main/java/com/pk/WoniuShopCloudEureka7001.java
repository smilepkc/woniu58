package com.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WoniuShopCloudEureka7001 {

	public static void main(String[] args) {
		SpringApplication.run(WoniuShopCloudEureka7001.class, args);
	}
}
