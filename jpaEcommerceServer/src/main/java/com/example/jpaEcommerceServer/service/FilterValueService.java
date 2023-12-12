package com.example.jpaEcommerceServer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.jpaEcommerceServer.model.criteria.FilterValueCriteria;
import com.example.jpaEcommerceServer.model.criteria.ProductCriteria;
import com.example.jpaEcommerceServer.model.entity.FilterValue;
import com.example.jpaEcommerceServer.model.entity.Product;
import com.example.jpaEcommerceServer.model.response.FilterValueAmount;
import com.example.jpaEcommerceServer.repository.FilterValueRepository;
import com.example.jpaEcommerceServer.repository.ProductRepository;
import com.example.jpaEcommerceServer.service.specification.FilterValueSpecification;
import com.example.jpaEcommerceServer.service.specification.ProductSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilterValueService {

    private final FilterValueRepository filterValueRepository;
    private final ProductRepository productRepository;

    // Get the filter values by filter id, and mapped these to a FilterValueAmount list
    public List<FilterValueAmount> getFilterValueAmountByFilterId(FilterValueCriteria filterValueCriteria, ProductCriteria productCriteria) {
        
        Specification<FilterValue> spec = FilterValueSpecification.byFilterId(filterValueCriteria.getFilterId());
        // we get all the filter values by their filter id
        List<FilterValue> values = filterValueRepository.findAll(spec);

        List<FilterValueAmount> list = new ArrayList<FilterValueAmount>();

        /* for each filter value, we check if it exists in the FilterValueAmount list,
            if it does not exist, we get all the products with that filter value,
            then with the value itself and the products amount
            we create the FilterValueAmount object which is added to FilterValueAmount list.
            With this we would get for example to the filter model of the possible model values
            and how many products with that especific value there are */
        values.forEach(filterValue -> {
            Optional<FilterValueAmount> exists = list.stream().filter(l -> l.getValue().equals(filterValue.getValue())).findAny();

            if(!exists.isPresent()) {
                Specification<Product> productSpec = ProductSpecification.productsByFilterValueAndCriteria(filterValue.getValue(), filterValueCriteria.getFilterId(), productCriteria);
                List<Product> products = productRepository.findAll(productSpec);

                FilterValueAmount newFilterValueAmount = new FilterValueAmount(filterValue.getValue(), products.size());

                list.add(newFilterValueAmount);
            }
        });
        
        return list;
    }
}
