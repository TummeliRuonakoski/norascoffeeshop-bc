package com.example.norascoffeeshop.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.example.norascoffeeshop.service.ProductService;
import com.example.norascoffeeshop.model.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


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

    @GetMapping("/coffeemachines")
    public String getAllCoffeemachines(Model model){
        List<Long> coffeemachines = Arrays.asList(3L, 4L, 5L);
        List<Product> products = productService.getAllCoffeeMachines(coffeemachines);
        model.addAttribute("coffeemachines", products);
        return "coffeemachines";
    }

    @GetMapping("/consumerproducts")
    public String getAllConsumerProducts(Model model){
        List<Long> consumerproducts = Arrays.asList(6L, 7L);
        List<Product> products = productService.getAllConsumeProducts(consumerproducts);
        model.addAttribute("consumerproducts", products);
        return "consumerproducts";
    }

    @GetMapping("/consumerproducts/coffees")
    public String getAllCoffees(Model model){
        List<Long> coffees = Arrays.asList(8L, 9L);
        List<Product> products = productService.getAllCoffees(coffees);
        model.addAttribute("coffees", products);
        return "consumerproducts";
    }

    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.getProduct(id));
        return "product";
    }

    @Secured("ADMIN")
    @PostMapping("/user/admin/product")
    public String createProduct(@RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam("image") MultipartFile image, @RequestParam Long deparmentId, @RequestParam Long editorId, @RequestParam Long makerId) throws IOException{
        this.productService.addProduct(name, description, price, image, 0L, deparmentId, editorId, makerId);
        return "redirect:/profile";
    }

    @Secured("ADMIN")
    @PostMapping("/user/admin/product/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam ("image") MultipartFile image, Long productsSold, @RequestParam Long deparmentId, @RequestParam Long editorId, @RequestParam Long makerId) throws IOException {
        this.productService.updateProduct(id, name, description, price, image, productsSold, deparmentId, editorId, makerId);
        return "redirect:/profile";
    }

    @Secured("ADMIN")
    @DeleteMapping("/user/admin/product/{id}")
    public String deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return "redirect:/profile";
    }

}
