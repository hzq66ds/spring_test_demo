package com.springboot.demo_01.restcontrllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RestController01")
public class RestController01 {
    @RequestMapping("/test01/{name}/{age}")
    public String test01(@PathVariable("name")String name,@PathVariable("age")Integer age){
        return "test01\t"+name+"\t"+age;
    }
}
