package com.learn.learnings.jakarta_beanvalidation.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"timestamp", "message", "httpStatusCode", "statusCode", "errorBody"})
public class ErrorResponse {
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("message")
    private String message;

    @JsonProperty("httpStatusCode")
    private HttpStatusCode httpStatusCode;

    @JsonProperty("statusCode")
    private int httpStatusCodeValue;

    @JsonProperty("errorBody")
    private Object errorBody;
}
