package com.example.norascoffeeshop.controller;

import com.example.norascoffeeshop.service.MakerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MakerController {

    @Autowired
    private MakerService makerService;

    @GetMapping("/user/admin/maker")
    public String getAllMakers(Model model){
        model.addAttribute("makers", this.makerService.listAll());
        return "postmaker";
    }

    @GetMapping("/user/admin/maker/{id}")
    public String getMaker(@PathVariable Long id, Model model){
        model.addAttribute("maker", makerService.getMaker(id));
        return "maker";
    }

    // @Secured("ADMIN")
    @PostMapping("/user/admin/maker")
    public String createMaker(@RequestParam String name, @RequestParam String url){
        this.makerService.addMaker(name, url);
        return "redirect:/user/admin/maker";

    }

    // @Secured("ADMIN")
    @PostMapping("/user/admin/maker/{id}")
    public String updateMaker(@PathVariable Long id, @RequestParam String name, @RequestParam String url){
        this.makerService.updateMaker(id, name, url);
        return "redirect:/user/admin/maker";
    }

    // @Secured("ADMIN")
    @DeleteMapping("/user/admin/maker/{id}")
    public String deleteMaker(@PathVariable Long id){
        this.makerService.deleteMaker(id);
        return "redirect:/profile";
    }    
}
