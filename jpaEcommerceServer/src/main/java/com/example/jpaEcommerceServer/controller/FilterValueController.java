package com.example.jpaEcommerceServer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaEcommerceServer.model.criteria.FilterValueCriteria;
import com.example.jpaEcommerceServer.model.response.FilterValueAmount;
import com.example.jpaEcommerceServer.service.FilterValueService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/filter_value")
@RequiredArgsConstructor
public class FilterValueController {

    private final FilterValueService filterValueService;

    @GetMapping("values-amount-by-filter-id")
    public ResponseEntity<List<FilterValueAmount>> getFilterValueAmountByFilterId(FilterValueCriteria criteria) {
        List<FilterValueAmount> map = filterValueService.getFilterValueAmountByFilterId(criteria);
        return ResponseEntity.ok(map);
    } 
}
