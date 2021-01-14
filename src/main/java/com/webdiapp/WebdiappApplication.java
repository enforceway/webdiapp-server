package com.webdiapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.webdiapp.questionaire.mapper")
public class WebdiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebdiappApplication.class, args);
	}

}
