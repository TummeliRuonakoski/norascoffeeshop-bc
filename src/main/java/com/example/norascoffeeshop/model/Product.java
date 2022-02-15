package com.example.norascoffeeshop.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
    
    private String name;
    private String description;
    private Double price;
    // @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Basic(fetch = FetchType.EAGER)
    private byte[] image;
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
