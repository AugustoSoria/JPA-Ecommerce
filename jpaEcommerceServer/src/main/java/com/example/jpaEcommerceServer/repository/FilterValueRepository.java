package com.example.jpaEcommerceServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.jpaEcommerceServer.model.entity.FilterValue;

@Repository
public interface FilterValueRepository extends JpaRepository<FilterValue, Long>, JpaSpecificationExecutor<FilterValue> {
}