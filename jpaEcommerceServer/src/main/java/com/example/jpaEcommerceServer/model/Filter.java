package com.example.jpaEcommerceServer.model;

import java.util.ArrayList;
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
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="filter")
public class Filter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isRange = false;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "filter_category",
        joinColumns = @JoinColumn(name = "filter_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> filterCategory = new ArrayList<Category>();
    
}
