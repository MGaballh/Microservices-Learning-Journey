package com.example.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @GetMapping("/hello")
    public String printHello(){
        return "Hello From Products Controller!! -_-";
    }

    @GetMapping("/all")
    public String getAll(){
        return "All Products --> (Phone, Laptop, TV, Tones) !! -_-";
    }

    @GetMapping("/slow")
    public String slowResponse() throws InterruptedException {
        Thread.sleep(5000);

        return "Response From Product Service After 5 Seconds";
    }

}
