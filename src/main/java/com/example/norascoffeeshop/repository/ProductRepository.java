package com.example.norascoffeeshop.repository;
import com.example.norascoffeeshop.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
