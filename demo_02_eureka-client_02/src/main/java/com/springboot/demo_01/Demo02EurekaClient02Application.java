package com.springboot.demo_01;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private MyConfig myConfig;

	@RequestMapping("/{name}")
	@HystrixCommand(fallbackMethod = "sayHelloFallbackMethod")
	public String sayHello(@PathVariable("name") String name){
		if ("name".equalsIgnoreCase(name)){
			int a = 1/0;
			return String.valueOf(a);
		}else{
			return "say hello1 "+name+"\t"+myConfig.getServers().size()+"\t"+myConfig.getServers().get(0);
		}
	}

	public String sayHelloFallbackMethod(@PathVariable("name") String name){
		return "say Demo02EurekaClient02Application  sayHelloFallbackMethod  "+name;
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo02EurekaClient02Application.class, args);
	}

}

