package com.example.norascoffeeshop.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product  extends AbstractPersistable<Long>{
    
    private String description;
    // @Type(type = "org.hibernate.type.BinaryType")
    // @Basic(fetch = FetchType.LAZY)
    // @Column(name = "image", length = 1000)
    // @Lob
    // private String image;
    // @Type(type = "org.hibernate.type.BinaryType")
    // @Basic(fetch = FetchType.EAGER)
    @Lob
    private byte[] image;

    private String name;
    private Double price;


    @ManyToOne
    private Deparment deparment;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne    
    private Maker maker;
}
