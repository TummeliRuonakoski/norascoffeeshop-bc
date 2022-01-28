package com.example.norascoffeeshop.service;

import com.example.norascoffeeshop.repository.DerparmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeparmentService {

    @Autowired
    private DerparmentRepository rDerparmentRepository;
    
}
