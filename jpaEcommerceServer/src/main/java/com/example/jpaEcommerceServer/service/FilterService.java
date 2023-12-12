package com.example.jpaEcommerceServer.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.jpaEcommerceServer.model.criteria.FilterCriteria;
import com.example.jpaEcommerceServer.model.entity.Filter;
import com.example.jpaEcommerceServer.repository.FilterRepository;
import com.example.jpaEcommerceServer.service.specification.FilterSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final FilterRepository filterRepository;
    
    public List<Filter> getAll() {
        return filterRepository.findAll();
    }
    
    public List<Filter> getAllByCriteria(FilterCriteria criteria) {
        Specification<Filter> spec = FilterSpecification.byCriteria(criteria);
        return filterRepository.findAll(spec);
    }

    public Filter save(Filter filter) {
        return filterRepository.save(filter);
    }
    
}
