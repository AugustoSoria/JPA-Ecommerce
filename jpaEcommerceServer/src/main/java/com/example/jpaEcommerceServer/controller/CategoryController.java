package com.example.jpaEcommerceServer.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaEcommerceServer.model.entity.Category;
import com.example.jpaEcommerceServer.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    	 
    @GetMapping()
    public ResponseEntity<List<Category>> getAll() {
        try {
            return ResponseEntity.ok(categoryService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	 
    @PostMapping("create")
    public ResponseEntity<String> save(@RequestBody Category category) {
        try {
            categoryService.save(category);
            return ResponseEntity.status(HttpStatus.CREATED).body("Category created");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong category");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
    
}
