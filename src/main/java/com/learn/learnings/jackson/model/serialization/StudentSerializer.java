package com.learn.learnings.jackson.model.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class StudentSerializer {
    public static void main(String[] args) throws IOException {
        Student student = Student.builder()
                .id(1)
                .name(null)
                .email("lTQZI@example.com")
                .address("Noida")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();

        //Writing the object as JSON
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);

        //Writing the object as JSON into file in classpath:
//        objectMapper.writeValue(new File("student.json"), student);
//        System.out.println("Done");

        //Writing the object as JSON into file in specific path:
//        objectMapper.writeValue(new File("D:\\temp\\student.json"), student);
        objectMapper.writeValue(new File("src/main/resources/student.json"), student);
    }
}
