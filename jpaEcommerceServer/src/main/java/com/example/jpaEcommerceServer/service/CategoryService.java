package com.example.jpaEcommerceServer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jpaEcommerceServer.model.entity.Category;
import com.example.jpaEcommerceServer.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
    
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    
}
