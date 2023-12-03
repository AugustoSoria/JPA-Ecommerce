package com.example.jpaEcommerceServer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jpaEcommerceServer.model.Filter;
import com.example.jpaEcommerceServer.repository.FilterRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilterService {

    private final FilterRepository filterRepository;
    
    public List<Filter> getAll() {
        return filterRepository.findAll();
    }

    public Filter save(Filter filter) {
        return filterRepository.save(filter);
    }
    
}
