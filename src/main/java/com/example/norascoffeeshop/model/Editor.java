package com.example.norascoffeeshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Editor  extends AbstractPersistable<Long> {
    
    private String name;
    private String contactperson;
    @Column(unique = true)
    @Email
    private String contactpersonsEmail;

    @OneToMany
    private List<Product> products = new ArrayList<>();

}
