package com.example.swaggerexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/")
    public String hell() {
        return "Hello world)!";
    }
}

