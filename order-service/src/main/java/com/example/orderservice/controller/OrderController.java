package com.example.orderservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
    @Retry(name = "productServiceRetry", fallbackMethod = "productFallback")
    @CircuitBreaker(
            name = "productService",
            fallbackMethod = "productFallback"
    )
    public String getProductFromProductService(){
        return productClient.getAllProduct();
    }

    @GetMapping("/product/slow")
    @CircuitBreaker(
            name = "productService",
            fallbackMethod = "productFallback"
    )
    public String getSlowProductResponse() {
        return productClient.slow();
    }

    public String productFallback(Throwable throwable){
        return "Product Service is currently unavailable. Please try again later!! -_-";
    }

    @GetMapping("/product/retry")
    @Retry(name = "productServiceRetry", fallbackMethod = "productRetryFallback")
    public String getProductWithRetry() {
        return productClient.getAllProduct();
    }

    public String productRetryFallback(Throwable throwable) {
        return "Product Service failed after retry attempts!";
    }
}
