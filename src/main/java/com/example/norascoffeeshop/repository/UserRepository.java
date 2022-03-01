package com.example.norascoffeeshop.repository;

import java.util.Optional;

import com.example.norascoffeeshop.model.UserData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Long>{

    // UserData findByEmail(String email);

    Optional<UserData> findByUsername(String username);
    
}
