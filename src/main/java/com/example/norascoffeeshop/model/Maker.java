package com.example.norascoffeeshop.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maker  extends AbstractPersistable<Long>{
    
    private String name;
    private String url;

    private List<Product> products = new ArrayList<>();


}
