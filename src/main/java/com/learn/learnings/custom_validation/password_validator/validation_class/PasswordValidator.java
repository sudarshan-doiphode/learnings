package com.learn.learnings.custom_validation.password_validator.validation_class;

import com.learn.learnings.custom_validation.password_validator.annotation.ValidatePassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidatePassword, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        // Password must be at least 8 characters long
        if (s.length() < 8) {
            return false;
        }
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        //Password must contain at least one uppercase letter, one lowercase letter, and one number
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(s).matches();
    }
}
