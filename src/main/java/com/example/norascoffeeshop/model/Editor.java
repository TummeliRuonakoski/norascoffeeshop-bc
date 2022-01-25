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
public class Editor  extends AbstractPersistable<Long> {
    
    private String name;
    private String contactperson;
    private String contactpersonsEmail;
}
