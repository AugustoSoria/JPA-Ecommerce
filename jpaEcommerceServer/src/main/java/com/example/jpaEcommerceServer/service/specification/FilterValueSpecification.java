package com.example.jpaEcommerceServer.service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.example.jpaEcommerceServer.model.entity.FilterValue;
import com.example.jpaEcommerceServer.model.metamodel.FilterValue_;
import com.example.jpaEcommerceServer.model.metamodel.Filter_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FilterValueSpecification {

    public static Specification<FilterValue> byFilterId(Long filterId) {
        return (Root<FilterValue> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate filterIdPredicate = criteriaBuilder.equal(
                root.get(FilterValue_.FILTER).get(Filter_.ID), filterId
            );
            return criteriaBuilder.and(filterIdPredicate);
        };
    }
    
}
