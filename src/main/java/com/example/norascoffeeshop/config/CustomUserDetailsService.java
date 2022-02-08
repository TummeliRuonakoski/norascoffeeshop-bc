package com.example.norascoffeeshop.config;

import java.util.Arrays;

import com.example.norascoffeeshop.model.UserData;
import com.example.norascoffeeshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserData customer = userRepository.findByEmail(email);
        if(customer == null){
            throw new UsernameNotFoundException("No such user " + email);
        }

        return new org.springframework.security.core.userdetails.User(
            customer.getEmail(),
            customer.getPassword(),
            true,
            true,
            true,
            true,
            Arrays.asList(new SimpleGrantedAuthority("USER"), new SimpleGrantedAuthority("ADMIN")));
    }
}
