package com.example.jpaEcommerceServer.model.metamodel;

import com.example.jpaEcommerceServer.model.entity.Category;
import com.example.jpaEcommerceServer.model.entity.Filter;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Filter.class)
public class Filter_ {

  public static volatile SingularAttribute<Filter, Long> id;
  public static volatile SingularAttribute<Filter, String> name;
  public static volatile SingularAttribute<Filter, Boolean> isRange;
  public static volatile ListAttribute<Filter, Category> filterCategory;

  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String IS_RANGE = "isRange";
  public static final String FILTER_CATEGORY = "filterCategory";

}

