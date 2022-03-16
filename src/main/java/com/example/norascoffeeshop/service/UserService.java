package com.example.norascoffeeshop.service;

import java.util.*;

import com.example.norascoffeeshop.model.Role;
import com.example.norascoffeeshop.model.UserData;
import com.example.norascoffeeshop.repository.RoleRepository;
import com.example.norascoffeeshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public UserData getUser(String email){
        return userRepository.findByEmail(email);
    }

    public UserData getUserById(Long id){
        return userRepository.getById(id);
    }

    public void addUser(String name, String address, String phonenumber, String email, String password, Boolean isAdmin){
        Role role = roleRepository.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        UserData user = new UserData();
        user.setName(name);
        user.setUsername(email);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(isAdmin);
        user.setRoles(roleSet);
        // user.setIsAdmin(isAdmin);
        userRepository.save(user);
    }

    public void updateUser(Long id, String name, String username, String address, String phonenumber, String email){
        UserData user = userRepository.getById(id);
        user.setName(name);
        user.setUsername(username);
        user.setAddress(address);
        user.setPhonenumber(phonenumber);
        user.setEmail(email);
        userRepository.save(user);
    }

    public void resetPassword(String email, String password){
        UserData user = userRepository.findByEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
    
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
