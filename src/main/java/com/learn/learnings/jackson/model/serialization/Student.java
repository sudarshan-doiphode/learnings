package com.learn.learnings.jackson.model.serialization;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name", "email"})
public class Student {

    @JsonProperty("student_id")
    private int id;

    @JsonProperty("student_name")
    private String name;

    @JsonProperty("student_email")
    private String email;

    @JsonIgnore
    private String address;
}
