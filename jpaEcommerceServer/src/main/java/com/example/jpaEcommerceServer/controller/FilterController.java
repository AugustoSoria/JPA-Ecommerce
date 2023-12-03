package com.example.jpaEcommerceServer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaEcommerceServer.model.Filter;
import com.example.jpaEcommerceServer.service.FilterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/filter")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;
    	 
    @GetMapping()
    public ResponseEntity<List<Filter>> getAll() {
        return ResponseEntity.ok(filterService.getAll());
    }

    @PostMapping("create")
    public ResponseEntity<Filter> save(@RequestBody Filter filter) {
        return ResponseEntity.ok(filterService.save(filter));
    }
    
}
