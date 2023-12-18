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
        try {
            return ResponseEntity.ok(filterService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("byCriteria")
    public ResponseEntity<List<Filter>> getAllByCriteria(FilterCriteria criteria) {
        try {
            return ResponseEntity.ok(filterService.getAllByCriteria(criteria));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("create")
    public ResponseEntity<String> save(@RequestBody Filter filter) {
        try {
            filterService.save(filter);
            return ResponseEntity.status(HttpStatus.CREATED).body("Filter created");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong Filter");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
    
}
