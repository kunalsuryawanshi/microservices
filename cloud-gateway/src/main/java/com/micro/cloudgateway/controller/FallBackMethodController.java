package com.micro.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service is Taking Longer than Expected.";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod(){
        return "Department Service is Taking Longer than Expected.";
    }
}
