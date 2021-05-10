package com.study.friendsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldContorller {
    @GetMapping("/api/helloworld")
    public String helloWorld(){
        return "Hello World";
    }
}
