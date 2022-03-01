package com.example.norascoffeeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserData  extends AbstractPersistable<Long>{
    
    private String name;
    private String username;
    private String address;
    private String phonenumber;
    @Column(unique = true)
    @Email
    private String email;
    private String password;
    private Boolean isAdmin;
}
