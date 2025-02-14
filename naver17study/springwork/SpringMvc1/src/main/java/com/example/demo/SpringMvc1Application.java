package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
//@ComponentScan({"controller.test","lombok.test"})
@ComponentScan({"*.test","bitcamp.study"}) //wild card도 가능

public class SpringMvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvc1Application.class, args);
	}

}
