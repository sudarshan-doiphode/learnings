package com.learn.learnings.custom_validation.password_validator.controller;

import com.learn.learnings.custom_validation.password_validator.model.UserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user/custom-validation")
    public void validateUser(@Validated @RequestBody UserDto user) {
        System.out.println("User is valid");
    }
}
