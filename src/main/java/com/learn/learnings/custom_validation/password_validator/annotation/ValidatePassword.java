package com.learn.learnings.custom_validation.password_validator.annotation;

import com.learn.learnings.custom_validation.password_validator.validation_class.PasswordValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatePassword {
    String message() default "Password should be strong";

    Class<?>[] groups() default {};

    Class<? extends Throwable>[] payload() default {};
}
