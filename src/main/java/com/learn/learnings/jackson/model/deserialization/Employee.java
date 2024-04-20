package com.learn.learnings.jackson.model.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) //Didn't work while deserializing
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"id", "name", "department", "jobTitle", "hireDate"})
public class Employee {
    @JsonProperty("id")
    private int employeeId;

    @JsonProperty("name")
    private String employeeName;

    @JsonProperty("department")
    private String department;

    @JsonProperty("jobTitle")
    private String jobTitle;

    @JsonProperty("hireDate")
    private String hireDate;
}

//The @JsonInclude(JsonInclude.Include.NON_NULL) annotation in your code
// instructs the Jackson ObjectMapper to exclude fields with null values
// during serialization (writing to JSON).
// However, it doesn't affect deserialization (reading from JSON).