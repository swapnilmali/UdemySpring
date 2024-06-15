package com.firstSpringApp.DemoApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    @GetMapping("/wecome")
    public String sayHello() {
        return "Hello Swapnil";
    }
}
