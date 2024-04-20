package com.learn.learnings.jakarta_beanvalidation.exception;

import lombok.Data;
import org.springframework.web.ErrorResponse;

@Data
public class CustomApplicationException extends RuntimeException{
    private final ErrorResponse errorResponse;
}
