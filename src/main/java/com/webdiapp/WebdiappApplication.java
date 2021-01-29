package com.webdiapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan({"com.webdiapp.questionaire.mapper","com.webdiapp.question.mapper","com.webdiapp.questionItem.mapper","com.webdiapp.user.mapper","com.webdiapp.roleAccess.mapper"})
public class WebdiappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebdiappApplication.class, args);
	}

}
