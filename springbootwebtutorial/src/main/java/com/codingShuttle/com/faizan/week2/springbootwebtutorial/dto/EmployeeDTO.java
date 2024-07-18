package com.codingShuttle.com.faizan.week2.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "Employee Field cannot be negative")
    @Size(min = 3,max = 10,message = "Number of characters should be in range 3 - 10")
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Email should be valid email")
    private String email;

    @NotNull(message = "Age of employee cannot be blank")
    @Max(value = 80,message = "Age of employee cannot be greater than 80.")
    @Min(value = 18,message = "Age of employee cannot be less than 18")
    private Integer age;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;

    @NotBlank(message = "Role of Employee can not be blank")
    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of employee can be USER or ADMIN")
    private String role; //ADMIN, USER

    @NotNull(message = "Salary of the employee cannot be null")
    @Positive(message = "Salary of the employee should be postive")
    @Digits(integer = 6,fraction = 2,message = "The salary can be in the form of XXXXXX.YY")
    private double salary;
}