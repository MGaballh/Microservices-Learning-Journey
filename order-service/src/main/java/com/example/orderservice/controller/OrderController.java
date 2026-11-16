package com.example.orderservice.controller;

import lombok.RequiredArgsConstructor;
import com.example.orderservice.client.ProductClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final ProductClient productClient;

    @GetMapping("/hello")
    public String printHello(){
        return "Hello From Order Controller!! -_-";
    }

    @GetMapping("/product")
    public String getProductFromProductService(){
        return productClient.getAllProduct();
    }
}
