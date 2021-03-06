package com.springboot.demo_01.restcontrllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableHystrix
@RequestMapping("/RestController01")
public class RestController01 {
    @HystrixCommand(fallbackMethod = "test01FallbackMethod")
    @RequestMapping("/test01/{name}/{age}")
    public String test01(@PathVariable("name")String name,@PathVariable("age")Integer age){
        return "test01\t"+name+"\t"+age;
    }

    public String test01FallbackMethod(@PathVariable("name")String name,@PathVariable("age")Integer age){
        return "say RestController01  test01FallbackMethod  "+name;
    }
}
