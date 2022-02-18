package com.example.norascoffeeshop.service;

import com.example.norascoffeeshop.model.UserData;
import com.example.norascoffeeshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public UserData getUser(Long id){
        return userRepository.getById(id);
    }

    public void addUser(String name, String address, String phonenumber, String email, String password, Boolean isAdmin){
        UserData user = new UserData(); 
        user.setName(name);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);
        user.setPassword(password);
        user.setIsAdmin(isAdmin);
        userRepository.save(user);
    }

    public void updateUser(Long id, String name, String address, String phonenumber, String email, String password, Boolean isAdmin){
        UserData user = userRepository.getById(id);
        user.setName(name);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setIsAdmin(isAdmin);
        userRepository.save(user);
    }
    
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
