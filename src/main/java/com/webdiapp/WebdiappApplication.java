package com.webdiapp;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.webdiapp.questionaire.mapper","com.webdiapp.question.mapper","com.webdiapp.user.mapper"})
public class WebdiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebdiappApplication.class, args);
	}

}
