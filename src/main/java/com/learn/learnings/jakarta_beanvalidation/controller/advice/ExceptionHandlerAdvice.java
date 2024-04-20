package com.learn.learnings.jakarta_beanvalidation.controller.advice;

import com.learn.learnings.jakarta_beanvalidation.exception.CustomApplicationException;
import com.learn.learnings.jakarta_beanvalidation.model.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        List<String> errorMessages = new ArrayList<>();

        // get all errors from binding result and add to list
        // (You can use getAllErrors() method as well instead of getFieldErrors() method)

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        });

        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message("Validation failed")
                .httpStatusCode(HttpStatus.BAD_REQUEST)
                .httpStatusCodeValue(HttpStatus.BAD_REQUEST.value())
                .errorBody(errorMessages)
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(CustomApplicationException.class)
    public ResponseEntity<Object> handleCustomApplicationException(CustomApplicationException ex) {
        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .httpStatusCodeValue(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorBody(ex.getErrorResponse())
                .build();
        return ResponseEntity.internalServerError().body(response);
    }
}
