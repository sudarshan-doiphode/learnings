package com.learn.learnings.jakarta_beanvalidation.controller;

import com.learn.learnings.jakarta_beanvalidation.model.request.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @PostMapping("/student/validation")
    public void validateStudent(@Valid @RequestBody Student student) {
        System.out.println(student.toString());
    }


    @GetMapping("/student/path/{age}")
    public void validateAge(@PathVariable("age") @Min(value = 18) int age) {
        System.out.println("Age: " + age);
    }
}
