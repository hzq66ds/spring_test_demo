package com.springboot.demo_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
@EnableHystrix
public class Demo02EurekaClient02Application {

	@RequestMapping("/{name}")
	public String sayHello(@PathVariable("name") String name){
		return "say hello1 "+name;
	}


	public static void main(String[] args) {
		SpringApplication.run(Demo02EurekaClient02Application.class, args);
	}

}

