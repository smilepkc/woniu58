package com.pk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.pk.service")
public class SpringCloudDemoConsumerFeign60 {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDemoConsumerFeign60.class, args);
	}
}
