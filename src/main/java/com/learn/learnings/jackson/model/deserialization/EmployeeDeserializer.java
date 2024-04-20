package com.learn.learnings.jackson.model.deserialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class EmployeeDeserializer {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee[] employees = objectMapper.readValue(new File("src/main/java/com/learn/learnings/jackson/model/deserialization/employee.json"), Employee[].class);
        Arrays.asList(employees).stream().forEach(System.out::println);
    }
}
