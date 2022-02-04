package com.example.norascoffeeshop.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
    private Long productsSold;

    @ManyToOne
    @JoinColumn(name = "deparmentId")
    private Deparment deparment;
    @ManyToOne
    @JoinColumn(name = "editorId")
    private Editor editor;
    @ManyToOne    
    @JoinColumn(name = "makerId")
    private Maker maker;

}
