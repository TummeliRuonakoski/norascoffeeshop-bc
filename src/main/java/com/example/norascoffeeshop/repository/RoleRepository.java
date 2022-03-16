package com.example.norascoffeeshop.repository;
import com.example.norascoffeeshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository  extends JpaRepository<Role, Long>{

    Role findByName(String name);
    
}
