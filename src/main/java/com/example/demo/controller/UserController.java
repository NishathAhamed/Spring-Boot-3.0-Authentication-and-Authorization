package com.example.demo.controller;

import com.example.demo.config.UserInfoUserDetails;
import com.example.demo.dto.ProductRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserInfoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserInfoUserDetailsService userInfoUserDetailsService;

    @PostMapping("reg-user")
    public void registerUser(@RequestBody UserEntity userEntity){

        userInfoUserDetailsService.registerUser(userEntity);
    }

}
