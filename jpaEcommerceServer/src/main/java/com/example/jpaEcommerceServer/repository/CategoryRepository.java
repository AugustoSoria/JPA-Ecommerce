package com.example.jpaEcommerceServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpaEcommerceServer.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
