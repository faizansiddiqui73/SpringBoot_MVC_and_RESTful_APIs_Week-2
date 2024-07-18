package com.codingShuttle.com.faizan.week2.springbootwebtutorial.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //3
@Target({ElementType.FIELD,ElementType.PARAMETER}) //4
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation { //1
    //2 body
    String message() default "{jakarta.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
