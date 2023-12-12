package com.example.jpaEcommerceServer.model.entity;

import java.util.Set;

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

    /* I changed the cascade type from all to merge
     * because with all I am also setting the type to persist
     * that make when I try to create a filter passing it a category
     * it also try to create the category, with merge it just will
     * to update the category */
    /* I changed the List<Category> to Set<Category> because
     * a filter should have uniques categories */
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "filter_category",
        joinColumns = @JoinColumn(name = "filter_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> filterCategory;
    
}
