package com.example.norascoffeeshop.controller;

import com.example.norascoffeeshop.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("user", username);
        return "profile";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/forgotpassword")
    public String forgotPassword(){
        return "forgotpassword";
    }

    @PostMapping("/forgotpassword")
    public String resetPassword(@RequestParam String email, @RequestParam String password) {
        this.userService.resetPassword(email, password);
        return "redirect:/login";
    }

    @PostMapping("/register")
    public String createUser(@RequestParam String name, @RequestParam String address, @RequestParam String phonenumber, @RequestParam String email, @RequestParam String password){
        this.userService.addUser(name, address, phonenumber, email, password, false);
        return "redirect:/index";
    }

    @PostMapping("/user/{id}")
    public String updateUser(@PathVariable Long id, @RequestParam String name, @RequestParam String address, @RequestParam String phonenumber, @RequestParam String email, @RequestParam String password, @RequestParam Boolean isAdmin){
        this.userService.updateUser(id, name, address, phonenumber, email, password, isAdmin);
        return "redirect:/profile";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);
        return "index";
    }
    
}
