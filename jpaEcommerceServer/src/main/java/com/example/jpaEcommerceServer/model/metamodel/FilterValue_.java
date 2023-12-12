package com.example.jpaEcommerceServer.model.metamodel;

import com.example.jpaEcommerceServer.model.entity.Filter;
import com.example.jpaEcommerceServer.model.entity.FilterValue;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FilterValue.class)
public class FilterValue_ {

  public static volatile SingularAttribute<FilterValue, Long> id;
  public static volatile SingularAttribute<FilterValue, String> value;
  public static volatile SingularAttribute<FilterValue, Filter> filter;

  public static final String ID = "id";
  public static final String VALUE = "value";
  public static final String FILTER = "filter";
    
}
