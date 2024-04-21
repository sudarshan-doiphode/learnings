package com.learn.learnings.custom_validation.fields_validator.validator_class;

import com.learn.learnings.custom_validation.fields_validator.annotation.FieldMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstField;
    private String secondField;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstField = constraintAnnotation.firstField();
        secondField = constraintAnnotation.secondField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Object firstObj = new BeanWrapperImpl(value).getPropertyValue(firstField);
        Object secondObj = new BeanWrapperImpl(value).getPropertyValue(secondField);

        return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
    }
}
