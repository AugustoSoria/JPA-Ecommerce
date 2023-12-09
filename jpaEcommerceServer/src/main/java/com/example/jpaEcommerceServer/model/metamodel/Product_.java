package com.example.jpaEcommerceServer.model.metamodel;

import java.math.BigDecimal;

import com.example.jpaEcommerceServer.model.Category;
import com.example.jpaEcommerceServer.model.FilterValue;
import com.example.jpaEcommerceServer.model.Product;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

// These type of classes are to not use strings when we want to access to an entity property 
// when we are creating a specification
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

  public static volatile SingularAttribute<Product, Long> id;
  public static volatile SingularAttribute<Product, String> name;
  public static volatile SingularAttribute<Product, BigDecimal> price;
  public static volatile SingularAttribute<Product, Boolean> priceInUsd;
  public static volatile SingularAttribute<Product, Category> category;
  public static volatile ListAttribute<Product, FilterValue> filterValues;

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String PRICE = "price";
  public static final String PRICE_IN_USD = "priceInUsd";
  public static final String CATEGORY = "category";
  public static final String FILTER_VALUES = "filterValues";

}
