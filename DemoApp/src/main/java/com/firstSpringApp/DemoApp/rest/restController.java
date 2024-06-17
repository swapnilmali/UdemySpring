package com.firstSpringApp.DemoApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    //Inject value from properties file
    @Value("${developer.name}")
    String name;

    @GetMapping("/welcome")
    public String sayHello() {
        return "Hello "+name;
    }
}
