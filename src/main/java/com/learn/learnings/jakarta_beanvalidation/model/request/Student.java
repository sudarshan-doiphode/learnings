package com.learn.learnings.jakarta_beanvalidation.model.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @NotBlank(message = "Name should not be blank")
    private String name;

    @Min(message = "Age should not be less than 18", value = 18)
    @Max(message = "Age should not be greater than 100", value = 100)
    private int age;

    @Pattern(message = "Phone number should be valid", regexp = "\\d{10}")
    private String phoneNumber;

    @Email(message = "Email should be valid")
    private String email;
}
