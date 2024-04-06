package com.example.jpaEcommerceServer.model.criteria;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCriteria {

    private String category;
    private String model;
    private String transmission;
    private String brand;
    private String year;
    private String condition;
    private String ubication;
}
