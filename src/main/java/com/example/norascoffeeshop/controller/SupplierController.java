package com.example.norascoffeeshop.controller;

import com.example.norascoffeeshop.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/user/admin/supplier")
    public String getAllSuppliers(Model model){
        model.addAttribute("suppliers", this.supplierService.listAll());
        return "postsupplier";
    }

    @GetMapping("/user/admin/supplier/{id}")
    public String getSupplier(@PathVariable Long id, Model model){
        model.addAttribute("supplier", this.supplierService.getSupplier(id));
        return "supplier";
    }

    // @Secured("ADMIN")
    @PostMapping("/user/admin/supplier")
    public String createSupplier(@RequestParam String name, @RequestParam String contactperson, @RequestParam String contactpersonsEmail){
        this.supplierService.addSupplier(name, contactperson, contactpersonsEmail);
        return "redirect:/user/admin/supplier";
    }

    // @Secured("ADMIN")
    @PostMapping("/user/admin/supplier/{id}")
    public String updateSupplier(@PathVariable Long id, @RequestParam String name, @RequestParam String contactperson, @RequestParam String contactpersonsEmail){
        this.supplierService.updateSupplier(id, name, contactperson, contactpersonsEmail);
        return "redirect:/user/admin/supplier";
    }

    // @Secured("ADMIN")
    @GetMapping("/user/admin/supplier/delete/{id}")
    public String deleteSupplier(@PathVariable Long id){
        this.supplierService.deleteSupplier(id);
        return "redirect:/user/admin/supplier";
    }

}
