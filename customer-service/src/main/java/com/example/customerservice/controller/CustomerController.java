package com.example.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @GetMapping("/hello")
    public String printHello(){
        return "Hello From Customers Controller!! -_-";
    }
}
