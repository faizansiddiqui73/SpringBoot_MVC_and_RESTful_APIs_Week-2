package com.codingShuttle.com.faizan.week2.springbootwebtutorial.controller;


import com.codingShuttle.com.faizan.week2.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class EmpolyeeController {

    @GetMapping("/")
    public String getServer() {
        return "Hello from spring sever";
    }

    String msg = "Honey";

    @GetMapping(path = "/getSecretMessage")
    public String getMySecretMessage() {
        return "Here is my seceret message : " + msg;
    }
    //PathVariable
    //employee/123
    @GetMapping(path = "/employees/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"faizan","faizansiddiqui73@gmail.com",24, LocalDate.of(2024,07,14),true);
    }

    //RequestParam
    // employee?id=123 //it is optional
    @GetMapping(path = "/employees")
    public String getAllEmployees(@RequestParam(required = false) Integer age){
        return "Hi my age is: "+age;
    }

    @PostMapping(path = "/employees")
    public EmployeeDTO crateNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }
}
