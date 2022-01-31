package com.example.norascoffeeshop.controller;

import com.example.norascoffeeshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String topSellers(Model model){
        Pageable pageable = PageRequest.of(0, 9, Sort.by("productsSold").descending());
        model.addAttribute("products", this.productService.topSellers(pageable));
        return "index";
    }

    @GetMapping("/consumerproducts")
    public String getAllConsumerProducts(Model model){
        model.addAttribute("consumerproducts", this.productService.listAll());
        return "";

    }

    @GetMapping("/coffeemachines")
    public String getAllCoffeemachines(Model model){
        model.addAttribute("coffeemachines", this.productService.listAll());
        return "";
    }

    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.getProduct(id));
        return "product";

    }

    @PostMapping("/admin")
    public String createProduct(@RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam String image){
        this.productService.addProduct(name, description, price, image, 0L);
        return "redirect:/";
    }

    @PostMapping("/product/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam String image, Long productsSold){
        this.productService.updateProduct(id, name, description, price, image, productsSold);
        return "redirect:/";
    }

    @DeleteMapping
    public String deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return "";
    }

}
