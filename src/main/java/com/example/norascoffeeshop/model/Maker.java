package com.example.norascoffeeshop.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

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

    @OneToMany(mappedBy = "maker")
    private List<Product> products = new ArrayList<>();


}
