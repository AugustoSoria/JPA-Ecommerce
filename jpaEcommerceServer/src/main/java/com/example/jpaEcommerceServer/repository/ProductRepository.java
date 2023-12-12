package com.example.jpaEcommerceServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.jpaEcommerceServer.model.entity.Product;

/* 
    With the repository annotation we indicate this interface is a spring component which
    will handle the data access by CRUD methods.
    The JpaRepository interface gives us CRUD methods, paginations and sorting features to
    handle our data
*/
/* 
    The JpaSpecificationExecutor interface allow us to use JPA specifications to filter, 
    in this case, the products 
*/
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {    
}
