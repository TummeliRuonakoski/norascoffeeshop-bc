package com.example.norascoffeeshop.repository;

import com.example.norascoffeeshop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
    
}
