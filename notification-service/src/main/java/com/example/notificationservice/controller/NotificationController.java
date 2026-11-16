package com.example.notificationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notifications")
public class NotificationController {
    @GetMapping("/hello")
    public String printHello(){
        return "Hello From Notifications Controller!! -_-";
    }
}
