package com.example.norascoffeeshop.service;

import com.example.norascoffeeshop.repository.MakerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakerService {

    @Autowired
    private MakerRepository makerRepository;
    
}
