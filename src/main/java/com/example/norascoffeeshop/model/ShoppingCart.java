package com.example.norascoffeeshop.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// @Entity
// @Component
// @NoArgsConstructor
// @AllArgsConstructor
// @Data
// @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
// public class ShoppingCart  implements Serializable {
    
//     private Map<Product, Long> products = new HashMap<>();

//     public double getSum(){
//         double i = 0;
//         for(Product product : products.keySet()){
//             i += products.get(product);
//         }
//         return i;
//     }

//     public void addToShoppingCart(Product product){
//         products.put(product, product.getId());
//     }

//     public void removeFromShoppingCart(Product product){
//         long count = products.get(product);
//         if(count <= 1){
//             products.remove(product);
//         }else{
//             products.put(product, count -1);
//         }
//     }
// }
