package com.springboot.demo_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
@EnableEurekaClient
public class Demo01Application {

	@RequestMapping("/{name}")
	public String sayHello(@PathVariable("name") String name){
		return "say hello1 "+name;
	}


	public static void main(String[] args) {
		SpringApplication.run(Demo01Application.class, args);
	}

}

