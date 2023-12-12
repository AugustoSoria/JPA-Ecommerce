package com.example.jpaEcommerceServer.model.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data // this lombok annotation provides us getter and setter to each field, so we dont need to explicitly write them
@Entity // this annotation mark the java class as a persistent entity, so it will be mapping to a database table
@Table(name="product")
public class Product {
    
    @Id // this annotation indicate that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // with GeneratedValue we can indicate how the primary key should be generated, in this case it will be auto incremented
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    BigDecimal price;

    // I would like to handle ARS and USD currencies for that this field
    Boolean priceInUsd = false;

    // Every product will belong to a category, for example vehicles or clothes
    // Many to one because many products could belong to a category
    @ManyToOne()
    @JoinColumn(nullable = false)
    private Category category;

    // The CascadeType attribute help us to specify how the FilterValue entity should be updated from the owning entity
    // The JoinTable annotation define how the ManyToMany table will be created, in this case with the field product_id and filter_value_id
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_filter_value",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "filter_value_id")
    )
    private List<FilterValue> filterValues;

}

/*
    To this example I would like to have the possibility of create categories, filters, etc. to each product
    So FilterValue is the table which will have the possible values of a filter
    for example if we have in the category vehicle, one possible filter would be "year",
    to this case each filterValue could be 2023, 2022 or any release date of a vehicle
*/