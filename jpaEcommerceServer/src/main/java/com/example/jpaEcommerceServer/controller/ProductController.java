package com.example.jpaEcommerceServer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaEcommerceServer.model.Product;
import com.example.jpaEcommerceServer.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController // Set this class as a RESTful web service, so it can handle http request
@RequestMapping("/api/product") // Every match with "/api/product/*" will call this controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    
    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
    
    @PostMapping("create")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }
    
}