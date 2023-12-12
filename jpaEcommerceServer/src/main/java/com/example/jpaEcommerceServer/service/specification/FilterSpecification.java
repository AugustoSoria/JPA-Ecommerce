package com.example.jpaEcommerceServer.service.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.jpaEcommerceServer.model.criteria.FilterCriteria;
import com.example.jpaEcommerceServer.model.entity.Filter;
import com.example.jpaEcommerceServer.model.metamodel.Category_;
import com.example.jpaEcommerceServer.model.metamodel.Filter_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class FilterSpecification {
    public static Specification<Filter> byCriteria(FilterCriteria criteria) {
        return (Root<Filter> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(criteria != null) {
                /* In this case I am using the like predicate and concating the % string
                 * because if the categoryName is a empty string i would like to get all filters */
                if (criteria.getCategoryName() != null) {
                    Predicate categoryNamePredicate = criteriaBuilder
                        .like(root.join(Filter_.FILTER_CATEGORY, JoinType.INNER)
                            .get(Category_.NAME), "%" + criteria.getCategoryName()
                        );
                    predicates.add(categoryNamePredicate);
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}
