package com.example.springnatvkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@EnableFeignClients(basePackages = "com.example.springnatvkg.microservices")
@SpringBootApplication
public class SpringNaTvKgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNaTvKgApplication.class, args);
	}

}
