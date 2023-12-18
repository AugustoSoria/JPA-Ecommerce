package com.example.jpaEcommerceServer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaEcommerceServer.model.criteria.FilterValueCriteria;
import com.example.jpaEcommerceServer.model.criteria.ProductCriteria;
import com.example.jpaEcommerceServer.model.response.FilterValueAmount;
import com.example.jpaEcommerceServer.service.FilterValueService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/filter_value")
@RequiredArgsConstructor
public class FilterValueController {

    private final FilterValueService filterValueService;

    @GetMapping("values-amount-by-filter-id")
    public ResponseEntity<List<FilterValueAmount>> getFilterValueAmountByFilterId(FilterValueCriteria criteria, ProductCriteria productCriteria) {
        try {
            return ResponseEntity.ok(filterValueService.getFilterValueAmountByFilterId(criteria, productCriteria));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    } 
}
