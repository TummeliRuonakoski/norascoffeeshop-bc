package com.example.norascoffeeshop.repository;
import java.util.Collection;
import java.util.List;

import com.example.norascoffeeshop.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByDeparment_idIn(Collection<Long> products);
    
}
