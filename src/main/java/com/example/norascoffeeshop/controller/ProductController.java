package com.example.norascoffeeshop.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.example.norascoffeeshop.service.DeparmentService;
import com.example.norascoffeeshop.service.MakerService;
import com.example.norascoffeeshop.service.ProductService;
import com.example.norascoffeeshop.service.SupplierService;
import com.example.norascoffeeshop.model.Product;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @GetMapping("/index")
    public String searchProduct(Model model, String keyword){
        return getAllProducts(0, model, keyword);    
    }

    @GetMapping("/index/{page}")
    public String getAllProducts(@PathVariable(name = "page") Integer page, Model model, @Param("keyword") String keyword) {
        if(keyword != null) {
            Page<Product> products = productService.getProductPageable(page, 6);
            model.addAttribute("products", productService.getByKeyword(keyword));
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", products.getTotalPages());
            model.addAttribute("totalItem", products.getTotalElements());
        } else {
            Page<Product> products = productService.getProductPageable(page, 6);
            model.addAttribute("products", products);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", products.getTotalPages());
            model.addAttribute("totalItem", products.getTotalElements());
        }
        return "index";
    }

    @GetMapping("/coffeemachines")
    public String getAllCoffeemachines(Model model){
        List<Long> coffeemachines = Arrays.asList(1L,3L, 4L, 5L);
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
        List<Long> consumerproducts = Arrays.asList(2L,6L, 7L, 8L, 9L);
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

    @Secured("ADMIN")
    @GetMapping("/user/admin/product/{id}")
    public String getUpdateProduct(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("deparments", deparmentService.listAll());
        model.addAttribute("suppliers", supplierService.listAll());
        model.addAttribute("makers", makerService.listAll());
        return "product";
    }

    @Secured("ADMIN")
    @GetMapping("/user/admin/product")
    public String getProducts(Model model){
        model.addAttribute("products", productService.listAll());
        model.addAttribute("deparments", deparmentService.listAll());
        model.addAttribute("suppliers", supplierService.listAll());
        model.addAttribute("makers", makerService.listAll());
        return "postproduct";

    }

    @Secured("ADMIN")
    @PostMapping("/user/admin/product")
    public String createProduct(@RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam Long deparmentId, @RequestParam Long supplierId, @RequestParam Long makerId, @RequestParam("image") MultipartFile image) throws IOException{
        productService.addProduct(name, description, price, deparmentId, supplierId, makerId, image);
        return "redirect:/user/admin/product";
    }

    @Secured("ADMIN")
    @PostMapping("/user/admin/product/{id}")
    public String updateProduct(@PathVariable Long id, @RequestParam String name, @RequestParam String description, @RequestParam Double price, @RequestParam Long deparmentId, @RequestParam Long supplierId, @RequestParam Long makerId, @RequestParam ("image") MultipartFile image) throws IOException {
        this.productService.updateProduct(id, name, description, price, deparmentId, supplierId, makerId, image);
        return "redirect:/user/admin/product";
    }

    @Secured("ADMIN")
    @GetMapping("/user/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return "redirect:/user/admin/product";
    }

}
