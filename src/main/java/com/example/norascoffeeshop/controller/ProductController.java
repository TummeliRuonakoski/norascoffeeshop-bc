package com.example.norascoffeeshop.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import com.example.norascoffeeshop.service.DeparmentService;
import com.example.norascoffeeshop.service.MakerService;
import com.example.norascoffeeshop.service.ProductService;
import com.example.norascoffeeshop.service.SupplierService;
import com.example.norascoffeeshop.model.Product;
import com.example.norascoffeeshop.model.Deparment;
import com.example.norascoffeeshop.model.Supplier;
import com.example.norascoffeeshop.model.Maker;



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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MakerService makerService;

    @Autowired
    private DeparmentService deparmentService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/")
    public String topSellers(Model model){
        Pageable pageable = PageRequest.of(0, 9, Sort.by("productsSold").descending());
        model.addAttribute("products", this.productService.topSellers(pageable));
        return "index";
    }

    @GetMapping("/coffeemachines")
    public String getAllCoffeemachines(Model model){
        List<Long> coffeemachines = Arrays.asList(1L);
        // List<Long> coffeemachines = Arrays.asList(3L, 4L, 5L);
        List<Product> products = productService.getAllCoffeeMachines(coffeemachines);
        model.addAttribute("coffeemachines", products);
        return "coffeemachines";
    }
    
    @GetMapping(path = "/product/{id}/image")
    @ResponseBody
    public byte[] getImages(@PathVariable Long id) {
        return productService.getProduct(id).getImage();
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
        return "showproduct";
    }

    // @Secured("ADMIN")
    @GetMapping("/user/admin/product")
    public String getProducts(Model model){
        model.addAttribute("products", productService.listAll());
        model.addAttribute("deparments", deparmentService.listAll());
        model.addAttribute("suppliers", supplierService.listAll());
        model.addAttribute("makers", makerService.listAll());
        return "postproduct";

    }

    // @Secured("ADMIN")
    @PostMapping("/user/admin/product")
    public String createProduct(@RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam Long deparmentId, @RequestParam Long supplierId, @RequestParam Long makerId, @RequestParam("image") MultipartFile image) throws IOException{
        productService.addProduct(name, description, price, deparmentId, supplierId, makerId, image);
        return "redirect:/user/admin/product";
    }

    // @Secured("ADMIN")
    @PostMapping("/user/admin/product/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam Long deparmentId, @RequestParam Long supplierId, @RequestParam Long makerId, @RequestParam ("image") MultipartFile image) throws IOException {
        this.productService.updateProduct(id, name, description, price, deparmentId, supplierId, makerId, image);
        return "redirect:/user/admin/product";
    }

    // @Secured("ADMIN")
    @GetMapping("/user/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return "redirect:/user/admin/product";
    }

}
