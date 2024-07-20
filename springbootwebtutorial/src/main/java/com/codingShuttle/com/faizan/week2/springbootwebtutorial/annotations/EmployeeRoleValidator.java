package com.codingShuttle.com.faizan.week2.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
//        if(inputRole==null){
//            return false;
//        }
        List<String> roles = List.of("USERS","ADMIN");
        return roles.contains(inputRole);
    }
}
