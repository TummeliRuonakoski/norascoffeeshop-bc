package com.example.norascoffeeshop.repository;
import java.util.Collection;
import java.util.List;

import com.example.norascoffeeshop.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByDeparment_idIn(Collection<Long> products);
    @Query("select product from Product product where lower(product.name) LIKE %?1%")
    List<Product> findByNameContainingIgnoreCase(String keyword);
    // List<Product> findByKeyword(String keyword);
    
}
