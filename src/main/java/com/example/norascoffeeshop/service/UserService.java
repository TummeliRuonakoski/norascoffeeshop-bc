package com.example.norascoffeeshop.service;

import java.util.List;

import com.example.norascoffeeshop.model.User;
import com.example.norascoffeeshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User getEditor(Long id){
        return userRepository.getById(id);
    }

    public void addMaker(String name, String address, String phonenumber, String email, String password, Boolean isAdmin){
        User user = new User(); 
        user.setName(name);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);
        user.setPassword(password);
        user.setIsAdmin(isAdmin);
        userRepository.save(user);
    }

    public void updateMaker(Long id, String name, String address, String phonenumber, String email, String password, Boolean isAdmin){
        User user = userRepository.getById(id);
        user.setName(name);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);
        user.setPassword(password);
        user.setIsAdmin(isAdmin);
        userRepository.save(user);
    }
    
    public void deleteEditor(Long id){
        userRepository.deleteById(id);
    }


}
