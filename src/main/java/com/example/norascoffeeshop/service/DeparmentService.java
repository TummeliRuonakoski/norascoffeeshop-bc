package com.example.norascoffeeshop.service;

import java.util.List;

import com.example.norascoffeeshop.model.Deparment;
import com.example.norascoffeeshop.repository.DeparmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeparmentService {

    @Autowired
    private DeparmentRepository deparmentRepository;
    

    public List<Deparment> listAll(){
        return deparmentRepository.findAll();
    }

    public Deparment getDeparment(Long id){
        return deparmentRepository.getById(id);
    }


}
