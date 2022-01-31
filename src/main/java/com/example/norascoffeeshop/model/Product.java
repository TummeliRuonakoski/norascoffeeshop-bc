package com.example.norascoffeeshop.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product  extends AbstractPersistable<Long>{
    
    private String name;
    private String description;
    private Double price;
    private String image;

    @ManyToOne
    private Deparment deparment;
    @ManyToOne
    private Editor editor;
    @ManyToOne
    private Maker maker;
    private Long productsSold;

}
