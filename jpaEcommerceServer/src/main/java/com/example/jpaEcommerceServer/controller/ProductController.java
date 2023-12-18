package com.example.jpaEcommerceServer.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaEcommerceServer.model.criteria.ProductCriteria;
import com.example.jpaEcommerceServer.model.entity.Product;
import com.example.jpaEcommerceServer.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController // Set this class as a RESTful web service, so it can handle http request
@RequestMapping("/api/product") // Every match with "/api/product/*" will call this controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    
    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        try {
            return ResponseEntity.ok(productService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("byCriteria") 
    public ResponseEntity<List<Product>> getAllByCriteria(ProductCriteria criteria) {
        try {
            return ResponseEntity.ok(productService.getAllByCriteria(criteria));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PostMapping("create")
    public ResponseEntity<String> save(@RequestBody Product product) {
        try {
            productService.save(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product Created");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong Product");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
    
}
