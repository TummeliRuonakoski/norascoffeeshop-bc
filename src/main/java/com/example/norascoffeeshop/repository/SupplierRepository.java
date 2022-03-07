package com.example.norascoffeeshop.repository;
import com.example.norascoffeeshop.model.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Long>{
    
}
