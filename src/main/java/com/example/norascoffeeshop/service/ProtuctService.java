package com.example.norascoffeeshop.service;

import com.example.norascoffeeshop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtuctService {

    @Autowired
    private ProductRepository productRepository;
    
}
