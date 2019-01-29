package com.springboot.demo_01;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@RestController
@RequestMapping("/hello")
public class Demo02EurekaClient01Application {

	@Bean(name = "restTemplate")
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand( fallbackMethod = "sayHelloFallbackMethod")
	@RequestMapping("/{name}")
	public String sayHello(@PathVariable("name") String name){
		if("name".equalsIgnoreCase(name)){
			int a= 1/0;
			return String.valueOf(a);
		}else{
			return "say hello1 "+name;
		}
	}

	public String sayHelloFallbackMethod(@PathVariable("name") String name){
		return "say sayHelloFallbackMethod "+name;
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo02EurekaClient01Application.class, args);
	}

}

