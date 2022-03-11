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

    // @Secured("ADMIN")
    @GetMapping("/user/admin/product")
    public String getProducts(Model model){
        model.addAttribute("products", productService.listAll());
        model.addAttribute("makers", makerService.listAll());
        model.addAttribute("deparments", deparmentService.listAll());
        model.addAttribute("suppliers", supplierService.listAll());
        return "product";

    }

    // @Secured("ADMIN")
    @PostMapping("/user/admin/product")
    public String createProduct(@RequestParam String description, @RequestParam("image") MultipartFile image, @RequestParam String name, @RequestParam Double price, @RequestParam Long deparmentId, @RequestParam Long supplierId, @RequestParam Long makerId) throws IOException{
        System.out.println("\n" + "!!!!!!!!!!! " + name + " " + description + " " + price + " " + " " + image + " " + deparmentId + " " + supplierId + " " + makerId + "!!!!!!!!!!!" + "\n");

        // System.out.println("3333333333333!!!!!!!!!!!!!!!!!image: " + Base64.getEncoder().encodeToString(image.getBytes()));

        
        System.out.println("!!!!!!!!!!!!!!!!!deparment: " + deparmentId);
        System.out.println("!!!!!!!!!!!!!!!!!!name: " + name);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!maker: " + makerId);
        System.out.println("!!!!!!!!!!!!!!!!!!11maker: " + makerService.getMaker(makerId));


        System.out.println("\n" + "2!!!!!!!!!!!2 " + name + " " + description + " " + price + " " + " " + image + " deparment: " + deparmentId + " " + deparmentService.getDeparment(deparmentId) + " supplier: " + supplierId + " " + supplierService.getSupplier(supplierId) + " maker: "+ makerId + " " + makerService.getMaker(makerId) + "2!!!!!!!!!!!2" + "\n");
        
        productService.addProduct(description, image, name, price, deparmentId, supplierId, makerId);
        return "redirect:/user/admin/product";
    }

    // @Secured("ADMIN")
    @PostMapping("/user/admin/product/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam Long deparmentId, @RequestParam Long supplierId, @RequestParam Long makerId, @RequestParam ("image") MultipartFile image) throws IOException {
        this.productService.updateProduct(id, name, description, price, deparmentId, supplierId, makerId, image);
        return "/user/admin/product";
    }

    // @Secured("ADMIN")
    @DeleteMapping("/user/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return "redirect:/profile";
    }

}
