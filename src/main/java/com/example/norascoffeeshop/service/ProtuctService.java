package com.example.norascoffeeshop.service;

import java.util.List;

import com.example.norascoffeeshop.model.Product;
import com.example.norascoffeeshop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProtuctService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public Product getEditor(Long id){
        return productRepository.getById(id);
    }

    public void addMaker(String name, String description, Double price, String image){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);
        productRepository.save(product);
    }

    public void updateMaker(Long id, String name, String description, Double price, String image){
        Product product = productRepository.getById(id);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);
        productRepository.save(product);
    }
    public void deleteEditor(Long id){
        productRepository.deleteById(id);
    }
    
}
