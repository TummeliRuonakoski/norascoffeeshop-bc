package com.example.norascoffeeshop.repository;

import com.example.norascoffeeshop.model.UserData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long>{

    UserData findByEmail(String email);
    
}
