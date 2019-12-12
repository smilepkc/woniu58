package com.pk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.pk.dao")
@EnableEurekaClient
public class WoniuShopCloudProviderUser8001 {
	public static void main(String[] args) {
		SpringApplication.run(WoniuShopCloudProviderUser8001.class, args);
	}
}
