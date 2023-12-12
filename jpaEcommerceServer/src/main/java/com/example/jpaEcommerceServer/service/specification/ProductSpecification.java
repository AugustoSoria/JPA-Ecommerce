package com.example.jpaEcommerceServer.service.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.jpaEcommerceServer.model.FiltersName;
import com.example.jpaEcommerceServer.model.criteria.ProductCriteria;
import com.example.jpaEcommerceServer.model.entity.Filter;
import com.example.jpaEcommerceServer.model.entity.FilterValue;
import com.example.jpaEcommerceServer.model.entity.Product;
import com.example.jpaEcommerceServer.model.metamodel.Category_;
import com.example.jpaEcommerceServer.model.metamodel.FilterValue_;
import com.example.jpaEcommerceServer.model.metamodel.Filter_;
import com.example.jpaEcommerceServer.model.metamodel.Product_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProductSpecification {

    public static Specification<Product> productsByCriteria(ProductCriteria productCriteria) {
        return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            // I created a list of predicates to be able to concatenate specification based on 
            // the product criteria
            List<Predicate> urlParamsPredicates = new ArrayList<>();

            if(productCriteria != null) {
                // A specification to get products based in the category name they belong
                if(productCriteria.getCategory() != null) {
                    Predicate predicateCategoryName = criteriaBuilder
                        .equal(root.get(Product_.CATEGORY).get(Category_.NAME), productCriteria.getCategory());
                    urlParamsPredicates.add(predicateCategoryName);
                }
                /* A specification to get products based in the filter value,
                    for example all products which model is "civic" */
                if(productCriteria.getModel() != null) {                    
                    Join<Product, FilterValue> filterValueJoin = root.join(Product_.FILTER_VALUES, JoinType.INNER);
                    Join<FilterValue, Filter> filterJoin = filterValueJoin.join(FilterValue_.FILTER);

                    Predicate predicateFilterName = criteriaBuilder.equal(filterJoin.get(Filter_.NAME), FiltersName.MODEL.name());
                    Predicate predicateFilterValue = criteriaBuilder.like(filterValueJoin.get(FilterValue_.VALUE), productCriteria.getModel());

                    urlParamsPredicates.add(predicateFilterName);
                    urlParamsPredicates.add(predicateFilterValue);
                }
                if(productCriteria.getTransmission() != null) {                    
                    Join<Product, FilterValue> filterValueJoin = root.join(Product_.FILTER_VALUES, JoinType.INNER);
                    Join<FilterValue, Filter> filterJoin = filterValueJoin.join(FilterValue_.FILTER);

                    Predicate predicateFilterName = criteriaBuilder.equal(filterJoin.get(Filter_.NAME), FiltersName.TRANSMISSION.name());
                    Predicate predicateFilterValue = criteriaBuilder.like(filterValueJoin.get(FilterValue_.VALUE), productCriteria.getTransmission());

                    urlParamsPredicates.add(predicateFilterName);
                    urlParamsPredicates.add(predicateFilterValue);
                }
            }
            
            return criteriaBuilder.and(urlParamsPredicates.toArray(new Predicate[0]));
        };
    }

    // Based on a filter value, like "civic" to the model filter, this method get all the products with that criteria
    public static Specification<Product> productsByFilterValue(String filterValue, Long filterId) {
        return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Product, FilterValue> filterValueJoin = root.join(Product_.FILTER_VALUES, JoinType.INNER);
            
            Predicate p1FilterValuePredicate = criteriaBuilder.and(
                criteriaBuilder.equal(filterValueJoin.get(FilterValue_.VALUE), filterValue),
                criteriaBuilder.equal(filterValueJoin.get(FilterValue_.FILTER).get(Filter_.ID), filterId)
            );
            predicates.add(p1FilterValuePredicate);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
