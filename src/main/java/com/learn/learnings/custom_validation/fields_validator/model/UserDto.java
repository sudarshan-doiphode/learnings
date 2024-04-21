package com.learn.learnings.custom_validation.fields_validator.model;

import com.learn.learnings.custom_validation.fields_validator.annotation.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldMatch(firstField = "password",
        secondField = "confirmPassword",
        message = "Passwords do not match")
public class UserDto {
    private String password;
    private String confirmPassword;
}
