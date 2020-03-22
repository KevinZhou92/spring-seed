package com.pengcheng.springseed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pengcheng.springseed")
public class SpringSeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeedApplication.class, args);
	}

}
