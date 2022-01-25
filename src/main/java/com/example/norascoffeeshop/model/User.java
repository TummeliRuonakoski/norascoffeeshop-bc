package com.example.norascoffeeshop.model;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User  extends AbstractPersistable<Long>{
    
    private String name;
    private String address;
    private String phonenumber;
    private String password;
    private Boolean admin;
}
