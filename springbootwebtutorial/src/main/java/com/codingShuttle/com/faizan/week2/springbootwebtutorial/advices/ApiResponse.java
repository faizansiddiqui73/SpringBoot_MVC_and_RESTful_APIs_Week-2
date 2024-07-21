package com.codingShuttle.com.faizan.week2.springbootwebtutorial.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


import java.time.LocalDateTime;

@Data //will create getter and setters
public class ApiResponse<T> {

    @JsonFormat(pattern = "hh:mm:ss dd-MM-YYYY")
    private LocalDateTime timeStamp;
    private T data;
    private ApiError apiError;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError apiError) {
        this(); //for default constructor
        this.apiError = apiError;
    }
    //data will called then error won't
}
