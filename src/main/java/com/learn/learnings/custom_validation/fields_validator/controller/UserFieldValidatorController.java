package com.learn.learnings.custom_validation.fields_validator.controller;

import com.learn.learnings.custom_validation.fields_validator.model.UserDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserFieldValidatorController {

    @PostMapping("/user/field")
    public void validateFields(@Validated @RequestBody UserDto userDto){
        System.out.println("User is valid");
    }
}
