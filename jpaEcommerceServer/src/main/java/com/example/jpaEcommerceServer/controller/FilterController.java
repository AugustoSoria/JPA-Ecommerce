package com.example.jpaEcommerceServer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaEcommerceServer.model.criteria.FilterCriteria;
import com.example.jpaEcommerceServer.model.entity.Filter;
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
    
    @GetMapping("byCriteria")
    public ResponseEntity<List<Filter>> getAllByCriteria(FilterCriteria criteria) {
        return ResponseEntity.ok(filterService.getAllByCriteria(criteria));
    }

    @PostMapping("create")
    public ResponseEntity<Filter> save(@RequestBody Filter filter) {
        return ResponseEntity.ok(filterService.save(filter));
    }
    
}
