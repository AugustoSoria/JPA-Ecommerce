package com.example.jpaEcommerceServer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jpaEcommerceServer.model.Product;
import com.example.jpaEcommerceServer.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

// The service annotation set this class as a service spring component, I will use this class to comunicate
// the controller with the repository
@Service 
@RequiredArgsConstructor // Lombok annotation to generate a constructor with all required arguments
public class ProductService {

    private final ProductRepository productRepository;
    
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    
    public Product save(Product product) {
        return productRepository.save(product);
    }
    
}
