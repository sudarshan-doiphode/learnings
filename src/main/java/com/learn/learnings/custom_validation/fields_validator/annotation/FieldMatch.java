package com.learn.learnings.custom_validation.fields_validator.annotation;

import com.learn.learnings.custom_validation.fields_validator.validator_class.FieldMatchValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMatch {
    String message() default "Field values don't match";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

    String firstField();

    String secondField();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        FieldMatch[] value();
    }
}
