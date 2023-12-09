package com.example.jpaEcommerceServer.service.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.jpaEcommerceServer.model.Product;
import com.example.jpaEcommerceServer.model.criteria.ProductCriteria;
import com.example.jpaEcommerceServer.model.metamodel.Category_;
import com.example.jpaEcommerceServer.model.metamodel.Product_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProductSpecification {

    public static Specification<Product> productsByCriteria(ProductCriteria criteria) {
        return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            // I created a list of predicates to be able to concatenate specification based on 
            // the product criteria
            List<Predicate> urlParamsPredicates = new ArrayList<>();

            if(criteria != null) {
                // A specification to get products based in the category name they belong
                if(criteria.getCategory() != null) {
                    Predicate predicateCategoryName = criteriaBuilder
                        .equal(root.get(Product_.CATEGORY).get(Category_.NAME), criteria.getCategory());
                    urlParamsPredicates.add(predicateCategoryName);
                }
            }
            
            return criteriaBuilder.and(urlParamsPredicates.toArray(new Predicate[0]));
        };
    }
}
