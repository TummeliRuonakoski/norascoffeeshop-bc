package com.example.norascoffeeshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private CustomUserDetailsService userDetailsService;

    

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.csrf().disable();
        // http.headers().frameOptions().sameOrigin();

        http.authorizeRequests()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        // .antMatchers("/**").permitAll()
        .antMatchers("/register", "/forgotpassword", "/index").permitAll()
        .antMatchers("/product/*").permitAll()
        .antMatchers("/consumerproducts", "/consumerproducts/*").permitAll()
        .antMatchers("/coffeemachines", "/coffeemachines/*").permitAll()
        .antMatchers("/h2-console","/h2-console/**").permitAll() 
        .antMatchers("/admin", "/admin/*").hasAnyAuthority("ADMIN")
        .anyRequest().authenticated().and()
        .formLogin().loginPage("/login").permitAll().and()
        .logout().permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
}
