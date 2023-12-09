package com.example.jpaEcommerceServer.model.metamodel;

import com.example.jpaEcommerceServer.model.Category;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

  public static volatile SingularAttribute<Category, Long> id;
  public static volatile SingularAttribute<Category, String> name;

  public static final String ID = "id";
  public static final String NAME = "name";

}