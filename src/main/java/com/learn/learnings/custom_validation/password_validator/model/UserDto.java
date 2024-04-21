package com.learn.learnings.custom_validation.password_validator.model;

import com.learn.learnings.custom_validation.password_validator.annotation.ValidatePassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    @ValidatePassword
    private String password;
}
