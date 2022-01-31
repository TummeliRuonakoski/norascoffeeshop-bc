package com.example.norascoffeeshop.controller;

import com.example.norascoffeeshop.service.MakerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MakerController {

    @Autowired
    private MakerService makerService;

    @GetMapping("/maker")
    public String getAllMakers(Model model){
        model.addAttribute("makers", this.makerService.listAll());
        return "admin";
        
    }
    
}
