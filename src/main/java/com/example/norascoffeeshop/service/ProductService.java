package com.example.norascoffeeshop.service;

import java.util.List;

import com.example.norascoffeeshop.model.Product;
import com.example.norascoffeeshop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> topSellers(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public List<Product> getAllCoffeeMachines(List<Long> coffeemachines){
        List<Product> products = productRepository.findByDeparment_idIn(coffeemachines);
        return products;
    }

    public List<Product> getAllConsumeProducts(List<Long> consumerproducts){
        List<Product> products = productRepository.findByDeparment_idIn(consumerproducts);
        return products;
    }

    public List<Product> getAllCoffees(List<Long> coffees){
        List<Product> products = productRepository.findByDeparment_idIn(coffees);
        return products;
    }

    public List<Product> listAll(){
        return productRepository.findAll();
    }


    public Product getProduct(Long id){
        return productRepository.getById(id);
    }

    public void addProduct(String name, String description, Double price, String image, Long productsSold){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);
        product.setProductsSold(productsSold);
        productRepository.save(product);
    }

    public void updateProduct(Long id, String name, String description, Double price, String image, Long productsSold){
        Product product = productRepository.getById(id);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(image);
        product.setProductsSold(productsSold);
        productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    
}
