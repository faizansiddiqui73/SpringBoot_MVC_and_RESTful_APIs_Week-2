package com.codingShuttle.com.faizan.week2.springbootwebtutorial.advices;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder //The @Builder annotation in Project Lombok generates a builder pattern for a class,
// allowing you to create instances of the class with a fluent and expressive API.
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subError;
}
